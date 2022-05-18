<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header include -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
				<div class="card-body">
					<div class="form-group form-inline justify-content-center">
						<label class="mr-2" for="sido">시도 : </label>
						<select class="form-control" id="sido">
							<option value="0">선택</option>
						</select>
						<label class="mr-2 ml-3" for="gugun">구군 : </label>
						<select class="form-control" id="gugun">
							<option value="0">선택</option>
						</select>
						<label class="mr-2 ml-3" for="dong">읍면동 : </label>
						<select class="form-control" id="dong">
							<option value="0">선택</option>
						</select>
						<label class="mr-2 ml-3" for="sort">정렬방법</label>
						<select class="form-control" id="sort">
							<option value="1">이름순</option>
							<option value="2">거리순</option>
						</select>
						<label class="mr-2 ml-3" for="apart">아파트 : </label>
						
						<select class="form-control" id="apart">
							<option value="0">선택</option>
						</select>
						<button type="button" id="aptSearchBtn">검색</button>
						
					</div>
					<table class="table mt-2">
						<colgroup>
							<col width="100">
							<col width="150">
							<col width="*">
							<col width="120">
							<col width="120">
						</colgroup>	
						<thead>
							<tr>
								<th>번호</th>
								<th>아파트이름</th>
								<th class="text-center">주소</th>
								<th>건축연도</th>
								<th>최근거래금액</th>
							</tr>
						</thead>
						<tbody id="searchResult"></tbody>
					</table>
				<div id="map" style="width:100%;height:500px;"></div>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e643d87f46c787a45db4e7079de5b301&libraries=services"></script>
				<script type="text/javascript" src="js/map.js"></script>
				<script type="text/javascript">
				let colorArr = ['table-primary','table-success','table-danger'];
				$(document).ready(function(){	
					$.get(root + "/map/sido"
						,function(data, status){
							$.each(data, function(index, vo) {
								$("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
							});
						}
						, "json"
					);
				});
				$(document).on("change", "#sido", function() {
					$.get(root + "/map/gugun"
							,{sido: $("#sido").val()}
							,function(data, status){
								$("#gugun").empty();
								$("#gugun").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#gugun").append("<option value='"+vo.gugunCode+"'>"+vo.gugunName+"</option>");
								console.log(vo.gugunCode);
								});
							}
							, "json"
					);
				});
				$(document).on("change", "#gugun", function() {
					$.get(root + "/map/dong"
							,{gugun: $("#gugun").val()}
							,function(data, status){
								$("#dong").empty();
								$("#dong").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#dong").append("<option value='"+vo.dongCode+"'>"+vo.dongName+"</option>");
									console.log(vo.dongCode);
								});
							}
							, "json"
					);
				});
				$(document).on("change", "#dong", function() {
					$.get(root + "/map/apt"
							,{dong: $("#dong").val()}
							,function(data, status){
								$("tbody").empty();
								$.each(data, function(index, vo) {
									let str = `
										<tr class="${'${colorArr[index%3]}'}">
										<td>${'${vo.aptCode}'}</td>
										<td>${'${vo.aptName}'}</td>
										<td>${'${vo.sidoName}'} ${'${vo.gugunName}'} ${'${vo.dongName}'} ${'${vo.jibun}'}</td>
										<td>${'${vo.buildYear}'}</td>
										<td>${'${vo.recentPrice}'}</td>
									`;
									$("tbody").append(str);
									//$("#apart").empty();
									$("#apart").append("<option value='"+vo.aptCode+"'>"+vo.aptName+"</option>");
								});
								displayMarkers(data);
							}
							, "json"
					);
				});
				
				$(document).on("change", "#sort", function() {
					$.get(root + "/map/type"
							,{type: $("#sort").val(), dong: $("#dong").val()}
							,function (data, status){
								$("tbody").empty();
								$.each(data, function(index, vo) {
									let str = `
										<tr class="${'${colorArr[index%3]}'}">
										<td>${'${vo.aptCode}'}</td>
										<td>${'${vo.aptName}'}</td>
										<td>${'${vo.sidoName}'} ${'${vo.gugunName}'} ${'${vo.dongName}'} ${'${vo.jibun}'}</td>
										<td>${'${vo.buildYear}'}</td>
										<td>${'${vo.recentPrice}'}</td>
									`;
									$("tbody").append(str);
									//$("#apart").empty();
									$("#apart").append("<option value='"+vo.aptCode+"'>"+vo.aptName+"</option>");
								});
								displayMarkers(data);
							}
							, "json"
						);
				});
				
				$(document).on("click", "#aptSearchBtn", function() {
					const aptCode = $("#apart").val();
					const aptName = $("#apart option:selected").text();
					location.href = "${root}/search/" + aptCode + "/" + aptName;
					//aptCode="+$("#apart").val()+"&aptName="+ aptName;
				});
				
				/*
				$(document).on("click", "#aptSearchBtn", function() {
					alert("검색");
					var param = {
							serviceKey:'3YoGT1R72EiBYd+r9Dfw2x9wfhPzZsCWvBeODEn+5fXWSamYcCONA0l/3dKVQ0+pa2/h3cWVz0Urj2m5jjMOow==',
							pageNo:encodeURIComponent('1'),
							numOfRows:encodeURIComponent('10'),
							LAWD_CD:encodeURIComponent($("#gugun").val()),
							DEAL_YMD:encodeURIComponent('202110')
					};
					$.get('http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev'
							,param
							,function(data, status){
						console.log(data);
								var items = $(data).find('item');
								var jsonArray = new Array();
								items.each(function() {
									var jsonObj	= new Object();
									jsonObj.aptCode = $(this).find('일련번호').text();
									jsonObj.aptName = $(this).find('아파트').text();
									jsonObj.dongCode = $(this).find('법정동읍면동코드').text();
									//jsonObj.dongName = $(this).find('').text();
									//jsonObj.sidoName = $(this).find('').text();
									//jsonObj.gugunName = $(this).find('').text();
									jsonObj.buildYear = $(this).find('건축년도').text();
									jsonObj.jibun = $(this).find('지번').text();
									jsonObj.recentPirce = $(this).find('거래금액').text();
										
									jsonObj = JSON.stringify(jsonObj);
									//String 형태로 파싱한 객체를 다시 json으로 변환
									jsonArray.push(JSON.parse(jsonObj));
								});
								console.log(jsonArray);
								//displayMarkers(jsonArray);
							}
							, "xml"
					);
					
					var xhr = new XMLHttpRequest();
					var url = 'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev';
					var queryParams = '?' + encodeURIComponent('serviceKey') + '='+encodeURIComponent('3YoGT1R72EiBYd%2Br9Dfw2x9wfhPzZsCWvBeODEn%2B5fXWSamYcCONA0l%2F3dKVQ0%2Bpa2%2Fh3cWVz0Urj2m5jjMOow%3D%3D');
					queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); 
					queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); 
					queryParams += '&' + encodeURIComponent('LAWD_CD') + '=' + encodeURIComponent($("#gugun").val()); 
					queryParams += '&' + encodeURIComponent('DEAL_YMD') + '=' + encodeURIComponent('202110'); 
					xhr.open('GET', url + queryParams);
					xhr.onreadystatechange = function () {
					    if (this.readyState == 4) {
					    	console.log(this.responseXML);
					        alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
					    }
					};

					xhr.send(''); 
				});*/
				</script>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
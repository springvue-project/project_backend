<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header include -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
				<div class="card-body">
					<div class="text-center">
						${apartName}
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
								<th>거래금액</th>
								<th>거래년</th>
								<th>거래월</th>
								<th>거래일</th>
								<th class="text-center">면적</th>
								<th>층수</th>
							</tr>
						</thead>
						<tbody id="searchResult">
						<c:forEach var="li" items="${list}">
    						<tr>
    							<td><c:out value="${li.dealAmount}"></c:out></td>
        						<td><c:out value="${li.dealYear}"></c:out></td>
								<td><c:out value="${li.dealMonth}"></c:out></td>
								<td><c:out value="${li.dealDay}"></c:out></td>
        						<td><c:out value="${li.area}"></c:out></td>
								<td><c:out value="${li.floor}"></c:out></td>
    						</tr>  
    					</c:forEach>
						</tbody>
					</table>
					
				<script type="text/javascript">
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
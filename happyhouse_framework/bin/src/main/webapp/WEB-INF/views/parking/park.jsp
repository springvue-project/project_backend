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
					</div>
					<div class="center">
					<span class="text-center" id="spantext"> </span>
					</div>
					<table class="table mt-2">
						<colgroup>
							<col width="150">
							<col width="*">
							<col width="70">
							<col width="70">
							<col width="100">
							<col width="150">
						</colgroup>	
						<thead>
							<tr>
								<th>주차장명</th>
								<th>주소</th>
								<th>구분</th>
								<th>요금</th>
								<th>주차대수</th>
								<th>연락처</th>
							</tr>
						</thead>
						<tbody id="searchResult"></tbody>
					</table>
					<h1>${root }</h1>
				<div id="map" style="width:100%;height:500px;"></div>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e643d87f46c787a45db4e7079de5b301&libraries=services"></script>
				<script type="text/javascript" src="../js/map.js"></script>
				<script type="text/javascript">
				let colorArr = ['table-primary','table-success','table-danger'];
				let searchCount = 0;
				const span = document.querySelector("#spantext");
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
								});
							}
							, "json"
					);
				});
				$(document).on("change", "#dong", function() {
					$.get(root + "/park/dong"
							,{dong: $("#dong").val()}
							,function(data, status){
								$("tbody").empty();
								searchCount = 0;
								$.each(data, function(index, vo) {
									searchCount++;
									let str = `
										<tr class="${'${colorArr[index%3]}'}">
										<td>${'${vo.parkName}'}</td>
										<td>${'${vo.parkAddress}'}</td>
										<td>${'${vo.type}'}</td>
										<td>${'${vo.pay}'}</td>
										<td>${'${vo.count}'}</td>
										<td>${'${vo.phone}'}</td>
									`;
									$("tbody").append(str);
									//$("#apart").empty();
									$("#apart").append("<option value='"+vo.aptCode+"'>"+vo.aptName+"</option>");
								});
								displayMarkers(data);
								if (searchCount >= 10) {
									span.innerText = "주차가 수월합니다.";
									span.style.color = "green";
								}
								 else if (searchCount > 0) {
									 span.innerText = "주차가 어렵습니다.";
									 span.style.color = "orange";
								 }
								 else {
									 span.innerText = "주차공간이 없습니다.";
									 span.style.color = "red";
								 }
								
							}
							, "json"
					);
					
				});
				</script>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
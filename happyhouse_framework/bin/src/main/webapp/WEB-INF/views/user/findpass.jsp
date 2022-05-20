<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header include -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="container text-center mt-3">
		<div class="col-lg-8 mx-auto">
			<h2 class="p-3 mb-3 shadow bg-light">비밀번호 찾기</h1>	
				<form method="post" id="loginform" class="text-left mb-3" action="${root}/login" enctype="multipart/form-data">
					<div class="form-group">
						<label for="id">아이디</label>
						<input type="text" id="id" name="id" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="name">이름</label>
						<input type="text" id="name" name="name" class="form-control"/>
					</div>
					<div id="pass" class="text-center" style="display:none" >
						<span id="passspan"></span>
					</div>
					<div class="form-group text-center">
						<button type="button" id="findBtn" class="btn btn-outline-primary">비밀번호 찾기</button>
						<button type="reset" class="btn btn-outline-danger">초기화</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<script type="text/javascript">
	let pass = '';
	$(document).ready(function() {
			// 회워 정보 수정 실행.
		      $(document).on("click", "#findBtn", function() {
		         $.ajax({
		            url:'${root}/user/findpass',  
		            type:'POST',
		            data: {
		            	  id : $("#id").val(), 
		                  password : '',
		                  name : $("#name").val(),
		                  email : '',
		                  pnum : ''
		            },
		            success:function(users) {
						document.querySelector("#pass").style.display = 'block';
						document.querySelector("#passspan").innerText = '비밀번호는 ' + users.password + '입니다.';
		            },
		            error:function(xhr,status,msg){
		               console.log("상태값 : " + status + " Http에러메시지 : "+msg);
		            }
		         });
		      });
		});
	</script>
</body>
</html>
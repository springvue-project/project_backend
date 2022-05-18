<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header include -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="container text-center mt-3">
		<div class="col-lg-8 mx-auto">
			<h2 class="p-3 mb-3 shadow bg-light">회원 로그인</h1>	
				<form method="post" id="loginform" class="text-left mb-3" action="${root}/login" enctype="multipart/form-data">
					<div class="form-group">
						<label for="id">아이디</label>
						<input type="text" id="id" name="id" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="password">패스워드</label>
						<input type="text" id="password" name="password" class="form-control"/>
					</div>
					<div class="text-danger mb-2">${msg }</div>
					<div class="form-group text-center">
						<button type="button" id="loginBtn" class="btn btn-outline-primary">로그인</button>
						<button type="button" id="findBtn" class="btn btn-outline-primary">비밀번호 찾기</button>
						<button type="reset" class="btn btn-outline-danger">초기화</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginBtn").click(function() {
				login();
			});
			
			$("#findBtn").click(function() {
				findPass();
			});
		});
		
		function login() {
			if (!$("#id").val()) {
				alert("아이디를 입력 해 주세요.");
			} else if (!$("#password").val()) {
				alert("패스워드를 입력 해 주세요.");
			} else {
				$("#loginform").submit();
			}
		}
		
		function findPass(){
			location.href = "${root}/findPass";
		}
	</script>
</body>
</html>
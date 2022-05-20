<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header include -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="container text-center mt-3">
		<div class="col-lg-8 mx-auto">
			<h2 class="p-3 mb-3 shadow bg-light">회원 가입</h1>	
				<form method="post" class="text-left mb-3" id="memberform" action="">
					<div class="form-group">
						<label for="id">아이디</label>
						<input type="text" id="id" name="id" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="password">패스워드</label>
						<input type="text" id="password" name="password" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="name">이름</label>
						<input type="text" id="name" name="name" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="email">이메일</label>
						<input type="text" id="email" name="email" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="pnum">휴대폰번호</label>
						<input type="text" id="pnum" name="pnum" class="form-control"/>
					</div>
					<div class="form-group text-center">
						<button type="button" id="registerBtn" class="btn btn-outline-primary">가입</button>
						<button type="reset" class="btn btn-outline-danger">초기화</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<script type="text/javascript">
	let a = '';
		$(document).ready(function() {
			$("#registerBtn").click(function (){
				regist();
			});
		});
		
		function regist() {
			$("#memberform").attr("action", "${root}/register").submit();
		}
	</script>
</body>
</html>
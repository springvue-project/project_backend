<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header include -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
   <div class="container text-center mt-3">
      <div class="col-lg-8 mx-auto">
         <h2 class="p-3 mb-3 shadow bg-light">회원 정보</h1>   
            <form method="" class="text-left mb-3" id="memberform" action="">
               <div class="form-group">
                  <label for="id">아이디</label>
                  <input type="text" id="id" name="id" class="form-control" value="${userinfo.id}" disabled/>
               </div>
               <div class="form-group">
                  <label for="password">패스워드</label>
                  <input type="text" id="password" name="password" class="form-control" value="${userinfo.password}"/>
               </div>
               <div class="form-group">
                  <label for="name">이름</label>
                  <input type="text" id="name" name="name" class="form-control" value="${userinfo.name}"/>
               </div>
               <div class="form-group">
                  <label for="email">이메일</label>
                  <input type="text" id="email" name="email" class="form-control" value="${userinfo.email}"/>
               </div>
               <div class="form-group">
                  <label for="pnum">휴대폰번호</label>
                  <input type="text" id="pnum" name="pnum" class="form-control" value="${userinfo.pnum}"/>
               </div>
               <div class="form-group text-center">
                  <button type="button" id="updateBtn" class="btn btn-outline-primary">수정</button>
                  <button type="button" id="deleteBtn" name="delete" class="btn btn-outline-danger">회원탈퇴</button>
               </div>
            </form>
         </div>
      </div>
   </div>
   </section>
   <script type="text/javascript">
      $(document).ready(function() {
         // 회워 정보 수정 실행.
            $(document).on("click", "#updateBtn", function() {
               $.ajax({
                  url:'${root}/user/update',  
                  type:'PUT',
                  data: {
                       id : $("#id").val(), 
                        password : $("#password").val(),
                        name : $("#name").val(),
                        email : $("#email").val(),
                        pnum : $("#pnum").val()
                  },
                  success:function(users) {
                     alert("회원 정보가 수정되었습니다.");
                     location.href = "${root}/";
                  },
                  error:function(xhr,status,msg){
                     console.log("상태값 : " + status + " Http에러메시지 : "+msg);
                  }
               });
            });
         
         // 회워 정보 수정 실행.
            $(document).on("click", "#deleteBtn", function() {
               
               const id = document.querySelector("#id").value;
               $("#memberform").attr("action", "${root}/delete/" + id).submit();
              /*  $.ajax({
                  url:'${root}/delete',  
                  type:'POST',
                  data: {
                       id : $("#id").val(), 
                        password : $("#password").val(),
                        name : $("#name").val(),
                        email : $("#email").val(),
                        pnum : $("#pnum").val()
                  },
                  success:function(users) {
                     alert("회원 탈퇴가 완료되었습니다.");
                     location.href = "${root}/";
                  },
                  error:function(xhr,status,msg){
                     console.log("상태값 : " + status + " Http에러메시지 : "+msg);
                  }
               }); */
            });
      });
      
      
   </script>
</body>
</html>
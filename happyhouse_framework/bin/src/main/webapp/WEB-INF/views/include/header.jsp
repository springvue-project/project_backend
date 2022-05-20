<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Framework Project</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- dto package import -->
	<%@ page import="com.ssafy.happyhouse.model.*" %>
	<!-- jstl -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="shortcut icon" href="img/favicon.ico">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/apt.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<c:set value="${pageContext.request.contextPath }" scope="session" var="root"></c:set>
</head>
<body>
	<div class="container">
		<!-- 로그인 정보가 없을 시 -->
		<c:if test="${empty loginUser }">
			<div class="text-right mb-1">
				<a href="${root }/regist">회원가입</a>&nbsp
				<a href="${root }/login">로그인</a>
			</div>
		</c:if>
		<c:if test="${!empty loginUser }">
			<div class="text-right mb-1">
				${loginUser.name }님 반갑습니다.&nbsp
				<a href="${root }/detail/${loginUser.id}">회원정보</a>&nbsp
				<a href="${root }/logout">로그아웃</a>
			</div>
		</c:if>
		<header id="index_header" class="jumbotron text-center mb-1">
			<img id="logo" src="/img/happyhouse.png">
		</header>
		<!-- nav start -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark rounded">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="${root}/">Home</a>
				</li>
				<!-- 
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#divinfo" id="navbardrop" data-toggle="dropdown">
						동네 정보
					</a>
					<div class="dropdown-menu" id="divinfo">
						<a class="dropdown-item" href="#">APT 매매</a>
						<a class="dropdown-item" href="#">APT 전월세</a>
						<a class="dropdown-item" href="#">주택 매매</a>
						<a class="dropdown-item" href="#">주택 전월세</a>
						<a class="dropdown-item" href="#">상권 정보</a>
						<a class="dropdown-item" href="#">환경 정보</a>
					</div>
				</li> -->
				<li class="nav-item">
					<a class="nav-link" href="${root}/park/">Parking</a>
				</li>
				<!-- 
				<li class="nav-item">
					<a class="nav-link" href="#">News</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Contact</a>
				</li> -->
			</ul>
		</nav>
		<section id="index_section">
			<div class="card col-sm-12 mt-1" style="min-height: 850px;">
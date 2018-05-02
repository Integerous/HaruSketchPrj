<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta 
    name="viewport"     
   	content="width=device-width, 
             initial-scale=1, minimum-scale=1, user-scalable=1"/>
<title>Insert title here</title>

<link href="resources/css/style.css" type="text/css" rel="stylesheet">


</head>
<body>
	<header class="header">
		<h1>블로그</h1>
			<nav class="main-menu">
			<h1 class="hidden">메인메뉴</h1>
				<ul>	
					<li><a href=""><img src="resources/images/ic_dehaze_black_24dp_1x.png"></a></li>
					<li><a href=""><img src="resources/images/ic_search_black_24dp_1x.png"></a></li>
					<!-- <li><li><a href=""><img src=""></a></li></li> -->
				</ul>
			</nav>
	</header>
	
	<main class="main">
		<section class="note-list">
			<h1 class="hidden">노트목록</h1>
			<ul>
				<c:forEach begin="0" end="9">
				<li>
					<div>노트 제목</div>
					<div>노트 내용이 들어갈 부분입니다.노트 내용이 들어갈 부분입니다.노트 내용이 들어갈 부분입니다.</div>
					<div><span>분류</span><span>2018-03-22 15:23</span></div>
				</li>
				</c:forEach>
			</ul>
		</section>
	</main>
</body>
</html>




<script>
	
	window.addEventListener("load",function(event){

		var hamButton = document.querySelector("#ham-btn");
		var aside = document.querySelector(".aside");
		
		hamButton.onclick = function(e){

			if(aside.classList.contains("show"))
				aside.classList.remove("show");
			
			else
				aside.classList.add("show")
				
			
			e.preventDefault();
		};

	});
	
</script>
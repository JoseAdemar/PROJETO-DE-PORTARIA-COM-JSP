<%@page import="beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="utf-8">
<title>Home</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="resources/img/favicon.png" rel="icon">
<link href="resources/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,500,600,700,700i|Montserrat:300,400,500,600,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="resources/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="resources/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="resources/lib/animate/animate.min.css" rel="stylesheet">
<link href="resources/lib/ionicons/css/ionicons.min.css"
	rel="stylesheet">
<link href="resources/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="resources/lib/lightbox/css/lightbox.min.css"
	rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="resources/css/style.css" rel="stylesheet">

<!-- =======================================================
    Theme Name: Rapid
    Theme URL: https://bootstrapmade.com/rapid-multipurpose-bootstrap-business-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body>

 <!--  CODIGO PARA APARECER O NOME DO USUARIO AUTENTICADO -->
 
   <%
   
    LoginBean loginBean = (LoginBean)session.getAttribute("usuAutenticado");
   
    out.print("Seja bem vindo ! " + loginBean.getLogin());
    
         
   %>
 
 <!--  FIM DO CODIGO PARA APARECER O NOME DO USUARIO AUTENTICADO -->


	<!--==========================
  Header
  ============================-->
	<header id="header">

		<div id="topbar">
			<div class="container">
				<div class="social-links">
					<a href="#" class="twitter"><i class="fa fa-twitter"></i></a> <a
						href="#" class="facebook"><i class="fa fa-facebook"></i></a> <a
						href="#" class="linkedin"><i class="fa fa-linkedin"></i></a> <a
						href="#" class="instagram"><i class="fa fa-instagram"></i></a>
				</div>
			</div>
		</div>

		<div class="container">

			<div class="logo float-left">
				<!-- Uncomment below if you prefer to use an image logo -->
				<h1 class="text-light">
					<a href="#intro" class="scrollto"><span>#</span></a>
				</h1>
				<!-- <a href="#header" class="scrollto"><img src="img/logo.png" alt="" class="img-fluid"></a> -->
			</div>

			<nav class="main-nav float-right d-none d-lg-block">
				<ul>
					<li class="active"><a href="#intro">Home</a></li>
					
					
					<li><a href="VisitanteServlet?acao=listartodos"> <img
							title="CADASTRO DE VISITANTES" src="resources/images/cadastro.png"
							width="65px" height="65px"></a></li>
							
							
					<li><a href="#services"><img title="LISTA DE RAMAIS"
							src="resources/images/telefone.png" width="70px" height="77px"></a></li>
							
							
					<li><a href="LoginServlet?acao=listartodos"> <img
							title="CADASTRO DE LOGIN" src="resources/images/login.png"
							width="65px" height="60px"></a></li>
					<li><a href="deslogar.jsp">Sair</a></li>
				</ul>

			</nav>
			<!-- .main-nav -->

		</div>
	</header>
	<!-- #header -->

	<!--==========================
    Intro Section
  ============================-->
	<section id="intro" class="clearfix">
		<div class="container d-flex h-100">
			<div class="row justify-content-center align-self-center">
				<div class="col-md-6 intro-info order-md-first order-last">



					<h2>
						<br> <span>Sejam bem vindos !</span>
					</h2>
					<img alt="recepcao" src="resources/images/recepcao.jpg" />

				</div>


			</div>

		</div>
	</section>
	<!-- #intro -->



	<!--==========================
      About Us Section
    ============================-->
	<section id="about">

		<div class="container">
			<div class="row">

				<div class="col-lg-5 col-md-6">
					<div class="about-img">
						<img src="img/about-img.jpg" alt="">
					</div>
				</div>


			</div>
		</div>

	</section>
	<!-- #about -->


	<!--==========================
      Services Section
    ============================-->
	<section id="services" class="section-bg">
		<div class="container">

			<header class="section-header">
				<h3>Lista de ramais</h3>

			</header>

			<div class="row">

				<div class="col-md-6 col-lg-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="box">
						<div class="icon" style="background: #fceef3;">
							<i class="ion-ios-bookmarks-outline" style="color: #ff689b;"></i>
						</div>
						<h4 class="title">Departamento 01</h4>
						<p class="description">Presidente: 000000</p>
						<p class="description">Secretária Presidente: 000000</p>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="box">
						<div class="icon" style="background: #fceef3;">
							<i class="ion-ios-bookmarks-outline" style="color: #ff689b;"></i>
						</div>
						<h4 class="title">Departamento 01</h4>
						<p class="description">Presidente: 000000</p>
						<p class="description">Secretária Presidente: 000000</p>
					</div>
				</div>

				<div class="col-md-6 col-lg-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="box">
						<div class="icon" style="background: #fceef3;">
							<i class="ion-ios-bookmarks-outline" style="color: #ff689b;"></i>
						</div>
						<h4 class="title">Departamento 01</h4>
						<p class="description">Presidente: 000000</p>
						<p class="description">Secretária Presidente: 000000</p>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="box">
						<div class="icon" style="background: #fceef3;">
							<i class="ion-ios-bookmarks-outline" style="color: #ff689b;"></i>
						</div>
						<h4 class="title">Departamento 01</h4>
						<p class="description">Presidente: 000000</p>
						<p class="description">Secretária Presidente: 000000</p>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="box">
						<div class="icon" style="background: #fceef3;">
							<i class="ion-ios-bookmarks-outline" style="color: #ff689b;"></i>
						</div>
						<h4 class="title">Departamento 01</h4>
						<p class="description">Presidente: 000000</p>
						<p class="description">Secretária Presidente: 000000</p>
					</div>
				</div>
				<div class="col-md-6 col-lg-4 wow bounceInUp"
					data-wow-duration="1.4s">
					<div class="box">
						<div class="icon" style="background: #fceef3;">
							<i class="ion-ios-bookmarks-outline" style="color: #ff689b;"></i>
						</div>
						<h4 class="title">Departamento 01</h4>
						<p class="description">Presidente: 000000</p>
						<p class="description">Secretária Presidente: 000000</p>
					</div>
				</div>

			</div>

		</div>
	</section>
	<!-- #services -->


</body>
</html>

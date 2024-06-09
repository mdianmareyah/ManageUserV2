<%@page import="beans.Utilisateur"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" integrity="sha384-4LISF5TTJX/fLmGSxO53rV4miRxdg84mZsxmO8Rx5jGtp/LbrixFETvWa5a6sESd" crossorigin="anonymous">
</head>
<body>
	<%@include file="include/header.jsp" %>
	<div class="container">
		
		<div class="card mt-3" >
                <div class=" card-header bg-primary ">
                    <h4 class="card-title text-center text-white">Modification de l'utilisateur pour id:  <c:out value="${ user.id }"/> </h4>
                </div>
                <div class="card-body bg-light-subtle">
                    <form method="post" >
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-4 col-form-label">Nom </label>
                            <div class="col-sm-7 ">
         						<input class="form-control" type="text" name="nom" id="nom" value="<c:out value="${ user.nom }"/>">
                            </div>
                        </div>
                        
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-4 col-form-label">Prenom </label>
                            <div class="col-sm-7 ">
         						<input class="form-control" type="text" name="prenom" placeholder="le prenom" id="prenom" value="<c:out value="${ user.prenom }"/>" >
                            </div>
                        </div>
                        
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-4 col-form-label">Login </label>
                            <div class="col-sm-7 ">
         						<input class="form-control" type="text" name="login" placeholder="son login" id="login" value="<c:out value="${ user.login }"/>" >
                            </div>
                        </div>
                        
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-4 col-form-label">Mot de passe </label>
                            <div class="col-sm-7 ">
         						<input  class="form-control" type="password" name="password" placeholder="le mot de passe" id="password" value="<c:out value="${ user.password }"/>" >
                            </div>
                        </div>
                        
                        <button class="btn btn-warning" type="submit"><i class="bi bi-pen-fill"></i> Modifier</button>
                     </form>
                  </div>
       		</div>
	</div>
</body>
</html>
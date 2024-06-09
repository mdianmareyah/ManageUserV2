<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout d'un utilisateur</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<%@include file="include/header.jsp" %>
	
	<div class="container">
			<div class="card mt-3" >
                <div class=" card-header bg-primary ">
                    <h4 class="card-title text-center text-white">Nouvel utilisateur</h4>
                </div>
                <div class="card-body bg-light-subtle">
                    <form method="post" >
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-3 col-form-label">Nom </label>
                            <div class="col-sm-6 ">
         						<input class="form-control" type="text" name="nom" placeholder="le nom" id="nom" value="${ utilisateur.nom }">
                            </div>
                            <span class="col-sm-3 text-danger">${ erreurs.nom }</span>
                        </div>
                        
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-3 col-form-label">Prenom </label>
                            <div class="col-sm-6 text-danger">
         						<input class="form-control" type="text" name="prenom" placeholder="le prenom" id="prenom" value="${ utilisateur.prenom }">
                            </div>
                            <span class="col-sm-3 text-danger">${ erreurs.prenom }</span>
                        </div>
                        
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-3 col-form-label">Login </label>
                            <div class="col-sm-6 ">
         						<input class="form-control" type="text" name="login" placeholder="son login" id="login" value="${ utilisateur.login }">
                            </div>
                            <span class="col-sm-3 text-danger">${ erreurs.login }</span>
                        </div>
                        
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-3 col-form-label">Mot de passe </label>
                            <div class="col-sm-6 ">
         						<input  class="form-control" type="password" name="password" placeholder="le mot de passe" id="password" >
                            </div>
                            <span class="col-sm-3 text-danger">${ erreurs.password }</span>
                        </div>
                        
                        <div class="mb-3 row">
                            <label for="staticEmail" class="col-sm-3 col-form-label">Confirmer </label>
                            <div class="col-sm-6 ">
         						<input  class="form-control" type="password" name="passwordBis" placeholder="le mot de passe" id="passwordBis">
                            </div>
                            <span class="col-sm-3 text-danger">${ erreurs.passwordBis }</span>
                        </div>
                        
                        <input class="btn btn-success" type="submit" value="enregistrer" >
                        
                     </form>
                  </div>
       </div>
	</div>

</body>
</html>
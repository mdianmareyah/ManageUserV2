<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% final String APP_ROOT = request.getContextPath();  %>

<nav class="navbar navbar-dark navbar-expand-lg bg-primary">
	<div class="container-fluid">
			<a class="navbar-brand" href="">Gestion des utilisateurs</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="<c:url value="/list"/>">Accueil</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/add"/>">Ajouter</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/list"/>">lister</a>
		        </li>
		      </ul>
		    </div>
		    <a class="btn btn-danger" href="<c:url value="/logout"/>" >Deconnexion</a>
	</div>
</nav>
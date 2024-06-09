<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.UtilisateurDao"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>liste des Utilisateurs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css">
</head>
<body>
	<%@include file="include/header.jsp" %>
	<div class="container mt-5">
		<h2 class="text-center text-primary mt-2 mb-2">Liste des utilisateurs</h2>
		
		<c:choose>
			<c:when test="${ empty utilisateurs }">Désolé, la liste des utilisateurs est vide</c:when>
			<c:otherwise>
				<div class="card mt-3">
					<div class="card-body bg-light-subtle">
						<table class="table table-bordered table-striped">
							<thead>
								<td>id</td>
								<td>nom</td>
								<td>prenom</td>
								<td>login</td>
								<td>password</td>
								<td colspan="2">Action</td>
							</thead>
							<tbody>
								<c:forEach var="utilisateur" items="${utilisateurs}">
									<tr>
										<td> <c:out value="${ utilisateur.id }"/></td>
										<td> <c:out value="${ utilisateur.nom }"/></td>
										<td> <c:out value="${ utilisateur.prenom }"/></td>
										<td> <c:out value="${ utilisateur.login }"/></td>
										<td> <c:out value="${ utilisateur.password }"/></td>
										<td> <a href="update?id=${ utilisateur.id }" class="btn btn-warning" > <i class="bi bi-pen-fill"></i> Modifier </a></td>
										<td> <a href="delete?id=${ utilisateur.id }"  class="btn btn-danger" onclick='return confirm("êtes-vous sûre de supprimer ?")'><i class="bi bi-trash3"></i> Supprimer </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>		
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
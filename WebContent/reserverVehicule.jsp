<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import = "modele.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserver Vehicule</title>
</head>
<body>
<form action="\Reservation" Method="post">
	<label>Reservation d'un vehicule:</label>
   	<p>
	   	<label>Marque: </label>
	    <input type="text" name="nom" value=<%= request.getParameter("Marque") %>>
	    <label>Class: </label>
	    <input type="text" name="prenom">
   	</p>
   	<p>
   	<label>Categorie: </label>
	    <input type="text" name="categorie">	   
   	</p>
   	<p>
   	<label>Date Debut: </label>
	    <input type="text" name="dateDebut">	   
   	</p>
   	<p>
   	<label>Date Fin: </label>
	    <input type="text" name="dateFin">	   
   	</p>
 
</form>

</body>
</html>
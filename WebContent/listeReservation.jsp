<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.util.*"
import = "modele.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<h1>Reservations List</h1>
<form name="reservationSearch" action="SearchR" method="post">
<label>Utilisateur :</label>
<input type="text" name="UtilisateurTxt" width="50">
<label>Marque :</label>
<input type="text" name="MarqueTxt" width="50">
<label>Modèle :</label>
<input type="text" name="ModeleTxt" width="50"/>
<label>Date :</label>
<input type="text" name="DateTxt" width="50">
<input type="submit" name="SearchR" value="Rechercher"/></form>


<table>

<%

List<Reservation> reservList = (List)request.getAttribute("Reservations");


out.println("<tr>");
out.println("<td>Utilisateur</td>");
out.println("<td>Id Véhicule</td>");
out.println("<td>Marque</td>");
out.println("<td>Modèle</td>");
out.println("<td>Date Debut</td>");
out.println("<td>Date Fin</td>");
out.println("</tr>");
for (Iterator iter = reservList.iterator(); iter.hasNext();) {
Reservation element = (Reservation) iter.next();
out.println("<tr>");
out.println("<td>" + element.getId() + "</td>");
//out.println("<td>" + element.getCategorie() + "</td>");
out.println("<td>" + element.getClass() + "</td>");
out.println("<td>" + element.getDateDebut() + "</td>");
out.println("<td>" + element.getDateFin() + "</td>");
Vehicule vehicule = element.getVehicule();
out.println("<td>" + vehicule.getMarque() + "</td>");
out.println("<td>" + vehicule.getModele() + "</td>");
%>
		</tr>

<%

}
%>

</table>

</body>
</html>
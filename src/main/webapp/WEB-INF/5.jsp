<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Info über die von einer bestimmten Kunde ausgeführten Geldeinzahlung</h1>

<c:if test="${bool }"> 

<h2><b> Sehr geehrte/r Besucher/in  den von Ihnen BenutzerName ist leider ungültig , prüfen sie  und geben sie es bitte erneut </b></h2>

<h3>Falls sie den Name der Kunde kennen möchten , gehen sie bitte zum Hauptmenu zurück un wählen sie Option Nummer 1 </h3>

</c:if>

<c:if test="${!bool }"> 
<p>Sie haben sie sich entschieden die von einer bestimmten Kunde ausgeführten Geldeinzahlung anzuzeigen  </p>

</c:if>

<p>Geben sie bitte den BenutzerName in den untenstehenden Feld </p>



<form action="5" method="post">
        <label for="user5">Please enter  the Username:</label>
        <input type="text" id="user5" name="user5">
        <input type="submit" value="Submit">
    </form>



</body>
</html>
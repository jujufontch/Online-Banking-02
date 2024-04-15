<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${welcome }">
<h1> Wilkommen  Sehr geehrte/r Besucher /in !!!!</h1>

<h2>In dieser Webseite können sie Informationen über  der Kunden einer Bank laden </h2>

<h2> Was wollen sie dann machen , geben sie bitte das Kennnummer ihrer  Wahl ein</h2>
</c:if>

<c:if test="${!welcome }">
<h1>Falsche Eingabe !!!</h1>

<h2> Die von Ihnen eingebener Eingabe ist leider ungültig , versuchen sie bitte erneut</h>
</c:if>
<ul>

<li>1 : Um Info über alle Kunde zu bekommen  </li>

<li>2 : Um Info über alle durchgeführten Transaktionen anzuzeigen </li>

<li>3 : Um die von einer bestimmten Kunde ausgeführten Transaktionen anzuzeigen</li>

<li>4 : Um die von einer bestimmten Kunde ausgeführten Geldabhebungen anzuzeigen</li>

<li>5 : Um die von einer bestimmten Kunde ausgeführten  Geldeinzahlung anzuzeigen </li></ul>


<form action="AdminSteuer" method="get">
        <label for="ASchoice">Enter your choice:</label>
        <input type="text" id="ASchoice" name="ASchoice">
        <input type="submit" value="Submit">
    </form>








</body>
</html>
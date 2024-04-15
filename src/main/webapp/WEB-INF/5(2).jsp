<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Historie der   durchgeführten Geldeinzahlungen </h1>

<c:if test="${empty table}">
    <p> Der ausgewählte Kontoinhaber hat momentan keine Transaktion ausgeführt</p>
</c:if>
<c:if test="${not empty table}">
<p>  Hier sind die Infos über die Geldeinzahlungen der von Ihnen ausgewählten KontoInhaber </p>

   <p> ${table} </p>
</c:if>
</body>
</html>
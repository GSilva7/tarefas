<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Empresa Cadastrada</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<a href = "index.html">Início</a><br><br>
<div>
	<div align="center">
	<h3>Empresa cadastrada com sucesso!</h3><br>
	</div>
</div>
Razão Social: ${param.razao }<br>
Horário de Abertura: ${param.horarioabertura }<br>
Horário de Fechamento: ${param.horariofechamento }<br>

</body>
</html>
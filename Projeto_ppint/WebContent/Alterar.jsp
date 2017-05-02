<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<a class="page-header" href="index.html">Início</a>
	<br>
	<br>
	<div>
		<div align="center">
			<h3 class="page-header">Empresa alterada com sucesso!</h3>
			<div class="row">
				<div class="col-md-12">
					<br>
				</div>
			</div>
		</div>
		</div>
	<div align="center">
		<div class="row">
			<div class="col-md-12">
				Novo CNPJ: ${param.cnpj } <br> Nova Razão Social:
				${param.razaosocial } <br> Novo Horário de Abertura: ${param.ha }
				<br> Novo Horário de Fechamento: ${param.hf } <br>
			</div>
		</div>
	</div>
</body>
</html>
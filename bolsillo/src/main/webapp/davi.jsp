<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Daviplata</title>
    <link rel="stylesheet" href="css/style_1.css">
    <style>
        body {
            color: white;
        }
    </style>
</head>
<body style="background-color: transparent;">
    <%-- Establecer la imagen de fondo --%>
    <style>
        body {
            background-image: url('img/fondo18.jpg');
            background-size: cover;
        }
    </style>

    <header>
        <h1>Daviplata</h1>
        <nav>
            <ul>
                <li><a href="consultar2?boton=daviplata">Inicio</a></li>
                <li><a href="consultar3?accion=consultart">Consultar saldo</a></li>
                <li><a href="index.jsp">salir</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <p>Bienvenido/a a Daviplata. Para utilizar nuestras opciones, por favor seleccione una de las siguientes opciones en la barra de navegación:</p>
        <section>
            <h2>Consultar saldo</h2>
            <p>aquí podrás acceder a consultar tu saldo, recargar tu saldo y retirar tu saldo. Gracias por utilizar nuestros servicios. :3</p>
        </section>
    </main>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.SaldoDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Nequi - Consultar saldo</title>
    <link rel="stylesheet" href="css/style_1.css" />
</head>
<body>
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
        <h1 style="color: #FFF;">Consulta tu saldo</h1>
        <%!
        // Definir el método obtenerIdCuenta()
        public int obtenerIdCuenta() {
            // Lógica para obtener el ID de la cuenta del usuario
            // ... tu implementación aquí ...
            int idCuenta = 123; // Ejemplo: ID de cuenta fijo para fines de demostración
            return idCuenta;
        }
        %>
        <%
        // Obtener el saldo actual
        SaldoDAO saldoDao = (SaldoDAO) request.getAttribute("saldoDao");
        int idCuenta = obtenerIdCuenta(); // Obtener el ID de la cuenta del usuario
        double saldo = saldoDao.consultarSaldo(idCuenta); // Llama al método consultarSaldo de SaldoDao para obtener el saldo
        %>
        <p style="color: #FFF;">Saldo actual: <%= saldo %></p>

        <!-- Formulario para realizar operaciones -->
        <form id="operacion-form" action="controller.Consultar3" method="post" novalidate>
            <input type="hidden" name="consultar" value="true">
            <label for="cantidad" style="color: #FFF;">Cantidad a operar</label>
            <input type="text" id="cantidad" name="cantidad" />
            <button type="submit" name="accion" value="suma" style="color: #FFF;">Recargar</button>
            <button type="submit" name="accion" value="resta" style="color: #FFF;">Retirar</button>
            <p id="error-msg" style="display: none; color: red;">Por favor, ingrese una cantidad válida.</p>
        </form>

        <!-- Sección para mostrar el resultado de la operación -->
        <p id="resultado" style="color: #FFF;"><%= request.getParameter("resultado") %></p>

        <p style="color: #FFF;">También puedes realizar otras operaciones en la aplicación Nequi.</p>
    </main>
</body>
</html>

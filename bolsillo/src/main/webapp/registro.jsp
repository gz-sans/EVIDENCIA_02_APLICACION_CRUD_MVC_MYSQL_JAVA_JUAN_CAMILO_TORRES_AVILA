<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <h1>Registro de Usuario</h1>
    
    <form action="Usuario" method="POST">
        <input type="hidden" name="action" value="register">
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        
        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" required>
        
        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required>
        
        <button type="submit">Registrar</button>
    </form>
    
    <a href="index.jsp">Volver</a>
</body>
</html>

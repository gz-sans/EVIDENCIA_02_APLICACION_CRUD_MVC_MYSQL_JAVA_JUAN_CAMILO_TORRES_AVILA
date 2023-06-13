<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <h1>Lista de Usuarios</h1>
    
    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%@ page import="java.util.List" %>
            <%@ page import="model.UsuarioVo" %>
            <%@ page import="java.util.ArrayList" %>
            <% List<UsuarioVo> usuarios = (List<UsuarioVo>) request.getAttribute("usuarios"); %>
            <% if (usuarios != null && !usuarios.isEmpty()) { %>
                <% for (UsuarioVo usuario : usuarios) { %>
                    <tr>
                        <td><%= usuario.getNombre() %></td>
                        <td><%= usuario.getUsuario() %></td>
                        <td><%= usuario.isActivo() ? "Activo" : "Inactivo" %></td>
                        <td>
                            <% if (usuario.isActivo()) { %>
                                <form action="Usuario" method="POST">
                                    <input type="hidden" name="action" value="deactivate">
                                    <input type="hidden" name="idUsuario" value="<%= usuario.getId() %>">
                                    <button type="submit" class="boton" style="background-color: red;">Inactivar</button>
                                </form>
                            <% } else { %>
                                <form action="Usuario" method="POST">
                                    <input type="hidden" name="action" value="activate">
                                    <input type="hidden" name="idUsuario" value="<%= usuario.getId() %>">
                                    <button type="submit" class="boton" style="background-color: green;">Activar</button>
                                </form>
                            <% } %>
                        </td>
                    </tr>
                <% } %>
            <% } else { %>
                <tr>
                    <td colspan="4">No hay usuarios registrados</td>
                </tr>
            <% } %>
        </tbody>
    </table>
    
    <a href="index.jsp">Volver</a>
</body>
</html>

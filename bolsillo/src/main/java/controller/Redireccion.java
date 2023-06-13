package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redireccion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario1");
        String contrasena = request.getParameter("contrasena1");
        
        // Realizar las operaciones necesarias con el usuario y contraseña
        
        // No es necesario el switch en el método doPost para la redirección
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String botonPresionado = request.getParameter("boton");
        switch (botonPresionado) {
            case "nequi":
                response.sendRedirect("nequi.jsp");
                break;
            case "daviplata":
                response.sendRedirect("davi.jsp");
                break;
            case "registro":
                response.sendRedirect("registro.jsp");
                break;
            default:
                // Manejar un caso de botón no reconocido
                break;
        }
    }
}

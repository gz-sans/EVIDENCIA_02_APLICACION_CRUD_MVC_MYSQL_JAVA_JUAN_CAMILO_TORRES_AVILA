package controller;

import model.UsuarioDao;
import model.UsuarioVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Usuario extends HttpServlet {

    private UsuarioDao usuarioDao;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDao = new UsuarioDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<UsuarioVo> usuarios = usuarioDao.listarUsuarios();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("/Usuario.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al obtener la lista de usuarios");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "register":
                    registrarUsuario(request, response);
                    break;
                case "activate":
                    activarUsuario(request, response);
                    break;
                case "deactivate":
                    desactivarUsuario(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath());
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Obtener los parámetros del formulario de registro
    String nombre = request.getParameter("nombre");
    String usuario = request.getParameter("usuario");
    String contrasena = request.getParameter("contrasena");

    // Crear un objeto UsuarioVo con los datos del nuevo usuario
    UsuarioVo nuevoUsuario = new UsuarioVo(nombre, usuario, contrasena);

    try {
        // Registrar el nuevo usuario en la base de datos
        usuarioDao.registrarUsuario(nuevoUsuario);
        // Redireccionar a la página de éxito después del registro
        response.sendRedirect(request.getContextPath() + "/exito.jsp");
    } catch (SQLException e) {
        e.printStackTrace();
        // Imprimir mensaje de error si ocurre una excepción SQL
        response.getWriter().println("Error al registrar el usuario");
    }
}

private void activarUsuario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Obtener el ID del usuario a activar
    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

    try {
        // Actualizar el estado del usuario a activo en la base de datos
        usuarioDao.actualizarEstadoUsuario(idUsuario, true);
        // Redireccionar a la página de lista de usuarios después de la activación
        response.sendRedirect(request.getContextPath() + "/Usuario?action=list");
    } catch (SQLException e) {
        e.printStackTrace();
        // Imprimir mensaje de error si ocurre una excepción SQL
        response.getWriter().println("Error al activar el usuario");
    }
}

private void desactivarUsuario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Obtener el ID del usuario a desactivar
    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

    try {
        // Actualizar el estado del usuario a inactivo en la base de datos
        usuarioDao.actualizarEstadoUsuario(idUsuario, false);
        // Redireccionar a la página de lista de usuarios después de la desactivación
        response.sendRedirect(request.getContextPath() + "/Usuario?action=list");
    } catch (SQLException e) {
        e.printStackTrace();
        // Imprimir mensaje de error si ocurre una excepción SQL
        response.getWriter().println("Error al desactivar el usuario");
    }
}

}
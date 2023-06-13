package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuarioDao;
import model.SaldoDAO;
import model.SaldoVO;

public class Consultar3 extends HttpServlet {

    private UsuarioDao usuarioDao;
    private SaldoDAO saldoDao;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar los objetos UsuarioDao y SaldoDAO
        usuarioDao = new UsuarioDao();
        saldoDao = new SaldoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        System.out.println(accion);

        // En el método doGet()
        switch (accion) {
            case "consultart":
                HttpSession session = req.getSession();
                session.setAttribute("usuarioDao", usuarioDao); // Establecer el objeto usuarioDao en el atributo de la sesión

                // Obtener el ID de la cuenta del usuario desde alguna fuente, como un parámetro de la solicitud
                String idCuentaStr = req.getParameter("idCuenta");

                if (idCuentaStr != null) {
                    int idCuenta = Integer.parseInt(idCuentaStr);

                    // Establecer el ID de la cuenta en la sesión
                    session.setAttribute("idCuenta", idCuenta);
                }

                // Pasar el objeto usuarioDao como atributo de la solicitud
                req.setAttribute("saldoDao", saldoDao);

                req.getRequestDispatcher("davi4.jsp").forward(req, resp);
                break;
            // ...
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la acción de la operación
        String accion = req.getParameter("consultar");

        // Obtener el saldo actual de la cuenta desde la sesión del usuario
        HttpSession session = req.getSession();
        Double saldoActual = (Double) session.getAttribute("saldo");

        // Si no hay saldo actual, se establece a 0
        if (saldoActual == null) {
            saldoActual = 0.0;
        }

        // Obtener la cantidad a sumar o restar del parámetro "cantidad"
        String cantidadStr = req.getParameter("cantidad");
        double cantidad = Double.parseDouble(cantidadStr);

        try {
            // Realizar la operación correspondiente según la acción
            if (accion.equals("suma")) {
                // Obtener el ID de la cuenta del usuario desde la sesión
                Integer idCuentaObj = (Integer) session.getAttribute("idCuenta");
                if (idCuentaObj != null) {
                    int idCuenta = idCuentaObj.intValue();

                    // Sumar el monto al saldo de la cuenta
                    saldoDao.sumarSaldo(idCuenta, cantidad);
                    saldoActual += cantidad;
                    System.out.println("Se sumó el saldo correctamente");
                } else {
                    throw new Exception("El ID de cuenta no está disponible en la sesión");
                }
            } else if (accion.equals("resta")) {
                // Obtener el ID de la cuenta del usuario desde la sesión
                Integer idCuentaObj = (Integer) session.getAttribute("idCuenta");
                if (idCuentaObj != null) {
                    int idCuenta = idCuentaObj.intValue();

                    // Restar el monto al saldo de la cuenta
                    saldoDao.retirarSaldo(idCuenta, cantidad);
                    saldoActual -= cantidad;
                    System.out.println("Se retiró el saldo correctamente");
                } else {
                    throw new Exception("El ID de cuenta no está disponible en la sesión");
                }
            } else {
                throw new Exception("Acción inválida");
            }

            // Actualizar el saldo en la sesión del usuario
            session.setAttribute("saldo", saldoActual);

            // Redirigir al JSP con el saldo actualizado
            resp.sendRedirect("davi4.jsp?resultado=ok");
        } catch (Exception e) {
            e.printStackTrace();
            // Redirigir al JSP con el mensaje de error
            resp.sendRedirect("davi4.jsp?resultado=error");
        }
    }
}

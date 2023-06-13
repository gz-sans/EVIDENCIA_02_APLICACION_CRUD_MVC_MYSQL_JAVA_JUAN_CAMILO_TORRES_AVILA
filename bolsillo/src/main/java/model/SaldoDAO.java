package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaldoDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public double consultarSaldo(int idCuenta) throws SQLException {
        double saldo = 0;
        sql = "SELECT valor FROM cuentas WHERE id = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCuenta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    saldo = rs.getDouble("valor");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar el saldo: " + e.getMessage());
        }
        return saldo;
    }

    public void sumarSaldo(int idCuenta, double cantidad) throws SQLException {
        sql = "UPDATE cuentas SET valor = valor + ? WHERE id = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDouble(1, cantidad);
            ps.setInt(2, idCuenta);
            ps.executeUpdate();
            System.out.println("Se sumó el saldo correctamente");
        } catch (Exception e) {
            System.out.println("Error al sumar saldo: " + e.getMessage());
        }
    }

    public void retirarSaldo(int idCuenta, double cantidad) throws SQLException {
        sql = "UPDATE cuentas SET valor = valor - ? WHERE id = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setDouble(1, cantidad);
            ps.setInt(2, idCuenta);
            ps.executeUpdate();
            System.out.println("Se retiró el saldo correctamente");
        } catch (Exception e) {
            System.out.println("Error al retirar saldo: " + e.getMessage());
        }
    }
}

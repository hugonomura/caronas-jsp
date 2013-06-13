/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hugo
 */
public class ConnectionCaronasFactory {

    public static Connection getConnection() throws CaronasDAOException {
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://192.168.12.4:1433;database=disciplinabd";
            String usuario = "", senha = "";
            Connection conn = DriverManager.getConnection(conexao, usuario, senha);
            return conn;
        } catch (Exception e) {
            throw new CaronasDAOException(e.getMessage());
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) throws CaronasDAOException {
        close(conn, ps, rs);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps)
            throws CaronasDAOException {
        close(conn, ps, null);
    }

    public static void closeConnection(Connection conn)
            throws CaronasDAOException {
        close(conn, null, null);
    }

    private static void close(Connection conn, PreparedStatement ps, ResultSet rs)
            throws CaronasDAOException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new CaronasDAOException(e.getMessage());
        }
    }
}

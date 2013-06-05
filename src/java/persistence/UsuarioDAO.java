/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import model.Usuario;
import java.sql.*;

/**
 *
 * @author hugo
 */
public class UsuarioDAO {
    private Connection conn;
    
    public UsuarioDAO() throws CaronasDAOException{
        this.conn = ConnectionCaronasFactory.getConnection();
    }
    
    public void salvar(Usuario u) throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO disciplinabd.dbo.usuario"
                + "(usuario, tipo) VALUES('" + u.getUsuario() + "', '" +
                u.getTipo() + "')");
    }
    
}

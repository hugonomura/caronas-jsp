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
        PreparedStatement ps;
        String SQL = "INSERT INTO disciplinabd.dbo.usuario"
                + "(username, email, senha, cidade, sexo) VALUES('" + 
                u.getUsuario() + "', '" +
                u.getEmail()+ "', '" +
                u.getSenha()+ "', '" +
                u.getCidade()+ "', '" +
                u.getSexo()+ "')";
        ps = conn.prepareStatement(SQL);
        
        ps.executeUpdate();
    }
    
    
    
}

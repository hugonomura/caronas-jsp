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
    
    public Usuario consultaSimples(String username) throws SQLException{
        Usuario u;
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "SELECT * FROM disciplinabd.dbo.usuario "
                + "WHERE username = '" + username +  "'";
        ps = conn.prepareStatement(SQL);
        
        rs = ps.executeQuery();
        if(rs.next()){
            u = new Usuario();
            u.setUsuario(rs.getString("username"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("senha"));
            u.setTipo(rs.getString("tipo"));
            u.setCidade(rs.getString("cidade"));
            u.setSexo(rs.getString("sexo"));
        }else{
            u = null;
        }
        return u;
    }
    
}

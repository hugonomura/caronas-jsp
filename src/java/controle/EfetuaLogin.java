/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import persistence.CaronasDAOException;
import persistence.UsuarioDAO;

/**
 *
 * @author lzaina
 */
public class EfetuaLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        UsuarioDAO userDao = new UsuarioDAO();
        Usuario u = userDao.consultaSimples(login);
        if (senha.equals(u.getSenha())) {
            // vincula bean
            request.setAttribute("usuarioBean", u);

            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/viewLogado.jsp");
            rd.forward(request, response);
        }
        response.sendRedirect("index.jsp");
    } catch (SQLException ex) {
        Logger.getLogger(EfetuaLogin.class.getName()).log(Level.SEVERE, null, ex);
        throw new ServletException(ex.getMessage());
    } catch (CaronasDAOException ex) {
        Logger.getLogger(EfetuaLogin.class.getName()).log(Level.SEVERE, null, ex);
        throw new ServerException(ex.getMessage());
    }
}
  

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  
  


  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

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
      String login = request.getParameter("login");
      String senha = request.getParameter("senha");
      
      if(login.equals(senha)){
            if(login.equals("adm")){
                //vinculo o bean
                
                Usuario objUsuario=new Usuario();
                objUsuario.setUsuario(login);

                // vincula bean
                request.setAttribute("usuarioBean",objUsuario);
         
                RequestDispatcher rd = null;
                rd = request.getRequestDispatcher("/viewLogado.jsp");
                rd.forward(request, response);
         } 
      }
      response.sendRedirect("index.jsp");
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

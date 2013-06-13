/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.CaronasDAOException;
import persistence.UsuarioDAO;

/**
 *
 * @author hugo
 */
public class CadastraUsuario extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastraUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastraUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = new Usuario();
        u.setUsuario(request.getParameter("username"));
        u.setTipo("user");
        u.setEmail(request.getParameter("email"));
        u.setSenha(request.getParameter("senha"));
        u.setCidade(request.getParameter("sexo"));
        u.setSexo(request.getParameter("cidade"));
        
        try {
            UsuarioDAO uDAO = new UsuarioDAO();
            uDAO.salvar(u);
            request.setAttribute("usuarioBean",u);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/viewLogado.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException();
        } catch (CaronasDAOException ex) {
            Logger.getLogger(CadastraUsuario.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException();
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Endereco;
import persistence.ClienteDao;

@WebServlet(name = "ManterCliente", urlPatterns = {"/ManterCliente"})
public class ManterCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                
        Cliente c = new Cliente();
        c.setNome(request.getParameter("nome"));
        c.setEmail(request.getParameter("email"));
        
        Endereco e = new Endereco();
        e.setLogradouro(request.getParameter("logradouro"));
        e.setCidade(request.getParameter("cidade"));
        e.setEstado(request.getParameter("estado"));
        
        //associar Endereco a Clinete
        e.setMorador(c);
        
        //gravar dados no danco
        try {
            
            new ClienteDao().salvar(c, e);
            request.setAttribute("mensagem", "Cliente cadastrado com sucesso!");
            
        }
        catch(Exception ex){
            request.setAttribute("mensagem", ex.getMessage());
        }
          finally {            
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

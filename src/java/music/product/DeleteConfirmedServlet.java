/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GiangTruong
 */
public class DeleteConfirmedServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Code = request.getParameter("productCode");
        String Description = request.getParameter("productDesc");
        String Price = request.getParameter("productPrice");

        String url = "/confirmDelete.jsp";

        ServletContext sc = getServletContext();
        //String path = sc.getRealPath("WEB-INF/ProductList.txt");
        //ProductIO.update(product, path);
        url = "/confirmDelete.jsp";
        request.setAttribute("Code", Code);
        request.setAttribute("Description", Description);
        request.setAttribute("Price", Price);
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

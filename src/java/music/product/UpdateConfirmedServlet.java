/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import music.business.Product;
import music.data.ProductDB;

/**
 *
 * @author GiangTruong
 */
public class UpdateConfirmedServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("Code");
        String description = request.getParameter("Description");
        String price = request.getParameter("Price");
        String message = "";
        String url = "";

        if (price == null) {
            price = "0.0";
        }
        double priceDB = Double.parseDouble(price);

        if (code == null) {
            code = "";
        }

        if (description == null) {
            description = "";
        }

        if (code.length() == 0
                || price.length() == 0
                || description.length() == 0) {
            message = "Please fill out all three textboxes";
            url = "/updateConfirmed.jsp";
        } else {
            Product product = new Product();
            product.setCode(code);
            product.setDescription(description);
            product.setPrice(priceDB);
            ProductDB.updateProduct(product);
            url = "/updateConfirmed.jsp";
            request.setAttribute("Code", code);
            request.setAttribute("Description", description);
            request.setAttribute("Price", price);
        }
        request.setAttribute("message", message);
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

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
import music.business.Product;
import music.data.ProductDB;

/**
 *
 * @author GiangTruong
 */
public class DeleteProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("productCode");
        String description = request.getParameter("productDesc");
        String price = request.getParameter("productPrice");
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

        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(priceDB);
        String message = "";
        String url = "";

        //ServletContext sc = getServletContext();
        //String path = sc.getRealPath("WEB-INF/ProductList.txt");
        ProductDB.removeProduct(product);
        url = "/deleteProduct.jsp";
        request.setAttribute("Code", code);
        request.setAttribute("Description", description);
        request.setAttribute("Price", price);
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

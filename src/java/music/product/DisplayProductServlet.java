/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class DisplayProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("test", "test!");

        ServletContext sc = getServletContext();
        ArrayList<Product> productList = new ArrayList<Product>();
        productList = ProductDB.selectProducts();

        request.setAttribute("productList", productList);
        request.setAttribute("products", "products");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayProduct.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("test", "test!");

        //ServletContext sc = getServletContext();
        //String path = sc.getRealPath("WEB-INF/ProductList.txt");

        ArrayList<Product> productList = new ArrayList<Product>();
        productList = ProductDB.selectProducts();

        request.setAttribute("productList", productList);
        request.setAttribute("products", "products");

        RequestDispatcher rd
                = getServletContext().getRequestDispatcher("/displayProduct.jsp");
        rd.forward(request, response);
    }
}

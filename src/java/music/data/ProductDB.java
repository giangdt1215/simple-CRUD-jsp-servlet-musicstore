/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import music.business.Product;

/*
 *
 * @author GiangTruong
 */
public class ProductDB {

    //Tra lai null neu product ko co
    public static Product selectProduct(String productCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlQuery = "SELECT * FROM Product WHERE ProductCode = ?";

        try {
            ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, productCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                Product product = new Product();
                product.setCode(rs.getString("ProductCode"));
                product.setDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("ProductPrice"));
                return product;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.closeConnection(connection);
        }
    }

    //tra lai 0 neu khong tim duoc productID tuong ung
    public static int selectProductID(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlQuery = "SELECT ProductID FROM Product WHERE ProductCode = ?";

        try {
            ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, product.getCode());
            rs = ps.executeQuery();

            rs.next();
            int productID = rs.getInt("ProductID");
            return productID;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.closeConnection(connection);
        }
    }

    //tra null neu khong tim duoc product
    public static Product selectProduct(int productID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE ProductID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.closeConnection(connection);
        }
    }

    //tra lai null neu khong co product
    public static ArrayList<Product> selectProducts() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Product> products = new ArrayList<Product>();
            while (rs.next()) {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.closeConnection(connection);
        }
    }

    public static void insertProduct(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String sqlQuery = "INSERT INTO product (ProductCode, ProductDescription, ProductPrice)VALUES('" + product.getCode()
                + "','" + product.getDescription()
                + "','" + product.getPriceNumberFormat() + "');";
        try {
            ps = connection.prepareStatement(sqlQuery);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.closeConnection(connection);
        }
    }

    public static void updateProduct(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE product SET productDescription ='"
                + product.getDescription() + "'," + "ProductPrice='"
                + product.getPriceNumberFormat() + "' WHERE ProductCode='"
                + product.getCode() + "';";

        try {
            ps = connection.prepareStatement(query);
            ps.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.closeConnection(connection);
        }
    }

    public static void removeProduct(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM product WHERE ProductCode='" + product.getCode() + "';";
        try {
            ps = connection.prepareStatement(query);
            ps.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.closeConnection(connection);
        }
    }
}

package sevicer;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSevicer {
    List<Product>productList=new ArrayList<>();
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "123456");
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public List<Product> findAll() {
        List<Product>products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from product where price");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price=rs.getInt("price");
                int quantity=rs.getInt("quantity");
                products.add(new Product(id,name,price,quantity));
            }
        } catch (SQLException e) {

        }
        return products;
    }

    public List<Product> findByName(String key){
        List<Product>products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like ?");) {
            preparedStatement.setString(1,"%" +key+ "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id =rs.getInt("id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                int quantity=rs.getInt("quantity");
                products.add(new Product(id,name,price,quantity));

            }
        } catch (SQLException e) {
        }
        return products;
    }


}

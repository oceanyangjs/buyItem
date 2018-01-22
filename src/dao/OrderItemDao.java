package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.OrderItem;

public class OrderItemDao {
	public void insert(OrderItem o) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cart?characterEncoding=UTF-8","root","000000");
			String sql = "insert into orderitem values(null,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, o.getProduct().getId());
			preparedStatement.setInt(2, o.getNum());
			preparedStatement.setInt(3, o.getOrder().getId());
			
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package com.commerce.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.commerce.pharmacy.model.Orders;
public interface OrderRepository extends JpaRepository<Orders, Integer> {

//	public void createOrder(Orders orders) {
//	try (Connection conn = dataSource.getConnection()) {
		//
//					PreparedStatement ps = conn.prepareStatement("insert into orders (user_id,product_id) values(?,?)");
//					ps.setInt(1, orders.getUser_id());
//					ps.setInt(2, orders.getProduct_id());
//					ps.executeUpdate();
		//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
}

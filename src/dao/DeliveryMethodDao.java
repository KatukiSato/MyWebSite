package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DataBaseManager;
import beans.DeliveryMethodBeans;

public class DeliveryMethodDao {

	/**
	 * 取得した配送方法IDを使って支払い方法を取得
	 * @param DeliveryMethodId
	 * @return
	 * @throws SQLException
	 */
	public static DeliveryMethodBeans getDeliveryMethodDataBeansByID(int DeliveryMethodId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from m_delivery_method where id = ?");
			st.setInt(1, DeliveryMethodId);

			ResultSet rs = st.executeQuery();

			DeliveryMethodBeans dmb = new DeliveryMethodBeans();
			while(rs.next()){
				dmb.setId(rs.getInt("id"));
				dmb.setName(rs.getString("name"));
				dmb.setPrice(rs.getInt("price"));
			}
			System.out.println("配送方法の表示成功");

			return dmb;

		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.Statement;

import base.DataBaseManager;
import beans.BuyHistryBeans;

public class BuyDao {
	/**
	 * 購入処理
	 * @param bdb
	 * @return
	 * @throws SQLException
	 */
	public static int insertBuy(BuyHistryBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DataBaseManager.getConnection();
			st = con.prepareStatement("insert into m_buy_history "
					+ " (user_id, total_price, pay_method_id, delivery_method_id, create_date) "
					+ " values(?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, bdb.getUser_id());
			st.setString(2, bdb.getTotal_priceStr());
			st.setInt(3, bdb.getPay_method_id());
			st.setInt(4, bdb.getDelivery_method_id());
			st.setTimestamp(5,  new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs =st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}

			System.out.println("購入処理が完了しました！！");

			return autoIncKey;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

//	public static BuyHistryBeans getBuyDataBeansByBuyId(int buyId) throws SQLException {
//		Connection con = null;
//		PreparedStatement st = null;
//
//		try {
//			con = DataBaseManager.getConnection();
//		} finally {
//			if (con != null) {
//				con.close();
//			}
//		}
//	}

}

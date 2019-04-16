package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DataBaseManager;
import beans.PayMethodBeans;

public class PayMethodDao {

	/**
	 * 取得した支払いIDを使って支払い方法を取得
	 * @param PayMethodId
	 * @return
	 * @throws SQLException
	 */
	public static PayMethodBeans getPayMethodDataBeansByID(int PayMethodId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from m_pay_method where id = ?");
			st.setInt(1, PayMethodId);

			ResultSet rs = st.executeQuery();

			PayMethodBeans dmb = new PayMethodBeans();
			while(rs.next()){
				dmb.setId(rs.getInt("id"));
				dmb.setName(rs.getString("name"));
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

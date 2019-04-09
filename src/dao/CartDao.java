package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DataBaseManager;

public class CartDao {


	/**
	 * 商品を買い物かごに入れる処理。
	 * @param quality
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public static int insertItem(String loginId, int quality, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("insert into cart(login_id,quality,item_id) values (?,?,?)");
			st.setString(1,loginId);
			st.setInt(2, itemId);
			st.setInt(3,quality);

			int result = st.executeUpdate();

			System.out.println("商品が買い物かごに入れられました。");

			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}

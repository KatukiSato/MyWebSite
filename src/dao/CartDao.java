package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.ItemBeans;

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

	public static ArrayList<ItemBeans> showCart(String loginId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select "
					+ " c1.login_id, c1.quality, "
					+ " m1.name, m1.price, m1.file_name "
					+ " from cart c1 "
					+ " inner join m_item m1 "
					+ " on c1.item_id = m1.id "
					+ " where login_id = ?");

			st.setString(1, loginId);

			ResultSet rs = st.executeQuery();

			ArrayList<ItemBeans> showCartList = new ArrayList<ItemBeans>();

			while(rs.next()) {
				ItemBeans cart = new ItemBeans();
//				cart.setId(rs.getInt("id"));
				cart.setName(rs.getString("name"));
//				cart.setDetail(rs.getString("detail"));
				cart.setPrice(rs.getInt("price"));
				cart.setFileName(rs.getString("file_name"));
				showCartList.add(cart);
			}
			System.out.println("買い物かごの中身です。");
			return showCartList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

}

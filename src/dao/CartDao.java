package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.CartBeans;
import beans.ItemBeans;

public class CartDao {


	/**
	 * 商品を買い物かごに入れる処理。
	 * @param quality
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<CartBeans> insertItem(String loginId,  int quality, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("insert into cart(login_id,quality,item_id) values (?,?,?)");
			st.setString(1,loginId);
			st.setInt(2,quality);
			st.setInt(3, itemId);

			st.executeUpdate();

			ArrayList<CartBeans> itemCartList = new ArrayList<CartBeans>();

			CartBeans item = new CartBeans();
			item.setLogin_id(loginId);
			item.setItem_id(itemId);
			item.setQuality(quality);

			itemCartList.add(item);

			System.out.println("商品が買い物かごに入れられました。");

			return itemCartList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 買い物かごに入れられているものを表示させる処理。
	 * @param loginId
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemBeans> showCart(String loginId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select "
					+ " c1.login_id, c1.quality, "
					+ " m1.name, m1.price, m1.file_name, "
					+ " m1.id"
					+ " from cart c1 "
					+ " inner join m_item m1 "
					+ " on c1.item_id = m1.id "
					+ " where login_id = ?");

			st.setString(1, loginId);

			ResultSet rs = st.executeQuery();

			ArrayList<ItemBeans> showCartList = new ArrayList<ItemBeans>();

			while(rs.next()) {
				ItemBeans cart = new ItemBeans();
				cart.setId(rs.getInt("id"));
				cart.setName(rs.getString("name"));
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

	/**
	 * カート画面で選択した商品を削除する
	 * @param loginId
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public static  int deleteCartItem(String loginId, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("delete from cart where login_id = ? and item_id = ?");
			st.setString(1, loginId);
			st.setInt(2, itemId);

			int result = st.executeUpdate();

			System.out.println("カートから削除されました。");

			return result;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 買い物かごに入れる際、重複がないか確認する
	 * @param loginId
	 * @return
	 * @throws SQLException
	 */
	public static  CartBeans checkCartItem(String loginId, int quality, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from cart where login_id = ?  and quality = ? and item_id = ?");
			st.setString(1, loginId);
			st.setInt(2, quality);
			st.setInt(3, itemId);

			ResultSet rs = st.executeQuery();

			CartBeans search = new CartBeans();
			while(rs.next()) {
				search.setLogin_id(rs.getString("login_id"));
				search.setItem_id(rs.getInt("item_id"));
			}
			System.out.println("カート内の商品を調べました。");
			return search;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static  CartBeans qualityUpdateWhenInsertCart(int quality, String loginId, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("update cart set quality = ? where login_id = ? and item_id = ?");
			st.setInt(1, quality);
			st.setString(2, loginId);
			st.setInt(3, itemId);
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

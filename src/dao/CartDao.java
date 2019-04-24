package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.CartBeans;

public class CartDao {


	/**
	 * 商品を買い物かごに入れる処理。
	 * @param quality
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public static  void insertItem(CartBeans cb, int itemId) throws SQLException {
		CartBeans cartcb = new CartBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("insert into cart(login_id,quality,item_id) values (?,?,?)");
			st.setString(1, cb.getLogin_id());
			st.setInt(2, cb.getQuality());
			st.setInt(3, itemId);
			st.executeUpdate();

			st = con.prepareStatement(" select login_id, quality, item_id from cart where item_id =" + cb.getItem_id());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				//				cartcb.setId(rs.getInt("id"));
				cartcb.setLogin_id(rs.getString("login_id"));
				cartcb.setQuality(rs.getInt("quality"));
				cartcb.setItem_id(rs.getInt("item_id"));
			}
			st.close();
			System.out.println("買い物かごに商品が入りました。");
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
	 * 買い物かごに入れられているものを表示させる処理。
	 * @param loginId
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<CartBeans> showCart(String loginId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select "
					+" t.id, t.item_id, t.quality, t.login_id, "
					+" m.name, m.file_name, m.price"
					+" from cart t "
					+" inner join m_item m"
					+" on t.item_id = m.id "
					+" where t.login_id = ? ");

			st.setString(1, loginId);

			ResultSet rs = st.executeQuery();

			ArrayList<CartBeans> showCartList = new ArrayList<CartBeans>();

			while(rs.next()) {
				CartBeans cart = new CartBeans();
				cart.setId(rs.getInt("id"));
				cart.setItem_id(rs.getInt("item_id"));
				cart.setQuality(rs.getInt("quality"));
				cart.setLogin_id(rs.getString("login_id"));
				cart.setPrice(rs.getInt("price"));
				cart.setFile_name(rs.getString("file_name"));
				cart.setName(rs.getString("name"));

				showCartList.add(cart);
			}
			//			int totalprice = Helper.getTotalItemPrice(showCartList);
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
	public static  CartBeans checkCartItem(String loginId, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from cart where login_id = ? and item_id = ?");
			st.setString(1, loginId);
			st.setInt(2, itemId);

			ResultSet rs = st.executeQuery();

			CartBeans search = new CartBeans();
			while(rs.next()) {
				search.setId(rs.getInt("id"));
				search.setLogin_id(rs.getString("login_id"));
				search.setItem_id(rs.getInt("item_id"));
				search.setQuality(rs.getInt("quality"));
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

	/**
	 * カートに既に入っている状態で再度登録した場合、個数を更新する。
	 *
	 * @param q
	 * @param cb
	 * @throws SQLException
	 */
	public static  void qualityUpdateCart(int q, CartBeans cb) throws SQLException {
		CartBeans cartcb = new CartBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("update cart set quality = ? where id = ?");
			st.setInt(1, cb.getQuality() + q);
			st.setInt(2, cb.getId());;
			st.executeUpdate();

			st = con.prepareStatement("select * from cart");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				cartcb.setId(rs.getInt("id"));
				cartcb.setLogin_id(rs.getString("login_id"));
				cartcb.setQuality(rs.getInt("quality"));
				cartcb.setItem_id(rs.getInt("item_id"));
			}
			st.close();
			System.out.println("個数を変更しました。");
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
	 * 買い物かご画面で個数の更新を行う処理
	 * @param quality
	 * @param loginId
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public static  CartBeans qualityChange(int quality, String loginId, int itemId) throws SQLException {
		CartBeans ccb = new CartBeans();
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("update cart t inner join m_item m "
					+ " on t.item_id = m.id  "
					+ " set t.quality = ? "
					+ " where t.login_id = ? and t.item_id = ? ");
			st.setInt(1, quality);
			st.setString(2, loginId);
			st.setInt(3, itemId);
			st.executeUpdate();

			st = con.prepareStatement("select * from cart where login_id = '"+ loginId +"' and item_id = " + itemId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ccb.setId(rs.getInt("id"));
				ccb.setLogin_id(rs.getString("login_id"));
				ccb.setQuality(rs.getInt("quality"));
				ccb.setItem_id(rs.getInt("item_id"));
			}
			System.out.println("カートから個数を更新しました。");
			return ccb;

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
	 * 購入完了したら買った商品買い物かごから削除
	 * @param loginId
	 * @return
	 * @throws SQLException
	 */
	public static  int deleteItemCart(String loginId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("delete from cart where login_id = ?");
			st.setString(1, loginId);

			int rs = st.executeUpdate();

			System.out.println("カート内のアイテムを削除しました。");
			return rs;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static int cartCount(String loginId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();
			st = con.prepareStatement("select count(*) as count from cart where login_id = ?");
			st.setString(1, loginId);

			ResultSet rs =st.executeQuery();

			int count = 0;

			while(rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			}

			System.out.println("買い物かごに入っている商品数はこちらです！");
			return count;

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

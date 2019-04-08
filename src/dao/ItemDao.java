package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.ItemBeans;

public class ItemDao {



	/**
	 * ＴＯＰページで商品をランダムに４つ並べる。
	 * @param limit
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemBeans> getRandItem(int limit) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("SELECT * FROM m_item ORDER BY RAND() LIMIT ? ");
			st.setInt(1, limit);

			ResultSet rs = st.executeQuery();

			ArrayList<ItemBeans> newitemList = new ArrayList<ItemBeans>();

			while (rs.next()) {
				ItemBeans item = new ItemBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
				newitemList.add(item);
			}
			System.out.println("アイテム取得に成功しました。");
			return newitemList;
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
	 * 商品テーブルから詳細を出すためにつかう。
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public static ItemBeans getItem (int itemId) throws SQLException {
		Connection con  = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from m_item where id = ?");
			st.setInt(1, itemId);

			ResultSet rs = st.executeQuery();

			ItemBeans item = new ItemBeans();

			if (rs.next()) {
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
			}

			System.out.println("商品詳細の取得に成功しました。");

			return item;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<ItemBeans> resultIndex (String searchWord) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con =DataBaseManager.getConnection();

			if (searchWord.length() == 0) {
				st = con.prepareStatement("select * from m_item");

			}else {
				st = con.prepareStatement("select * from m_item where name like ?");
				st.setString(1,"%" + searchWord + "%");
			}

			ResultSet rs = st.executeQuery();
			ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();

			while (rs.next()) {
				ItemBeans item = new ItemBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
				itemList.add(item);
			}

			System.out.println("商品検索の結果がこちらです！");

			return itemList;
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

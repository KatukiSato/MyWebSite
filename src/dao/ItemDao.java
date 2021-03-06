package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.ItemBeans;
import beans.TagBeans;

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
	public static ArrayList<ItemBeans> getItem (int itemId) throws SQLException {
		Connection con  = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from m_item where id = ?");
			st.setInt(1, itemId);

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

			System.out.println("商品詳細の取得に成功しました。");

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

	/**
	 * 部分一致検索
	 * タグ検索も追加　2019/05/10 16:09
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemBeans> resultIndex (String searchWord) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con =DataBaseManager.getConnection();

				st = con.prepareStatement("select "
						+ "item.*, "
						+ "tag.id as タグid, tag.name as タグの名前 "
						+ "from m_item item "
						+ "inner join relay re "
						+ "on item.id = re.item_id "
						+ "inner join tag "
						+ "on re.tag_id = tag.id "
						+ "where tag.name like ? "
						+ "or item.name like ? "
						+ "group by item.name");
				st.setString(1,"%" + searchWord + "%");
				st.setString(2,"%" + searchWord + "%");


			ResultSet rs = st.executeQuery();
			ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();

			while (rs.next()) {
				ItemBeans item = new ItemBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
				item.setTagId(rs.getInt("タグid"));
				item.setTagName(rs.getString("タグの名前"));
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

	/**
	 * 売れ筋ランキング
	 * @param rank
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemBeans> itemRanking (int rank) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		ArrayList<ItemBeans> rankList = new ArrayList<ItemBeans>();
		try {
			con =DataBaseManager.getConnection();

			st = con.prepareStatement("select "
					+ " sum(d1.quality) as ranking, "
					+ " m2.name, m2.price, m2.file_name, m2.id as itemid "
					+ " from m_buy_detail d1"
					+ " inner join m_item m2"
					+ " on d1.item_id = m2.id "
					+ " group by d1.item_id"
					+ " order by ranking desc limit ?");

			st.setInt(1, rank);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemBeans ranking = new ItemBeans();
				ranking.setId(rs.getInt("itemid"));
				ranking.setName(rs.getString("name"));
				ranking.setPrice(rs.getInt("price"));
				ranking.setFileName(rs.getString("file_name"));
				rankList.add(ranking);
			}

			System.out.println("このサイトで売れている商品です。");

			return rankList;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 検索件数の表示
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public static int itemCount(String searchWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();
			st = con.prepareStatement("select count(*) as count from m_item where name like ?");
			st.setString(1, "%" + searchWord + "%");

			ResultSet rs =st.executeQuery();

			int count = 0;

			while(rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			}

			System.out.println("検索件数はこちらです！");
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

	/**
	 * タグ情報の取得
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<TagBeans> itemTag (int itemId) throws SQLException{
		Connection con  = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select "+
					"tag.id, "
					+ " tag.name  as tagname" +
					" from \r\n" +
					"	m_item as item\r\n" +
					"		inner join\r\n" +
					"			relay as re\r\n" +
					"		on\r\n" +
					"			item.id = re.item_id\r\n" +
					"		inner join\r\n" +
					"			tag\r\n" +
					"		on\r\n" +
					"			re.tag_id = tag.id\r\n" +
					"where \r\n" +
					"	item.id = ?");
			st.setInt(1, itemId);

			ResultSet rs = st.executeQuery();

			ArrayList<TagBeans> tagList = new ArrayList<TagBeans>();

			while (rs.next()) {
				TagBeans tag = new TagBeans();
				tag.setId(rs.getInt("id"));
				tag.setName(rs.getString("tagname"));
				tagList.add(tag);
			}

			System.out.println("タグの取得に成功しました。");

			return tagList;

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

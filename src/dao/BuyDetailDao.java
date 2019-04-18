package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.BuyDetailBeans;
import beans.BuyHistryBeans;
import beans.ItemBeans;

public class BuyDetailDao {

	/**
	 * 買ったアイテム情報を記録(概略)
	 * @param dItem
	 * @throws SQLException
	 */
	public static void getBuyItemSummary(BuyDetailBeans dItem) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();
			st = con.prepareStatement("insert into m_buy_detail(history_id, quality, item_id) values (?,?,?)");

			st.setInt(1, dItem.getHistory_id());
			st.setInt(2, dItem.getQuality());
			st.setInt(3,dItem.getItem_id());

			st.executeUpdate();

			System.out.println("買ったアイテム情報を記録しました。");
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * アイテム情報の詳細を引っ張る
	 * @param buyItem
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemBeans> getBuyItemDetail(int buyItem) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();
			st = con.prepareStatement("select i2.name, i2.price, i2.id "
					+ " from m_buy_detail d1 "
					+ " inner join m_item i2 "
					+ " on d1.item_id = i2.id "
					+ " where d1.history_id = ?");

			st.setInt(1, buyItem);

			ResultSet rs = st.executeQuery();

			ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();

			while (rs.next()) {
				ItemBeans item = new ItemBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				itemList.add(item);
			}
			System.out.println("アイテム情報の詳細を引っ張ります！");

			return itemList;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<BuyHistryBeans> getHistoryList (int userId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		ArrayList<BuyHistryBeans> hisList = new ArrayList<BuyHistryBeans>();

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select h1.*, "
					+ " p2.id as payid, p2.name as payname,"
					+ " d3.id as deliveryid, d3.name as deliveryname, d3.price as deliveryprice "
					+ " from m_buy_history h1 "
					+ " inner join m_pay_method p2 on h1.pay_method_id = p2.id "
					+ " inner join m_delivery_method d3 on h1.delivery_method_id = d3.id "
					+ " where user_id = ?");

			st.setInt(1, userId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				BuyHistryBeans test = new BuyHistryBeans();
				test.setId(rs.getInt("id"));
				test.setUser_id(userId);
				test.setTotal_priceStr(rs.getString("total_price"));
				test.setPay_method_id(rs.getInt("payid"));
				test.setPay_method_name(rs.getString("payname"));
				test.setDelivery_method_id(rs.getInt("deliveryid"));
				test.setDelivery_method_name(rs.getString("deliveryname"));
				test.setCreate_date(rs.getTimestamp("create_date"));
				test.setDelivery_method_price(rs.getInt("deliveryprice"));
				hisList.add(test);
			}

			System.out.println("おためし！");
			return hisList;

		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<BuyHistryBeans> getHistoryParent(int userId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		 ArrayList<BuyHistryBeans> itemList= new ArrayList<BuyHistryBeans>();

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from m_buy_history where user_id = ?");

			st.setInt(1, userId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				BuyHistryBeans oya = new BuyHistryBeans();
				oya.setId(rs.getInt("id"));
				oya.setUser_id(rs.getInt("user_id"));
//				oya.setBuyDetailBeans(rs.);
				itemList.add(oya);
			}

			System.out.println("ラスト！！");

			return itemList;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<BuyDetailBeans> getHistoryChild(int historyId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		 ArrayList<BuyDetailBeans> buyDetailList= new ArrayList<BuyDetailBeans>();

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select * from m_buy_detail where history_id = ?");

			st.setInt(1, historyId);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				BuyDetailBeans child = new BuyDetailBeans();
				child.setId(rs.getInt("id"));
				child.setHistory_id(rs.getInt("history_id"));
				child.setItem_id(rs.getInt("item_id"));
				child.setQuality(rs.getInt("quality"));
				buyDetailList.add(child);
			}

			System.out.println("ラスト！！");

		} finally {
			if (con != null) {
				con.close();
			}
		}
		return buyDetailList;
	}

}

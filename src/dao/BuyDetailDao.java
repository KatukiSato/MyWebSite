package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.BuyDetailBeans;
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

}

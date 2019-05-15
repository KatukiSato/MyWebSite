package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DataBaseManager;
import beans.TagBeans;

public class TagDao {

	/**
	 * タグテーブルから重複をチェック
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public static boolean isMatchTag(String name) throws SQLException {

		boolean isMatch = true;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("SELECT name FROM tag WHERE name = ?");
			st.setString(1,name);

			ResultSet rs = st.executeQuery();

			System.out.println("タグが重複していないか確認しています。");

			if (rs.next()) {
				isMatch = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}

		System.out.println("タグの確認が完了しました。");
		return isMatch;

	}

	public static void entryTag (String tag) throws SQLException {

		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("insert into	tag (name) values (?)");
			st.setString(1, tag);

			st.executeUpdate();
			System.out.println("データベースにタグが登録されました。");

		}catch (SQLException  e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public List<TagBeans> tagList() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<TagBeans> TagBeansList = new ArrayList<TagBeans>();

		try {
			con = DataBaseManager.getConnection();

			st= con.prepareStatement("select * from tag");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				TagBeans tb = new TagBeans();
				tb.setId(rs.getInt("id"));
				tb.setName(rs.getString("name"));

				TagBeansList.add(tb);
			}
			System.out.println("タグ一覧です！");

			return TagBeansList;
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

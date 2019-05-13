package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DataBaseManager;

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
}

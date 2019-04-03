package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DataBaseManager;

public class CustomerDao {

	/**
	 * @param loginId
	 * @return
	 * ログインIDが重複していないか確かめる手段
	 * @throws SQLException
	 */
	public static boolean isMatchLoginId(String loginId) throws SQLException {

		boolean isMatch = true;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("SELECT login_id FROM t_user WHERE login_id = ?");
			st.setString(1,loginId);

			ResultSet rs = st.executeQuery();

			System.out.println("ログインIDが重複していないか確認しています。");

			if (rs.next()) {
				isMatch = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}

		System.out.println("ログインIDの確認が完了しました。");
		return isMatch;

	}

}

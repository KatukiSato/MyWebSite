package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DataBaseManager;
import beans.CustomerDataBeans;
import controller.Helper;

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

	/**
	 * 新規ユーザ登録処理
	 * @param cdb
	 * @throws SQLException
	 */
	public static void entryUser(CustomerDataBeans cdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();
			st = con.prepareStatement("insert into t_user(login_id, name, mail, phone, address, login_password, create_date) values(?,?,?,?,?,?,?)");

			st.setString(1, cdb.getLogin_id());
			st.setString(2, cdb.getName());
			st.setString(3, cdb.getMail());
			st.setString(4, cdb.getPhone());
			st.setString(5, cdb.getAddress());
			st.setString(6, Helper.getAngo(cdb.getLogin_password()));
			st.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

			st.executeUpdate();
			System.out.println("データベースにユーザが登録されました。");

		}catch (SQLException | NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


	/**
	 * ユーザーテーブルからログインIdとパスワードを探すだけ。
	 * 照合完了出来たらidを取得する。
	 * @param loginId
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 */
	public static int receiveUserId(String loginId, String password) throws SQLException, NoSuchAlgorithmException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();

			st =con.prepareStatement("select * from t_user where login_id = ? ");
			st.setString(1, loginId);

			ResultSet rs = st.executeQuery();

			int customerId = 0;
			while(rs.next()) {
				if(Helper.getAngo(password).equals(rs.getString("login_password"))) {
					customerId = rs.getInt("id");
					break;
				}
			}

			System.out.println("データベースからログインIDとパスワードを探しました。");
			return customerId;

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
	 * 詳細情報の表示処理
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<CustomerDataBeans>  getUserInfoByUserId(int userId) throws SQLException {
		ArrayList<CustomerDataBeans> cdbList = new ArrayList<CustomerDataBeans>();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DataBaseManager.getConnection();

			st = con.prepareStatement("select login_id, name, mail, phone, address from t_user where id =  " + userId);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				CustomerDataBeans cdb = new CustomerDataBeans();
				cdb.setLogin_id(rs.getString("login_id"));
				cdb.setName(rs.getString("name"));
				cdb.setMail(rs.getString("mail"));
				cdb.setPhone(rs.getString("phone"));
				cdb.setAddress(rs.getString("address"));

				cdbList.add(cdb);
			}

			System.out.println("DBからユーザー情報を取得");
			return cdbList;

		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}

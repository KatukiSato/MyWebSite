package controller;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import beans.CartBeans;
import beans.DeliveryMethodBeans;
import dao.DeliveryMethodDao;


public class Helper {

	/**
	 * @author snowr
	 *フォワード先一覧
	 */
	// TOPページ
	static final String TOP_PAGE = "/WEB-INF/jsp/TopPage.jsp";

	// 新規登録入力フォーム
	static final String NEWENTRY_PAGE = "/WEB-INF/jsp/NewEntry.jsp";

	// 新規登録入力内容確認
	static final String NEW_ENTRY_CONFIRM_PAGE = "/WEB-INF/jsp/NewEntryConfirm.jsp";

	//新規登録完了
	static final String NEW_ENTRY_SUCCESS_PAGE = "/WEB-INF/jsp/EntrySuccess.jsp";

	//ログイン画面
	static final String LOGIN_PAGE = "/WEB-INF/jsp/Login.jsp";

	//ログアウト画面
	static final String LOGOUT_PAGE = "/WEB-INF/jsp/Logout.jsp";

	//商品詳細
	static final String ITEM_PAGE = "/WEB-INF/jsp/ItemDetail.jsp";

	//検索結果
	static final String INDEX_PAGE = "/WEB-INF/jsp/Index.jsp";

	//お買い物かご
	static final String CART_PAGE = "/WEB-INF/jsp/cart.jsp";

	//購入方法確認
	static final String REGISTER_PAGE = "/WEB-INF/jsp/Register.jsp";

	//購入最終確認
	static final String REGISTER_CONFIRM_PAGE = "/WEB-INF/jsp/RegisterConfirm.jsp";

	//購入完了
	static final String BUY_COMPLETE_PAGE = "/WEB-INF/jsp/BuyComplete.jsp";

	//お客様情報
	static final String USER_DETAIL_PAGE = "/WEB-INF/jsp/UserDetail.jsp";

	//購入履歴一覧
	static final String BUY_HISTORY_PAGE = "/WEB-INF/jsp/BuyHistory.jsp";

	//ユーザ情報更新
	static final String USER_UPDATE_PAGE = "/WEB-INF/jsp/UserUpdate.jsp";

	//情報更新確認
	static final String USER_UPDATE_CONFIRM_PAGE = "/WEB-INF/jsp/UserUpdateConfirm.jsp";

	//情報更新完了
	static final String UPDATE_SUCCESS_PAGE = "/WEB-INF/jsp/UpdateSuccess.jsp";

	//管理者コマンド一覧
	static final String ADMIN_COMMAND_PAGE = "/WEB-INF/jsp/AdminCommand.jsp";

	//新規タグ登録
	static final String NEW_ENTRY_TAG_PAGE = "/WEB-INF/jsp/NewEntryTag.jsp";

	//タグ登録確認
	static final String NEW_ENTRY_TAG_CONFIRM_PAGE = "/WEB-INF/jsp/NewEntryTagConfirm.jsp";

	//タグ登録完了
	static final String TAG_ENTRY_SUCCESS_PAGE = "/WEB-INF/jsp/TagEntrySuccess.jsp";

	//タグ一覧
	static final String TAG_LIST_PAGE = "/WEB-INF/jsp/TagList.jsp";

	//タグ更新
	static final String TAG_UPDATE_PAGE = "/WEB-INF/jsp/TagUpdate.jsp";


	/**
	 * @param isLoginIdform
	 * @return
	 * ログインIDは英数字のみにしておく。
	 */
	public static boolean isLoginIdform(String inputLoginId) {
		// 英数字以外が入力されていたら
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}

		return false;

	}

	/**
	 * 暗号化に関わるもの
	 * @param ango
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getAngo(String ango) throws NoSuchAlgorithmException{

			String source = ango;

			Charset charset = StandardCharsets.UTF_8;

			String algorithm = "SHA-256";

			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);

		return result;
	}

	/**
	 * 合計金額
	 * @param items
	 * @return
	 */
	public static String getTotalItemPrice(ArrayList<CartBeans> items) {
		int total = 0;
		for (CartBeans item : items) {
			total += item.getTotalprice();
		}

		DeliveryMethodBeans pp = new DeliveryMethodBeans();
		total += pp.getPrice();

		return String.format("%,d",  total);
	}


	/**
	 * 配送料金を加えた合計金額。最終確認につかう。
	 * @param items
	 * @param deliId
	 * @return
	 * @throws SQLException
	 */
	public static String getFinalTotalPrice(ArrayList<CartBeans> items, int deliId) throws SQLException {
		int total = 0;
		for (CartBeans item : items) {
			total += item.getTotalprice();
		}
		DeliveryMethodBeans pp = DeliveryMethodDao.getDeliveryMethodDataBeansByID(deliId);
		total += pp.getPrice();

		return String.format("%,d",  total);
	}

	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}
}

package controller;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

import beans.CartBeans;


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

	static final String REGISTER_PAGE = "/WEB-INF/jsp/Register.jsp";

	static final String REGISTER_CONFIRM_PAGE = "/WEB-INF/jsp/RegisterConfirm.jsp";

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

	public static int getTotalItemPrice(ArrayList<CartBeans> items) {
		int total = 0;
		for (CartBeans item : items) {
			total += item.getPrice() * item.getQuality();
		}
		return total;
	}
}

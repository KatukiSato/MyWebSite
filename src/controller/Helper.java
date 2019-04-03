package controller;

import javax.servlet.http.HttpSession;

public class Helper {

	// TOPページ
	static final String TOP_PAGE = "/WEB-INF/jsp/TopPage.jsp";

	// TOPページ
	static final String NEWENTRY_PAGE = "/WEB-INF/jsp/NewEntry.jsp";

	// 新規登録入力内容確認
	static final String NEW_ENTRY_CONFIRM_PAGE = "/WEB-INF/jsp/NewEntryConfirm.jsp";

	/**
	 * セッションから指定データを取得（削除も一緒に行う）
	 *
	 * @param session
	 * @param str
	 * @return
	 */
	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;


	}

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

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemBeans;
import dao.ItemDao;

/**
 * Servlet implementation class TopPage
 */
@WebServlet("/TopPage")
public class TopPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {

			//商品情報を取得
			ArrayList<ItemBeans>item = ItemDao.getRandItem(4);

			ArrayList<ItemBeans> sellranking = ItemDao.itemRanking(3);
			//リクエストスコープにセット
			request.setAttribute("itemList", item);
			request.setAttribute("ranking", sellranking);

			/*登録確認画面でＴＯＰペーシに戻った場合、入力情報を捨てる。エラーメッセージも？？
			追記：　多分いらないと思うので、最終的に確認したら削除する　2019/04/08 14:11　　　　　　　
			*/
//			session.removeAttribute("udb");
//			session.removeAttribute("validationMessage");
//			session.removeAttribute("userId");
//			request.getAttribute("qchange");
//			session.removeAttribute("qchange");

			//セッションにsearchが入っていたら破棄する
			String searchWord = (String)session.getAttribute("search");
			if(searchWord != null) {
				session.removeAttribute("search");
			}

			request.getRequestDispatcher(Helper.TOP_PAGE).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import dao.CartDao;
import dao.ItemDao;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();

		try {
			String login = (String) session.getAttribute("logId");
			int quality =Integer.parseInt (request.getParameter("quality"));
			int itemId =Integer.parseInt (request.getParameter("item_id"));

			//商品をカートに入れる処理
			int cart = CartDao.insertItem(login, quality, itemId);

			//商品詳細を引っ張ってくる処理
			ArrayList<ItemBeans> item = ItemDao.getItem(itemId);

			//ログインされていない状態だったら、ログイン画面へ。
			if(login == null) {
			//ここの改善の余地はあるかも。　ログインIDがnullのまま登録されている原因か。
				session.setAttribute("number", quality);
				session.setAttribute("item", itemId);
				response.sendRedirect("Login");

			} else if(login != null){
				session.setAttribute("number", quality);
				session.setAttribute("item", itemId);
				session.setAttribute("itemList", item);

				request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);

			}
		} catch ( Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}

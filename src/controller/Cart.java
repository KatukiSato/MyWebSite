package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBeans;
import beans.ItemBeans;
import dao.CartDao;

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

		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("logId");

		//カートに入れられた商品を表示する処理
		try {
			ArrayList<ItemBeans> show = CartDao.showCart(login);

			session.setAttribute("show", show);
			session.getAttribute("cart");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

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
			int quality = Integer.parseInt (request.getParameter("quality"));
			int itemId = Integer.parseInt(request.getParameter("item_id")) ;

			session.setAttribute("test", itemId);

			//商品をカートに入れる処理
			ArrayList<CartBeans> cart = CartDao.insertItem(login, quality, itemId);

			//カートに入れられた商品を表示する処理
			ArrayList<ItemBeans> show = CartDao.showCart(login);

			CartBeans check = CartDao.checkCartItem(login,itemId, quality);
			if(check != null) {
				session.setAttribute("show", show);
				session.setAttribute("cart", cart);

				request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
			} else {
				//ログインされていない状態だったら、ログイン画面へ。
				if(login == null) {
					response.sendRedirect("Login");

				} else if(login != null){
					session.setAttribute("show", show);
					session.setAttribute("cart", cart);

					request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
				}
			}

		} catch ( Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}

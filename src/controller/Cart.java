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

		try {
			ArrayList<CartBeans> show = CartDao.showCart(login);

			session.setAttribute("show", show);
			session.getAttribute("show");
			session.getAttribute("cart");
			session.getAttribute("qchange");
			session.removeAttribute("qchange");

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
//			int id = Integer.parseInt(request.getParameter("id")) ;
			CartBeans check = CartDao.checkCartItem(login, itemId);


			CartBeans cb = new CartBeans();
			cb.setUp(login, quality, itemId);
			if(login == null) {
				response.sendRedirect("Login");

			} else if(login != null){


				if (check.getQuality() == 0 && check.getItem_id() == 0) {

					//商品をカートに入れる処理
					CartDao.insertItem(cb,itemId);

					//カートに入れられた商品を表示する処理
					ArrayList<CartBeans> show = CartDao.showCart(login);


					//セッションだとダメなので、修正するかも
					session.setAttribute("show", show);
					session.setAttribute("cart", cb);
					System.out.println("完全に新規です。");
					request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);

				} else {
					//既にカートに商品が登録されている時。
					CartDao.qualityUpdateCart(cb.getQuality(), check);

					ArrayList<CartBeans> show = CartDao.showCart(login);
					session.setAttribute("show", show);
					System.out.println("選んだ商品が重複していたので、個数を追加しました。");
					session.setAttribute("cart2", cb);
					request.getRequestDispatcher(Helper.CART_PAGE).forward(request, response);
				}
			}

		} catch ( Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}

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

import beans.BuyDetailBeans;
import beans.BuyHistryBeans;
import beans.CartBeans;
import dao.BuyDao;
import dao.BuyDetailDao;
import dao.CartDao;

/**
 * Servlet implementation class BuyComplete
 */
@WebServlet("/BuyComplete")
public class BuyComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Object logcheck = session.getAttribute("userId");

		if (logcheck == null) {
			System.out.println("飛びます！");
			response.sendRedirect("TopPage");
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		try {
			ArrayList<CartBeans> cart = (ArrayList<CartBeans>)session.getAttribute("show");

			BuyHistryBeans bhb = (BuyHistryBeans) session.getAttribute("bhb");
			String loginid = (String)session.getAttribute("logId");

			//購入処理
			int buyItem = BuyDao.insertBuy(bhb);

			//商品の情報の概略を紐付け
			for(CartBeans summaryItem : cart) {
				BuyDetailBeans dItem = new BuyDetailBeans();
				dItem.setHistory_id(buyItem);
				dItem.setQuality(summaryItem.getQuality());
				dItem.setItem_id(summaryItem.getItem_id());
				BuyDetailDao.getBuyItemSummary(dItem);
			}

//			ArrayList<ItemBeans> detailItem = BuyDetailDao.getBuyItemDetail(buyItem);

			//買い物かごの商品を削除
			CartDao.deleteItemCart(loginid);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.getRequestDispatcher(Helper.BUY_COMPLETE_PAGE).forward(request, response);

	}

}

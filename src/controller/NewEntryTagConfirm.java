package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TagDao;

/**
 * Servlet implementation class NewEntryTagConfirm
 */
@WebServlet("/NewEntryTagConfirm")
public class NewEntryTagConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEntryTagConfirm() {
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

		request.getRequestDispatcher(Helper.NEW_ENTRY_TAG_CONFIRM_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String tag =request.getParameter("tag");

		String validationMessage = "";

		//取りあえずタグの重複だけ確かめる。他にもあったら追加
		try {
			if (!TagDao.isMatchTag(tag)) {
				validationMessage += "既にデータベースに登録されています。";
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (validationMessage.length() == 0) {
			session.setAttribute("tag", tag);
			request.getRequestDispatcher(Helper.NEW_ENTRY_TAG_CONFIRM_PAGE).forward(request, response);

		} else {
			session.setAttribute("tag", tag);
			session.setAttribute("validationMessage", validationMessage);
			response.sendRedirect("NewEntryTag");
		}



	}

}

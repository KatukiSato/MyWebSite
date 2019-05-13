package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewEntryTag
 */
@WebServlet("/NewEntryTag")
public class NewEntryTag extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEntryTag() {
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

		//後で型の変更の必要あり？　2019/05/13 17:14
		String tag = session.getAttribute("tag")!= null?(String)
				Helper.cutSessionAttribute(session, "tag"):new String();;

		request.setAttribute("tag", tag);

		request.getRequestDispatcher(Helper.NEW_ENTRY_TAG_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

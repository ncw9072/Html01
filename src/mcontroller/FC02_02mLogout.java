package mcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberServiceImpl;

@WebServlet("/mlogout")
public class FC02_02mLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl service = new MemberServiceImpl();

	public FC02_02mLogout() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="home.jsp";
		String message = null;
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginID")!=null) {
			message = "~~ "+session.getAttribute("loginID")+"님 로그아웃 되었습니다 !!! ~~";
			session.invalidate(); // 윗 줄과의 순서 중요!
		}else {
			message="~~ 당신은 로그인 되어있지 않았습니다 !!! ~~";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

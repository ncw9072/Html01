package mcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/mlist")
public class FC02_01mList extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl service = new MemberServiceImpl();

	public FC02_01mList() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberVO> list=service.selectList();
		String message= null;
		
		String url="member/memberList.jsp";
		if(list!=null) {
			request.setAttribute("Banana", list);
			message=" ~~ selectList 성공 ~~ ";
			}
		else {
			message=" ~~ 출력할 자료가 없습니다 ~~ ";
		}
		// 서버내에서의 요청시 message가 있는 경우를 위해
		
		if(request.getParameter("message")!=null) {
		  message=request.getParameter("message"); }
		 
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost
}//class

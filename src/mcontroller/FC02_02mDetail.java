package mcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/mdetail")
public class FC02_02mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl service = new MemberServiceImpl();

	public FC02_02mDetail() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    
		vo.setId(request.getParameter("id"));
		vo = service.selectOne(vo);
		
		String message= null;
		String url="member/memberDetail.jsp";
		if(vo != null) {
			request.setAttribute("Apple", vo);
			// Update 확인
			if("U".equals(request.getParameter("jcode"))) {
				url="member/updateForm.jsp";
			}
		}else {
			message="~~ 해당 자료는 존재하지 않습니다 ~~";
			url="/mlist?message="+message; // 메시지와 같이 서블릿으로 보내줌
		}
		
		if(request.getParameter("message")!=null) {
			message=request.getParameter("message"); 
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}//class

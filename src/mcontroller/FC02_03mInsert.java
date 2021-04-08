package mcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/minsert")
public class FC02_03mInsert  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl service = new MemberServiceImpl();

	public FC02_03mInsert() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	1. request 처리
		//	-> 한글처리(FrontController 에서), parameter
		//	2. 필요객체 생성
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setBirthd(request.getParameter("birthd"));
		vo.setPoint(Integer.parseInt(request.getParameter("point")));
		vo.setWeight(Double.parseDouble(request.getParameter("weight")));
		vo.setRid(request.getParameter("rid"));
		//	3. dao 처리
		//	4. 결과
		String url = "login/loginForm.jsp";
		if(service.insert(vo) > 0) {
			//	성공 -> message, 로그인 (loginForm.jsp)
			request.setAttribute("message", "~~ 회원가입 성공 !! 로그인 후 이용하세요 ~~");
		}else {
			//	실패 -> message, 재입력 (joinForm.jsp)
			request.setAttribute("message", "~~ 회원가입 실패 !! 다시 입력 하세요 ~~");
			url="member/joinForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

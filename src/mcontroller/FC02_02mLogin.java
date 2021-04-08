package mcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/mlogin")
public class FC02_02mLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl service = new MemberServiceImpl();

	public FC02_02mLogin() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	1. id, password 확인
		//	=> request, dao 처리
		//	2. 결과 처리
		
		String password = request.getParameter("password");
		MemberServiceImpl service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String message =null;
		String url= "/login/loginForm.jsp";
		
		vo.setId(request.getParameter("id"));
		vo = service.selectOne(vo);
		
		if(vo != null) { // ID OK
			if(vo.getPassword().equals(password)) {
				// Login 성공 -> login 정보 session에 보관, home.jsp
				request.getSession().setAttribute("loginID", vo.getId());
				message= vo.getId()+"님 로그인 성공 !!!";
				url= "home.jsp";
			}else {	// Password Error -> message, 재로그인
				message= "~~ 비밀번호가 틀립니다!! 다시하세요 ~~";
			}
		}else {	// ID Error -> message, 재로그인
			message= "~~ 없는 아이디입니다!! 다시 하세요 !!! ~~";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}//class

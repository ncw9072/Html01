package mcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/mdelete")
public class FC02_05mDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl service = new MemberServiceImpl();

	public FC02_05mDelete() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 정보에서 id getAttribute
		String url = null;
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("loginID") != null) {
			MemberServiceImpl service = new MemberServiceImpl();
			MemberVO vo = new MemberVO();
			vo.setId((String) session.getAttribute("loginID"));
			if (service.delete(vo) > 0) { // 삭제 처리 -> List
				url = "home.jsp";
				request.setAttribute("message", "~~ 삭제성공, 1개월 후 재가입 할 수 있습니다 ~~");
				session.invalidate();
			} else { // 삭제오류 -> Detail
				url = "/mdetail?id=" + vo.getId() + "&message=~~ 삭제오류 , 다시 하세요 ~~";
				// request.setAttribute("message", "~~ 삭제오류 , 다시 하세요 ~~");
				// ㄴ detail에 setAttribute가 없으므로 재요청이어도 이런방법이 가능하긴 함
				// url="/mdetail?id="+vo.getId();
			}
		} else {
			request.setAttribute("message", "~~ 삭제할 정보가 없습니다 (sessionIsNull) ~~");
			url = "home.jsp";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}

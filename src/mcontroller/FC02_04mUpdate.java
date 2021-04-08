package mcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberServiceImpl;
import vo.MemberVO;

@WebServlet("/mupdate")
public class FC02_04mUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberServiceImpl service = new MemberServiceImpl();

	public FC02_04mUpdate() {
		super();
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		String url=null;// url이 null인건 좋지 않음
		String message=null;
		response.setContentType("text/html;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setBirthd(request.getParameter("birthd"));
		vo.setPoint(Integer.parseInt(request.getParameter("point")));
		vo.setWeight(Double.parseDouble(request.getParameter("weight")));
		vo.setRid(request.getParameter("rid"));
		System.out.println("updateTest=>"+vo);
		if(service.update(vo)>0) {
			// 성공 -> message, List출력 (memberList.jsp)
			url="/mlist?message=~~ 정보 수정 성공 !!! ~~";
			// message="~~ 정보 수정 성공 !!! ~~";
		}else {
			// 실패 -> message, Detail (mdetail)
			url="/mdetail?id="+vo.getId()+"&message=~~ 정보 수정 실패!!! 다시 하세요 ~~";
		//	message="~~ 정보 수정 실패!!! 다시 하세요 ~~";
		}
	//	request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
	}// doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}// class

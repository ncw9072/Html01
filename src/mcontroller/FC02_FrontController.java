//package mcontroller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = { "*.do" })
//public class FC02_FrontController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	public FC02_FrontController() {
//		super();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// 1. 요청분석
//		// => uri를 분석해서 요청명을 확인
//		// => request 한글 처리
//		request.setCharacterEncoding("UTF-8");
//		String uri = request.getRequestURI();
//		String page = uri.substring(uri.lastIndexOf("/"));
//		System.out.println("Page => " + page);
//		//** 기본 준비
//		String url = "home.jsp";
////		// 3. 의 결과 View의  url이 "~.do"인 경우 전달되는 message 처리하기
////		if(request.getParameter("message") != null) { // <- 서블릿에서 .do로 다시 올아온 경우
////			request.setAttribute("message", "** Member Test : "+request.getParameter("message"));
////		}else { // <- 그렇지 않은 경우: 처음. ( 바로 jsp로 가는 경우는 이미 해당 서블릿에서 setAttribute로 메시지 전달했음)
////			request.setAttribute("message", "** Web03 Member Test **");
////		}
//		// ** 각 리턴하는 값이 '~.do'형태인 url은 여기 프론트컨트롤러에서 message가 덧씌워질 수 있으므로
//		// ** 파라미터로 보내주고 그렇지 않은 url은 다시 프론트컨트롤러로 돌아올 일이 없으므로 각 클래스에서 바로 setAttribute해준다. 
//	//	request.setAttribute("message", "** Front Controller02 Test **");
//		// 메시지는 기본값을 정해서 어트리뷰트에 저장했고, 이후에는 입력받은 페이지에 따라 어트리뷰트 설정하는 부분이 있다면 메시지를 덮어씌워줌
//		// delete의 경우 삭제메시지는, delete를 통해 slist.do가 한번더 호출되게 만들었으므로 메시지가 여기 메시지로 다시 덮혀짐
//		
//		// 2. 해당 서비스 실행
//		// => page 에 해당하는 Controller의 매핑을 Factory 에 맡김
//		// => PageFactory 생성
//		//	  싱글톤 이므로
//		// 	  PageFactory pf = new PageFactory(); -> 허용안됨
//		FC02_PageFactory pf = FC02_PageFactory.getInstance();
//		FC02_00Controller controller = pf.getController(page); // 인스턴스로 다형성 적용 (, 추상메서드도 적용)
//		if(controller != null) {
//			url = controller.doUser(request, response); // <-실질적인 실행코드. url도 리턴하고, 해당 controller의 기능 모두 구현함
//			if(request.getParameter("message")!=null) {
//				// 리턴된 url이 .do인 상황에선 url에  파라미터를 붙여 보내주고 여기서 받는다. 그러면 여기서 setAttribute를 덮어(수정)쓸수 있다.
//				request.setAttribute("message", request.getParameter("message"));
//			}
//		}else {									// ㄴ원하는 객체의 오버라이딩해놓은 메서드를 실행시킴
//			request.setAttribute("message","~~ FC02 Test : 없는 요청 입니다 ~~");
//		}
//
//		// 3. 결과
//		request.getRequestDispatcher(url).forward(request, response);
//	}// doGet
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}// doPost
//
//}// class

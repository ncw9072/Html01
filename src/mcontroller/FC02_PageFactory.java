//package mcontroller;
//
//import java.util.HashMap;
//import java.util.Map;
//
////** PageFactory
//// 요청명(age) 에 따른 컨트롤러를 생성해서 전달
//
////** 싱글톤 패턴: 인스턴스를 1개만 허용  (정보가 아닌 기능위주로 필요할 때)
//// => 일반적인 경우 : 복수의 인스턴스 가능
//// Student s1 = new Student();
//// Student s2 = new Student();
//// ** 방법
////=> 생성자를 private으로 내부에서만 사용가능하도록하고
////=> 내부에서 getInstance() 메서드로 생성 제공해줌
////=> 외부에서는 getInstance() 메서드를 통해서만 사용
//
//// ** Map 적용하기
//
//public class FC02_PageFactory {
//	
//	// Map 정의
//	// key, value 를 put :
//	private Map<String,FC02_00Controller> mappings;
//	
//	// 싱글톤 패턴 구현
//	// ** Map 적용
//	private FC02_PageFactory() {
////		mappings = new HashMap<>(); //우변 타입 생략가능
//		mappings = new HashMap<String,FC02_00Controller>();
//		mappings.put("/mlist.do", new FC02_01mList());
//		mappings.put("/mdetail.do", new FC02_02mDetail());
//		mappings.put("/mlogin.do", new FC02_02mLogin());
//		mappings.put("/mlogout.do", new FC02_02mLogout());
//		mappings.put("/minsert.do", new FC02_03mInsert());
//		mappings.put("/mupdate.do", new FC02_04mUpdate());
//		mappings.put("/mdelete.do", new FC02_05mDelete());
//	}
//		
//	private static FC02_PageFactory instance = new FC02_PageFactory();
//	// static 으로 정의해야만 외부에서는 인스턴스생성없이 사용가능 (1개의 단일 인스턴스를 사용함)  // 선생님 설명:static 으로 정의해야만 외부에서 '인스턴스없이(X)' 클래스명으로만 사용가능(<-new 없이) 
//	public static FC02_PageFactory getInstance(){
//		return instance;
//	} 
////	public static PageFactory getInstance2() {
////		return new PageFactory();
////	}
//	
//	// 요청명(age) 에 따른 콘트롤럴르 생성해서 전달
//	public FC02_00Controller getController(String page) {
//	
//		// Test2 Map
//		return mappings.get(page);
//		
//	/*	Test1
//		FC00_Controller controller =null;
//		if(page.equals("/slist.do")) {
//			controller = new FC02_01sList();
//		}else if(page.equals("/sdetail.do")) {
//			controller = new FC02_02sDetail();
//		}else if(page.equals("/sinsert.do")) {
//			controller = new FC02_03sInsert();
//		}else if(page.equals("/sdelete.do")) {
//			controller = new FC02_04sDelete();
//		}
//		return controller;
//	*/	
//	}// Controller
//}// class

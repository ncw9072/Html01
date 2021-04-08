package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	// 1. DB Connection
		public static Connection getConnection() {

			// 1) DB 드라이버 이름 지정
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 해당 드라이버를 메모리에 올려줌
				// 2) DB 드라이버 위치 지정
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl"; // @ip:포트번호:해당 버젼의 SID
				// 3) 로그인 정보 (Connection 생성)
				return DriverManager.getConnection(url, "system", "oracle"); // Connection을 반환해주는 메서드
			} catch (Exception e) {
				System.out.println("** DB 연결 실패 => " + e.toString());
				return null;
			}

		}// getConnection
	
}

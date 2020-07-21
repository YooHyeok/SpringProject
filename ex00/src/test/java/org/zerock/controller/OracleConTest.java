package org.zerock.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConTest {
	private static final String Driver = "oracle.jdbc.OracleDriver";
	//static final은 정적 상수이다. 상수는 관례적으로 영어 대문자로 한다.
	//OracleDriver jdbc 드라이버 클래스명
	//정적 상수는 주로 클래스로 직접 접근해서 사용하기위해 선언해준다 . 예를들어 OracleConTest.Driver 이렇게
	//하지만 private가 붙어이씅므로 다른클래스에서는 사용할수없고 해당클래스의 메인메서드나, 중첩클래스에서 활용할수있지 않을까 생각든다
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	//오라클 접속주소, 1521은 포트번호, xe는 DB명
	private static final String USER="week";//오라클 접속 사용자
	private static final String PW="week";//오라클 접속 사용자 비밀번호
	
	@Test //JUnit 연습용 테스트 애노테이션 (임포트해줘야한다.)
	public void testCon() throws Exception{
		Class.forName(Driver);//jdbc 드라이버 클래스 로드
		
		try ( Connection con = DriverManager.getConnection(URL,USER,PW) ){
			
		/*	java 7 버전에서 추가된 문법으로 Connection은 AutoClosable인터페이스를 구현 상속을 받았기 때문에 try()내에서 객체를 생성하면
			finally문에서 명시적 코드로 close()하지 않아도 자동으로 닫힌다.*/
			
			System.out.println("JDBC드라이버가 잘 로드 되나(연결되나)확인");
			System.out.println(con);//con 즉 디비연결 객체주소를 이클립스 콘솔모드에 출력
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


package org.zerock.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //Junit 실행 클래스 어노테이션
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
//root-context.xml파일 경로 설정 (DB연결된 정보를 읽어온다.)

public class DataSourceTest {
	@Inject //자동의존성 주입
	//주방장 : ds
	private DataSource ds; //ds 멤버변수인 참조변수에 객체 주소를 주입해서 사용할 수 있게 의존성 주입 (커넥션풀 관리객체)
	//DriverManagerDataSource의 최상위 인터페이스는 DataSource인터페이스이다.
	 //private DriverManagerDataSource ds; 

	
	@Test //JUnit 연습용 테스트 어노테이션
	public void testCon() throws Exception{
		
		try (Connection con = ds.getConnection()){//커넥션 풀 관리 ds로 DB연결 con을 생성
			
			System.out.println(con);//레스토랑 사장
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

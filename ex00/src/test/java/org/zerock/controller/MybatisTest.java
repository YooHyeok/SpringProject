package org.zerock.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//JUnit 테스트 실행클래스
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})//root-context.xml파일 로드
public class MybatisTest {
	@Autowired //자동의존성 주입 => DI(의존성 주입 => 해당 변수에 객체주소를 주입하는 과정)
	
	private SqlSessionFactory sqlFactory;//주방장
	
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	@Test
	public void testSession() throws Exception{
		try (SqlSession sqlSession = sqlFactory.openSession()){
		/*	1.SqlSession은 자바7버전에 추가된 AutoCloseable인터페이스를 구현상속 받았으므로
			try()내에서 객체를 생성하면 명시적인 close()를 하지 않아도 자동으로 닫힌다.
			2. sqlSession은 mybatis쿼리문 수행객체가 된다.*/
			
		System.out.println(sqlSession);//레스토랑
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}

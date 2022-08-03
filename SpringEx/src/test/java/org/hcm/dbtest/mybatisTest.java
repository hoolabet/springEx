package org.hcm.dbtest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class mybatisTest {
	@Autowired // <- 를 선언하면 DataSource dataSource = new DataSource(); 으로 적용
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() throws Exception{
		try {
			SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();
			
			System.out.println("성공");
		}catch (Exception e) {
			e.getMessage();
		}
	}
}

package com.maiziedu.demo.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.maiziedu.demo.mybatis.bean.Student;
import com.maiziedu.demo.mybatis.mapper.StudentMapper;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {

			// 1. 获取sqlSessionFactory
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);

			// 2. 获取SqlSession
			SqlSession session = sqlSessionFactory.openSession();
			try {
				// a.method1
//				Student student = (Student) session
//						.selectOne(
//								"com.maiziedu.demo.mybatis.mapper.StudentMapper.selectStudent",
//								1);

				// b.method2
				StudentMapper mapper = session.getMapper(StudentMapper.class);
				Student student = mapper.selectStudent(new Long(1));

				System.out.println(student.getName());
				System.out.println(student.getBirthday().toString());
			} finally {
				session.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.maiziedu.demo.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.maiziedu.demo.mybatis.bean.Score;
import com.maiziedu.demo.mybatis.bean.Student;
import com.maiziedu.demo.mybatis.mapper.OperMapper;
import com.maiziedu.demo.mybatis.mapper.ScoreMapper;
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
				OperMapper operMapper = session.getMapper(OperMapper.class);
				ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
				
				/*Student student = mapper.selectStudent(new Long(1));
				//取同样的内容，SQL只打印一次，缓存的原因
				Student student2 = mapper.selectStudent(new Long(1));
				
				System.out.println(student.getName());
//				System.out.println(student.getBirthday().toString());
				System.out.println(student.getBrt().toString());
				System.out.println(student.getGender());*/
				
				/*Student stu = new Student();
				stu.setId("007");
				stu.setName("lxd008");
				stu.setBrt(java.sql.Date.valueOf("1992-02-02"));
				mapper.updateStudent(stu);*/
				
				/*Oper oper = new Oper();
				oper.setOpertype("insert");
				oper.setOperdate(java.sql.Date.valueOf("1993-08-14"));
				operMapper.insertOper(oper);*/
				
				/*stu.setId("007");
				stu.setName("lxd2");
				mapper.updateStudent(stu);*/
				
				/*stu.setId("007");
				mapper.deleteStudent(stu);*/
				
//				Score score = new Score();
//				score.setKemu("语文");
//				
//				Student stu = new Student();
//				stu.setId("1");
//				stu.setGender("2");
				
//				score.setStu(stu);
				
				/*List<Score> score1 = (List<Score>)scoreMapper.getScoreByStudentandKeMu(score);
				System.out.println("stu name: " + score1.getStu().getName());
				System.out.println("stu kemu: " + score1.getKemu());
				System.out.println("stu gender: " + score1.getStu().getGender());
				System.out.println(score1.size());*/
				
		/*		List<Long> ids = new ArrayList<>();
				ids.add(new Long(1));
				ids.add(new Long(2));
				ids.add(new Long(3));
				System.out.println(mapper.queryStudentByIds(ids).size());*/
				
				Student stu = new Student();
				stu.setName("xd");
				System.out.println(mapper.queryStudentByName(stu));
				
				session.commit();
				System.out.println("操作成功");
			} catch (Exception e) {
				e.printStackTrace();
				session.rollback();
			} finally {
				session.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}

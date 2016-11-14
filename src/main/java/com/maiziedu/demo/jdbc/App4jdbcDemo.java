package com.maiziedu.demo.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class App4jdbcDemo {
	public static void main(String[] args) {
		PreparedStatement stmt = null;
		Connection con = null;

		try {

			FileInputStream fis = new FileInputStream("D:\\JavaWorkSpace\\mybatisTest\\mybatis\\src\\main\\resources\\jdbc.properties");
			Properties p = new Properties();
			p.load(fis);

			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
			con.setAutoCommit(false);

			//语句中大小写没有区分
			String sql = "select * from Student where ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, new Long(1));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				Date birthday = rs.getDate("BIRTHDAY");
				String name = rs.getString("NAME");
				System.out.println("ID[" + id + "]:" + name + "生日是:" + birthday);
			}
			rs.close();
			//2-1插入student
		/*	String insertSql = "insert into Student(ID, BIRTHDAY, NAME) values(?, ?, ?)";
			stmt = con.prepareStatement(insertSql);
			stmt.setLong(1, new Long(5));
			stmt.setDate(2, java.sql.Date.valueOf("1994-12-12"));
			stmt.setString(3, "田七");
			
			stmt.execute();
			System.out.println("1 student insert");*/
			
		/*	String insertOperSql = "insert into OPERLOG(OPERTYPE, OPERDATE) values(?, ?)";
			stmt = con.prepareStatement(insertOperSql);
			stmt.setString(1, "插入操作");
			stmt.setDate(2, java.sql.Date.valueOf("2016-11-02"));
		//	throw new RuntimeException();
			stmt.execute();
			System.out.println("1 operlog insert");*/
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

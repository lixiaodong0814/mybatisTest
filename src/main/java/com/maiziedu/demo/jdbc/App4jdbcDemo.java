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

			FileInputStream fis = new FileInputStream("D:\\JavaWorkSpace\\mybatis\\src\\main\\resources\\jdbc.properties");
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

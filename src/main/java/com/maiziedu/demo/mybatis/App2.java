package com.maiziedu.demo.mybatis;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class App2 {
	public static void main(String[] args) {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setDatabaseName("test");
		ds.setUser("root");
		ds.setPassword("root");
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, ds);
		Configuration configuration = new Configuration(environment);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

	}

}

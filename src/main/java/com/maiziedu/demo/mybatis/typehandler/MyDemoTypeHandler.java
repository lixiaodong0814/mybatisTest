package com.maiziedu.demo.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 封装结果转换
 * @author 李晓东
 *
 */
public class MyDemoTypeHandler extends BaseTypeHandler {
	 @Override
	  public void setNonNullParameter(PreparedStatement ps, int i, Object parameter,
	       JdbcType jdbcType) throws SQLException {
	     System.out.println("setNonNullParameter....");
	     String gender = (String)parameter; 
	     
	     if("male".equals(gender)){
	       ps.setInt(i, 0);
	     }else if("female".equals(gender)){
	       ps.setInt(i, 1);
	     }else{
	       ps.setInt(i, 2);
	     } 
	  }

	  @Override
	  public String getNullableResult(ResultSet rs, String columnName)
	       throws SQLException {
	     System.out.println("getNullableResult1....");
	     int gender = rs.getInt(columnName);
	     if(gender == 0){
	       return "male";
	     }else if(gender == 1){
	       return "female";
	     }else{
	       return "unknown";
	     }
	  }

	  @Override
	  public String getNullableResult(ResultSet rs, int columnIndex)
	       throws SQLException {
	     System.out.println("getNullableResult2....");
	     int gender = rs.getInt(columnIndex);
	     if(gender == 0){
	       return "male";
	     }else if(gender == 1){
	       return "female";
	     }else{
	       return "unknown";
	     }
	  }

	  @Override
	  public String getNullableResult(CallableStatement cs, int columnIndex)
	       throws SQLException {
	     return cs.getString(columnIndex);
	  }

	
}

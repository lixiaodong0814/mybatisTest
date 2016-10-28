package com.maiziedu.demo.mybatis.objfactory;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class DemoObjFactory extends DefaultObjectFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8795813297333356941L;

	@Override
	public <T> T create(Class<T> type) {
		System.out.println(type.getName());
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public void setProperties(Properties properties) {
		System.out.println("setProperties - properties: " + properties.toString() + ", someProperty: " + properties.getProperty("name"));
		super.setProperties(properties);
	}

	@Override
	protected Class<?> resolveInterface(Class<?> type) {
		return super.resolveInterface(type);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		return super.isCollection(type);
	}

	
}

package com.maiziedu.demo.mybatis.bean.page;

import com.maiziedu.demo.mybatis.bean.Student;
import com.maiziedu.demo.mybatis.plugin.page.Page;

public class StudentPage extends Student {
	
	private Page<Student> page = new Page<Student>();

	public Page<Student> getPage() {
		return page;
	}

	public void setPage(Page<Student> page) {
		this.page = page;
	}
	
}

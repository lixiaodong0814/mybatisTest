package com.maiziedu.demo.mybatis.mapper;

import java.util.List;

import com.maiziedu.demo.mybatis.bean.Student;

public interface StudentMapper {
	//新增接口
	public Student selectStudent(Long id);

	public void insertStudent(Student stu);
	
	public void updateStudent(Student stu);
	
	public void deleteStudent(Student stu);
	
	public List<Student> queryStudentByIds(List<Long> id);
	
	public List<Student> queryStudentByName(Student stu);
}

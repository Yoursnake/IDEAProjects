package com.example;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
@MapperScan("com.example.dao")
public class StudentApplication {

	@Autowired
	static StudentDao studentDao;

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setId(1);
		student1.setAge(10);
		student1.setSex(true);
		Date date = new GregorianCalendar(1997, 8, 2).getTime();
		student1.setBirthday(date);
		student1.setStudentName("shengliyi");
		studentDao.save(student1);
		SpringApplication.run(StudentApplication.class, args);
	}
}

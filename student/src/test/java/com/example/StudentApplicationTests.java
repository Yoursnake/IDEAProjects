package com.example;

import com.example.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.dao")
public class StudentApplicationTests {

	@Autowired
	StudentDao studentDao;

	@Test
	public void contextLoads() {


	}

}

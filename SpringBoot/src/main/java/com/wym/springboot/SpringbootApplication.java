package com.wym.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
//排除此类的autoconfig。启动以后就可以正常运行。
// 这是因为添加了数据库组件，所以autoconfig会去读取数据源配置，
// 而我新建的项目还没有配置数据源，所以会导致异常出现。
public class SpringbootApplication {

	@Value("${teacher.name}")
	private String teacherName;
	@Value("${teacher.age}")
	private int age;
//	@Autowired
//	private AuthorSetting authorSetting;
    @RequestMapping("/")
	String index(){
    	return "你的名字是："+this.teacherName+" "+"你的年龄是："+this.age;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}

package com.cer;

import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TkMybatisApplicationTests {

	@Test
	public void contextLoads() {
		Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/test", "root", "123456").load();
		flyway.migrate();
	}

}

package com.ccm.configmaster.configmaster;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureMockMvc
class ConfigmasterApplicationTests {

	 @Mock
	 private SpringApplication springApplication;
	
	@Test
	void mockMain() {
		assertTrue(true);
	}

}

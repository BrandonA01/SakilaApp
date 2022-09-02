package com.Sakila.api.SakilaApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SakilaAppApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("hello", "hello", "hello!=hello");
	}
}

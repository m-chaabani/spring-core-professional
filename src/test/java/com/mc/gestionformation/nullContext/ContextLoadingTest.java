package com.mc.gestionformation.nullContext;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class ContextLoadingTest {
	@Autowired
	ApplicationContext ctx;

	@Test
	public void testContext() {
		assertNotNull(ctx);
	}
}
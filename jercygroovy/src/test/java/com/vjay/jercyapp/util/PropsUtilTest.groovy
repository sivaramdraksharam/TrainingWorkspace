package com.vjay.jercyapp.util

import static org.junit.Assert.*

import org.junit.Test

class PropsUtilTest {

	@Test
	public void test() {
		File file = new File(getClass().getResource("/dbconfig.properties")?.toURI())
		PropsUtil props = new PropsUtil(file);
		println props.connection_url
		
		assert props.'connection_url'.equals("jdbc://localhost:443")
		props.driver('com.sql.test') 
		assert props.driver.equals("com.sql.test")
		println props.driver
	}

}

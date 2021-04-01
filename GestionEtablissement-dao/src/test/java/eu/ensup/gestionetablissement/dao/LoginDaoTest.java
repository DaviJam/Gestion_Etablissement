package eu.ensup.gestionetablissement.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginDaoTest
{
	@Test
	@BeforeEach
	public void testConnection()
	{
		try {
			assertThat(Connect.openConnection(), is(notNullValue()));
		} catch (ExceptionDao e) {
			fail(e.getMessage());
		}
	}
}

package eu.ensup.gestionetablissement.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonDaoTest
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
	
	
	@Test
	@DisplayName("Test si getAll retourne bien quelque chose")
	public void testGetAll() //public List<Course> getAll() throws ExceptionDo;
	{
		PersonDao dao = new PersonDao();
		
		try {
			assertThat(dao.getAll(), is(notNullValue()));
			assertThat(dao.getAll(), is(empty()));
			
		} catch (ExceptionDao e) {
			fail(e.getMessage());
		}
	}
}

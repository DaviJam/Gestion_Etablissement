package eu.ensup.gestionetablissement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import eu.ensup.gestionetablissement.dao.ExceptionDao;
import eu.ensup.gestionetablissement.dao.ILoginDao;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ConnectionServiceTest
{
	@Mock
	ILoginDao mockDao; // Objet que l'on vas mocker
	// Class dont on souhaite copier le comportement le temps du test

	@InjectMocks
	ConnectionService service; // Objet dans lequel on vas injecter l'objet mocker
	// Class que l'on souhaite tester

	@Test
	@DisplayName("Test exception login and password are good")
	void testCheckPasswordLoginAndPasswordAreGood() throws ExceptionDao, ExceptionService
	{
		// GIVEN
		//Stubing = imposer un comportement a un mock
		when(mockDao.checkPassword("root", "")).thenReturn(0);
		
		// WHEN
		// test le comportement du mock
		final int result = service.checkConnection("root", "");
		assertEquals(0, result);
		
		// THEN
		// verify que le comportement a été tester
		verify(mockDao).checkPassword("root", "");
		
	}

	@Test
	@DisplayName("Test exception login and password are bad")
	void testCheckPasswordLoginAndPasswordAreBad()
	{
		try {
			// GIVEN
			when(mockDao.checkPassword("admin", "admin")).thenReturn(1);
			
			// WHEN
			final int result = service.checkConnection("admin", "admin");
			assertEquals(1, result);
			
			// THEN
			verify(mockDao).checkPassword("admin", "admin");
		}
		catch (ExceptionDao | ExceptionService e) {
			fail(e.getMessage());
		}
	}
}

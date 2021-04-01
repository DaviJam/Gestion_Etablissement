package eu.ensup.gestionetablissement.dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import eu.ensup.gestionetablissement.business.Course;

class CourseDaoTest
{
	private static CourseDao dao;
	private int id = 0;
	private String subject = "Informatique";
	private float nbHours = 25;
	
	@BeforeAll
	public static void init()
	{
		dao = new CourseDao();
	}
	
	@BeforeEach
	public static void testConnection()
	{
		try {
			assertThat(Connect.openConnection(), is(notNullValue()));
		} catch (ExceptionDao e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Test create")
	@Order(1)
	public void testCreate() //public List<Course> getAll() throws ExceptionDo;
	{
		try {
			//Compte le nombre de mark existant avant l'ajout
			int nbMarkBeforeCreate = dao.getAll().size();
			
			dao.create(new Course(subject, nbHours));

			//Vérifie qu'une mark a bien été ajouter
			assertThat(dao.getAll().size(), equalTo(nbMarkBeforeCreate+1));
			
			id = dao.getAll().get(nbMarkBeforeCreate).getId();
		}
		catch (ExceptionDao e) {
			fail(e.getMessage());
		}
	}

	@Test
	@DisplayName("Test get")
	@Order(2)
	public void testGet() //public Course get( int index )  throws ExceptionDao;
	{
		try {
			Course course = dao.get(id);
			
			assertThat(course.getCourseSubject(), equalTo(subject));
			assertThat(course.getNbHours(), equalTo(nbHours));
		}
		catch (ExceptionDao e) {
			fail(e.getMessage());
		}
	}

	@Test
	@DisplayName("Test getIndex")
	@Order(3)
	public void testGetIndex() //public int getIndex( String coursesubject, float nbhours ) throws ExceptionDao;
	{
		CourseDao dao = new CourseDao();
		
		try {
			//Compte le nombre de mark existant avant l'ajout
			int index = dao.getIndex(subject, nbHours);
			
			assertThat(index, is(notNullValue()));
			assertThat(index, equalTo(id));
		}
		catch (ExceptionDao e) {
			fail(e.getMessage());
		}
	}

	/*@Test
	@DisplayName("Test delete")
	@Order(4)
	public void testDelete() //public int delete( int index ) throws ExceptionDao;
	{
		CourseDao dao = new CourseDao();
		
		try {
			dao.delete(id);
		}
		catch (ExceptionDao e) {
			fail(e.getMessage());
		}
		assertThat(true, equalTo(true));
	}*/
}

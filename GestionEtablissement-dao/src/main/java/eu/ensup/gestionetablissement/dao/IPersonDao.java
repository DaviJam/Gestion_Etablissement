package eu.ensup.gestionetablissement.dao;

import eu.ensup.gestionetablissement.business.Person;

/**
 * The interface School dao.
 */
public interface IPersonDao extends IDao<Person>
{
	/**
	 * Get the index of the school by this name
	 *
	 * @param surname name of the School
	 * @return type of return
	 */
	public int linkToCourse( int idEtudiant, int idCourse ) throws ExceptionDao;
}

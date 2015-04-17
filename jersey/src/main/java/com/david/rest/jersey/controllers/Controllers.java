/**
 * 
 */
package com.david.rest.jersey.controllers;

/**
 * @author daviD
 *
 */
public class Controllers 
{
	private static PersonController personController;
	private static SkillController skillController;
	
	static
	{
		personController = new PersonController();
		skillController = new SkillController();
	}

	/**
	 * @return the personController
	 */
	public static PersonController getPersonController() {
		return personController;
	}

	/**
	 * @return the skillController
	 */
	public static SkillController getSkillController() {
		return skillController;
	}
}

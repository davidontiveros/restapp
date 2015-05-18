/**
 * 
 */
package com.david.rest.jersey.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.david.rest.jersey.daos.SkillDao;
import com.david.rest.jersey.model.Skill;

/**
 * @author daviD
 *
 */
@Path("skillService")
public class SkillResource 
{
	private SkillDao skillDao = new SkillDao();
	
	@Path("getSkills")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Skill> getSkills()
	{
		return skillDao.findAll();
	}
	
}

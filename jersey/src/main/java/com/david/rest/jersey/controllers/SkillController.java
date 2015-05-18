/**
 * 
 */
package com.david.rest.jersey.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.david.rest.jersey.model.Skill;

/**
 * @author daviD
 *
 */
public class SkillController 
{
	// dummy list of skills, since we don't have a datasource yet..
	private static List<Skill> dummySkills = new ArrayList<Skill>();
	private static Integer TOP_ID;
	
	static
	{
		/*
		dummySkills.add(new Skill(1, "PHP"));
		dummySkills.add(new Skill(2, "Java"));
		dummySkills.add(new Skill(3, ".Net"));
		dummySkills.add(new Skill(4, "angular.js"));
		dummySkills.add(new Skill(5, "javascript"));
		dummySkills.add(new Skill(6, "SQL"));
		dummySkills.add(new Skill(7, "python"));
		dummySkills.add(new Skill(8, "Oracle"));
		dummySkills.add(new Skill(9, "jquery"));
		dummySkills.add(new Skill(10, "html5"));
		dummySkills.add(new Skill(11, "css"));
		dummySkills.add(new Skill(12, "desing patterns"));
		*/
		TOP_ID = 12;
	}

	public Integer save(String name, Integer level)
	{
		TOP_ID += 1;
		//Skill skill = new Skill(TOP_ID, name);
		//return skill.getId();
		return null;
	}
	
	public Skill get(Integer id)
	{
		for(Skill skill : dummySkills)
		{
			if(skill.getId().equals(id))
			{
				return skill;
			}
		}
		return null;
	}
	
	public Skill get(String name)
	{
		for(Skill skill : dummySkills)
		{
			if(skill.getName().equalsIgnoreCase(name))
			{
				return skill;
			}
		}
		return null;
	}
	
	public List<Skill> get(String... names)
	{
		List<Skill> skills = new ArrayList<Skill>();
		for(String name : names)
		{
			Skill skill = get(name);
			if(skill != null)
			{
				skills.add(skill);
			}
		}
		return skills;
	}
	
	public List<Skill> getNRandomSkills(int n)
	{
		List<Skill> skills = new ArrayList<Skill>();
		for(int i=0; i<n; i++)
		{
			skills.add(get(getRandomId()));
		}
		return skills;
	}
	
	private int getRandomId()
	{
		int minInclusive = 1;
		int maxExclusive = TOP_ID;
		
		Random random = new Random();
		int id = random.nextInt(maxExclusive - minInclusive + 1) + minInclusive;
		return id;
	}
}

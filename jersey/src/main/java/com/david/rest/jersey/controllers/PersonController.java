/**
 * 
 */
package com.david.rest.jersey.controllers;

import java.util.ArrayList;
import java.util.List;

import com.david.rest.jersey.model.Person;
import com.david.rest.jersey.model.PersonSkill;
import com.david.rest.jersey.model.Skill;

/**
 * @author daviD
 *
 */
public class PersonController 
{
	// dummy list of person, since we don't have a datasource yet..
	private static List<Person> dummyPersons = new ArrayList<Person>();
	private static Integer TOP_ID;
	
	static{
		dummyPersons.add(new Person(1, "David"));
		dummyPersons.add(new Person(2, "Juan"));
		dummyPersons.add(new Person(3, "Irma"));
		dummyPersons.add(new Person(4, "Pedro"));
		dummyPersons.add(new Person(5, "Julieta"));
		dummyPersons.add(new Person(6, "Daniela"));
		dummyPersons.add(new Person(7, "Ramiro"));
		dummyPersons.add(new Person(8, "Miguel"));
		dummyPersons.add(new Person(9, "Maria"));
		dummyPersons.add(new Person(10, "Irma"));
		dummyPersons.add(new Person(11, "Luis"));
		TOP_ID = 11;
	}
	
	public List<Person> getAll()
	{
		List<Person> persons = new ArrayList<Person>();
		for(Person person : dummyPersons)
		{
			List<PersonSkill> personSkills = new ArrayList<PersonSkill>();
			for(int i=0; i<2; i++)
			{
				Skill skill = Controllers.getSkillController().getNRandomSkills(1).get(0);
				personSkills.add(new PersonSkill(skill, Skill.LOW));
				
				skill = Controllers.getSkillController().getNRandomSkills(1).get(0);
				personSkills.add(new PersonSkill(skill, Skill.MEDIUM));
				
				skill = Controllers.getSkillController().getNRandomSkills(1).get(0);
				personSkills.add(new PersonSkill(skill, Skill.HIGH));
			}
			person.setPersonSkills(personSkills);
			persons.add(person);
		}
		return persons;
	}
	
	public Person get(String name)
	{
		for(Person person : dummyPersons)
		{
			if(person.getName().equals(name))
			{
				return person;
			}
		}
		return null;
	}
	
	public Person get(Integer id)
	{
		for(Person person : dummyPersons)
		{
			if(person.getId().equals(id))
			{
				return person;
			}
		}
		return null;
	}
}

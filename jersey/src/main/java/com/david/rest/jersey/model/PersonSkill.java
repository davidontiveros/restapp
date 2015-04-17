/**
 * 
 */
package com.david.rest.jersey.model;

/**
 * @author daviD
 *
 */
public class PersonSkill 
{
	private Skill skill;
	private Integer level;
	
	public PersonSkill() {
		// TODO Auto-generated constructor stub
	}
	
	public PersonSkill(Skill skill, Integer level) {
		this.skill = skill;
		this.level = level;
	}
	
	/**
	 * @return the skill
	 */
	public Skill getSkill() {
		return skill;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
}

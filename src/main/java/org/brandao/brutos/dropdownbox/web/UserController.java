package org.brandao.brutos.dropdownbox.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.brandao.brutos.annotation.Action;
import org.brandao.brutos.annotation.Actions;
import org.brandao.brutos.annotation.Basic;
import org.brandao.brutos.annotation.View;
import org.brandao.brutos.annotation.web.RequestMethod;
import org.brandao.brutos.annotation.web.ResponseErrors;
import org.brandao.brutos.dropdownbox.entity.User;
import org.brandao.brutos.web.RequestMethodTypes;
import org.brandao.brutos.web.WebFlowController;

@Actions({
	@Action(value="/", view=@View("user/form")),
	@Action(value="/success", view=@View("user/show"))
})
@ResponseErrors(rendered=false)
public class UserController {

	@Action("/")
	@View("user/form")
	@RequestMethod(RequestMethodTypes.POST)
	public void updateUser(
			@Valid
			@Basic(bean="user")User user) throws ValidationException{
		
		WebFlowController
			.redirect()
			.put("user", user).to("/success");
	}
	
	public Map<String, String> getJavaSkillList(){
		Map<String, String> skill = new LinkedHashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Groovy");
		skill.put("Grails", "Grails");
		return skill;
	}
	
	public Map<String, String> getCountryList(){
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("BR", "Brazil");
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		return country;
	}
	
}

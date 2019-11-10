package dz.acs.si.demo1.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import dz.acs.si.demo1.model.Person;
import lombok.Getter;

@Component("generatePersonService")
public class GeneratePersonService {

	@Getter
	@Value("${person.sep.val}")
	public String separ;
	
	@Getter
	@Value("${person.date.format}")
	public String dateFormat;
	
	
	
	@Getter
	@Value("${person.format.size}")
	public int size;

	public Person generate(String test) {
		Person p = Person.NULL;
		//id, name, gender, dateOfBirth
		//String[] res = StringUtils.split(test, separ);
		String[] res = test.split(separ);
		if(res.length<size) {
			return  Person.NULL;
		}
		try {
			int id = Integer.parseInt(res[0]);
			String name =res[1];
			String gender =res[2];
			Date dateOfBirth =new SimpleDateFormat(dateFormat).parse(res[3]);
			p= new Person(id, name, gender, dateOfBirth);
		} catch (Exception e) {
			return  Person.ERROR;
		}
		System.out.println("ACTIVATOR!!!"+p);
		return p;
	}

	public void out(Person test) {
		System.out.println(test);
	}

	public boolean filter(String message) {
		return !message.trim().isEmpty();
	}

	public String[] split(String message) {
		return message.split("\\n");
	}
}

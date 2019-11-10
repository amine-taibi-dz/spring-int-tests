package dz.acs.si.demo1.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	public final static Person NULL = new Person(Integer.MAX_VALUE, "NULL_NAME", "X", new Date());
	public final static Person ERROR = new Person(Integer.MIN_VALUE, "ERROR_NAME", "Y", new Date());
	private int id;
	private String name;
	private String gender;
	private Date dateOfBirth;
	
}

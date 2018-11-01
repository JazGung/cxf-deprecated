package net.jazgung.cfx.rs.dto;

import javax.ws.rs.core.MultivaluedHashMap;

public class MultivaluedMapDto extends MultivaluedHashMap<String, String> {

	private static final long serialVersionUID = 1L;

	private static final String NAME = "Name";

	private static final String AGE = "Age";

	public MultivaluedMapDto() {
		setName("巩");
		setAge(18);
	}

	public void setName(String name) {
		super.add(NAME, name);
	}

	public String getAge() {
		return (String) super.getFirst(AGE);
	}

	public void setAge(Integer age) {
		super.add(AGE, age.toString());
	}

	public Integer getName() {
		return Integer.parseInt(super.getFirst(AGE));
	}

}

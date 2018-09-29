package net.jazgung.cfx.rs.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlDto {

	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public XmlDto() {
		this.name = "Jaz";
		this.age = 18;
	}

	public XmlDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}

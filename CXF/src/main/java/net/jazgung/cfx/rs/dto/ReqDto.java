package net.jazgung.cfx.rs.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReqDto {

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

	public ReqDto() {
		this.name = "Jaz";
		this.age = 18;
	}

	public ReqDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}

package net.jazgung.cfx.binding.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.jazgung.cfx.webservice.WebServiceConstans;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicesReq", namespace = WebServiceConstans.NAME_SPACE)
public class ReqDto {

	@XmlElement(name = "Word", namespace = WebServiceConstans.NAME_SPACE)
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}

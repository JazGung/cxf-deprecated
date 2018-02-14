package net.jazgung.cfx.binding.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.jazgung.cfx.webservice.WebServiceConstans;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicesRes", namespace = WebServiceConstans.NAME_SPACE)
public class RspDto {

	@XmlElement(name = "Echo", namespace = WebServiceConstans.NAME_SPACE)
	private String echo;

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}
}

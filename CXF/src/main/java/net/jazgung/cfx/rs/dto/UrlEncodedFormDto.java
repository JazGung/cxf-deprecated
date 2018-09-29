package net.jazgung.cfx.rs.dto;

import javax.ws.rs.FormParam;

public class UrlEncodedFormDto {

	@FormParam("form_filed")
	String formParamFiled = "form-filed";
	String formParamGet = "form-get";
	String formParamSet = "form-set";

	public String getFormParamFiled() {
		return formParamFiled;
	}

	public void setFormParamFiled(String formParamFiled) {
		this.formParamFiled = formParamFiled;
	}

	@FormParam("form-get") // @FormParam配置在get方法上不生效
	public String getFormParamGet() {
		return formParamGet;
	}

	public void setFormParamGet(String formParamGet) {
		this.formParamGet = formParamGet;
	}

	@FormParam("form-set") // @FormParam配置在set方法上不生效
	public String getFormParamSet() {
		return formParamSet;
	}

	public void setFormParamSet(String formParamSet) {
		this.formParamSet = formParamSet;
	}
}

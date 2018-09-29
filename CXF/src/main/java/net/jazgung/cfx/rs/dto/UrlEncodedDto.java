package net.jazgung.cfx.rs.dto;

import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class UrlEncodedDto {

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	String pathParam = "path";

	public String getPathParam() {
		return pathParam;
	}

	@PathParam("path_param")
	public void setPathParam(String pathParam) {
		this.pathParam = pathParam;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @MatrixParam配置在字段上不生效
	@MatrixParam("matrix-filed")
	String matrixParamFiled = "matrix-filed";
	String matrixParamGet = "matrix-get";
	String matrixParamSet = "matrix-set";

	public String getMatrixParamFiled() {
		return matrixParamFiled;
	}

	public void setMatrixParamFiled(String matrixParamFiled) {
		this.matrixParamFiled = matrixParamFiled;
	}

	@MatrixParam("matrix-get") // @MatrixParam配置在get方法上不生效
	public String getMatrixParamGet() {
		return matrixParamGet;
	}

	public void setMatrixParamGet(String matrixParamGet) {
		this.matrixParamGet = matrixParamGet;
	}

	public String getMatrixParamSet() {
		return matrixParamSet;
	}

	@MatrixParam("matrix-set") // @MatrixParam配置在是et方法上生效
	public void setMatrixParamSet(String matrixParamSet) {
		this.matrixParamSet = matrixParamSet;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @QueryParam配置在字段上不生效
	@QueryParam("query-filed")
	String queryParamFiled = "query-filed";
	String queryParamGet = "query-get";
	String queryParamSet = "query-set";

	public String getQueryParamFiled() {
		return queryParamFiled;
	}

	public void setQueryParamFiled(String queryParamFiled) {
		this.queryParamFiled = queryParamFiled;
	}

	@QueryParam("query-get") // @QueryParam配置在get方法上不生效
	public String getQueryParamGet() {
		return queryParamGet;
	}

	public void setQueryParamGet(String queryParamGet) {
		this.queryParamGet = queryParamGet;
	}

	public String getQueryParamSet() {
		return queryParamSet;
	}

	@QueryParam("query-set") // @QueryParam配置在set方法上生效
	public void setQueryParamSet(String queryParamSet) {
		this.queryParamSet = queryParamSet;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @HeaderParam配置在字段上不生效
	@HeaderParam("header-filed")
	String headerParamFiled = "header-filed";
	String headerParamGet = "header-get";
	String headerParamSet = "header-set";

	public String getHeaderParamFiled() {
		return headerParamFiled;
	}

	public void setHeaderParamFiled(String headerParamFiled) {
		this.headerParamFiled = headerParamFiled;
	}

	@HeaderParam("header-get") // @HeaderParam配置在get方法上不生效
	public String getHeaderParamGet() {
		return headerParamGet;
	}

	public void setHeaderParamGet(String headerParamGet) {
		this.headerParamGet = headerParamGet;
	}

	public String getHeaderParamSet() {
		return headerParamSet;
	}

	@HeaderParam("header-set") // @HeaderParam配置在set方法上生效
	public void setHeaderParamSet(String headerParamSet) {
		this.headerParamSet = headerParamSet;
	}

	// @CookieParam配置在字段上不生效
	@CookieParam("cookie-filed")
	String cookieParamFiled = "cookie-filed";
	String cookieParamGet = "cookie-get";
	String cookieParamSet = "cookie-set";

	public String getCookieParamFiled() {
		return cookieParamFiled;
	}

	public void setCookieParamFiled(String cookieParamFiled) {
		this.cookieParamFiled = cookieParamFiled;
	}

	@CookieParam("cookie_get") // @CookieParam配置在get方法上不生效
	public String getCookieParamGet() {
		return cookieParamGet;
	}

	public void setCookieParamGet(String cookieParamGet) {
		this.cookieParamGet = cookieParamGet;
	}

	public String getCookieParamSet() {
		return cookieParamSet;
	}

	@CookieParam("cookie_set") // @CookieParam配置在set方法上生效
	public void setCookieParamSet(String cookieParamSet) {
		this.cookieParamSet = cookieParamSet;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// @FormParam配置在字段上不生效
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

package net.jazgung.cfx.rs.webservice;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.log.LoggingFormatOutInterceptor;
import net.jazgung.cfx.rs.dto.ReqDto;
import net.jazgung.cfx.rs.dto.UrlEncodedDto;
import net.jazgung.cfx.rs.dto.XmlDto;

@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
@OutInterceptors(interceptors = { LoggingFormatOutInterceptor.NAME })
public interface RsWebService {

	public static final String ADDRESS = "RsWebService";

	@GET
	@Path("/rs")
	void retrieve();

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Http GET方法，六种方式截取参数
	@GET
	@Path("/get/{path_param}")
	void get(//
			@PathParam("path_param") String pathParam// 配置了@PathParam，则会从URL中{@PathParam.value}部分获取参数
			, @QueryParam("query_param") String queryParam// 配置了@QueryParam，则会从URL的?后面截取参数名为@QueryParam.value的参数值
			, @MatrixParam("matrix_param") String matrixParam// 配置了@MatrixParam，则会从URL的;与?之间截取参数名为@MatrixParam.value的参数的值
			, @HeaderParam("header_param") String headerParam// 配置了@HeaderParam，则会从Http Headers的截取参数名为@HeaderParam.value的参数的值
			, @CookieParam("cookie_param") String cookieParam// 配置了@CookieParam，则会从Http Headers的Cookie中截取参数名为@CookieParam.value的参数的值
			, @FormParam("form_param") String formParam// 配置了@FormParam，则会从Http Body的表单中截取参数名为@FormParam.value的参数值
	);

	// Http GET方法，参数配置@PathParam但@Path.value中又没有相应的占位符，则直接忽略
	@GET
	@Path("/get_path_unconfig")
	void getPathParamButUnconfig(@PathParam("path_param") String pathParam);

	// Http
	// GET方法，参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，则会将参数值直接放入，有且只允许有一个参数未做配置
	@GET
	@Path("/get_unconfig_one_param")
	void getUnconfig(String param);

	// Http
	// GET方法，多于一个参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，会抛出异常
	@GET
	@Path("/get_unconfig_more_than_one_param")
	void getUnconfig(String param1, String param2);

	// Http GET方法，参数为DTO必须配置@Consumes，否则会因为没有串行/反串行逻辑导致报错
	@GET
	@Path("/get/dto")
	void getDtoParam(@BeanParam UrlEncodedDto req);

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Http POST方法，六种方式截取参数
	@POST
	@Path("/post/{path_param}")
	void post(//
			@PathParam("path_param") String pathParam// 配置了@PathParam，则会从URL中{@PathParam.value}部分获取参数
			, @QueryParam("query_param") String queryParam// 配置了@QueryParam，则会从URL的?后面截取参数名为@QueryParam.value的参数值
			, @MatrixParam("matrix_param") String matrixParam// 配置了@MatrixParam，则会从URL的;与?之间截取参数名为@MatrixParam.value的参数的值
			, @HeaderParam("header_param") String headerParam// 配置了@HeaderParam，则会从Http Headers的截取参数名为@HeaderParam.value的参数的值
			, @CookieParam("cookie_param") String cookieParam// 配置了@CookieParam，则会从Http Headers的Cookie中截取参数名为@CookieParam.value的参数的值
			, @FormParam("form_param") String formParam// 配置了@FormParam，则会从Http Body的表单中截取参数名为@FormParam.value的参数值
	);

	// Http POST方法，参数配置@PathParam但@Path.value中又没有相应的占位符，则直接忽略
	@POST
	@Path("/post_path_unconfig")
	void postPathParamButUnconfig(@PathParam("path_param") String pathParam);

	// Http
	// POST方法，参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，则会将参数值直接放入，有且只允许有一个参数未做配置
	@POST
	@Path("/post_unconfig_one_param")
	void postUnconfig(String param);

	// Http
	// POST方法，多于一个参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，会抛出异常
	@POST
	@Path("/post_unconfig_more_than_one_param")
	void postUnconfig(String param1, String param2);

	// Http POST方法，参数为DTO必须配置@Consumes，否则会因为没有串行/反串行逻辑导致报错
	@POST
	@Path("/post/dto")
	void postDtoParam(ReqDto req);

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Http PUT方法，六种方式截取参数
	@PUT
	@Path("/put/{path_param}")
	void put(//
			@PathParam("path_param") String pathParam// 配置了@PathParam，则会从URL中{@PathParam.value}部分获取参数
			, @QueryParam("query_param") String queryParam// 配置了@QueryParam，则会从URL的?后面截取参数名为@QueryParam.value的参数值
			, @MatrixParam("matrix_param") String matrixParam// 配置了@MatrixParam，则会从URL的;与?之间截取参数名为@MatrixParam.value的参数的值
			, @HeaderParam("header_param") String headerParam// 配置了@HeaderParam，则会从Http Headers的截取参数名为@HeaderParam.value的参数的值
			, @CookieParam("cookie_param") String cookieParam// 配置了@CookieParam，则会从Http Headers的Cookie中截取参数名为@CookieParam.value的参数的值
			, @FormParam("form_param") String formParam// 配置了@FormParam，则会从Http Body的表单中截取参数名为@FormParam.value的参数值
	);

	// Http PUT方法，参数配置@PathParam但@Path.value中又没有相应的占位符，则直接忽略
	@PUT
	@Path("/put_path_unconfig")
	void putPathParamButUnconfig(@PathParam("path_param") String pathParam);

	// Http
	// PUT方法，参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，则会将参数值直接放入，有且只允许有一个参数未做配置
	@PUT
	@Path("/put_unconfig_one_param")
	void putUnconfig(String param);

	// Http
	// PUT方法，多于一个参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，会抛出异常
	@PUT
	@Path("/put_unconfig_more_than_one_param")
	void putUnconfig(String param1, String param2);

	// Http PUT方法，参数为DTO必须配置@Consumes，否则会因为没有串行/反串行逻辑导致报错
	@PUT
	@Path("/put/dto")
	void putDtoParam(ReqDto req);

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Http DELET方法，六种方式截取参数
	@DELETE
	@Path("/delete/{path_param}")
	void delete(//
			@PathParam("path_param") String pathParam// 配置了@PathParam，则会从URL中{@PathParam.value}部分获取参数
			, @QueryParam("query_param") String queryParam// 配置了@QueryParam，则会从URL的?后面截取参数名为@QueryParam.value的参数值
			, @MatrixParam("matrix_param") String matrixParam// 配置了@MatrixParam，则会从URL的;与?之间截取参数名为@MatrixParam.value的参数的值
			, @HeaderParam("header_param") String headerParam// 配置了@HeaderParam，则会从Http Headers的截取参数名为@HeaderParam.value的参数的值
			, @CookieParam("cookie_param") String cookieParam// 配置了@CookieParam，则会从Http Headers的Cookie中截取参数名为@CookieParam.value的参数的值
			, @FormParam("form_param") String formParam// 配置了@FormParam，则会从Http Body的表单中截取参数名为@FormParam.value的参数值
	);

	// Http DELET方法，参数配置@PathParam但@Path.value中又没有相应的占位符，则直接忽略
	@DELETE
	@Path("/delete_path_unconfig")
	void deletePathParamButUnconfig(@PathParam("path_param") String pathParam);

	// Http
	// DELET方法，参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，则会将参数值直接放入，有且只允许有一个参数未做配置
	@DELETE
	@Path("/delete_unconfig_one_param")
	void deleteUnconfig(String param);

	// Http
	// DELET方法，多于一个参数未配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam、@FormParam，会抛出异常
	@DELETE
	@Path("/delete_unconfig_more_than_one_param")
	void deleteUnconfig(String param1, String param2);

	// Http DELET方法，参数为DTO必须配置@Consumes，否则会因为没有串行/反串行逻辑导致报错
	@DELETE
	@Path("/delete/dto")
	void deleteDtoParam(ReqDto req);

	// @Consumes决定请求的Http Body中数据封装格式，@Produces决定响应的的Http Body中数据封装格式
	@POST
	@Path("/consumesAndProduces")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	XmlDto consumesAndProduces(XmlDto req);

	@POST
	@Path("/urlEncoded")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	void urlEncoded(@FormParam("name") String name, @FormParam("age") int age);

	// 请求参数如果是DTO，则不能使用MediaType.APPLICATION_FORM_URLENCODED
	@POST
	@Path("/urlEncodedDto/{path_param}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	void urlEncoded(@BeanParam UrlEncodedDto req);

	// 响应无法配置参数名，@Produces.value配置为MediaType.APPLICATION_FORM_URLENCODED后会把响应值直接写入Http
	// Body
	@POST
	@Path("/urlEncodedReturn")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	String urlEncoded();

	@POST
	@Path("/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	ReqDto json(ReqDto req);
}

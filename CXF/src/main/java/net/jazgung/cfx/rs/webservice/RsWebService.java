package net.jazgung.cfx.rs.webservice;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.log.LoggingFormatOutInterceptor;
import net.jazgung.cfx.rs.dto.MultivaluedMapDto;
import net.jazgung.cfx.rs.dto.ReqDto;
import net.jazgung.cfx.rs.dto.UrlEncodedDto;
import net.jazgung.cfx.rs.dto.UrlEncodedEmptyDto;
import net.jazgung.cfx.rs.dto.UrlEncodedFormDto;
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

	// 在CXF
	// 3.0.3中，方法参数上配置了@BeanParam，则在参数类的set方法上配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam客户端、服务端都可正常处理，但在字段上配置则只有服务端能正常处理
	// 在CXF
	// 3.1.10中，方法参数上配置了@BeanParam，则在参数类的set方法和字段上上配置@PathParam、@QueryParam、@MatrixParam、@HeaderParam、@CookieParam客户端、服务端都可正常处理
	// 在CXF
	// 3.0.3/3.1.10，方法参数上配置了@BeanParam，在参数类@FormParam的使用有其他要求
	@POST
	@Path("/urlEncodedDto/{path_param}")
	void urlEncoded(@BeanParam UrlEncodedDto dto);

	// 在CXF 3.0.3/3.1.10，方法参数上配置了@FormParam后可以将参数对象中所有的字段映射到Http
	// Body中，每个字段的key与字段名相同且无法修改（对象中的所有@FormParam无效）
	@POST
	@Path("/urlEncodedFormDto")
	void urlEncoded(@FormParam("") UrlEncodedFormDto dto);

	// 在CXF 3.0.3/3.1.10， 如要要将参数对象中的字段映射到Http
	// Body中且对字段的key进行定制，必须配置带@FormParam的字段，如果字段类中没有以get开头的方法
	@POST
	@Path("/urlEncodedFormDto/{path_param}")
	void urlEncoded(@BeanParam UrlEncodedDto dto1, @FormParam("") UrlEncodedEmptyDto dto2);

	// @Produces.value配置为MediaType.APPLICATION_FORM_URLENCODED，则响应类型必须是MultivaluedMap的实现类（Value必须泛型为String）或Form的子类
	// 响应中的所有字段都只能写入HTTP Body，无法写入HTTP Header
	@POST
	@Path("/urlEncodedReturn")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	MultivaluedMapDto urlEncoded();

	// 如果请求的数据封装格式为MediaType.APPLICATION_FORM_URLENCODED，参数使用MultivaluedMap类型
	@POST
	@Path("/urlEncodedMultivaluedMap")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	MultivaluedMapDto urlEncodedMultivaluedMap(MultivaluedMapDto dto);

	// CXF当请求的数据封装格式为MediaType.APPLICATION_FORM_URLENCODED时，@Consumes不生效，只能多加一个参数并配置@HeaderParam(HttpHeaders.CONTENT_TYPE)注解并在调用方通过参数值来制定Http
	// Header中的Content-Type
	// 如果要指定编码方案，可以直接在Content-Type后拼接"; charset=xxx"，请求必须在调用方的参数中加，响应可以在@Produces配置
	@POST
	@Path("/urlEncodedMultivaluedMapContentType")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED + "; charset=GBK")
	MultivaluedMapDto urlEncodedMultivaluedMapContentType(MultivaluedMapDto dto, @HeaderParam(HttpHeaders.CONTENT_TYPE) String contentType);

	@POST
	@Path("/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Encoded()
	ReqDto json(ReqDto req);
}

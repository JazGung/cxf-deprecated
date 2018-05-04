package net.jazgung.cfx.rs.webservice;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
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

@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
@OutInterceptors(interceptors = { LoggingFormatOutInterceptor.NAME })
public interface RsWebService {

	public static final String ADDRESS = "RsWebService";

	@GET
	@Path("/rs")
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto retrieve();

	@GET
	@Path("/rs/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto retrieveById(@PathParam("id") long id);

	/**
	 * 参数查询
	 * 
	 * @param name
	 * @return
	 */
	@GET
	@Path("/rs/query/name")
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto retrievesByName_param(@QueryParam("name") String name);

	/**
	 * 提交表单查询
	 * 
	 * @param name
	 * @return
	 */
	@POST
	@Path("/rs/form/name")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto retrievesByName_form(@FormParam("name") String name);

	@POST
	@Path("/rs")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto create(ReqDto req);

	@PUT
	@Path("/rs/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto updateById(@PathParam("id") long id, Map<String, Object> req);

	@PUT
	@Path("/rs")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto update(ReqDto req);

	@DELETE
	@Path("/rs/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto deleteById(@PathParam("id") long id);

	@DELETE
	@Path("/rs")
	@Produces(MediaType.APPLICATION_JSON)
	ReqDto deleteById_param(@QueryParam("id") long id);
}

package net.jazgung.cfx.rs.webservice;

import net.jazgung.cfx.rs.dto.MultivaluedMapDto;
import net.jazgung.cfx.rs.dto.ReqDto;
import net.jazgung.cfx.rs.dto.UrlEncodedDto;
import net.jazgung.cfx.rs.dto.UrlEncodedEmptyDto;
import net.jazgung.cfx.rs.dto.UrlEncodedFormDto;
import net.jazgung.cfx.rs.dto.XmlDto;
import net.jazgung.cfx.util.PropertyValuePrinter;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;

public class RsWebServiceImpl extends AbstractWebServiceImpl implements RsWebService {

	@Override
	public String getAddress() {
		return ADDRESS;
	}

	@Override
	public void retrieve() {
	}

	@Override
	public void get(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara) {
		System.out.println(123);
	}

	@Override
	public void getPathParamButUnconfig(String pathParam) {
		System.out.println("pathParam: " + pathParam);
	}

	@Override
	public void getUnconfig(String param) {
		System.out.println("param1: " + param);
	}

	@Override
	public void getUnconfig(String param1, String param2) {
		System.out.println("param1: " + param1 + ", param2: " + param2);
	}

	@Override
	public void getDtoParam(UrlEncodedDto req) {
	}

	@Override
	public void post(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara) {
		System.out.println(123);
	}

	@Override
	public void postPathParamButUnconfig(String pathParam) {
		System.out.println("pathParam: " + pathParam);
	}

	@Override
	public void postUnconfig(String param) {
		System.out.println("param1: " + param);
	}

	@Override
	public void postUnconfig(String param1, String param2) {
		System.out.println("param1: " + param1 + ", param2: " + param2);
	}

	@Override
	public void postDtoParam(ReqDto req) {
	}

	@Override
	public void put(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara) {
		System.out.println(123);
	}

	@Override
	public void putPathParamButUnconfig(String pathParam) {
		System.out.println("pathParam: " + pathParam);
	}

	@Override
	public void putUnconfig(String param) {
		System.out.println("param1: " + param);
	}

	@Override
	public void putUnconfig(String param1, String param2) {
		System.out.println("param1: " + param1 + ", param2: " + param2);
	}

	@Override
	public void putDtoParam(ReqDto req) {
	}

	@Override
	public void delete(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara) {
		System.out.println(123);
	}

	@Override
	public void deletePathParamButUnconfig(String pathParam) {
		System.out.println("pathParam: " + pathParam);
	}

	@Override
	public void deleteUnconfig(String param) {
		System.out.println("param1: " + param);
	}

	@Override
	public void deleteUnconfig(String param1, String param2) {
		System.out.println("param1: " + param1 + ", param2: " + param2);
	}

	@Override
	public void deleteDtoParam(ReqDto req) {
	}

	@Override
	public XmlDto consumesAndProduces(XmlDto req) {
		return req;
	}

	@Override
	public void urlEncoded(String name, int age) {
	}

	@Override
	public MultivaluedMapDto urlEncoded() {
		return new MultivaluedMapDto();
	}

	@Override
	public MultivaluedMapDto urlEncodedMultivaluedMap(MultivaluedMapDto dto) {
		return dto;
	}

	@Override
	public MultivaluedMapDto urlEncodedMultivaluedMapContentType(MultivaluedMapDto dto, String contentType) {
		return dto;
	}

	@Override
	public void urlEncoded(UrlEncodedDto dto) {
		PropertyValuePrinter.print(dto);
	}

	@Override
	public void urlEncoded(UrlEncodedFormDto dto) {
		PropertyValuePrinter.print(dto);
	}

	@Override
	public void urlEncoded(UrlEncodedDto dto1, UrlEncodedEmptyDto dto2) {
		PropertyValuePrinter.print(dto1);
		PropertyValuePrinter.print(dto2);
	}

	@Override
	public ReqDto json(ReqDto req) {
		return req;
	}

}

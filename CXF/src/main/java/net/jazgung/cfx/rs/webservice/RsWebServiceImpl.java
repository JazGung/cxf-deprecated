package net.jazgung.cfx.rs.webservice;

import net.jazgung.cfx.rs.dto.ReqDto;
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
	public void getDtoParam(ReqDto req) {
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
	public ReqDto consumesAndProduces(ReqDto req) {
		return req;
	}

	@Override
	public void urlEncoded(String name, int age) {
	}

	@Override
	public String urlEncoded() {
		return "Hello";
	}

	@Override
	public ReqDto urlEncoded(ReqDto req) {
		return req;
	}

	@Override
	public ReqDto json(ReqDto req) {
		return req;
	}

}

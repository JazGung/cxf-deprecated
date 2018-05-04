package net.jazgung.cfx.rs.webservice;

import java.util.Map;

import net.jazgung.cfx.rs.dto.ReqDto;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;

public class RsWebServiceImpl extends AbstractWebServiceImpl implements RsWebService {

	@Override
	public String getAddress() {
		return ADDRESS;
	}

	@Override
	public ReqDto retrieve() {
		return new ReqDto();
	}

	@Override
	public ReqDto retrieveById(long id) {
		return new ReqDto();
	}

	@Override
	public ReqDto retrievesByName_param(String name) {
		return new ReqDto();
	}

	@Override
	public ReqDto retrievesByName_form(String name) {
		return new ReqDto();
	}

	@Override
	public ReqDto create(ReqDto req) {
		return new ReqDto();
	}

	@Override
	public ReqDto updateById(long id, Map<String, Object> req) {
		return new ReqDto();
	}

	@Override
	public ReqDto update(ReqDto req) {
		return new ReqDto();
	}

	@Override
	public ReqDto deleteById(long id) {
		return new ReqDto();
	}

	@Override
	public ReqDto deleteById_param(long id) {
		return new ReqDto();
	}

}

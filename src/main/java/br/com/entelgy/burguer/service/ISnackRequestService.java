package br.com.entelgy.burguer.service;

import br.com.entelgy.burguer.entity.SnackRequest;
import br.com.entelgy.burguer.entity.vo.SnackRequestVO;

public interface ISnackRequestService {
	
	void save(SnackRequest entity);
	
	SnackRequestVO findById(Integer id);
}
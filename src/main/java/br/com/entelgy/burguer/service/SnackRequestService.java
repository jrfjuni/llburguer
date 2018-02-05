package br.com.entelgy.burguer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entelgy.burguer.dao.SnackRequestDAO;
import br.com.entelgy.burguer.entity.SnackRequest;
import br.com.entelgy.burguer.entity.vo.SnackRequestVO;

@Service
public class SnackRequestService implements ISnackRequestService{
	
	@Autowired
	private SnackRequestDAO snackRequestDAO;

	public void save(SnackRequest entity) {
		
		if(entity.getId() == null)
			getSnackRequestDAO().insert(entity);
		else
			getSnackRequestDAO().update(entity);
		
	}
	
	public SnackRequestVO findById(Integer id) {
		return getSnackRequestDAO().findById(id);
	}
	
	public SnackRequestDAO getSnackRequestDAO() {
		return snackRequestDAO;
	}
}
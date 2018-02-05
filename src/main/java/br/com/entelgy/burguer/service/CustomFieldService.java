package br.com.entelgy.burguer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entelgy.burguer.dao.CustomFieldDAO;
import br.com.entelgy.burguer.entity.vo.CustomFieldVO;
import br.com.entelgy.burguer.search.SearchCustomField;

@Service
public class CustomFieldService implements ICustomFieldService {
	
	@Autowired
	private CustomFieldDAO customFieldDAO;
	
	public List<CustomFieldVO> findCustomField(SearchCustomField search){
		return getCustomFieldDAO().findCustomField(search);
	}
	
	public CustomFieldVO findById(Integer id) {
		return getCustomFieldDAO().findById(id);
	}
	
	public CustomFieldDAO getCustomFieldDAO() {
		return customFieldDAO;
	}
}
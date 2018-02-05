package br.com.entelgy.burguer.service;

import java.util.List;

import br.com.entelgy.burguer.entity.vo.CustomFieldVO;
import br.com.entelgy.burguer.search.SearchCustomField;

public interface ICustomFieldService {
	
	List<CustomFieldVO> findCustomField(SearchCustomField search);
	
	CustomFieldVO findById(Integer id);
}
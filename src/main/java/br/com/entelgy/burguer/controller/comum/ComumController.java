package br.com.entelgy.burguer.controller.comum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.entelgy.burguer.comuns.OperatingResult;
import br.com.entelgy.burguer.entity.vo.CustomFieldVO;
import br.com.entelgy.burguer.enuns.ECustomField;
import br.com.entelgy.burguer.search.SearchCustomField;
import br.com.entelgy.burguer.service.ICustomFieldService;

@Controller
@RequestMapping(value="/comum")
public class ComumController {
	
	@Autowired
	private ICustomFieldService customFieldService;
	
	@RequestMapping(value="/allProducts", method=RequestMethod.GET)
	public @ResponseBody OperatingResult getAllProductsCombo(){
		OperatingResult operatingResult = new OperatingResult();
		
		List<CustomFieldVO> cheese = getCustomFieldService().findCustomField(getSearch(ECustomField.CHEESE));
		List<CustomFieldVO> bread = getCustomFieldService().findCustomField(getSearch(ECustomField.BREAD));
		List<CustomFieldVO> filling = getCustomFieldService().findCustomField(getSearch(ECustomField.FILLING));
		List<CustomFieldVO> snacks = getCustomFieldService().findCustomField(getSearch(ECustomField.SNACK));
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("cheese", cheese);
		 map.put("bread", bread);
		 map.put("filling", filling);
		 map.put("snack", snacks);
		
		 operatingResult.setExtraData(map);

		 return operatingResult;
	}
	
	@RequestMapping(value="/snack", method=RequestMethod.GET)
	public @ResponseBody CustomFieldVO getSnack(Integer id){
		return getCustomFieldService().findById(id);
	}

	private SearchCustomField getSearch(ECustomField customField){
		SearchCustomField search = new SearchCustomField();
		search.setLang(LocaleContextHolder.getLocale().toString());
		search.setCustomField(customField);
		return search;
	}
	
	public ICustomFieldService getCustomFieldService() {
		return customFieldService;
	}
}
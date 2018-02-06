package br.com.entelgy.burguer.controller.snackrequest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.entelgy.burguer.comuns.OperatingResult;
import br.com.entelgy.burguer.conf.UserLogged;
import br.com.entelgy.burguer.entity.SnackRequest;
import br.com.entelgy.burguer.entity.UserSystem;
import br.com.entelgy.burguer.entity.vo.CustomFieldVO;
import br.com.entelgy.burguer.entity.vo.SnackRequestVO;
import br.com.entelgy.burguer.service.ICustomFieldService;
import br.com.entelgy.burguer.service.ISnackRequestService;

@Controller
@RequestMapping(value="/snackrequest")
public class SnackRequestController {
	
	private Map<Integer, FormSnack> snacks;
	
	@Autowired
	private ISnackRequestService snackRequestService;
	
	@Autowired
	private ICustomFieldService customFieldService;
	
	@RequestMapping(value="/index")
	public String index(){
		return "snackrequest/index";
	}
	
	@RequestMapping(value="/details/{id}")
	public String details(@PathVariable(value="id") Integer id, Model model) {
		String pageRedirect = "snackrequest/index";
		
		if(id != null) {
			SnackRequestVO vo = getSnackRequestService().findById(id);
			
				if(vo != null && vo.getId() != null) {
					model.addAttribute("snackRequest", vo);
					pageRedirect = "snackrequest/details";
				}
		}
		
		
		return pageRedirect;
	}
	
	@RequestMapping(value="/finish", method=RequestMethod.POST, produces={"application/json","application/xml"})
	public @ResponseBody OperatingResult finish(@Valid FormSnackRequest form, BindingResult bindingResult){
		OperatingResult operatingResult = new OperatingResult();
		
		if(bindingResult.hasErrors()){
			operatingResult.setSuccess(Boolean.FALSE);
			operatingResult.addFieldsErros(bindingResult.getFieldErrors());
			return operatingResult;
		}
		
		if(getSnacks().isEmpty()) {
			operatingResult.setSuccess(Boolean.FALSE);
			operatingResult.setMessage("Errrooooooo");
			return operatingResult;
		}
		
		SnackRequest snackRequest = new SnackRequest();
		fillSnackRequest(snackRequest, form);
		getSnackRequestService().save(snackRequest);
		this.snacks = null;
		operatingResult.getExtraData().put("id", snackRequest.getId());
		
		return operatingResult;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, produces={"application/json","application/xml"})
	public @ResponseBody OperatingResult save(@Valid FormSnack form, BindingResult bindingResult) {
		OperatingResult operatingResult = new OperatingResult();
		
		if(bindingResult.hasErrors()){
			operatingResult.setSuccess(Boolean.FALSE);
			operatingResult.addFieldsErros(bindingResult.getFieldErrors());
			return operatingResult;
		}
		
		getSnacks().put(getSnacks().size() + 1, form);
		return operatingResult;
	}
	
	private void fillSnackRequest(SnackRequest snackRequest, FormSnackRequest form) {
		snackRequest.setDtRequest(new Date());
		snackRequest.setNameRequester(form.getName());
		snackRequest.setAddressRequester(form.getAddress());
		
		UserSystem user = new UserSystem();
		user.setEmail(UserLogged.getUsetLogged().getEmail());
		
		snackRequest.setUser(user);
		snackRequest.setPendent(Boolean.TRUE);
		
		BigDecimal valueOrder = BigDecimal.ZERO;
		for (Entry<Integer, FormSnack> snack : getSnacks().entrySet()) {
				
			FormSnack formSnack = snack.getValue();
			
			valueOrder = valueOrder.add(getValueByIdCustom(formSnack.getBread()));
			
				if( formSnack.getSnack() != null) {
					CustomFieldVO custom = getCustomFieldService().findById(formSnack.getSnack());
					valueOrder = valueOrder.add(custom.getPriceCheese());
					valueOrder = valueOrder.add(custom.getPriceFilling());
				}
				else {
					
					if(formSnack.getCheese() != null)
						valueOrder = valueOrder.add(getValueByIdCustom(formSnack.getCheese()));
					
					if(formSnack.getCheese() != null)
						valueOrder = valueOrder.add(getValueByIdCustom(formSnack.getFilling()));
					
				}
				
				if(formSnack.getDoubleCheese()) 
					valueOrder = valueOrder.add(getValueByIdCustom(formSnack.getCheese()));
				
				if(formSnack.getDoubleFilling()) 
					valueOrder = valueOrder.add(getValueByIdCustom(formSnack.getFilling()));
			
		}
		
		snackRequest.setValueOrder(valueOrder);
	}
	
	private BigDecimal getValueByIdCustom(Integer idCustom) {
		CustomFieldVO custom = getCustomFieldService().findById(idCustom);
		return custom.getNumeric();
	}
	
	public Map<Integer, FormSnack> getSnacks() {
		if (snacks == null) {
			snacks = new HashMap<Integer, FormSnack>();
		}

		return snacks;
	}
	
	public ISnackRequestService getSnackRequestService() {
		return snackRequestService;
	}
	
	public ICustomFieldService getCustomFieldService() {
		return customFieldService;
	}
}
package br.com.entelgy.burguer.comuns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

public class OperatingResult {
	
	private Boolean success;
	
	private List<FieldErrorForm> fieldsError; 
	
	private Map<String, Object> extraData;
	
	private String message;
	
	public OperatingResult(){
		this.success = Boolean.TRUE;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public void addFieldsErros(List<FieldError> fieldsErros){
		for (FieldError fieldError : fieldsErros) {
			getFieldsError().add(new FieldErrorForm(fieldError.getField(), fieldError.getDefaultMessage()));
		}
	}

	public List<FieldErrorForm> getFieldsError() {
		if (fieldsError == null) {
			fieldsError = new ArrayList<FieldErrorForm>();
		}
		return fieldsError;
	}

	public void setFieldsError(List<FieldErrorForm> fieldsError) {
		this.fieldsError = fieldsError;
	}

	public Map<String, Object> getExtraData() {
		if (extraData == null) {
			extraData = new  HashMap<String, Object>();
		}

		return extraData;
	}

	public void setExtraData(Map<String, Object> extraData) {
		this.extraData = extraData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
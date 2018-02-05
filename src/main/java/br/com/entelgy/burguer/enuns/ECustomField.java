package br.com.entelgy.burguer.enuns;

public enum ECustomField {

	SNACK("CUSTOM_FIELD_SNACK"),
	BREAD("CUSTOM_FIELD_BREAD"),
	CHEESE("CUSTOM_FIELD_CHEESE"),
	FILLING("CUSTOM_FIELD_FILLING");
	
	private String customField;
	
	ECustomField(String customField){
		this.customField = customField;
	}
	
	public String getCustomField() {
		return customField;
	}
}
package br.com.entelgy.burguer.search;

import br.com.entelgy.burguer.enuns.ECustomField;

public class SearchCustomField {
	
	private ECustomField customField;
	
	private String lang;
	
	private Integer idCustomField;

	public ECustomField getCustomField() {
		return customField;
	}

	public void setCustomField(ECustomField customField) {
		this.customField = customField;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Integer getIdCustomField() {
		return idCustomField;
	}

	public void setIdCustomField(Integer idCustomField) {
		this.idCustomField = idCustomField;
	}
}
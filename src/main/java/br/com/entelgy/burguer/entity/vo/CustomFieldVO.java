package br.com.entelgy.burguer.entity.vo;

import java.math.BigDecimal;

import br.com.entelgy.burguer.entity.CustomField;

public class CustomFieldVO {
	
	private Integer id;
	
	private String value;
	
	private BigDecimal numeric;
	
	private Integer idBread;
	
	private BigDecimal priceBread;
	
	private Integer idCheese;
	
	private BigDecimal priceCheese;
	
	private Integer idFilling;
	
	private BigDecimal priceFilling;
	
	private String customFieldValueFilling;
	
	public CustomFieldVO() {}
	
	public CustomFieldVO(Integer id, String value, BigDecimal bigDecimal) {
		this.id = id;
		this.value = value;
		this.numeric = bigDecimal;
	}
	
	public CustomFieldVO(CustomField custom) {
		if(custom != null) {
			this.numeric = custom.getCustomFieldDecimal();
			
			CustomField customFieldBread = custom.getCustomFieldBread();
			CustomField customFieldCheese = custom.getCustomFieldCheese();
			CustomField customFieldFilling = custom.getCustomFieldFilling();
			
			if(customFieldBread != null) {
				this.idBread = customFieldBread.getId();
				this.priceBread = customFieldBread.getCustomFieldDecimal();
			}
			
			if(customFieldCheese != null) {
				this.idCheese = customFieldCheese.getId();
				this.priceCheese = customFieldCheese.getCustomFieldDecimal();
			}
			
			if(customFieldFilling != null) {
				this.idFilling = customFieldFilling.getId();
				this.priceFilling = customFieldFilling.getCustomFieldDecimal();
				this.customFieldValueFilling = customFieldFilling.getCustomFieldValue();
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BigDecimal getNumeric() {
		return numeric;
	}

	public void setNumeric(BigDecimal numeric) {
		this.numeric = numeric;
	}

	public Integer getIdBread() {
		return idBread;
	}

	public void setIdBread(Integer idBread) {
		this.idBread = idBread;
	}

	public BigDecimal getPriceBread() {
		return priceBread;
	}

	public void setPriceBread(BigDecimal priceBread) {
		this.priceBread = priceBread;
	}

	public Integer getIdCheese() {
		return idCheese;
	}

	public void setIdCheese(Integer idCheese) {
		this.idCheese = idCheese;
	}

	public BigDecimal getPriceCheese() {
		return priceCheese;
	}

	public void setPriceCheese(BigDecimal priceCheese) {
		this.priceCheese = priceCheese;
	}

	public Integer getIdFilling() {
		return idFilling;
	}

	public void setIdFilling(Integer idFilling) {
		this.idFilling = idFilling;
	}

	public BigDecimal getPriceFilling() {
		return priceFilling;
	}

	public void setPriceFilling(BigDecimal priceFilling) {
		this.priceFilling = priceFilling;
	}

	public String getCustomFieldValueFilling() {
		return customFieldValueFilling;
	}

	public void setCustomFieldValueFilling(String customFieldValueFilling) {
		this.customFieldValueFilling = customFieldValueFilling;
	}
}
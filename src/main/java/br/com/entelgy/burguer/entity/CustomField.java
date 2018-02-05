package br.com.entelgy.burguer.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOM_FIELD")
public class CustomField {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="id_language")
	private Language language;
	
	@Column(name="CUSTOM_FIELD")
	private String customField;
	
	@Column(name="CUSTOM_FIELD_VALUE")
	private String customFieldValue;
	
	@ManyToOne
	@JoinColumn(name="CUSTOM_FIELD_ASSOCIATE_BREAD")
	private CustomField customFieldBread;
	
	@ManyToOne
	@JoinColumn(name="CUSTOM_FIELD_ASSOCIATE_CHEESE")
	private CustomField customFieldCheese;
	
	@ManyToOne
	@JoinColumn(name="CUSTOM_FIELD_ASSOCIATE_FILLING")
	private CustomField customFieldFilling;
	
	@Column(name="CUSTOM_FIELD_DECIMAL")
	private BigDecimal customFieldDecimal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getCustomField() {
		return customField;
	}

	public void setCustomField(String customField) {
		this.customField = customField;
	}

	public String getCustomFieldValue() {
		return customFieldValue;
	}

	public void setCustomFieldValue(String customFieldValue) {
		this.customFieldValue = customFieldValue;
	}

	public CustomField getCustomFieldBread() {
		return customFieldBread;
	}

	public void setCustomFieldBread(CustomField customFieldBread) {
		this.customFieldBread = customFieldBread;
	}

	public CustomField getCustomFieldCheese() {
		return customFieldCheese;
	}

	public void setCustomFieldCheese(CustomField customFieldCheese) {
		this.customFieldCheese = customFieldCheese;
	}

	public CustomField getCustomFieldFilling() {
		return customFieldFilling;
	}

	public void setCustomFieldFilling(CustomField customFieldFilling) {
		this.customFieldFilling = customFieldFilling;
	}

	public BigDecimal getCustomFieldDecimal() {
		return customFieldDecimal;
	}

	public void setCustomFieldDecimal(BigDecimal customFieldDecimal) {
		this.customFieldDecimal = customFieldDecimal;
	}
}
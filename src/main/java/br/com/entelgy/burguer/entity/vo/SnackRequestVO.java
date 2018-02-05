package br.com.entelgy.burguer.entity.vo;

import java.math.BigDecimal;

import br.com.entelgy.burguer.entity.SnackRequest;

public class SnackRequestVO {
	
	private String nameRequester;
	
	private String addressRequester;
	
	private BigDecimal valueOrder;
	
	private Integer id;
	
	public SnackRequestVO() {}
	
	public SnackRequestVO(SnackRequest entity) {
		if(entity != null) {
			this.id = entity.getId();
			this.nameRequester = entity.getNameRequester();
			this.addressRequester = entity.getAddressRequester();
			this.valueOrder = entity.getValueOrder();
		}
	}

	public String getNameRequester() {
		return nameRequester;
	}

	public void setNameRequester(String nameRequester) {
		this.nameRequester = nameRequester;
	}

	public String getAddressRequester() {
		return addressRequester;
	}

	public void setAddressRequester(String addressRequester) {
		this.addressRequester = addressRequester;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValueOrder() {
		return valueOrder;
	}

	public void setValueOrder(BigDecimal valueOrder) {
		this.valueOrder = valueOrder;
	}
}
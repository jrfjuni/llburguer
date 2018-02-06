package br.com.entelgy.burguer.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SNACK_REQUEST")
public class SnackRequest {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="NAME_REQUESTER")
	private String nameRequester;
	
	@Column(name="ADDRESS_REQUESTER")
	private String addressRequester;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_system", nullable = false)
	private UserSystem user;
	
	@Column(name="DT_REQUEST")
	private Date dtRequest;
	
	@Column(name="PENDENT")
	private Boolean pendent;
	
	@Column(name="VALUE_ORDER")
	private BigDecimal valueOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserSystem getUser() {
		return user;
	}

	public void setUser(UserSystem user) {
		this.user = user;
	}

	public Date getDtRequest() {
		return dtRequest;
	}

	public void setDtRequest(Date dtRequest) {
		this.dtRequest = dtRequest;
	}

	public Boolean getPendent() {
		return pendent;
	}

	public void setPendent(Boolean pendent) {
		this.pendent = pendent;
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

	public BigDecimal getValueOrder() {
		return valueOrder;
	}

	public void setValueOrder(BigDecimal valueOrder) {
		this.valueOrder = valueOrder;
	}
}
package br.com.entelgy.burguer.controller.snackrequest;

import java.util.List;

import br.com.entelgy.burguer.comuns.validators.ConvertListInteger;
import br.com.entelgy.burguer.comuns.validators.Required;

public class FormSnack {
	
	private Integer snack;

	@Required
	private Integer bread;
	
	private Integer cheese;
	
	private Boolean doubleCheese;
	
	private Integer filling;
	
	private Boolean doubleFilling;
	
	private Integer salad;
	
	@ConvertListInteger
	private List<Integer> sauces;
	
	@ConvertListInteger
	private List<Integer> spices;

	public Integer getSnack() {
		return snack;
	}

	public void setSnack(Integer snack) {
		this.snack = snack;
	}

	public Integer getBread() {
		return bread;
	}

	public void setBread(Integer bread) {
		this.bread = bread;
	}

	public Integer getCheese() {
		return cheese;
	}

	public void setCheese(Integer cheese) {
		this.cheese = cheese;
	}

	public Integer getFilling() {
		return filling;
	}

	public void setFilling(Integer filling) {
		this.filling = filling;
	}

	public Integer getSalad() {
		return salad;
	}

	public void setSalad(Integer salad) {
		this.salad = salad;
	}

	public List<Integer> getSauces() {
		return sauces;
	}

	public void setSauces(List<Integer> sauces) {
		this.sauces = sauces;
	}

	public List<Integer> getSpices() {
		return spices;
	}

	public void setSpices(List<Integer> spices) {
		this.spices = spices;
	}

	public Boolean getDoubleCheese() {
		return doubleCheese;
	}

	public void setDoubleCheese(Boolean doubleCheese) {
		this.doubleCheese = doubleCheese;
	}

	public Boolean getDoubleFilling() {
		return doubleFilling;
	}

	public void setDoubleFilling(Boolean doubleFilling) {
		this.doubleFilling = doubleFilling;
	}
}
package br.com.entelgy.burguer.enuns;

public enum ETypeProduct {

	SNACKS(1),
	BREAD(2),
	CHEESE(3),
	FILLING(4),
	SALAD(5),
	SAUCES(6),
	SPICES(7);
	
	private Integer id;
	
	ETypeProduct(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
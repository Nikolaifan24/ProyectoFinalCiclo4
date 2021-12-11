package com.proyectoCiclo4.enums;

public enum CollectionEnum {
	BOGOTA("usuarios_bogota"),
	MEDELLIN("usuarios_medellin"),
	CALI("usuarios_cali");
	
	private String collectionName;
	
	CollectionEnum(String collectionName) {
		this.collectionName = collectionName;
	}
	
	public String getCollectionName() {
		return collectionName;
	}
	
	public CollectionEnum getCollectionEnum(String ciudad) {
		return CollectionEnum.valueOf(ciudad.toUpperCase());
	}
}

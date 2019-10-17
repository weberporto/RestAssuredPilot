package com.serene.tests.features.steps.structureXML;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("habitacao")
public class Habitacao {

	private String origemRecurso;
	private String valorImovel;
	private String cotaMaxima;
	
	public Habitacao(String origemRecurso, String valorImovel, String cotaMaxima) {		
		this.origemRecurso = origemRecurso;
		this.valorImovel = valorImovel;
		this.cotaMaxima = cotaMaxima;
	}

	public String getOrigemRecurso(){
		return origemRecurso;
	}
	
	public void setOrigemRecurso(String origemRecurso){
		this.origemRecurso = origemRecurso;
	}
	
	public String getValorImovel(){
		return valorImovel;
	}
	
	public void setValorImovel(String valorImovel){
		this.valorImovel = valorImovel;
	}
	
	public String getCotaMaxima(){
		return cotaMaxima;
	}
	
	public void setCotaMaxima(String cotaMaxima){
		this.cotaMaxima = cotaMaxima;
	}
}

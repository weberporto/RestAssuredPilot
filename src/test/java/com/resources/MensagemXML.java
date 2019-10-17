package com.resources;

import com.serene.tests.features.steps.structureXML.AvaliacaoRisco;
import com.serene.tests.features.steps.structureXML.Garantia;
import com.serene.tests.features.steps.structureXML.GrupoHabitacional;
import com.serene.tests.features.steps.structureXML.Habitacao;
import com.serene.tests.features.steps.structureXML.Header;
import com.serene.tests.features.steps.structureXML.Produto;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ns:mensagem xmlns:ns='http://br.unisys.com/siaci-messages/1.0.0'")
public class MensagemXML {
	
	private String mensagem;
	private Header headerSIBAR;
	private AvaliacaoRisco avaliacaoRisco;	
	private Produto produto;
	private Habitacao habitacao;
	private GrupoHabitacional grupoHabitacional;
	private Garantia garantia;
	
	public String getMensagem(){
		return mensagem;
	}
	
	public void setMensagem(String mensagem){
		this.mensagem = mensagem;
	}

	public Header getHeader(){
		return headerSIBAR;
	}
	    
	public void setHeader(Header header){
	   this.headerSIBAR = header;
	}
	
	public AvaliacaoRisco getAvaliacaoRisco(){
		return avaliacaoRisco;
	}
	
	public void setAvaliacaoRisco(AvaliacaoRisco avaliacaoRisco){
		this.avaliacaoRisco = avaliacaoRisco;
	}

	//**
	public void setAvaliacaoRisco(Produto produto) {
		this.produto = produto;
	}

	public void setAvaliacaoRisco(Habitacao habitacao) {
		this.habitacao = habitacao;
	}

	public void setAvaliacaoRisco(GrupoHabitacional grupoHabitacional) {
		this.grupoHabitacional = grupoHabitacional;		
	}

	public void setAvaliacaoRisco(Garantia garantia) {
		this.garantia = garantia;		
	}
	//**
}
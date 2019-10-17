package com.serene.tests.features.steps.structureXML;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("garantia")
public class Garantia {
	
	private String codigoProduto;
	private String codigoModalidade;
	private String codigoTipoGarantia;
	private String seqTipoGarantia;
	private String prioridade;
	private String valor;
	
	public Garantia(String codigoProduto, String codigoModalidade, String codigoTipoGarantia, String seqTipoGarantia, String prioridade, String valor) {

		this.codigoProduto = codigoProduto;
		this.codigoModalidade = codigoModalidade;
		this.codigoTipoGarantia = codigoTipoGarantia;
		this.seqTipoGarantia = seqTipoGarantia;
		this.prioridade = prioridade;
		this.valor = valor;
	}

	public String getCodigoProduto(){
		return codigoProduto;
	}
	
	public void setCodigoProduto(String codigoProduto){
		this.codigoProduto = codigoProduto;
	}
	
	public String getCodigoModalidade(){
		return codigoModalidade;
	}
	
	public void setCodigoModalidade(String codigoModalidade){
		this.codigoModalidade = codigoModalidade;
	}

	public String getCodigoTipoGarantia(){
		return codigoTipoGarantia;
	}
	
	public void setCodigoTipoGarantia(String codigoTipoGarantia){
		this.codigoTipoGarantia = codigoTipoGarantia;
	}
	
	public String getSeqTipoGarantia(){
		return seqTipoGarantia;
	}
	
	public void setSeqTipoGarantia(String seqTipoGarantia){
		this.seqTipoGarantia = seqTipoGarantia;
	}
	
	public String getPrioridade(){
		return prioridade;
	}
	
	public void setPrioridade(String prioridade){
		this.prioridade = prioridade;
	}
	
	public String getValor(){
		return valor;
	}
	
	public void setValor(String valor){
		this.valor = valor;
	}
}

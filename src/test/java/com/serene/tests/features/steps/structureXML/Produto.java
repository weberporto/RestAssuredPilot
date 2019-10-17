package com.serene.tests.features.steps.structureXML;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("produto")
public class Produto {

	private String codigoProduto;
	private String codigoSistemaDestino;
	private String codigoModalidade;
	private String valorMaxPrestacao;
	private String valorMaxEmprestimo;
	private String tipoPrazo;
	private String prazoMaximoEmprestimo;
	private String conceitoRating;
	private String coContrato;
	private String indRenovaAuto;
	
	public Produto(String codigoProduto, String codigoSistemaDestino, String codigoModalidade, String valorMaxPrestacao, String valorMaxEmprestimo, String tipoPrazo,
			String prazoMaximoEmprestimo, String conceitoRating, String coContrato, String indRenovaAuto) {
		
		this.codigoProduto = codigoProduto;
		this.codigoSistemaDestino = codigoSistemaDestino;
		this.codigoModalidade = codigoModalidade;
		this.valorMaxPrestacao = valorMaxPrestacao;
		this.valorMaxEmprestimo = valorMaxEmprestimo;
		this.tipoPrazo = tipoPrazo;
		this.prazoMaximoEmprestimo = prazoMaximoEmprestimo;
		this.conceitoRating = conceitoRating;
		this.coContrato = coContrato;
		this.indRenovaAuto = indRenovaAuto;	
	}

	public String getCodigoProduto(){
	    	return codigoProduto;
	    }
	    
	 public void setCodigoProduto(String codigoProduto){
	    	this.codigoProduto = codigoProduto;
	    }  	    
	    
	 public String getCodigoSistemaDestino(){
	    	return codigoSistemaDestino;
	    }
	 
	 public void setCodigoSistemaDestino(String codigoSistemaDestino){
	    	this.codigoSistemaDestino = codigoSistemaDestino;
	    }  	 
	 
	 public String getCodigoModalidade(){
		 	return codigoModalidade;
	 }
	 
	 public void setCodigoModalidade(String codigoModalidade){
		 	this.codigoModalidade = codigoModalidade;
	 }
	 
	 public String getValorMaxPrestacao(){
		 	return valorMaxPrestacao;
	 }
	 
	 public void setValorMaxPrestacao(String valorMaxPrestacao){
		 	this.valorMaxPrestacao = valorMaxPrestacao;
	 }
	 
	 public String getValorMaxEmprestimo(){
		 	return valorMaxEmprestimo;
	 }
	 
	 public void setValorMaxEmprestimo(String valorMaxEmprestimo){
		 	this.valorMaxEmprestimo = valorMaxEmprestimo;
	 }
	 
	 public String getTipoPrazo(){
		 	return tipoPrazo;
	 }
	 
	 public void setTipoPrazo(String tipoPrazo){
		 	this.tipoPrazo = tipoPrazo;
	 }
	 
	 public String getPrazoMaximoEmprestimo(){
		 	return prazoMaximoEmprestimo;
	 }
	 
	 public void setPrazoMaximoEmprestimo(String prazoMaximoEmprestimo){
		 	this.prazoMaximoEmprestimo = prazoMaximoEmprestimo;
	 }
	 
	 public String getConceitoRating(){
		 	return conceitoRating;
	 }
	 
	 public void setConceitoRating(String conceitoRating){
		 	this.conceitoRating = conceitoRating;
	 }
	 
	 public String getCoContrato(){
		 	return coContrato;
	 }
	 
	 public void setCoContrato(String coContrato){
		 	this.coContrato = coContrato;
	 }
	 
	 public String getIndRenovaAuto(){
		 	return indRenovaAuto;
	 }
	 
	 public void setIndRenovaAuto(String indRenovaAuto){
		 	this.indRenovaAuto = indRenovaAuto;
	 }
}

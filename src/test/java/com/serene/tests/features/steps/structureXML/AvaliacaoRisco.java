package com.serene.tests.features.steps.structureXML;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("avaliacaoRisco")
public class AvaliacaoRisco {

	private String tipoRegistro;
 	private String tipoAvaliacao;
 	private String codigoAvaliacao;
 	private String indCpfCnpj;
 	private String cpfCnpj;
 	private String dataInicioValidade;
 	private String dataFimValidade;
 	private String codigoUnidade;
 	private String criterioJulgamental;
 	private String indContrataValorExato;
 	private String indPermissao;
 	private String usuario;
 	private Produto produto;
 	private Habitacao habitacao;
 	private GrupoHabitacional grupoHabitacional;
 	private Garantia garantia;
 	
 	public AvaliacaoRisco(String tipoRegistro, String tipoAvaliacao, String codigoAvaliacao, String indCpfCnpj, String cpfCnpj, String dataInicioValidade,
 			String dataFimValidade, String codigoUnidade, String criterioJulgamental, String indContrataValorExato, String indPermissao, String usuario,
 			Produto produto, Habitacao habitacao, GrupoHabitacional grupoHabitacional, Garantia garantia){
 		
 		this.tipoRegistro = tipoRegistro;
 		this.tipoAvaliacao = tipoAvaliacao;
 		this.codigoAvaliacao = codigoAvaliacao;
 		this.indCpfCnpj = indCpfCnpj;
 		this.cpfCnpj = cpfCnpj;
 		this.dataInicioValidade = dataInicioValidade;
 		this.dataFimValidade = dataFimValidade;
 		this.codigoUnidade = codigoUnidade;
 		this.criterioJulgamental = criterioJulgamental;
 		this.indContrataValorExato = indContrataValorExato;
 		this.indPermissao = indPermissao;
 		this.usuario = usuario; 
 		this.produto = produto;
 		this.habitacao = habitacao;
 		this.grupoHabitacional = grupoHabitacional;
 		this.garantia = garantia;
 	} 	
 	
 	public AvaliacaoRisco(String tipoRegistro, String tipoAvaliacao, String codigoAvaliacao, String indCpfCnpj, String cpfCnpj, String dataInicioValidade,
 			String dataFimValidade, String codigoUnidade, String criterioJulgamental, String indContrataValorExato, String indPermissao, String usuario,
 			Produto produto, Habitacao habitacao, GrupoHabitacional grupoHabitacional1, GrupoHabitacional grupoHabitacional2, Garantia garantia){
 		
 		this.tipoRegistro = tipoRegistro;
 		this.tipoAvaliacao = tipoAvaliacao;
 		this.codigoAvaliacao = codigoAvaliacao;
 		this.indCpfCnpj = indCpfCnpj;
 		this.cpfCnpj = cpfCnpj;
 		this.dataInicioValidade = dataInicioValidade;
 		this.dataFimValidade = dataFimValidade;
 		this.codigoUnidade = codigoUnidade;
 		this.criterioJulgamental = criterioJulgamental;
 		this.indContrataValorExato = indContrataValorExato;
 		this.indPermissao = indPermissao;
 		this.usuario = usuario; 
 		this.produto = produto;
 		this.habitacao = habitacao;
 		this.grupoHabitacional = grupoHabitacional1;
 		this.grupoHabitacional = grupoHabitacional2;
 		this.garantia = garantia;
 	} 	
 	
 	//public AvaliacaoRisco(Produto produto){
 	//	this.produto = produto;
 	//}
 	
 	//public AvaliacaoRisco(Habitacao habitacao){
 	//	this.habitacao = habitacao;
 	//}
 	
 	//public AvaliacaoRisco(GrupoHabitacional grupoHabitacional){
 	//	this.grupoHabitacional = grupoHabitacional;
 	//}
 	
 	//public AvaliacaoRisco(Garantia garantia){
 	//	this.garantia = garantia;
 	//}
 
    public AvaliacaoRisco() {
		// TODO Auto-generated constructor stub
	}

	public String getTipoRegistro(){
    	return tipoRegistro;
    }
    
    public void setTipoRegistro(String tipoRegistro){
    	this.tipoRegistro = tipoRegistro;
    }  	    
    
    public String getTipoAvaliacao(){
    	return tipoAvaliacao;
    }
    
    public void setTipoAvaliacao(String tipoAvaliacao){
    	this.tipoAvaliacao = tipoAvaliacao;
    }
    	    
    public String getCodigoAvaliacao(){
    	return codigoAvaliacao;
    }
    
    public void setCodigoAvaliacao(String codigoAvaliacao){
    	this.tipoAvaliacao = codigoAvaliacao;
    }
    
    public String getIndCpfCnpj(){
    	return indCpfCnpj;
    }
    
    public void setIndCpfCnpj(String indCpfCnpj){
    	this.indCpfCnpj = indCpfCnpj;
    }
    
    public String getCpfCnpj(){
    	return cpfCnpj;
    }
    
    public void setCpfCnpj(String cpfCnpj){
    	this.cpfCnpj = cpfCnpj;
    }
    
    public String getDataInicioValidade(){
    	return dataInicioValidade;
    }
    
    public void setDataInicioValidade(String dataInicioValidade){
    	this.dataInicioValidade = dataInicioValidade;
    }
    
    public String getDataFimValidade(){
    	return dataFimValidade;
    }
    
    public void setDataFimValidade(String dataFimValidade){
    	this.dataFimValidade= dataFimValidade;
    }
    
    public String getCodigoUnidade(){
    	return codigoUnidade;
    }
    
    public void setCodigoUnidade(String codigoUnidade){
    	this.codigoUnidade = codigoUnidade;
    }
    
    public String getCriterioJulgamental(){
    	return criterioJulgamental;
    }
    
    public void setCriterioJulgamental(String criterioJulgamental){
    	this.criterioJulgamental = criterioJulgamental;
    }
    
    public String getIndContrataValorExato(){
    	return indContrataValorExato;
    }
    
    public void setIndContrataValorExato(String indContrataValorExato){
    	this.indContrataValorExato = indContrataValorExato;
    }
    
    public String getIndPermissao(){
    	return indPermissao;
    }
    
    public void setIndPermissao(String indPermissao){
    	this.indPermissao = indPermissao;
    }
    
    public String getUsuario(){
    	return usuario;
    }
    
    public void setUsuario(String usuario){
    	this.usuario = usuario;
    }
    
    //**
    public Produto getProduto(){
    	return produto;
    }
  
    public void setProduto(Produto produto){
    	this.produto = produto;
    }
    //**
    
    public Habitacao getHabitacao(){
    	return habitacao;
    }
    
    public void setHabitacao(Habitacao habitacao){
    	this.habitacao = habitacao;
    }
    
    public GrupoHabitacional getGrupoHabitacional(){
    	return grupoHabitacional;
    }
    
    public void setGrupoHabitacional(GrupoHabitacional grupoHabitacional){
    	this.grupoHabitacional = grupoHabitacional;
    }
    
    public Garantia getGarantia(){
    	return garantia;
    }
    
    public void setGarantia(Garantia garantia){
    	this.garantia = garantia;
    }
}

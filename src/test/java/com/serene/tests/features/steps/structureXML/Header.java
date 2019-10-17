package com.serene.tests.features.steps.structureXML;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("HeaderSIBAR")
public class Header {
	
	private String Usuario;
	
	public String getUsuario(){
		return Usuario;
	}
	
	public void setUsuario(String Usuario){
		this.Usuario = Usuario;
	}
	
	public Header(String usuario){
		this.Usuario = usuario;
	}
}

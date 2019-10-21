package com.serene.tests.features.steps.structureXML;

/**
 * @author PortoAmW
 * 
 * Descrição: Classe responsável pela implementação da TAG Grupo Habitacional
 */

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("grupoHabitacional")
public class GrupoHabitacional {
	
	private String icPapelCliente;
	private String cpfTomador;
	private String cpfParticipante;
	private String rendaCliente;	
	
	public GrupoHabitacional(String icPapelCliente, String cpfTomador, String rendaCliente) {
		
		this.icPapelCliente = icPapelCliente;
		this.cpfTomador = cpfTomador;
		this.rendaCliente = rendaCliente;
	}
	
	public GrupoHabitacional(String icPapelCliente, String cpfTomador, String cpfParticipante, String rendaCliente) {
		
		this.icPapelCliente = icPapelCliente;
		this.cpfTomador = cpfTomador;
		this.cpfParticipante = cpfParticipante;	
		this.rendaCliente = rendaCliente;
			
	}
	
	public GrupoHabitacional() {
		// TODO Auto-generated constructor stub
	}

	public String getIcPapelCliente(){
		return icPapelCliente;
	}
	
	public void setIcPapelCliente(String icPapelCliente){
		this.icPapelCliente = icPapelCliente;
	}
	
	public String getCpfTomador(){
		return cpfTomador;
	}
	
	public void setCpfTomador(String cpfTomador){
		this.cpfTomador = cpfTomador;
	}
	
	public String getRendaCliente(){
		return rendaCliente;
	}
	
	public void setRendaCliente(String rendaCliente){
		this.rendaCliente = rendaCliente;
	}
	
	public String getCpfParticipante(){
		return cpfParticipante;
	}
	
	public void setCpfParticipante(String cpfParticipante){
		this.cpfParticipante = cpfParticipante;
	}
}

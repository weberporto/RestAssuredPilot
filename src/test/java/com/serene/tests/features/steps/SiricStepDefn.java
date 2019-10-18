package com.serene.tests.features.steps;

import java.io.IOException;

import org.junit.runner.RunWith;

import cucumber.api.java.After;
import cucumber.api.java.Before;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

/**
 * @author PortoAmW
 * @version 1.0
 * @since Out/19
 * Descrição: Classe responsável pela implementação das definições que compõe o passo a passo (Steps) 
 *            Implementa o passo a passo que são executados nas Features
 */

@RunWith(SerenityRunner.class)

public class SiricStepDefn {
	
	@Before
	public void setup()
	{   //Endpoint 	
    	RestAssured.baseURI = "http://172.20.22.18";
	}
	
	@After
	public void tearDown()
	{
        RestAssured.reset();
	}
		
	@Steps
	SiricAPISteps siricAPI;
	
	//@Dado("^que possuo um arquivo \"([^\"]*)\" de dados simulando a aplicação do SIOPI")
	
	//Implementação NOVA
	@Dado("^que possuo dados para a geração de um arquivo \"([^\"]*)\" para simulação do SIOPI")	
	public void verifica_tipo_dados(String tipo){
		System.out.println("Recebeu o(s) tipo(s) do arquivo: "+ tipo);
		//
	}
	
	//@E("^informo o(s) campo(s) \"([^\"]*)\" da funcionalidade 'SIRIC' para cadastro dos dados de 'Avaliação de Risco'")
	
	//Implementação NOVA
	@E("^informo o campo \"([^\"]*)\" com o valor \"([^\"]*)\" ")
	public void recebe_dados(String campo, String valor){	
		System.out.println("Recebeu o(s) valor(es) da funcionalidade SIRIC: "+ campo);
		siricAPI.informa_campos(campo, valor);
	}
	
	@E("^informo todos os dados para o cadastro de uma avaliação de risco SIRIC: avaliação de risco de risco \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e produto \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e habitação \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e grupo habitação \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e garantia \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void informa_dados(String tReg, String tAva, String cAval, String iCpf, String cpfCnpj, String dVal, String dFim, String cUni, String cJul, String iVEx, String iPer, String usu,
			String cProd, String cSis, String cMod, String vMPres, String vMEmp, String tPra, String pMEmp, String cRat, String cCont, String iRen,
			String oRec, String vImo, String cMax,
			String iPap, String cTom, String rCli, String cPar,
			String cPGar, String cMGar, String cTGar, String sTGar, String pGar, String vGar){
		
		siricAPI.geraArquivo(tReg, tAva, cAval, iCpf, cpfCnpj, dVal, dFim, cUni, cJul, iVEx, iPer, usu,
				cProd, cSis, cMod, vMPres, vMEmp, tPra, pMEmp, cRat, cCont, iRen,
				oRec, vImo, cMax,
				iPap, cTom, rCli, cPar,
				cPGar, cMGar, cTGar, sTGar, pGar, vGar);
	}
	
	@Então("^o arquivo esta pronto para envio")
	public void gera_arquivo(){
		System.out.println("Arquivo gerado!");
		//siricAPI.geraArquivo();
	}
	
	//Implementação NOVA
	@Quando("^realizo o envio destes dados para a alta plataforma SIACI")
	public void gera_envia_arquivo(){
		System.out.println("Chamou o passo envio do arquivo!");
		//
	}	
	//***
	
	@Dado("^que recupero estes dados do arquivo \"([^\"]*)\" do tipo \"([^\"]*)\" que foi gerado$")
	public void recupera_dados(String nome, String tipo) throws IOException{		
		siricAPI.recuperaArquivoServico(nome, tipo);
	}
	
	@Dado("^o arquivo \"([^\"]*)\" do tipo \"([^\"]*)\"$")
	public void recupera_dados_arquivo(String nome, String tipo) throws IOException{		
		siricAPI.recuperaArquivoServico(nome, tipo);
	}
	
	@E("^informo o numero de uma avaliação já cadastrada")
	public void informa_numero_avalicao(){
		//testar
		//Serenity.setSessionVariable("codigoAvaliacao").to(numero);
	}
	
	@E("^verifico que o acesso ao serviço foi realizado com sucesso.")
	public void acesso_servico_sucessoE(){
		siricAPI.verificaAcessoServicoSucesso();
	}
	
	@Então("^verifico se o acesso ao serviço foi com sucesso.")
	public void acesso_servico_sucessoEntao(){
		siricAPI.verificaAcessoServicoSucesso();
	}
	
	@Quando("^realizo o envio destes dados$")
	public void envio_arquivo_post() {
		siricAPI.postSiricRequest();
	}
	@Então("^verifico o retorno do arquivo \"([^\"]*)\"$")
	public void verifica_retornoEntao(String tipo) throws Exception{		
		//String status = Serenity.sessionVariableCalled("status").toString();		
		//String codigoAvaliacao = Serenity.sessionVariableCalled("codigoAvaliacao").toString();		
		siricAPI.verificaRetorno(tipo);
	}
	
	@E("^ também verifico o retorno do arquivo \"([^\"]*)\"$")
	public void verifica_retornoE(String tipo) throws Exception{	
		siricAPI.verificaRetorno(tipo);
	}
	
	@Então("^verifico a validação da tentativa de cadastro da avaliação \"([^\"]*)\" já existente, no arquivo \"([^\"]*)\"$")
	public void verifica_tentativa_cadastro_avaliacao_existente(String avaliacao, String tipo) throws Exception{
		
		siricAPI.verificaValidacaoRetorno(avaliacao, tipo);
	}
	
	@Então("^verifico o retorno da avaliação com conjuge, número \"([^\"]*)\", do arquivo \"([^\"]*)\"$")
	public void verifica_retorno_com_conjuge(String avaliacao, String tipo) throws Exception{		
		//String status = Serenity.sessionVariableCalled("status").toString();		
		//String codigoAvaliacao = Serenity.sessionVariableCalled("codigoAvaliacao").toString();		
		siricAPI.verificaRetornoComConjuge(avaliacao, tipo);
	}
	
	@Então("^verifico o retorno da avaliação sem conjuge, número \"([^\"]*)\", do arquivo \"([^\"]*)\"$")
	public void verifica_retorno_sem_conjuge(String avaliacao, String tipo) throws Exception{		
		//String status = Serenity.sessionVariableCalled("status").toString();		
		//String codigoAvaliacao = Serenity.sessionVariableCalled("codigoAvaliacao").toString();		
		siricAPI.verificaRetornoSemConjuge(avaliacao, tipo);
	}
}

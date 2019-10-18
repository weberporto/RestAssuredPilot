package com.serene.tests.features.steps;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author PortoAmW
 * @version 1.0
 * @since 10/2019
 */

/**
 * Classe responsável pela implementação de cada função (Steps) para a execução do BDD
 * Implementa o passo a passo
 */

import java.io.IOException;

import org.junit.Assert;

import com.resources.Arquivo;
import com.resources.MensagemXML;
import com.serene.tests.features.steps.structureXML.AvaliacaoRisco;
import com.serene.tests.features.steps.structureXML.Garantia;
import com.serene.tests.features.steps.structureXML.GrupoHabitacional;
import com.serene.tests.features.steps.structureXML.Habitacao;
import com.serene.tests.features.steps.structureXML.Header;
import com.serene.tests.features.steps.structureXML.Produto;

import cucumber.deps.com.thoughtworks.xstream.XStream;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;


public class SiricAPISteps {
	
	  private Response res = null;  
	  private RequestSpecification requestSpec;
	  //Resource
	  String basePath = "siric/v1/incluir";	  
	  Arquivo ler = new Arquivo();
	  private JsonPath jp = null; 					    
	  private XmlPath xp = null; 
	  
	  MensagemXML mensagem = new MensagemXML();
	  
	  @Step
	  public void geraArquivo(String tReg, String tAva, String cAval, String iCpf, String cpfCnpj, String dVal, String dFim, String cUni, String cJul, String iVEx, String iPer, String usu,
				String cProd, String cSis, String cMod, String vMPres, String vMEmp, String tPra, String pMEmp, String cRat, String cCont, String iRen,
				String oRec, String vImo, String cMax,
				String iPap, String cTom, String rCli, String cPar,
				String cPGar, String cMGar, String cTGar, String sTGar, String pGar, String vGar){  

		  	mensagem.setEndereco("http://br.unisys.com/siaci-messages/1.0.0");
		  
		  	mensagem.setHeader(new Header("Teste"));
					
			mensagem.setAvaliacaoRisco(new AvaliacaoRisco(tReg, tAva, cAval, iCpf, cpfCnpj, dVal, dFim, cUni, cJul, iVEx, iPer, usu,
					new Produto(cProd, cSis, cMod, vMPres, vMEmp, tPra, pMEmp, cRat, cCont, iRen), 
					new Habitacao(oRec, vImo, cMax),
					new GrupoHabitacional(iPap, cTom, cPar, rCli), 
					//new GrupoHabitacional("P", "00000000000", "43903817090", "1382.90"),
					new Garantia(cPGar, cMGar, cTGar, sTGar, pGar, vGar)));	
			
		    XStream xStream = new XStream();
		    
		    xStream.alias("ns:mensagem", MensagemXML.class);		    
		    xStream.useAttributeFor(MensagemXML.class, "endereco");
		    xStream.aliasField("xmlns:ns", MensagemXML.class, "endereco");
		    
		    //xStream.alias("ns:mensagem xmlns:ns=\"http://br.unisys.com/siaci-messages/1.0.0\"", MensagemXML.class);
		        
		    File arquivo = new File("RepositoryArchives/siricTest.xml");
		    FileOutputStream gravar;
		    try {
		         	gravar = new FileOutputStream(arquivo);
		         	gravar.write(xStream.toXML(mensagem).getBytes());
		         	gravar.close();
		     	} catch (IOException ex) {
		            ex.printStackTrace();
		    }

	  }
	  
	  @Step
      public void recuperaArquivoServico (String nome, String tipo) throws IOException {
		  
      	String newArquivo = ler.leituraArquivo(nome, tipo);      
      	RequestSpecBuilder builder = new RequestSpecBuilder();      	
      	builder.setBasePath(basePath);      	
      	builder.setContentType("application/"+ tipo); 
      	
      	builder.setBody(newArquivo);  
      	requestSpec = builder.build();
      	
      	requestSpec = RestAssured.given().spec(requestSpec);      	
      	requestSpec.log().all();
      }
	  
	  @Step     
      public void postSiricRequest()  {
      	res = requestSpec.when().post();
      }
	  
	  @Step
      public void verificaRetorno(String tipo){
		  
		if(tipo.equalsIgnoreCase("xml")){
			xp = res.xmlPath();
			Assert.assertEquals("Sucesso", 200, res.getStatusCode());
			Assert.assertEquals("654321880", xp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
			Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo 654321880.", xp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
		} else {
			JsonPath jp = res.jsonPath();
			Assert.assertEquals("Sucesso", 200, res.getStatusCode());
			Assert.assertEquals("654321880", jp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
			Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo 654321880.", jp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
		}
		
      }
	  
	  @Step
      public void verificaValidacaoRetorno(String avaliacao, String tipo){
		  
		  if(tipo.equalsIgnoreCase("xml")){
			  	xp = res.xmlPath();
			  	Assert.assertEquals("Sucesso", 200, res.getStatusCode());
			  	Assert.assertEquals(avaliacao, xp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
			  	Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo "+ avaliacao +".", xp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
		  } else {
			  	JsonPath jp = res.jsonPath();	
			  	Assert.assertEquals("Sucesso", 200, res.getStatusCode());
			  	Assert.assertEquals(avaliacao, jp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
				Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo "+ avaliacao +".", jp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
		  }
	  }
	  
	  @Step
	  public void verificaRetornoComConjuge(String avaliacao, String tipo){
		  
		  if(tipo.equalsIgnoreCase("xml")){
				xp = res.xmlPath();
				Assert.assertEquals("Sucesso", 200, res.getStatusCode());
				Assert.assertEquals(avaliacao, xp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
				Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo "+ avaliacao +".", xp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
			} else {
				JsonPath jp = res.jsonPath();	
				Assert.assertEquals("Sucesso", 200, res.getStatusCode());
				Assert.assertEquals(avaliacao, jp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
				Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo "+ avaliacao +".", jp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
			}
	  }
	  
	  @Step
	  public void verificaRetornoSemConjuge(String avaliacao, String tipo){
		  
		  if(tipo.equalsIgnoreCase("xml")){
				xp = res.xmlPath();
				Assert.assertEquals("Sucesso", 200, res.getStatusCode());
				Assert.assertEquals(avaliacao, xp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
				Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo "+ avaliacao +".", xp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
			} else {
				jp = res.jsonPath();	
				Assert.assertEquals("Sucesso", 200, res.getStatusCode());
				Assert.assertEquals(avaliacao, jp.getString("mensagem.respostaAvaliacaoRisco.codigoAvaliacao"));
				Assert.assertEquals("Ja existe uma avaliacao de risco com o codigo "+ avaliacao +".", jp.getString("mensagem.respostaAvaliacaoRisco.mensagemValidacao"));
			}
	  }
	  
	  @Step
	  public void verificaAcessoServicoSucesso(){		  
		  Assert.assertEquals("Sucesso", 200, res.getStatusCode());
	  }
	  
	  
	  //Implementação NOVA - informa os parâmetros para a geração do arquivo
	  @Step
	  public MensagemXML informa_campos(String campo, String valor){
		  System.out.println("Recebeu o(s) valor(es): " + campo);
		   
		  mensagem.setHeader(new Header("Teste"));
			
			mensagem.setAvaliacaoRisco(new AvaliacaoRisco("13", "03", "654321880", "F", "32769966340", "2017-01-31", "2020-09-30", "4144", "N", "0", "0", "SICAQ",
					new Produto("999", "27", "3", "4000.00", "200000.00", "2", "420", "B32", "00000000000000000000", "N"), 
					new Habitacao("12018", "200000.00", "80.00000"),
					//new GrupoHabitacional("T", "93136469003", "93136469003"), 
					new GrupoHabitacional("P", "00000000000", "43903817090", "1382.90"),
					new Garantia("999", "3", "426", "1", "1", "200000.00")));		

	        XStream xStream = new XStream();        
	        xStream.alias("ns:mensagem xmlns:ns='http://br.unisys.com/siaci-messages/1.0.0'", MensagemXML.class);
		  
	        return mensagem;
	  }
}

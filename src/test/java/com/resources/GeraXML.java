package com.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.serene.tests.features.steps.structureXML.AvaliacaoRisco;
import com.serene.tests.features.steps.structureXML.Garantia;
import com.serene.tests.features.steps.structureXML.GrupoHabitacional;
import com.serene.tests.features.steps.structureXML.Habitacao;
import com.serene.tests.features.steps.structureXML.Header;
import com.serene.tests.features.steps.structureXML.Produto;

import cucumber.deps.com.thoughtworks.xstream.XStream;

public class GeraXML {

	MensagemXML mensagem = new MensagemXML();
	
	//GrupoHabitacional grupoT, grupoP = new GrupoHabitacional();	
	//GrupoHabitacional grupoP = new GrupoHabitacional();

	public void gravaXML() {
		
		//grupoT.setIcPapelCliente("T");
		//grupoT.setCpfTomador("93136469003");		
		//grupoT.setRendaCliente("93136469003");
		
		//grupoP.setIcPapelCliente("P");
		//grupoP.setCpfTomador("00000000000");
		//grupoP.setCpfParticipante("43903817090");
		//grupoP.setRendaCliente("1382.90");
		
		//List<GrupoHabitacional> grupos = new ArrayList<GrupoHabitacional>();
		
        //grupos.add(grupoT);
        //grupos.add(grupoP);
		
		mensagem.setHeader(new Header("Teste"));
			
		mensagem.setAvaliacaoRisco(new AvaliacaoRisco("13", "03", "654321880", "F", "2017-01-31", "2020-09-30", "4144", "N", "0", "0", "SICAQ",
				new Produto("999", "27", "3", "4000.00", "200000.00", "2", "420", "B32", "00000000000000000000", "N"), 
				new Habitacao("12018", "200000.00", "80.00000"),
				new GrupoHabitacional("T", "93136469003", "93136469003"), 
				new GrupoHabitacional("P", "00000000000", "43903817090", "1382.90"),
				new Garantia("999", "3", "426", "1", "1", "200000.00")));		

        XStream xStream = new XStream();        
        xStream.alias("ns:mensagem xmlns:ns='http://br.unisys.com/siaci-messages/1.0.0'", MensagemXML.class);
        
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
}

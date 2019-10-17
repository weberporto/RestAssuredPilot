package com.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author PortoAmW
 * @since 2019/10
 * @category Arquivo
 *  
 * Descrição: Classe responsável pela identificação, leitura e formato do arquivo utilizado na requisição
 * 			  dos serviços
 */

public class Arquivo {

	public String leituraArquivo(String arquivo, String tipo) throws IOException{
		
		String diretorioArquivo = "RepositoryArchives/" + arquivo +"."+ tipo;        	    	
      	File fileArquivo = new File(diretorioArquivo); 
      	FileReader lerArquivo = new FileReader(fileArquivo);
      	BufferedReader leitura = new BufferedReader(lerArquivo);      	
      	String newArquivo = "";      	
      	while(leitura.ready()){    		
      			newArquivo += leitura.readLine();
      	} 
      	lerArquivo.close();
      	leitura.close();      	
      	return newArquivo;
	}
}

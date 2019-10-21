#language:pt

@Siric
Funcionalidade: Cadastramento de avaliação SIRIC

O sistema deve prover o cadastramento de uma avaliação de forma correta.
Seguindo os seguintes critérios:

1) Realiza o cadastro, se o número da avaliação informado no arquivo XML não existir
2) Se a avaliação existir, retorna uma mensagem de validação informando que o número informado já existe
3) Realiza o cadastro com sucesso, tanto para avaliação de risco com conjuge quanto para sem conjuge

 	Esquema do Cenario: Tentar cadastrar avaliação SIRIC existente e verificar retorno
  
  	Dado que possuo os dados para a geração do arquivo "<tipo>" para simulação de envio via SIOPI
  	E informo todos os dados para o cadastro de uma avaliação de risco SIRIC: avaliação de risco de risco "<tReg>", "<tAval>", "<cAval>", "<iCpf>", "<cpfCnpj>", "<dVal>", "<dFim>", "<cUni>", "<cJul>", "<iVEx>", "<iPer>", "<usu>" e produto "<cProd>", "<cSis>", "<cMod>", "<vMPres>", "<vMEmp>", "<tPra>", "<pMEmp>", "<cRat>", "<cCont>", "<iRen>" e habitação "<oRec>", "<vImo>", "<cMax>" e grupo habitação "<iPap>", "<cTom>", "<rCli>", "<cPar>" e garantia "<cPGar>", "<cMGar>", "<cTGar>", "<sTGar>", "<pGar>", "<vGar>"
  	E verifico que todos os dados do arquivo "<nome>" do tipo "<tipo>" estão 'Ok'
  	Dado que o arquivo está pronto para envio
  	E os dados são carregados para envio
  	Quando realizo o envio destes dados para a alta plataforma SIACI	
  	Então verifico a validação da tentativa de cadastro da avaliação "<avaliacao>" já existente, no arquivo "<tipo>"
  
  	Exemplos:
  		|avaliacao|nome     |tipo|tReg|tAval|cAval		  |iCpf|cpfCnpj    |dVal			|dFim				|cUni|cJul|iVEx|iPer|usu  |cProd|cSis|cMod|vMPres	|vMEmp		|tPra|pMEmp|cRat|cCont               |iRen|oRec |vImo     |cMax    |iPap|cTom       |cPar				|rCli   |cPGar |cMGar |cTGar|sTGar|pGar|vGar		 |
  		|654321880|siricTest|xml |13	|03	  |654321880	|F   |32769966340|2017-01-31|2020-09-30	|4144|N   |0	 |0   |SICAQ|999  |27  |3   |4000.00|200000.00|2   |420  |b32 |00000000000000000000|N   |12018|200000.00|80.00000|P   |00000000000|43903817090|1382.90|999   |3     |426  |1    |1   |200000.00|
  	
  Esquema do Cenario: Cadastrar avaliação  	  

		Dado que possuo o arquivo "<nome>" do tipo "<tipo>" com os dados já preenchidos
		Quando realizo o envio destes dados
		Então verifico o retorno do arquivo "<tipo>"
		
		Exemplos: 
			|nome |tipo|
			|siric|xml |
		
	Esquema do Cenario: Cadastrar avaliação existente
	
		Dado que possuo o arquivo "<nome>" do tipo "<tipo>" com os dados já preenchidos
		E informo o numero de uma avaliação já cadastrada
		Quando realizo o envio destes dados
		Então verifico a validação da tentativa de cadastro da avaliação "<avaliacao>" já existente, no arquivo "<tipo>"
		
		Exemplos: 
			|nome |tipo|avaliacao|
			|siric|xml |654321880|
		
	Esquema do Cenario: Cadastrar avaliação com conjuge
	
		Dado que possuo o arquivo "<nome>" do tipo "<tipo>" com os dados já preenchidos
		Quando realizo o envio destes dados
		Então verifico se o acesso ao serviço foi com sucesso.
		E verifico o retorno da avaliação com conjuge, número "<avaliacao>", do arquivo "<tipo>"
		
		Exemplos: 
			|nome           |tipo|avaliacao|
			|siricComConjuge|xml |99997    |
			
	Esquema do Cenario: Cadastrar avaliação sem conjuge
	
		Dado que possuo o arquivo "<nome>" do tipo "<tipo>" com os dados já preenchidos
		Quando realizo o envio destes dados
		Então verifico se o acesso ao serviço foi com sucesso.
		E verifico o retorno da avaliação sem conjuge, número "<avaliacao>", do arquivo "<tipo>"
		
		Exemplos:
			|nome           |tipo|avaliacao|
			|siricSemConjuge|xml |99998    |
  	
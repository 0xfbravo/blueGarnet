blueGarnet
==========
					�ltima Vers�o:
				v0.4b � 2014/Outubro                                  
                                                     
  ------------------------------------------------
  		@author Fellipe Bravo Ribeiro Pimentel
  					� 2014/Outubro
  				Atualizado em 12/10/2014
  				Programa ainda em fase beta
  ------------------------------------------------
  
  *Aplicativo com diversas utilidades desenvolvido
  para o Escrit�rio Cont�bil S�o Judas Tadeu (SJT)
  utilizando o Microsoft SQL Server como o banco
  de dados.
  Algumas consultas ao banco de dados s�o feitas
  na base de dados da ALTERDATA sistema Pack Diamond (SQL).
  Novas funcionalidades est�o sendo adicionadas ao programa
  a cada dia que passa.*
  
    
  Bibliotecas utilizadas:
   * _JTattoo_ (Skin do Aplicativo)
   * _SQLJDBC_ (Conex�o com o Banco de Dados SQL)
   * _JRimum-BOPEPO_ (Gera��o de Boletos Banc�rios)
   	- Log4J (Depend�ncia BOPEPO)
  	- Commons-Lang (Depend�ncia BOPEPO)
   	- iText (Depend�ncia BOPEPO)
   	
   	   
   Fun��es do Aplicativo:   
   		* _Usu�rio Administrador_
   			- Criar Usu�rio
   			- Editar Usu�rio
   			- Listagem de Empresas
   			- Listagem de Usu�rios
 
   		* _Usu�rio Financeiro_
   			- Renomear Boletos
   					> Pode ser utilizado para renomear diversos arquivos
   			- Gerar Boletos
   					> Gera diversos boletos que s�o salvos automaticamente organizados
   					em pastas seguindo o caminho:
   						>> ANO/M�S/N�meroDaEmpresa/Documento.pdf <<
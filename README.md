blueGarnet
==========

 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|
                  v0.4b � 2014                                   
                                                     
  ------------------------------------------------
  		@author Fellipe Bravo Ribeiro Pimentel
  					� 2014/Outubro
  		Atualizado em 09/10/2014 - Vers�o v0.4b
  				Programa ainda em fase beta
  ------------------------------------------------
  
  Aplicativo com diversas utilidades desenvolvido
  para o Escrit�rio Cont�bil S�o Judas Tadeu (SJT)
  utilizando o Microsoft SQL Server como o banco
  de dados.
  Algumas consultas ao banco de dados s�o feitas
  na base de dados da ALTERDATA sistema Pack Diamond (SQL).
  Novas funcionalidades est�o sendo adicionadas ao programa
  a cada dia que passa.
  
  Bibliotecas utilizadas:
   * JTattoo (Skin do Aplicativo)
   * SQLJDBC (Conex�o com o Banco de Dados SQL)
   * JRIMUM-BOPEPO (Gera��o de Boletos Banc�rios)
   	- Log4J (Depend�ncia BOPEPO)
  	- Commons-Lang (Depend�ncia BOPEPO)
   	- iText (Depend�ncia BOPEPO)
   
   Funções do Aplicativo:
   
   		* Administrativas
   			- Criar Usu�rio
   			- Editar Usu�rio
   			- Listagem de Empresas
   			- Listagem de Usu�rios
 
   		* Gerais
   			- Renomear Boletos
   				>> Pode ser utilizado para
   				renomear diversos arquivos
   			- Gerar Boletos
   				>> Gera diversos boletos que s�o
   				salvos automaticamente organizados
   				em pastas seguindo o caminho:
   					ANO/M�S/N�meroDaEmpresa/Documento.pdf
blueGarnet
==========
					Última Versão:
				v0.4b © 2014/Outubro                                  
                                                     
  ------------------------------------------------
  		@author Fellipe Bravo Ribeiro Pimentel
  					© 2014/Outubro
  				Atualizado em 12/10/2014
  				Programa ainda em fase beta
  ------------------------------------------------
  
  *Aplicativo com diversas utilidades desenvolvido
  para o Escritório Contábil São Judas Tadeu (SJT)
  utilizando o Microsoft SQL Server como o banco
  de dados.
  Algumas consultas ao banco de dados são feitas
  na base de dados da ALTERDATA sistema Pack Diamond (SQL).
  Novas funcionalidades estão sendo adicionadas ao programa
  a cada dia que passa.*
  
    
  Bibliotecas utilizadas:
   * _JTattoo_ (Skin do Aplicativo)
   * _SQLJDBC_ (Conexão com o Banco de Dados SQL)
   * _JRimum-BOPEPO_ (Geração de Boletos Bancários)
   	- Log4J (Dependência BOPEPO)
  	- Commons-Lang (Dependência BOPEPO)
   	- iText (Dependência BOPEPO)
   	
   	   
   Funções do Aplicativo:   
   		* _Usuário Administrador_
   			- Criar Usuário
   			- Editar Usuário
   			- Listagem de Empresas
   			- Listagem de Usuários
 
   		* _Usuário Financeiro_
   			- Renomear Boletos
   					> Pode ser utilizado para renomear diversos arquivos
   			- Gerar Boletos
   					> Gera diversos boletos que são salvos automaticamente organizados
   					em pastas seguindo o caminho:
   						>> ANO/MÊS/NúmeroDaEmpresa/Documento.pdf <<
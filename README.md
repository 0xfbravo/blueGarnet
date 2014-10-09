blueGarnet
==========
/**
 * 
 */
/**
 * ------------------------------------------------
 * 		@author Fellipe Bravo Ribeiro Pimentel
 * 					© 2014/Outubro
 * 		Atualizado em 08/10/2014 - Versão v0.4b
 * 				Programa ainda em fase beta
 * ------------------------------------------------
 * 
 * Aplicativo com diversas utilidades desenvolvido
 * para o Escritório Contábil São Judas Tadeu (SJT)
 * utilizando o Microsoft SQL Server como o banco
 * de dados.
 * Algumas consultas ao banco de dados são feitas
 * na base da ALTERDATA, sistema Pack Diamond (SQL).
 * 
 * Bibliotecas utilizadas:
 *  - JTattoo (Skin do Aplicativo)
 *  - SQLJDBC (Conexão com o Banco de Dados SQL)
 *  - JRIMUM-BOPEPO (Geração de Boletos Bancários)
 *  	- Log4J (Dependência BOPEPO)
 * 		- Commons-Lang (Dependência BOPEPO)
 *  	- iText (Dependência BOPEPO)
 *  
 *  Funções do Aplicativo:
 *  
 *  		• Administrativas
 *  			- Criar Usuário
 *  			- Editar Usuário
 *  			- Listagem de Empresas
 *  			- Listagem de Usuários
 *
 *  		• Gerais
 *  			- Renomear Boletos
 *  				* Pode ser utilizado para
 *  				renomear diversos arquivos
 *  			- Gerar Boletos
 *  				* Gera diversos boletos que são
 *  				salvos automaticamente organizados
 *  				em pastas seguindo o caminho:
 *  					ANO/MÊS/NúmeroDaEmpresa/Documento.pdf
 *
 *
 */
package br.com.fpimentel;
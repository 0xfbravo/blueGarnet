package br.com.blueGarnet.system;
/*
 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

							  Fellipe Pimentel © 2014
										 www.fcode.co
*/

import javax.swing.ImageIcon;

import br.com.blueGarnet.others.FuncoesExtras;

public class Config {
	/*
	 *   Definições do Sistema
	 */
	public static String versaoPrograma = "v0.5.1b";
	public static String nomePrograma = "blueGarnet "+versaoPrograma;
	public static int alturaPrograma = 700, larguraPrograma = 1200;
	public static ImageIcon imagemTituloJanela = FuncoesExtras.buscarIcone("img/blueGarnet.png");

}

package br.com.fpimentel.dev;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/


import javax.swing.JMenu;

import br.com.fpimentel.Menu;
import br.com.fpimentel.util.FuncoesExtras;

public class MenuDesenvolvedor {
	
	public MenuDesenvolvedor(){
		/*----------------------------------*
		 *  	Menu de Desenvolvimento
		 *----------------------------------*/
		JMenu menuDesenvolvimento = new JMenu("Funções BETA");
		menuDesenvolvimento.setIcon(FuncoesExtras.buscarIcone("img/nuclear.png"));
		Menu.barraMenu.add(menuDesenvolvimento);
	}

}

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.com.fpimentel.Menu;
import br.com.fpimentel.util.Arquivos;

public class MenuDesenvolvedor {
	
	public MenuDesenvolvedor(){
		/*----------------------------------*
		 *  	Menu de Desenvolvimento
		 *----------------------------------*/
		JMenu menuDesenvolvimento = new JMenu("Funções BETA");
		menuDesenvolvimento.setIcon(Arquivos.buscarIcone("img/nuclear.png"));
		Menu.barraMenu.add(menuDesenvolvimento);
			
			// Sub-menu 1
			JMenuItem opcaoDEV1 = new JMenuItem("Renomear Boletos");
			opcaoDEV1.setIcon(Arquivos.buscarIcone("img/page_white_stack.png"));
			menuDesenvolvimento.add(opcaoDEV1);
			opcaoDEV1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Menu.cobranca.RenomearBoletos();
				}
			});
	}

}

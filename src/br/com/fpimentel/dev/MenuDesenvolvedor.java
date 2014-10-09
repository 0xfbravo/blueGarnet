package br.com.fpimentel.dev;

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

package br.com.blueGarnet.graphics;
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

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.JDesktopPane;

import br.com.blueGarnet.enums.Modulo;
import br.com.blueGarnet.users.NivelPermissao;

@SuppressWarnings("serial")
public class Menu extends JDesktopPane{
	List<Modulo> listaModulos = Arrays.asList(Modulo.values());
	
	public Menu(int nivelPermissao){
		setLayout(new GridLayout(0,1));
		setBackground(new Color(44, 62, 80));
		
		add(Box.createVerticalGlue());
		
		if(nivelPermissao == NivelPermissao.Dev.getNumPermissao()){
			listaModulos.forEach((Modulo m) -> {
					add(new BotaoMenu(m.getIdModulo(),m.getNomeModulo(), m.getIcone()));
			});
		}
		if(nivelPermissao == NivelPermissao.Adm.getNumPermissao()){
			listaModulos.forEach((Modulo m) -> {
				if(m.getPermissao() <= NivelPermissao.Adm.getNumPermissao())
					add(new BotaoMenu(m.getIdModulo(),m.getNomeModulo(), m.getIcone()));
			});
		}
		if(nivelPermissao != NivelPermissao.Adm.getNumPermissao() && nivelPermissao != NivelPermissao.Dev.getNumPermissao()){
			listaModulos.forEach((Modulo m) -> {
				if(m.getPermissao() == nivelPermissao){ add(new BotaoMenu(m.getIdModulo(),m.getNomeModulo(), m.getIcone())); }
			});
		}
		
		add(Box.createVerticalGlue());
	}
}

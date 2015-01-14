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
import javax.swing.JDesktopPane;

import br.com.blueGarnet.enums.Modulo;

@SuppressWarnings("serial")
public class Menu extends JDesktopPane{
	
	public Menu(int nivelPermissao){
		setLayout(new GridLayout(0,1));
		setBackground(new Color(44, 62, 80));
		
		List<Modulo> listaModulos = Arrays.asList(Modulo.values());
		listaModulos.forEach(
				(Modulo m) -> {
					if(m.getPermissao() <= nivelPermissao)
						add(new BotaoMenu(m.getPermissao(),m.getNomeModulo(), m.getIcone()));
				});
	}
}

package br.com.fpimentel.util;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/
import javax.swing.ImageIcon;

import br.com.fpimentel.Menu;

public class Arquivos {
	
	public static ImageIcon buscarIcone(String caminho){
		ImageIcon a = new ImageIcon(Menu.class.getClassLoader().getResource(caminho));
		return a;
	}
}

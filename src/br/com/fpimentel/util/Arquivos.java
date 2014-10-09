package br.com.fpimentel.util;

import javax.swing.ImageIcon;

import br.com.fpimentel.Menu;

public class Arquivos {
	
	public static ImageIcon buscarIcone(String caminho){
		ImageIcon a = new ImageIcon(Menu.class.getClassLoader().getResource(caminho));
		return a;
	}
}

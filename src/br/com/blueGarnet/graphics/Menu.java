package br.com.blueGarnet.graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.JDesktopPane;

import br.com.blueGarnet.enums.Modulo;

@SuppressWarnings("serial")
public class Menu extends JDesktopPane{
	
	public Menu(){
		setLayout(new GridLayout(0,1));
		setBackground(new Color(44, 62, 80));
		add(Box.createVerticalGlue());
		
		List<Modulo> listaModulos = Arrays.asList(Modulo.values());
		listaModulos.forEach((Modulo m) -> add(new BotaoMenu(m.getPermissao(),m.getNomeModulo(), m.getIcone())));
		add(Box.createVerticalGlue());
	}
}

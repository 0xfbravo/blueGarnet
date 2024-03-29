package br.com.blueGarnet.graphics;
/*
 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

							  Fellipe Pimentel � 2014
										 www.fcode.co
*/

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import br.com.blueGarnet.system.Config;

@SuppressWarnings("serial")
public class NovidadesVersao extends JDesktopPane{
	Font f = new Font("Arial",Font.PLAIN,22);
	
	public NovidadesVersao(){
		setBackground(new Color(236, 240, 241));
		JLabel titulo = new JLabel("<html> Novidades da Vers�o <b style='color:#c0392b;'>"+Config.versaoPrograma+"</b></html>");
		titulo.setBounds(40,30,300,20);
		titulo.setFont(f);
		titulo.setForeground(new Color(127, 140, 141));
		add(titulo);
		
		JLabel descricao = new JLabel();
		descricao.setBounds(40,10,600,200);
		descricao.setFont(f.deriveFont(12f));
		descricao.setForeground(new Color(127, 140, 141));
		add(descricao);
		descricao.setText(""
				+ "<html>"
				+ "� Otimiza��es com Java 8<br><br><br>"
				+ ""
				+ "<i>Por: Fellipe Pimentel em 21/01/2015</i>");
	}
}

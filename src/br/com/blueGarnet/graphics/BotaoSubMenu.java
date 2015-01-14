package br.com.blueGarnet.graphics;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.blueGarnet.others.FuncoesExtras;


public class BotaoSubMenu extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotaoSubMenu(String nome,String caminhoImagem, Color cor){
	    setForeground(Color.WHITE);
	    setText(nome);
		setToolTipText(nome);
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.BOTTOM);
		setIcon(FuncoesExtras.buscarIcone(caminhoImagem));
		setBorder(new EmptyBorder(15,15,15,15));
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setBackground(cor);
		setHorizontalAlignment(SwingConstants.LEFT);
		addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(70,85,94));
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(cor);
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}
}

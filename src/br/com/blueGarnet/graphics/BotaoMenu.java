package br.com.blueGarnet.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import br.com.blueGarnet.others.FuncoesExtras;


public class BotaoMenu extends JButton{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean menuAberto;
    
	public BotaoMenu(String nome,String caminhoImagem){
	    setText("<html><b>"+nome.toUpperCase()+"</b></html>");
	    setFont(new Font("Tahoma", Font.PLAIN, 9));
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.BOTTOM);
		setForeground(new Color(236, 240, 241));
		setIcon(FuncoesExtras.buscarIcone(caminhoImagem));
		setPreferredSize(new Dimension(150,0));
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setBackground(new Color(44, 62, 80));
		setBorder(new EmptyBorder(10,10,10,10));
		addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setBackground(new Color(78,105,121));
				//setMenuAberto(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
					if(menuAberto){
						setBackground(new Color(78,105,121));
					} else {
						setBackground(new Color(52, 73, 94));
					}
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if(menuAberto){
					setBackground(new Color(78,105,121));
				} else {
					setBackground(new Color(44, 62, 80));
				}
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}

	public boolean isMenuAberto() {
		return menuAberto;
	}

	public void setMenuAberto(boolean menuAberto) {
		this.menuAberto = menuAberto;
	}
}

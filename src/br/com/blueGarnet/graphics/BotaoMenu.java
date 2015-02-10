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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import br.com.blueGarnet.enums.SubModulo;
import br.com.blueGarnet.others.FuncoesExtras;

public class BotaoMenu extends JButton{

	private static final long serialVersionUID = 1L;
	private boolean menuAberto;
	private int idModulo;
	private JFrame jf;
    
	public BotaoMenu(int idModulo,String nome,String caminhoImagem){
		this.setIdModulo(idModulo);
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
		addActionListener( event -> {
				JanelaPrincipal.subModulos.removeAll();
				List<SubModulo> lstSubModulo = Arrays.asList(SubModulo.values());
					lstSubModulo.forEach((SubModulo s) -> {
						if(s.getJ() != null && getIdModulo() == s.getPermissao()){
							JanelaPrincipal.subModulos.addTab(s.getNomeSubModulo(),s.getIcone(),s.getJ());
						}
						else if(s.getJsp() != null && getIdModulo() == s.getPermissao()){
							JanelaPrincipal.subModulos.addTab(s.getNomeSubModulo(),s.getIcone(),s.getJsp());
						}		
					}
				);
		});
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

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}
}

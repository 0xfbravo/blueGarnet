package br.com.blueGarnet.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.border.EmptyBorder;

import br.com.blueGarnet.enums.SubModulo;
import br.com.blueGarnet.others.FuncoesExtras;


public class BotaoMenu extends JButton{

	private static final long serialVersionUID = 1L;
	private boolean menuAberto;
	private int permissao;
	private ArrayList<SubModulo> subModulos = new ArrayList<SubModulo>();
    
	public BotaoMenu(int permissao,String nome,String caminhoImagem){
		this.setPermissao(permissao);
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
		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JanelaPrincipal.subModulos.removeAll();
				List<SubModulo> lstSubModulo = Arrays.asList(SubModulo.values());
				lstSubModulo.forEach((SubModulo s) -> {
						if(s.getPermissao() == getPermissao() && s.getJ() != null){
							JanelaPrincipal.subModulos.addTab(s.getNomeSubModulo(),s.getIcone(),s.getJ());
						}
						else if(s.getPermissao() == getPermissao() && s.getJsp() != null){
							JanelaPrincipal.subModulos.addTab(s.getNomeSubModulo(),s.getIcone(),s.getJsp());
						}		
					}
				);
			}
			
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

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	public ArrayList<SubModulo> getSubModulos() {
		return subModulos;
	}

	public void setSubModulos(ArrayList<SubModulo> subModulos) {
		this.subModulos = subModulos;
	}
}

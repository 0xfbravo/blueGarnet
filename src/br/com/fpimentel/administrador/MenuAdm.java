package br.com.fpimentel.administrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import br.com.fpimentel.graf.BotaoSubMenu;
import br.com.fpimentel.graf.JanelaPrincipal;

public class MenuAdm {

	public MenuAdm(JFrame Janela, JButton item){
		item.setBackground(new Color(123,148,151));
		JanelaPrincipal.PainelInterno.removeAll();
		JanelaPrincipal.PainelInterno.repaint();
		JDesktopPane jdp = new JDesktopPane();
		jdp.setBackground(JanelaPrincipal.PainelInterno.getBackground());
		jdp.setBackground(new Color(0,0,0,40));
		jdp.add(Box.createHorizontalGlue());
		jdp.setPreferredSize(new Dimension(0,60));
		jdp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0,0,0,90)));
		jdp.setLayout(new BoxLayout(jdp, BoxLayout.X_AXIS));
			BotaoSubMenu adicionarUsuario = new BotaoSubMenu("Adicionar Usuário","img/user.png",Color.DARK_GRAY);
				adicionarUsuario.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						JanelaPrincipal.PainelInterno.removeAll();
						Administracao.CriarUsuario();
					}
				});
			jdp.add(adicionarUsuario);
			// ---
			BotaoSubMenu item2 = new BotaoSubMenu("Editar Usuário","img/page_white_wrench.png",Color.DARK_GRAY);
			item2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaPrincipal.PainelInterno.removeAll();
					Administracao.EditarUsuario();
				}
			});
			jdp.add(item2);
			// ---
			BotaoSubMenu item3 = new BotaoSubMenu("Listagens","img/book.png",Color.DARK_GRAY);
			item3.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					jdp.removeAll();
					jdp.add(Box.createHorizontalGlue());
					BotaoSubMenu titulo = new BotaoSubMenu("Menu Listagens","img/book.png",new Color(28,57,85));
					titulo.setEnabled(false);
					jdp.add(titulo);
					BotaoSubMenu item = new BotaoSubMenu("Voltar","img/arrow_undo.png",Color.DARK_GRAY);
					item.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							JanelaPrincipal.PainelInterno.removeAll();
							JanelaPrincipal.PainelInterno.repaint();
							jdp.repaint();
							Janela.invalidate();
							Janela.validate();
						}
					});
					jdp.add(item);
					jdp.add(Box.createHorizontalGlue());
					jdp.repaint();
					Janela.invalidate();
					Janela.validate();
				}

				@Override
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}
			});
			jdp.add(item3);
			// ---
			BotaoSubMenu item4 = new BotaoSubMenu("Gerar Importação Alterdata","img/bricks.png",Color.DARK_GRAY);
			item4.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaPrincipal.PainelInterno.removeAll();
					Administracao.GerarImportacaoAlterdata();
				}
			});
			jdp.add(item4);
			// ---
			BotaoSubMenu item5 = new BotaoSubMenu("Alteração de E-mails - Clientes","img/envelope.png",Color.DARK_GRAY);
			item5.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaPrincipal.PainelInterno.removeAll();
					Administracao.AlteracaoDeEmail();
				}
			});
			jdp.add(item5);
			// ---
			
			BotaoSubMenu item6 = new BotaoSubMenu("Cadastros Diversos","img/add.png",Color.DARK_GRAY);
			item6.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					jdp.removeAll();
					jdp.add(Box.createHorizontalGlue());
					BotaoSubMenu titulo = new BotaoSubMenu("Menu Cadastros Diversos","img/add.png",Color.DARK_GRAY);
					titulo.setEnabled(false);
					titulo.setBackground(new Color(123,148,151));
					jdp.add(titulo);
					BotaoSubMenu item = new BotaoSubMenu("Voltar","img/arrow_undo.png",Color.DARK_GRAY);
					item.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							JanelaPrincipal.PainelInterno.removeAll();
							JanelaPrincipal.PainelInterno.repaint();
							jdp.repaint();
							Janela.invalidate();
							Janela.validate();
						}
					});
					jdp.add(item);
					jdp.add(Box.createHorizontalGlue());
					jdp.repaint();
					Janela.invalidate();
					Janela.validate();
				}

				@Override
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {}
			});
			jdp.add(item6);
			
		jdp.add(Box.createHorizontalGlue());
		JanelaPrincipal.PainelInterno.add(jdp,BorderLayout.NORTH);
		Janela.invalidate();
		Janela.validate();
	}
}

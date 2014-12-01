package br.com.fpimentel.financeiro;

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
import javax.swing.border.Border;

import br.com.fpimentel.administrador.Administracao;
import br.com.fpimentel.graf.BotaoSubMenu;
import br.com.fpimentel.graf.JanelaPrincipal;

/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/
public class Orcamento {
	
	public Orcamento(JFrame Janela, JButton item2){
		item2.setBackground(new Color(123,148,151));
		JanelaPrincipal.PainelInterno.removeAll();
		JanelaPrincipal.PainelInterno.repaint();
		JDesktopPane jdp = new JDesktopPane();
		jdp.setBackground(new Color(0,0,0,40));
		jdp.add(Box.createHorizontalGlue());
		jdp.setPreferredSize(new Dimension(0,60));
		jdp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0,0,0,90)));
		jdp.setLayout(new BoxLayout(jdp, BoxLayout.X_AXIS));
		//Gerar Orçamento
			BotaoSubMenu gerarOrc = new BotaoSubMenu("Gerar Orçamento","img/cross_shield.png",Color.DARK_GRAY);
				gerarOrc.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						JanelaPrincipal.PainelInterno.removeAll();
						Administracao.CriarUsuario();
					}
				});
			jdp.add(gerarOrc);
		//Importar Dados CP & CR
			BotaoSubMenu impCPCR = new BotaoSubMenu("Importar Dados CP & CR","img/cross_shield.png",Color.DARK_GRAY);
			impCPCR.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaPrincipal.PainelInterno.removeAll();
					Administracao.EditarUsuario();
				}
			});
			jdp.add(impCPCR);
		//Atualizações
			BotaoSubMenu atualizacoes = new BotaoSubMenu("Atualizações","img/cross_shield.png",Color.DARK_GRAY);
			atualizacoes.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					jdp.removeAll();
					jdp.add(Box.createHorizontalGlue());
					BotaoSubMenu titulo = new BotaoSubMenu("Menu Atualizações","img/cross_shield.png",new Color(28,57,85));
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
			jdp.add(atualizacoes);
			// Eventos
			BotaoSubMenu eventos = new BotaoSubMenu("Eventos","img/cross_shield.png",Color.DARK_GRAY);
			eventos.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaPrincipal.PainelInterno.removeAll();
					Administracao.GerarImportacaoAlterdata();
				}
			});
			jdp.add(eventos);
			// Eventos
			BotaoSubMenu relatorios = new BotaoSubMenu("Relatórios","img/cross_shield.png",Color.DARK_GRAY);
			relatorios.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaPrincipal.PainelInterno.removeAll();
					Administracao.GerarImportacaoAlterdata();
				}
			});
			jdp.add(relatorios);
		
		jdp.add(Box.createHorizontalGlue());
		JanelaPrincipal.PainelInterno.add(jdp,BorderLayout.NORTH);
		Janela.invalidate();
		Janela.validate();
	}

}

package br.com.blueGarnet.graphics;

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
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import br.com.fpimentel.administrador.Administracao;

public class MenuContasReceber {

	public MenuContasReceber(JFrame Janela, JButton item){
		item.setBackground(new Color(123,148,151));
		JanelaPrincipal.PainelInterno.removeAll();
		JanelaPrincipal.PainelInterno.repaint();
		JDesktopPane jdp = new JDesktopPane();
		jdp.setBackground(JanelaPrincipal.PainelInterno.getBackground());
		jdp.setBackground(Color.DARK_GRAY);
		jdp.add(Box.createHorizontalGlue());
		jdp.setPreferredSize(new Dimension(0,60));
		jdp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0,0,0,90)));
		jdp.setLayout(new BoxLayout(jdp, BoxLayout.X_AXIS));
			BotaoSubMenu cobrancas = new BotaoSubMenu("Cobranças","img/cross_shield.png",Color.DARK_GRAY);
			cobrancas.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					jdp.removeAll();
					JLabel titulo = new JLabel("Menu Cobranças");
					titulo.setForeground(Color.WHITE);
					titulo.setBorder(new EmptyBorder(10,10,10,10));
					jdp.add(titulo);
					jdp.add(Box.createHorizontalGlue());
					
					// ---
					// TODO: Fazer sub-menu de Gerar Cobrança
					BotaoSubMenu gerarCobranca = new BotaoSubMenu("Gerar Cobrança","img/cross_shield.png",Color.DARK_GRAY);
					gerarCobranca.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							JanelaPrincipal.PainelInterno.removeAll();
						}
					});
					jdp.add(gerarCobranca);
					// ---
					// TODO: Fazer sub-menu de Lançamentos & Baixas
					BotaoSubMenu lancamentosBaixas = new BotaoSubMenu("Lançamentos & Baixas","img/cross_shield.png",Color.DARK_GRAY);
					lancamentosBaixas.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							JanelaPrincipal.PainelInterno.removeAll();
						}
					});
					jdp.add(lancamentosBaixas);
					// ---
					// TODO: Fazer sub-menu de Relatório
					BotaoSubMenu relatorios = new BotaoSubMenu("Relatórios","img/cross_shield.png",Color.DARK_GRAY);
					relatorios.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							JanelaPrincipal.PainelInterno.removeAll();
						}
					});
					jdp.add(relatorios);
					// ---
					jdp.add(Box.createHorizontalGlue());
					BotaoSubMenu voltar = new BotaoSubMenu("Voltar","img/arrow_undo.png",Color.DARK_GRAY);
					voltar.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							JanelaPrincipal.PainelInterno.removeAll();
							JanelaPrincipal.PainelInterno.repaint();
							jdp.repaint();
							Janela.invalidate();
							Janela.validate();
						}
					});
					jdp.add(voltar);
					
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
			jdp.add(cobrancas);
			
		jdp.add(Box.createHorizontalGlue());
		JanelaPrincipal.PainelInterno.add(jdp,BorderLayout.NORTH);
		Janela.invalidate();
		Janela.validate();
	}
}

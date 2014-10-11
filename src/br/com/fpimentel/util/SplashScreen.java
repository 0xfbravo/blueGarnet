package br.com.fpimentel.util;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JWindow;

import br.com.fpimentel.Janela;
import br.com.fpimentel.enums.TipoInfoSplash;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

public class SplashScreen {
	JWindow splashScreen = new JWindow();
	JDesktopPane painel = new JDesktopPane();
	
	public void mensagemSplash(String mensagem, TipoInfoSplash tipoMensagem){
		JLabel lblInformacoes = new JLabel(mensagem);
		lblInformacoes.setHorizontalAlignment(SwingConstants.LEFT);
		painel.add(lblInformacoes);
		lblInformacoes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInformacoes.setBounds(28, 346, 342, 25);
		if(tipoMensagem == TipoInfoSplash.acessoDB){
			lblInformacoes.setIcon(Arquivos.buscarIcone("img/database.png"));
		}
		else if(tipoMensagem == TipoInfoSplash.sucesso){
			lblInformacoes.setIcon(Arquivos.buscarIcone("img/database.png"));
		}
		splashScreen.repaint();
	}
	
	public SplashScreen(String mensagem, TipoInfoSplash tipoMensagem){
		mensagemSplash(mensagem, tipoMensagem);
		Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(
				Toolkit.getDefaultToolkit().createImage(""),new Point(splashScreen.getX(), splashScreen.getY()), "Cursor");
		splashScreen.setCursor(c);
		splashScreen.setSize(404, 419);
		splashScreen.setLocationRelativeTo(null);
		splashScreen.setBackground(new Color(0, 0, 0, 0));
		
		painel.setBackground(new Color(0, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel(Janela.versaoPrograma);
		painel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(149, 56, 85, 25);
		
		JLabel lblImgLoad = new JLabel("");
		lblImgLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgLoad.setIcon(Arquivos.buscarIcone("img/loader.gif"));
		lblImgLoad.setBounds(137, 134, 128, 137);
		painel.add(lblImgLoad);
		
		JLabel splashImg = new JLabel();
		splashImg.setLocation(0, 0);
		splashImg.setHorizontalAlignment(SwingConstants.CENTER);
		splashImg.setIcon(Arquivos.buscarIcone("img/blueGarnet_SPLASH.png"));
		splashImg.setSize(410, 409);
		painel.add(splashImg);
		
		splashScreen.getContentPane().add(painel);
		splashScreen.setOpacity(0.05f);
		splashScreen.setVisible(true);
		for(int i= 1; i <= 50; i++){
			try {
				splashScreen.setOpacity(0.02f * i);
				Thread.sleep(70);
				splashScreen.repaint();
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1600);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
			splashScreen.setVisible(false);
	}
}

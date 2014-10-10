package br.com.fpimentel.util;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JWindow;

import br.com.fpimentel.Janela;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class SplashScreen {
	
	public SplashScreen(){
		JWindow splashScreen = new JWindow();
		splashScreen.setSize(426, 448);
		splashScreen.setLocationRelativeTo(null);
		splashScreen.setBackground(new Color(0, 0, 0, 0));
		
		JDesktopPane painel = new JDesktopPane();
		painel.setBackground(new Color(0, 0, 0, 0));
		
		JLabel splashImg = new JLabel();
		splashImg.setLocation(0, 0);
		splashImg.setHorizontalAlignment(SwingConstants.CENTER);
		splashImg.setIcon(Arquivos.buscarIcone("img/blueGarnet_SPLASH.png"));
		splashImg.setSize(410, 409);
		painel.add(splashImg);
		
		splashScreen.getContentPane().add(painel);
		
		JLabel lblNewLabel = new JLabel(Janela.versaoPrograma);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(152, 61, 46, 14);
		painel.add(lblNewLabel);
		splashScreen.setOpacity(0);
		splashScreen.setVisible(true);
		for(int i= 1; i <= 100; i++){
			try {
				splashScreen.setOpacity(0.01f * i);
				Thread.sleep(50);
				splashScreen.repaint();
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
			splashScreen.setVisible(false);
	}
}

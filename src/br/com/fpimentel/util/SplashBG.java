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

public class SplashBG implements Runnable{

	public JWindow splJanela = new JWindow();
	JDesktopPane painel = new JDesktopPane();
	JLabel lblInfoIMG = new JLabel();
	JLabel lblInfoMSG = new JLabel();

	public void mudarIconeMensagem(TipoInfoSplash tipoMensagem){
		if(tipoMensagem == TipoInfoSplash.acessoDB){
			lblInfoIMG.setIcon(Arquivos.buscarIcone("img/database.png"));
		}
		else if(tipoMensagem == TipoInfoSplash.sucesso){
			lblInfoIMG.setIcon(Arquivos.buscarIcone("img/world.png"));
		}
	}
	public void mudaMensagem(String mensagem, TipoInfoSplash tipoMensagem){
		lblInfoMSG.setText(mensagem);
		this.mudarIconeMensagem(tipoMensagem);
		splJanela.repaint();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		lblInfoIMG.setHorizontalAlignment(SwingConstants.LEFT);
		painel.add(lblInfoIMG);
		lblInfoIMG.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfoIMG.setBounds(68, 325, 23, 25);
		
		lblInfoMSG.setHorizontalAlignment(SwingConstants.LEFT);
		painel.add(lblInfoMSG);
		lblInfoMSG.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfoMSG.setBounds(115, 325, 329, 25);
		
		Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(
				Toolkit.getDefaultToolkit().createImage(""),new Point(splJanela.getX(), splJanela.getY()), "Cursor");
		splJanela.setCursor(c);
		splJanela.setSize(419, 419);
		splJanela.setLocationRelativeTo(null);
		splJanela.setBackground(new Color(0, 0, 0, 0));
		
		painel.setBackground(new Color(0, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel(Janela.versaoPrograma);
		painel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(159, 67, 85, 25);
		
		JLabel lblImgLoad = new JLabel("");
		lblImgLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgLoad.setIcon(Arquivos.buscarIcone("img/loader.gif"));
		lblImgLoad.setBounds(152, 161, 128, 137);
		painel.add(lblImgLoad);
		
		JLabel splashImg = new JLabel();
		splashImg.setLocation(10, 11);
		splashImg.setHorizontalAlignment(SwingConstants.CENTER);
		splashImg.setIcon(Arquivos.buscarIcone("img/blueGarnet_SPLASH.png"));
		splashImg.setSize(422, 409);
		painel.add(splashImg);
		
		splJanela.getContentPane().add(painel);
		splJanela.setOpacity(0.05f);
		splJanela.setVisible(true);
		
		for(int i= 1; i <= 50; i++){
			try {
				splJanela.setOpacity(0.02f * i);
				Thread.sleep(40);
				splJanela.repaint();
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		}	
	}
}

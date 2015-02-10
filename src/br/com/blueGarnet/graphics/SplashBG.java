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

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JWindow;

import br.com.blueGarnet.enums.TipoInfoSplash;
import br.com.blueGarnet.others.FuncoesExtras;
import br.com.blueGarnet.system.Config;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

public class SplashBG implements Runnable{

	public JWindow splJanela = new JWindow();
	JDesktopPane painel = new JDesktopPane();
	JLabel lblInfoIMG = new JLabel();
	JLabel lblInfoMSG = new JLabel();

	/*
	 * ---------------------------------------------------------------
	 * 			mudarIconeMensagem(TipoInfoSplash tipoMensagem)
	 * ---------------------------------------------------------------
	 *  Verifica a mudança de mensagem e busca o ícone referente a
	 *  mensagem que aparece. 
	 * 
	 *					 @author Fellipe Pimentel
	 * 													www.fcode.co
	 * ---------------------------------------------------------------
	 */
	public void mudarIconeMensagem(TipoInfoSplash tipoMensagem){
		ArrayList<TipoInfoSplash> t = new ArrayList<TipoInfoSplash>();
		t.forEach((TipoInfoSplash tis) -> {
			if(tipoMensagem.equals(tis)) lblInfoIMG.setIcon(FuncoesExtras.buscarIcone(tis.getCaminhoImg()));
		});
	}
	
	/*
	 * ---------------------------------------------------------------
	 * 	 mudarMensagem(String mensagem, TipoInfoSplash tipoMensagem)
	 * ---------------------------------------------------------------
	 *  Muda a mensagem que aparece no SplashScreen informando ao
	 *  usuário o estado atual do processo em questão.
	 * 
	 *					 @author Fellipe Pimentel
	 * 													www.fcode.co
	 * ---------------------------------------------------------------
	 */
	public void mudarMensagem(String mensagem, TipoInfoSplash tipoMensagem){
		lblInfoMSG.setText(mensagem);
		lblInfoMSG.setForeground(Color.WHITE);
		this.mudarIconeMensagem(tipoMensagem);
		splJanela.repaint();
	}
	
	@Override
	public void run() {
		lblInfoIMG.setHorizontalAlignment(SwingConstants.LEFT);
		painel.add(lblInfoIMG);
		lblInfoIMG.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfoIMG.setBounds(30, 113, 23, 25);
		
		lblInfoMSG.setHorizontalAlignment(SwingConstants.LEFT);
		painel.add(lblInfoMSG);
		lblInfoMSG.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfoMSG.setBounds(52, 113, 210, 25);
		
		Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(
				Toolkit.getDefaultToolkit().createImage(""),new Point(splJanela.getX(), splJanela.getY()), "Cursor");
		splJanela.setCursor(c);
		splJanela.setSize(466, 152);
		splJanela.setLocationRelativeTo(null);
		splJanela.setBackground(new Color(0, 0, 0, 0));
		
		painel.setBackground(new Color(0, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel(Config.versaoPrograma);
		lblNewLabel.setForeground(Color.WHITE);
		painel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(418, 17, 49, 25);
		
		JLabel lblImgLoad = new JLabel("");
		lblImgLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgLoad.setIcon(FuncoesExtras.buscarIcone("img/loader.gif"));
		lblImgLoad.setBounds(20, 17, 33, 39);
		painel.add(lblImgLoad);
		
		JLabel splashImg = new JLabel();
		splashImg.setLocation(0, 11);
		splashImg.setHorizontalAlignment(SwingConstants.CENTER);
		splashImg.setIcon(FuncoesExtras.buscarIcone("img/blueGarnet_SPLASH.png"));
		splashImg.setSize(467, 137);
		painel.add(splashImg);
		
		splJanela.getContentPane().add(painel);
		splJanela.setOpacity(0.05f);
		splJanela.setVisible(true);
		
		for(int i= 1; i <= 50; i++){
			try {
				splJanela.setOpacity(0.02f * i);
				Thread.sleep(40);
				splJanela.repaint();
			} catch (InterruptedException e) { e.printStackTrace(); }
		}	
	}
}

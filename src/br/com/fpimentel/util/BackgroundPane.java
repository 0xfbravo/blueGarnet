package br.com.fpimentel.util;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDesktopPane;

@SuppressWarnings("serial")
public class BackgroundPane extends JDesktopPane {  
	 Image img;  
	  
	 public BackgroundPane() {  
	  try {  
	   java.net.URL caminho = BackgroundPane.class.getClassLoader().getResource("img/bg.jpg");  
	   img = javax.imageio.ImageIO.read(caminho);  
	  } catch (Exception e) {}  
	 } 
	  
	 public void paintComponent(Graphics g) {  
	  super.paintComponent(g);  
	  if (img != null)  
	   g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
	  else  
	   g.drawString("Imagem não encontrada", 50, 50);  
	 }  
	}

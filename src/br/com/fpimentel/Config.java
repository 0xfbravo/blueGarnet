package br.com.fpimentel;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import br.com.fpimentel.util.FuncoesExtras;

public class Config {
	
	/*
	 *   Definições do Programa
	 */
	public static String versaoPrograma = "v0.4b";
	public static String nomePrograma = "blueGarnet "+versaoPrograma;
	public static int alturaPrograma = 600, larguraPrograma = 900;
	BufferedImage imagem;
	public static ImageIcon imagemTituloJanela = FuncoesExtras.buscarIcone("img/blueGarnet.png");

}

package br.com.blueGarnet.system;
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

import java.awt.HeadlessException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.blueGarnet.graphics.JanelaLogin;
import br.com.blueGarnet.graphics.JanelaPrincipal;
import br.com.blueGarnet.users.Usuario;

public class blueGarnetInit{
	public static TrayIcon icon = new TrayIcon(Config.imagemTituloJanela.getImage(), Config.nomePrograma, createPopupMenu());
	private static PopupMenu createPopupMenu() throws HeadlessException {
	      PopupMenu menu = new PopupMenu();
	      MenuItem exit = new MenuItem("Sair do blueGarnet");
	      exit.addActionListener( event -> { System.exit(0); } );
	      menu.add(exit);
	      return menu;
	   }

	public static void main(String[] args){
        try {
            SystemTray.getSystemTray().add(icon);
            
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } 
    	    catch (UnsupportedLookAndFeelException e) {}
    	    catch (ClassNotFoundException e) {}
    	    catch (InstantiationException e) {}
    	    catch (IllegalAccessException e) {}

			//new Thread(() -> new JanelaLogin()).start();
            new Usuario("root","senha").acessarSistema();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}

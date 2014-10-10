package br.com.fpimentel;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/
import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;

public class Main extends Janela{

	public static void main(String[] args){
        try {
        	Properties props = new Properties();
        	props.put("logoString", "  ");
        	props.put("textAntiAliasing","on");
        	props.put("menuOpaque","20");
        	props.put("windowTitleFont", "Arial BOLD 11");
        	props.put("menuTextFont", "Arial BOLD 12");
        	props.put("systemTextFont", "Arial 11");
        	props.put("userTextFont", "Arial 11");
        	props.put("textAntiAliasingMode", "default");
        	  
        	  
        	GraphiteLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			new Janela(nomePrograma,330,195);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
	}

}

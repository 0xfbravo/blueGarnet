package br.com.fpimentel;

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
    		@SuppressWarnings("unused")
			br.com.fpimentel.Janela janelaLogin = new br.com.fpimentel.Janela(nomePrograma,330,195,true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
	}

}

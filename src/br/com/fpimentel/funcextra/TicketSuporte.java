package br.com.fpimentel.funcextra;

import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import br.com.blueGarnet.system.blueGarnetInit;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Processor;
import oshi.util.FormatUtil;

// TODO: Finalizar M�DULO Ticket de Suporte
public class TicketSuporte {
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private boolean resolvido;
	private String solucao;
	
	private String dataSolucao;
	private String dataAbertura = formato.format(new Date());
	
 	String nameOS = "os.name";
 	String architectureOS = "os.arch"; 
 	String processador = "Processador N�o Identificado.";
 	String ip = "IP N�o Identificado.";
 	String nomeMaquina = "Nome da M�quina n�o identificado.";
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
	
	
	public TicketSuporte(){
		/*
		 *  Ideia a ser implementada
		 *  
		 *  	- Buscar informa��es da m�quina
		 *  		* Processador
		 *  		* Mem�ria RAM
		 *  		* Sistema Operacional (32/64)
		 *  
		 *  	- Nome da M�quina
		 *  	- IP da M�quina
		 *  	- Descri��o do Problema
		 */	
	    try {
	    	nomeMaquina = "<b>"+InetAddress.getLocalHost().getHostName()+"</b>";
	    	if(InetAddress.getLocalHost().getHostAddress().equals("127.0.0.1") ||
	    			InetAddress.getLocalHost().getHostAddress().equals("localhost"))
	    		ip = "Usu�rio desconectado da Internet!";
	    	else
				ip = "IP: <b>"+InetAddress.getLocalHost().getHostAddress()+"</b>";
		}
	    catch (UnknownHostException e) {e.printStackTrace();}
	    for(Processor cpu : hal.getProcessors()) {
	        processador = "Processador: " + cpu+" || "+hal.getProcessors().length + " N�cleo(s)";
	        break;
	    }
	    
	    
	    blueGarnetInit.icon.displayMessage("Aten��o, novo chamado aberto!", "Novo chamado aberto", 
                TrayIcon.MessageType.WARNING);
	    blueGarnetInit.icon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null,
            		   "<html>"
            		   + ip+"<br>"
            		   + "Nome da M�quina: "+nomeMaquina+"<br>"
            		   + "Sistema Operacional: <b>" + 
            		   System.getProperty(nameOS)+"</b> || "+System.getProperty(architectureOS)+"<br>"
            		   + processador+"<br>"
            		   + "Mem�ria:<br>"
            		   + "<b style='color: green;padding-left:5em;'>" +
            		   FormatUtil.formatBytes(hal.getMemory().getAvailable())
            		   + "{Livre}"
            		   + "</b><br>"
            		   + "<b style='color: red;padding-left:5em;'>" +
            		   FormatUtil.formatBytes(hal.getMemory().getTotal()-hal.getMemory().getAvailable())
            		   + "{Usado}"
            		   + "</b><br>"
            		   + "<b style='color: blue;padding-left:5em;'>" +
            		   FormatUtil.formatBytes(hal.getMemory().getTotal())+"{Total}</b>"
            		   + "<br><br>"
            		   + "N�mero de Protocolo: "+gerarTicket()+"<br>"
            		   + "Chamado Aberto em: <b style='color:red;'>"+dataAbertura+"</b><br>"
            		   + "</html>");
            }
          });
	}
	
	public String gerarTicket(){
		String ticket = "N�mero do Ticket";
			/* Buscar informa��es de �ltimo ticket gerado no DB */
			//ticket = "0123456789ABCDEF";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyddMM");
			String isoDate = sdf.format(new Date());
			Random diceRoller = new Random();
			ticket = "bg"+isoDate+"tk";
			for (int i = 0; i < 6; i++) {
			  int roll = diceRoller.nextInt(6) + 1;
			  ticket = ticket+roll;
			}
		return ticket;
	}
}

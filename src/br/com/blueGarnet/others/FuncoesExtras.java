package br.com.blueGarnet.others;
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

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.blueGarnet.enums.NivelPermissao;

public class FuncoesExtras{
	/*
	 * Método para criação da Tabelas com SQL
	 */	
	public static DefaultTableModel buildTableModel(ResultSet rs,boolean contemPermissao)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        		vector.add(rs.getObject(columnIndex));
	            	if(contemPermissao == true){
	            		// -- DEBUG
	            		//System.out.println("Coluna recebendo:"+rs.getInt("Permissao"));
	            		if(rs.getInt("Permissao") == NivelPermissao.Adm.getNumPermissao()){
	            			vector.add(NivelPermissao.Adm.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Financeiro.getNumPermissao()){
	            			vector.add(NivelPermissao.Financeiro.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Fiscal.getNumPermissao()){
	            			vector.add(NivelPermissao.Fiscal.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Contabil.getNumPermissao()){
	            			vector.add(NivelPermissao.Contabil.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Dev.getNumPermissao()){
	            			vector.add(NivelPermissao.Dev.getNomePermissao());
	            		}
	            	}
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}

	/*
	 * Método para formatação de CNPJ, CPF e etc
	 * 		utilizando Máscaras
	 */
	public static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
	/* Buscar Ícones dentro do Projeto */
	public static ImageIcon buscarIcone(String caminho){
		ImageIcon a = new ImageIcon(FuncoesExtras.class.getClassLoader().getResource(caminho));
		return a;
	}
}

package controleurs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import View.Frm_Menu;
import modeles.ModConnexion;


public class CtrlConnexion {
	static ResultSet jeuEnreg = null;
	
	public static void connexion(JDialog fenetre,String nomUsager, String mdp) 
	 {  
		
	    try {
	       
	  	    ModConnexion.getInstance().connexion(nomUsager,mdp);   	
	       	
	       	//testConnexion();
	       	
	       	fenetre.dispose();
	        Frm_Menu fenetrer = new Frm_Menu();
	        fenetrer.show();
	       	
	       	
	      
	          	} 
	    catch (Exception e) 
	    	{
	    		e.printStackTrace();
	     	JOptionPane.showMessageDialog(null, "Information inexistante", "Désolé", JOptionPane.WARNING_MESSAGE);
	    	}
	    
	  }
	
	
private static void testConnexion() throws SQLException
 { 
	
	//Appel de procédure stockée avec un paramètre en lecture
	
/*	String sql = "{call test(?)}";
	CallableStatement call = ModConnexion.getInstance().getLaConnectionStatique().prepareCall(sql); 
	//passage de la chaîne "ioio" comme valeur du premier paramètre 
	call.setString(1,"ioio"); 
	call.execute();*/
	
/*	
 * 
 *  Exécution d'une requête simple
   */
    String vCode = "";
	String vNom = "";
	
	PreparedStatement prepare = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT * FROM FJEAN.DM_ACH");
  	jeuEnreg = prepare.executeQuery();
	
  	while (jeuEnreg.next())
		{
			vCode = jeuEnreg.getString(1);
			vNom = jeuEnreg.getString(2);
			System.out.println(" " +vCode + "  " + vNom);
		}
	
}

}



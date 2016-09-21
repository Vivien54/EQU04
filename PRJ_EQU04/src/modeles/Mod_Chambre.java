package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Chambre extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private int NoCham;
	private int Etage;
	private double Prix;
	private boolean Etat;
	private String Memo;
	private String CodTypCha;
	private String CodLoc;
	private String Desc_typ;
	private String Desc_Loc;
	private int courant = 0;
	
	private ArrayList<Mod_Chambre> Ls_Chambre = new ArrayList<Mod_Chambre>();
	
	
	public Mod_Chambre()
	{
		super();
	}
	
	public Mod_Chambre(int No_Cham, int etage, double prix, boolean etat, String memo, String codtypcha,String codloc, String desctyp, String descloc)
	{
		super();
		
		this.Set_Nocham(No_Cham);
		this.Set_Etage(etage);
		this.Set_Prix(prix);
		this.Set_Etat(etat);
		this.Set_Memo(memo);
		this.Set_CodTypCham(codtypcha);
		this.Set_CodLoc(codloc);
		this.Set_DescTyp(desctyp);
		this.Set_DescLoc(descloc);
		
	}
	
	
	public void Lire()
	{
		try {    
			
			
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT ");
			
			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
			    int No_Cham = rs.getInt("NoCham");
			    int Etage = rs.getInt("Etage");
			    double Prix = rs.getDouble("Prix");
			    boolean Etat = rs.getBoolean("Etat");
			    String Memo = rs.getString("Memo");
			    String Codtypcha = rs.getString("CodTypCha");
			    String CodLoc = rs.getString("CodLoc");
			    String DescType = rs.getString("DescType");
			    String DescLoc = rs.getString("DescLoc");
			    
				
				Ls_Chambre.add(new Mod_Chambre(No_Cham,Etage,Prix,Etat,Memo,Codtypcha,CodLoc,DescType,DescLoc));  
				}		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans Mod_Chambre.java",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	//Get et Set ------------------------------------------------------------------
	public ArrayList<Mod_Chambre> Get_LsChambre()
	{
		return Ls_Chambre;
	}
	
	public int Get_Nocham()
	{
		return this.NoCham;
	}
	
	public void Set_Nocham(int set)
	{
		this.NoCham = set;
	}
	
	
	public int Get_Etage()
	{
		return this.Etage;
	}
	
	public void Set_Etage(int set)
	{
		this.Etage = set;
	}
	
	
	public double Get_Prix()
	{
		return this.Prix;
	}
	
	public void Set_Prix(double set)
	{
		this.Prix = set;
	}
	
	public boolean Get_Etat()
	{
		return this.Etat;
	}
	
	public void Set_Etat(boolean set)
	{
		this.Etat = set;
	}
	
	
	public String Get_Memo()
	{
		return this.Memo;
	}
	
	public void Set_Memo(String set)
	{
		this.Memo = set;
	}
	
	
	public String Get_CodTypCham()
	{
		return this.CodTypCha;
	}
	
	public void Set_CodTypCham(String set)
	{
		this.CodTypCha = set;
	}
	
	
	
	public String Get_CodLoc()
	{
		return this.CodLoc;
	}
	
	public void Set_CodLoc(String set)
	{
		this.CodLoc = set;
	}
	
	
	public String Get_DescTyp()
	{
		return this.Desc_typ;
	}
	
	public void Set_DescTyp(String set)
	{
		this.Desc_typ = set;
	}
	
	public String Get_DescLoc()
	{
		return this.Desc_Loc;
	}
	
	public void Set_DescLoc(String set)
	{
		this.Desc_Loc = set;
	}
	
	public int Get_courant()
	{
		return this.courant;
	}
	
	public void Set_courant(int set)
	{
		this.courant = set;
	}
//----------------------------------------------------------------------------------------	
	
	
	
	
	
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
package modeles;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Reservation extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//variable client
	private int IdCli;
	private String nom;
	private String adresse;
	private String telephone;
	private String fax;
	private String typ_carte;
	private Date exp;
	private double solde_du;
	//variable reservation
	private int IdReser;
	private Date dateReser;
	private Date dateDebut;
	private Date dateFin;
	
	private int courant=0;
	
	private ArrayList<Mod_Reservation> les_resers = new  ArrayList<Mod_Reservation>();
	public final  String[] lesTitres = {"IdCli", "Nom","adresse","telephone","fax","typ_carte","exp","solde_du", "IdReser", "dateReser","dateDebut", "dateFin"};
	
	public Mod_Reservation()
	{
		Lire_Enre();
	}
	
	public Mod_Reservation(int IdCli, String nom, String adresse, String telephone, String fax, String typ_carte, java.sql.Date exp, double solde_du, int IdReser, java.sql.Date dateReser, java.sql.Date dateDebut, java.sql.Date dateFin)
	{
		SetIdCli(IdCli);
		SetNom(nom);
		SetAdresse(adresse);
		SetTelephone(telephone);
		SetFax(fax);
		SetTypeCarte(typ_carte);
		SetExp(exp);
		SetSolde(solde_du);
		SetIdReser(IdReser);
		SetDateReser(dateReser);
		SetDateDebut(dateDebut);
		SetDateFin(dateFin);
	}
	
	public Mod_Reservation(int Idreser, int Idcli, java.sql.Date date_reser, java.sql.Date date_debut, java.sql.Date date_fin)
	{
		SetIdCli(Idcli);
		SetIdReser(Idreser);
		SetDateReser(date_reser);
		SetDateDebut(date_debut);
		SetDateFin(date_fin);
	}
	
	public void Lire_Enre()
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT *" + 
																											"FROM EQU04PRG01.SELECT_RESERVATION");	
			ResultSet rs = state.executeQuery();
			
			
			while (rs.next()) {
				int idcli = rs.getInt("IdCli");
				String nom = rs.getString("Nom");
				String adresse = rs.getString("Adresse");
				String tel = rs.getString("Telephone");
				String fax = rs.getString("fax");
				String carte = rs.getString("TypeCarte");
				java.sql.Date exp = rs.getDate("DateExp");
				double solde = rs.getDouble("Solde_Du");
				int idreser = rs.getInt("IdReser");
				java.sql.Date datreser = rs.getDate("dateReser");
				java.sql.Date datdebut = rs.getDate("dateDebut");
				java.sql.Date datfin = rs.getDate("dateFin");

				//System.out.println(idcli + " " + nom + " " + adresse + " " + tel +" " + fax + " " + carte +  " " + exp + " " + solde + " " + idreser + " " + datreser + " " + datdebut + " " + datfin);
				
				les_resers.add(new Mod_Reservation(idcli, nom, adresse, tel, fax, carte, exp, solde, idreser, datreser, datdebut, datfin)); 
				//this.setCourant(idreser);
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
	}

	public void SetIdCli(int id)
	{
		this.IdCli = id;
	}
	public int GetIdCli()
	{
		return this.IdCli;
	}
	
	public void SetIdReser(int id)
	{
		this.IdReser = id;
	}
	
	public int GetIdReser()
	{
		return this.IdReser;
	}
	
	public void SetNom(String id)
	{
		this.nom = id;
	}
	public String GetNom()
	{
		return this.nom;
	}
	
	public void SetAdresse(String id)
	{
		this.adresse = id;
	}
	
	public String GetAdresse()
	{
		return this.adresse;
	}
	
	public void SetTelephone(String id)
	{
		this.telephone = id;
	}
	
	public String GetTelephone()
	{
		return this.telephone;
	}
	
	public void SetFax(String id)
	{
		this.fax = id;
	}
	
	public String GetFax()
	{
		return this.fax;
	}

	public void SetTypeCarte(String id)
	{
		this.typ_carte = id;
	}
	public String GetTypeCarte()
	{
		return this.typ_carte;
	}
	public void SetExp(Date id)
	{
		this.exp = id;
	}

	public Date GetExp()
	{
		return this.exp;
	}
	public void SetSolde(double id)
	{
		this.solde_du = id;
	}
	
	public double GetSolde()
	{
		return this.solde_du;
	}
	public void SetDateReser(Date id)
	{
		this.dateReser = id;
	}
	
	public Date GetDateReser()
	{
		return this.dateReser;
	}
	
	public void SetDateDebut(Date id)
	{
		this.dateDebut = id;
	}
	
	public Date GetDateDebut()
	{
		return this.dateDebut;
	}
	
	public void SetDateFin(Date id)
	{
		this.dateFin = id;
	}
	
	public Date GetDateFin()
	{
		return this.dateFin;
	}

	public ArrayList<Mod_Reservation> getLes_resers() {
		return les_resers;
	}

	public void setLes_resers(ArrayList<Mod_Reservation> les_resers) {
		this.les_resers = les_resers;
	}

	public int Get_courant() {
		// TODO Auto-generated method stub
		return courant;
	}

	public void setCourant(int valueAt) {
		// TODO Auto-generated method stub
		this.courant = valueAt;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return les_resers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Mod_Reservation reser = (Mod_Reservation)les_resers.get(rowIndex);
		
		if(columnIndex == 0) return reser.GetIdCli();
		if(columnIndex == 1) return reser.GetNom();
		if(columnIndex == 2) return reser.GetAdresse();
		if(columnIndex == 3) return reser.GetTelephone();
		if(columnIndex == 4) return reser.GetFax();
		if(columnIndex == 5) return reser.GetTypeCarte();
		if(columnIndex == 6) return reser.GetExp();
		if(columnIndex == 7) return reser.GetSolde();
		if(columnIndex == 8) return reser.GetIdReser();
		if(columnIndex == 9) return reser.GetDateReser();
		if(columnIndex == 10) return reser.GetDateDebut();
		if(columnIndex == 11) return reser.GetDateFin();
		
		return null;
	}
	
	public java.sql.Date getDatDuJour() {
	    Calendar calendar = Calendar.getInstance();
	    java.util.Date laDate = calendar.getTime();
	    return new java.sql.Date(laDate.getTime());
	}
	
	public java.sql.Date getDateRequise(){
		 Calendar calendar = Calendar.getInstance();
		 calendar.add(Calendar.DATE, 10);
		 java.util.Date laDate = calendar.getTime();
		 return new java.sql.Date(laDate.getTime());
	}
	
	public void InsertReservation(Mod_Reservation m){
		try {    
			PreparedStatement state = ModConnexion.getInstance()
					.getLaConnectionStatique()
					.prepareStatement("INSERT INTO EQU04PRG01.RESERVATION VALUES ( "+m.IdReser+" , "
					+ m.IdCli + " , "
					+ "TO_DATE('" + m.dateReser + "' , 'YY-MM-DD'), "
					+ "TO_DATE('" + m.dateDebut + "' , 'YY-MM-DD'), "
					+ "TO_DATE('" + m.dateFin + "' , 'YY-MM-DD')"
					+ " )");

			state.executeUpdate();
			 
			state.execute("commit");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur dans ajout de la reservation\n" + e.getMessage(),
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void UpdateReservation(Mod_Reservation m){
		try {    
			PreparedStatement state = ModConnexion.getInstance()
					.getLaConnectionStatique()
					.prepareStatement( "UPDATE EQU04PRG01.RESERVATION SET "
										+ " FKIdCli=" + m.IdCli + ", "
										+ " dateDebut=TO_DATE('" + m.dateDebut + "' , 'YY-MM-DD'), "
										+ " dateFin=TO_DATE('" + m.dateFin + "' , 'YY-MM-DD') "
										+ " WHERE IdReser=" + m.IdReser );
			state.executeUpdate();
			state.execute("commit");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur dans modification de la reservation\n" + e.getMessage(),
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DeleteReservation(int Idreser){
		try {    
			PreparedStatement state = ModConnexion.getInstance()
					.getLaConnectionStatique()
					.prepareStatement("DELETE FROM EQU04PRG01.RESERVATION WHERE IdReser="+Idreser);
			state.executeUpdate();
			state.execute("commit");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur dans suppression de la reservation\n" + e.getMessage(),
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public boolean IsClient(int reser, int cli){
		boolean flag = true;
		try {
			PreparedStatement state = ModConnexion.
					getInstance().
					getLaConnectionStatique().
					prepareStatement("select * from EQU04PRG01.Trx where FKIdCli=" + cli + " and FKIdReser="+reser);
			
			ResultSet rs = state.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
			     flag=false;
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java isClient " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
		return flag;
	}
	
	public boolean IsArrive(int reser){
		boolean flag = true;
		try {
			PreparedStatement state = ModConnexion.
					getInstance().
					getLaConnectionStatique().
					prepareStatement("select * from EQU04PRG01.ARRIVE where FKIdReser="+reser);
			
			ResultSet rs = state.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
			     flag=false;
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java isArrive " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
		return flag;
	}
	
	public boolean IsDepart(int reser){
		boolean flag = true;
		try {
			PreparedStatement state = ModConnexion.
					getInstance().
					getLaConnectionStatique().
					prepareStatement("select * from EQU04PRG01.Depart where FKIdReser="+reser);
			
			ResultSet rs = state.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
			     flag=false;
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java isDepart " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
		return flag;
	}
	
	public boolean IsArriveInDe(int reser, String cha){
		boolean flag = true;
		try {
			PreparedStatement state = ModConnexion.
					getInstance().
					getLaConnectionStatique().
					prepareStatement("select * from EQU04PRG01.Arrive where FKIdReser="+reser+" and FKNoCham="+cha);
			
			ResultSet rs = state.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
			     flag=false;
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java isDepart " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
		return flag;
	}
	
	public long NextValSeqReservation(){
		long val=0;
		try {
			PreparedStatement state = ModConnexion.
					getInstance().
					getLaConnectionStatique().
					prepareStatement("select EQU04PRG01.SEQ_Reservation.nextval from dual");
			
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				val = rs.getLong(1);
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java CurrValSeqReservation "
									+ e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
		return val;
	}
	
	public int CountIdReserForArrive(int id){
		int count=0;
		
		try {
			PreparedStatement state = ModConnexion.
					getInstance().
					getLaConnectionStatique().
					prepareStatement("select count(*) from EQU04PRG01.ARRIVE where FKIdReser="+id+" group by FKIdReser");
			
			ResultSet rs = state.executeQuery();
			if (rs.isBeforeFirst() ) {
				while(rs.next()){
					count = rs.getInt(1);
				}
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java CountIdReserForArrive "
									+ e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
		
		return count;
	}
	
	public int CountIdReserForDepart(int id){
		int count=0;
		
		try {
			PreparedStatement state = ModConnexion.
					getInstance().
					getLaConnectionStatique().
					prepareStatement("select count(*) from EQU04PRG01.DEPART where FKIdReser="+id+" group by FKIdReser");
			
			ResultSet rs = state.executeQuery();
			if (rs.isBeforeFirst() ) {
				while(rs.next()){
					count = rs.getInt(1);
				}
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java CountIdReserForDepart "
									+ e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			//System.out.println(e);
		}
		
		return count;
	}
}

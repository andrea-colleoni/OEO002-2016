package it.overnet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudenteDao {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.18.103;database=OEO002", "sa", "password");
		Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.18.103/OEO002", "sa", "password");
		return conn;
	}
	
	private Studente map(ResultSet rs) throws SQLException {
		Studente s = new Studente();
		s.setId(rs.getInt("id"));
		s.setNome(rs.getString("nome"));
		s.setCognome(rs.getString("cognome"));
		s.setDataNascita(rs.getDate("dataNascita"));
		s.setAltezzaInCm(rs.getInt("altezzaInCm"));
		s.setPesoInKg(rs.getFloat("pesoInKg"));
		s.setMatricola(rs.getInt("matricola"));
		return s;
	}
	private void setFields(PreparedStatement st, Studente s) throws SQLException {
		st.setString(1, s.getNome());
		st.setString(2, s.getCognome());
		st.setDate(3, new java.sql.Date(s.getDataNascita().getTime()));
		st.setInt(4, s.getAltezzaInCm());
		st.setFloat(5, s.getPesoInKg());
		st.setInt(6, s.getMatricola());		
	}
	public List<Studente> tutti() {
		try {
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Studente");
			List<Studente> studenti = new ArrayList<>();
			while(rs.next()) {
				studenti.add(map(rs));
			}
			return studenti;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	public Studente perChiave(int id) {
		try {
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Studente WHERE id = " + id);
			if(rs.next()) {
				return map(rs);
			}
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;			
	}
	
	public void salvaStudente(Studente s) {
		try {
			String sql = "INSERT INTO [Studente]"
					+ "([nome]"
					+ ",[cognome]"
					+ ",[dataNascita]"
					+ ",[altezzaInCm]"
					+ ",[pesoInKg]"
					+ ",[matricola])"
					+ "VALUES"
					+ "(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = getConnection().prepareStatement(sql);
			setFields(st, s);
			st.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void aggiornaStudente(Studente s) {
		String sql = "USE UPDATE [Studente] "
				+ " SET [nome] = ?"
				+ ",[cognome] = ?"
				+ ",[dataNascita] = ?"
				+ ",[altezzaInCm] = ?"
				+ "[pesoInKg] = ?"
				+ ",[matricola] = ?"
				+ " WHERE id = ?";
		try {
			PreparedStatement st = getConnection().prepareStatement(sql);
			setFields(st, s);
			st.setInt(7, s.getId());
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminaStudente(Studente s) {
		try {
			PreparedStatement st = getConnection().prepareStatement("DELETE FROM STudente WHERE id = ?");
			st.setInt(1, s.getId());
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

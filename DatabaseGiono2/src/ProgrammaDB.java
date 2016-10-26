import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.18.103;database=OEO002", "sa", "password");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Studente");
			List<Studente> studenti = new ArrayList<>();
			while(rs.next()) {
				Studente s = new Studente();
				s.setId(rs.getInt("id"));
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				s.setDataNascita(rs.getDate("dataNascita"));
				s.setAletzzaInCm(rs.getInt("altezzaInCm"));
				s.setPesoInKg(rs.getFloat("pesoInKg"));
				s.setMatricola(rs.getInt("matricola"));
				
				studenti.add(s);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

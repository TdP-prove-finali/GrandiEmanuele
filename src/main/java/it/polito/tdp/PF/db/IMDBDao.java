package it.polito.tdp.PF.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.PF.model.Titolo;



public class IMDBDao {

	

	public List<String> listAllGenres(){
		String sql = "SELECT DISTINCT last_genre FROM(SELECT DISTINCT "
				+ "  SUBSTRING_INDEX(GENERE,', ', 1) AS first_genre, "
				+ "  SUBSTRING_INDEX(SUBSTRING_INDEX(GENERE, ', ', 2),', ', -1) AS middle_genre, "
				+ "  SUBSTRING_INDEX(GENERE,', ', -1) AS last_genre "
				+ "  FROM imdb_copy) AS t2";
		List<String> result = new ArrayList<String>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				String s = res.getString("last_genre");
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliNetflixGenAnno(String tipo, String genere,int anno, int durata,int anno2){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, netflix_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%') && i.ANNO>=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			st.setInt(3,anno );
			st.setInt(4,anno2 );
			st.setInt(5, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Titolo> listTitoliNetflixGen(String tipo, String genere, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, netflix_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%') && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			
			st.setInt(3, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliNetflixAnno(String tipo, int anno, int durata,int anno2){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, netflix_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.ANNO>=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			
			st.setInt(2,anno );
			st.setInt(3,anno2 );
			st.setInt(4, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliAmazonGenAnno(String tipo, String genere,int anno, int durata,int anno2){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, amazon_prime_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%') && i.ANNO>=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			st.setInt(3,anno );
			st.setInt(4,anno2 );
			st.setInt(5, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Titolo> listTitoliAmazonGen(String tipo, String genere, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, amazon_prime_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%') && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			
			st.setInt(3, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliAmazonAnno(String tipo, int anno, int durata,int anno2){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, amazon_prime_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.ANNO>=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setInt(2, anno);
			st.setInt(3, anno2);
			st.setInt(4, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Titolo> listTitoliDisneyGenAnno(String tipo, String genere,int anno, int durata,int anno2){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, disney_plus_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%')&& i.ANNO>=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			st.setInt(3,anno );
			st.setInt(4, anno2);
			st.setInt(5, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliDisneyGen(String tipo, String genere, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, disney_plus_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%')&& i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			
			st.setInt(3, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Titolo> listTitoliDisneyAnno(String tipo, int anno, int durata,int anno2){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description,n.Piattaforma "
				+ "FROM imdb_copy i, disney_plus_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.ANNO>=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setInt(2, anno);
			st.setInt(3, anno2);
			st.setInt(4, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"),res.getString("n.Piattaforma"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo>getVertici(String genere,double nud,double viol,double alc,double fri,double vot,int anno1,int anno2){
	
	String sql="SELECT d.Nome,d.Anno,d.Voto,d.Durata,d.Genere,d.Nud,d.Viol,d.Alc,d.Fri,d.Descr,d.Piattaf "
			+ "FROM data_tot d "
			+ "WHERE d.Nud<=? && d.Viol<=?&& d.Alc<=? && d.Fri<=? && d.Genere LIKE CONCAT('%',?,'%') && d.Voto>=? && d.Anno>=? && d.Anno<=?";
	
	List<Titolo> result = new ArrayList<Titolo>();
	Connection conn = DBConnect.getConnection();

	try {
		PreparedStatement st = conn.prepareStatement(sql);
		st.setDouble(1, nud);
		st.setDouble(2, viol);
		
		st.setDouble(3, alc);
		st.setDouble(4, fri);
		st.setString(5, genere);
		st.setDouble(6, vot);
		st.setInt(7, anno1);
		st.setInt(8, anno2);
		ResultSet res = st.executeQuery();
		while (res.next()) {

			Titolo s = new Titolo(res.getString("d.Nome"),res.getInt("d.Anno"),res.getDouble("d.Voto"),res.getInt("d.Durata"),res.getString("d.Genere"),res.getInt("d.Nud"),res.getInt("d.Viol"),res.getInt("d.Alc"),res.getInt("d.Fri"),res.getString("d.Descr"),res.getString("d.Piattaf"));
			result.add(s);
		}
		conn.close();
		return result;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}

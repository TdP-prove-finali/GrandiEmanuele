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
	
	public List<Titolo> listTitoliNetflixGenAnno(String tipo, String genere,int anno, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
				+ "FROM imdb_copy i, netflix_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%') && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			st.setInt(3,anno );
			st.setInt(4, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
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
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
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

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliNetflixAnno(String tipo, int anno, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
				+ "FROM imdb_copy i, netflix_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			
			st.setInt(2,anno );
			st.setInt(3, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliAmazonGenAnno(String tipo, String genere,int anno, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
				+ "FROM imdb_copy i, amazon_prime_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%') && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			st.setInt(3,anno );
			st.setInt(4, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
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
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
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

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Titolo> listTitoliAmazonAnno(String tipo, int anno, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
				+ "FROM imdb_copy i, amazon_prime_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setInt(2, anno);
			
			st.setInt(3, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Titolo> listTitoliDisneyGenAnno(String tipo, String genere,int anno, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
				+ "FROM imdb_copy i, disney_plus_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.GENERE LIKE CONCAT('%',?,'%')&& i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setString(2, genere);
			st.setInt(3,anno );
			st.setInt(4, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
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
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
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

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
				result.add(s);
			}
			conn.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Titolo> listTitoliDisneyAnno(String tipo, int anno, int durata){
		String sql = "SELECT i.NOME, i.ANNO, i.VOTO, i.DURATA, i.GENERE, i.NUD, i.VIOL, i.ALC, i.FRI, n.description "
				+ "FROM imdb_copy i, disney_plus_titles n "
				+ "WHERE i.NOME=n.title && i.TIPO=? && i.ANNO<=? && i.DURATA<=?";
		List<Titolo> result = new ArrayList<Titolo>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tipo);
			st.setInt(2, anno);
			
			st.setInt(3, durata);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Titolo s = new Titolo(res.getString("i.NOME"),res.getInt("i.ANNO"),res.getDouble("i.VOTO"),res.getInt("i.DURATA"),res.getString("i.GENERE"),res.getInt("i.NUD"),res.getInt("i.VIOL"),res.getInt("i.ALC"),res.getInt("i.FRI"),res.getString("n.description"));
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

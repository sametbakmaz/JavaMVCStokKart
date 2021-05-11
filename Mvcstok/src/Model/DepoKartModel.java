package Model;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepoKartModel extends Baglanti{
	
	String depoKodu;
	String depoAdi;
	String depoAciklama;
	
	
	
	public boolean kaydetDepo(DepoKartModel sd) {
		PreparedStatement ps = null;
		Connection con = (Connection) getBaglanti();
		String sql = "INSERT INTO  depo_kart(depo_kodu,depo_adi,depo_aciklama) VALUES(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sd.getDepoKodu());

			ps.setString(2, sd.getDepoAdi());

			ps.setString(3, sd.getDepoAciklama());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	
	
	
	public boolean duzenleDepo(DepoKartModel sd) {
		PreparedStatement ps = null;
		Connection con = (Connection) getBaglanti();
		String sql = "UPDATE depo_kart SET depo_kodu=?,depo_adi=?,depo_aciklama=? WHERE depo_kodu";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sd.getDepoKodu());

			ps.setString(2, sd.getDepoAdi());

			ps.setString(3, sd.getDepoAciklama());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	public boolean sil(DepoKartModel ds) {// sil
		PreparedStatement ps = null;
		Connection con = (Connection) getBaglanti();
		String sql = "DELETE FROM depo_kart WHERE depo_kodu=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ds.getDepoKodu());
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	public boolean select(DepoKartModel ds) {// arama
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = (Connection) getBaglanti();
		String sql = "SELECT*FROM depo_kart WHERE depo_kodu=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ds.getDepoKodu());
			rs = ps.executeQuery();

			if (rs.next()) {
				ds.setDepoKodu(rs.getString("depo_kodu"));

				ds.setDepoAdi(rs.getString("depo_adi"));

				ds.setDepoAciklama(rs.getString("depo_aciklama"));

			
				return true;

			}

			return false;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	public String getDepoKodu() {
		return depoKodu;
	}
	public void setDepoKodu(String depoKodu) {
		this.depoKodu = depoKodu;
	}
	public String getDepoAdi() {
		return depoAdi;
	}
	public void setDepoAdi(String depoAdi) {
		this.depoAdi = depoAdi;
	}
	public String getDepoAciklama() {
		return depoAciklama;
	}
	public void setDepoAciklama(String depoAciklama) {
		this.depoAciklama = depoAciklama;
	}

	

}

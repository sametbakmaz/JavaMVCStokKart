package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StokKartModel extends Baglanti {

	String stokKodu;
	String stokAdi;
	Integer stokTipi;
	String stokBirimi;
	String barkod;
	Double kdvTipi;
	String aciklama;


	public boolean kaydet(StokKartModel pro) { // ekle
		PreparedStatement ps = null;
		Connection con = (Connection) getBaglanti();
		String sql = "INSERT INTO stok_kart (stok_kodu,stok_adi,stok_tipi,stok_birimi,stok_barkodu,stok_kdv,stok_aciklama) VALUES(?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getStokKodu());

			ps.setString(2, pro.getStokAdi());

			ps.setInt(3, pro.getStokTipi());

			ps.setString(4, pro.getStokBirimi());

			ps.setString(5, pro.getBarkod());

			ps.setDouble(6, pro.getKdvTipi());
			ps.setString(7, pro.getAciklama());
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

	public boolean duzenle(StokKartModel pro) { // guncelle
		PreparedStatement ps = null;
		Connection con = (Connection) getBaglanti();
		String sql = "UPDATE stok_kart SET stok_kodu=?,stok_adi=?,stok_tipi=?,stok_birimi=?,stok_barkodu=?,stok_kdv=?,stok_aciklama=? WHERE stok_kodu=?";
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getStokKodu());

			ps.setString(2, pro.getStokAdi());

			ps.setInt(3, pro.getStokTipi());

			ps.setString(4, pro.getStokBirimi());

			ps.setString(5, pro.getBarkod());

			ps.setDouble(6, pro.getKdvTipi());
			ps.setString(7, pro.getAciklama());
			ps.setString(8, pro.getStokKodu());
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println(e);
			}
		}
	}

	public boolean sil(StokKartModel pro) {// sil
		PreparedStatement ps = null;
		Connection con = (Connection) getBaglanti();
		String sql = "DELETE FROM stok_kart WHERE stok_kodu=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getStokKodu());
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

	public boolean select(StokKartModel pro) {// arama
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = (Connection) getBaglanti();
		String sql = "SELECT*FROM stok_kart WHERE stok_kodu=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getStokKodu());
			rs = ps.executeQuery();

			if (rs.next()) {
				pro.setStokKodu(rs.getString("stok_kodu"));

				pro.setStokAdi(rs.getString("stok_adi"));

				pro.setStokTipi(Integer.parseInt(rs.getString("stok_tipi")));

				pro.setStokBirimi(rs.getString("stok_birimi"));

				pro.setBarkod(rs.getString("stok_barkodu"));

				pro.setKdvTipi(Double.parseDouble(rs.getString("stok_kdv")));

				pro.setAciklama(rs.getString("stok_aciklama"));
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

	public boolean kopyala(StokKartModel pro) { // kopyala
		PreparedStatement ps = null;
		Connection con = (Connection) getBaglanti();
		String sql = "INSERT INTO stok_kart (stok_kodu,stok_adi,stok_tipi,stok_birimi,stok_barkodu,stok_kdv,stok_aciklama) VALUES(?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, pro.getStokKodu());

			ps.setString(2, pro.getStokAdi());

			ps.setInt(3, pro.getStokTipi());

			ps.setString(4, pro.getStokBirimi());

			ps.setString(5, pro.getBarkod());

			ps.setDouble(6, pro.getKdvTipi());
			ps.setString(7, pro.getAciklama());
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

	

	public String getStokKodu() {
		return stokKodu;
	}

	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getStokAdi() {
		return stokAdi;
	}

	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}

	public Integer getStokTipi() {
		return stokTipi;
	}

	public void setStokTipi(Integer string) {
		this.stokTipi = string;
	}

	public String getStokBirimi() {
		return stokBirimi;
	}

	public void setStokBirimi(String stokBirimi) {
		this.stokBirimi = stokBirimi;
	}

	public String getBarkod() {
		return barkod;
	}

	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}

	public Double getKdvTipi() {
		return kdvTipi;
	}

	public void setKdvTipi(Double kdvTipi) {
		this.kdvTipi = kdvTipi;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

}

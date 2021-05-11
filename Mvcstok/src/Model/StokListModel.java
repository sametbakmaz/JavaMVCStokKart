package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StokListModel {

	String stokKodu;
	String guncelStokKodu;
	String stokAdi;
	Integer stokTipi;
	String stokBirimi;
	String barkod;
	Double kdvTipi;
	String aciklama;
	String tarih;

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	Baglanti con = new Baglanti();

	// --------------Getters--And---Setters----------
	public String getStokKodu() {
		return stokKodu;
	}

	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getGuncelStokKodu() {
		return guncelStokKodu;
	}

	public void setguncelStokKodu(String _guncelStokKodu) {
		this.guncelStokKodu = _guncelStokKodu;
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

	public void setStokTipi(Integer stokTipi) {
		this.stokTipi = stokTipi;
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

	public ArrayList<StokListModel> list() { // listele
		ArrayList<StokListModel> cardList = new ArrayList<StokListModel>();
		try {

			String query = "select * from stok_kart";
			ResultSet rs = con.result(query);
			while (rs.next()) {

				StokListModel card = new StokListModel();
				card.setStokKodu(rs.getString("stok_kodu"));
				card.setStokAdi(rs.getString("stok_adi"));
				card.setStokTipi(rs.getInt("stok_tipi"));
				card.setStokBirimi(rs.getString("stok_birimi"));
				card.setBarkod(rs.getString("stok_barkodu"));
				card.setKdvTipi(rs.getDouble("stok_kdv"));
				card.setAciklama(rs.getString("stok_aciklama"));
				card.setTarih(rs.getString("stok_tarih"));

				cardList.add(card);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cardList;
	}

}

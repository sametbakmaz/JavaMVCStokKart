package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepoListModel {

	String depoKodu;
	String depoAdi;
	String depoAciklama;
	
	Baglanti con = new Baglanti();
	
	// --------------Getters--And---Setters----------

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
	
	
	public ArrayList<DepoListModel> list() { // listele
		ArrayList<DepoListModel> cardList = new ArrayList<DepoListModel>();
		try {

			String query = "select * from depo_kart";
			ResultSet rs = con.result(query);
			while (rs.next()) {

				DepoListModel card = new DepoListModel();
				card.setDepoKodu(rs.getString("depo_kodu"));
				card.setDepoAdi(rs.getString("depo_adi"));
				card.setDepoAciklama(rs.getString("depo_aciklama"));

				cardList.add(card);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cardList;
	}

	
	
}

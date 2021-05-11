package View;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Controller.ClearDepoController;
import Controller.CopyDepoController;
import Controller.DeleteDepoController;
import Controller.EditDepoController;
import Controller.SaveDepoController;
import Controller.SearchDepoController;
import Model.DepoKartModel;

public class DepoKartFrame extends JInternalFrame {
	public static JTextField TxtDepoKodu;
	public static JTextField TxtDepoAdi;
	public static JTextField TxtAciklama;
	public static JTextField TxtDepoAra;
	public static JButton btnDepoKaydet;
	public static JButton btnDepoDuzenle;
	public static JButton btnDepoKopyala;
	public static JButton btnDepoSil;
	public static JButton btnDepoTemizle;
	public static JButton btnDepoAra;

	/**
	 * Create the frame.
	 */
	public DepoKartFrame() throws ParseException {
		setTitle("DEPO KART");
		setBounds(100, 100, 473, 582);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Depo Kodu");
		lblNewLabel.setBounds(33, 31, 82, 27);
		getContentPane().add(lblNewLabel);

		JLabel lblDepoAd = new JLabel("Depo Adı\r\n");
		lblDepoAd.setBounds(33, 89, 82, 27);
		getContentPane().add(lblDepoAd);

		JLabel lblAklama = new JLabel("Açıklama");
		lblAklama.setBounds(33, 149, 82, 27);
		getContentPane().add(lblAklama);

		TxtDepoKodu = new JTextField();
		TxtDepoKodu.setBounds(114, 35, 177, 27);
		getContentPane().add(TxtDepoKodu);
		TxtDepoKodu.setColumns(10);

		TxtDepoAdi = new JTextField();
		TxtDepoAdi.setColumns(10);
		TxtDepoAdi.setBounds(114, 93, 177, 27);
		getContentPane().add(TxtDepoAdi);

		TxtAciklama = new JTextField();
		TxtAciklama.setColumns(10);
		TxtAciklama.setBounds(114, 153, 246, 82);
		getContentPane().add(TxtAciklama);

		TxtDepoAra = new JTextField();
		TxtDepoAra.setBounds(170, 512, 238, 27);
		getContentPane().add(TxtDepoAra);
		TxtDepoAra.setColumns(10);

		this.btnDepoKaydet = new JButton("KAYDET");
		btnDepoKaydet.setBounds(159, 278, 115, 35);
		getContentPane().add(btnDepoKaydet);

		this.btnDepoKopyala = new JButton("KOPYALA");
		btnDepoKopyala.setBounds(263, 355, 115, 35);
		getContentPane().add(btnDepoKopyala);

		this.btnDepoDuzenle = new JButton("DÜZENLE\r\n");
		btnDepoDuzenle.setBounds(57, 355, 115, 35);
		getContentPane().add(btnDepoDuzenle);

		this.btnDepoTemizle = new JButton("TEMİZLE");
		btnDepoTemizle.setBounds(263, 440, 115, 35);
		getContentPane().add(btnDepoTemizle);

		this.btnDepoSil = new JButton("SİL");
		btnDepoSil.setBounds(57, 440, 115, 35);
		getContentPane().add(btnDepoSil);

		this.btnDepoAra = new JButton("ARA");
		btnDepoAra.setBounds(33, 508, 115, 35);
		getContentPane().add(btnDepoAra);

		DepoKartModel depoKartModel = new DepoKartModel();

		SaveDepoController saveController = new SaveDepoController(depoKartModel, null, this);
		SearchDepoController searchController = new SearchDepoController(depoKartModel, null, this);
		DeleteDepoController deleteController = new DeleteDepoController(depoKartModel, null, this);
		ClearDepoController celarController = new ClearDepoController(depoKartModel, null, this);
		EditDepoController editController = new EditDepoController(depoKartModel, null, this);
		CopyDepoController copyController = new CopyDepoController(depoKartModel, null, this);

	}

	public static JTextField getTxtDepoKodu() {
		return TxtDepoKodu;
	}

	public static void setTxtDepoKodu(JTextField txtDepoKodu) {
		TxtDepoKodu = txtDepoKodu;
	}

	public static JTextField getTxtDepoAdi() {
		return TxtDepoAdi;
	}

	public static void setTxtDepoAdi(JTextField txtDepoAdi) {
		TxtDepoAdi = txtDepoAdi;
	}

	public static JTextField getTxtAciklama() {
		return TxtAciklama;
	}

	public static void setTxtAciklama(JTextField txtAciklama) {
		TxtAciklama = txtAciklama;
	}

	public static JTextField getTxtStokAra() {
		return TxtDepoAra;
	}

	public static void setTxtStokAra(JTextField txtStokAra) {
		TxtDepoAra = txtStokAra;
	}

	public static JButton getBtnDepoKaydet() {
		return btnDepoKaydet;
	}

	public static void setBtnDepoKaydet(JButton btnDepoKaydet) {
		DepoKartFrame.btnDepoKaydet = btnDepoKaydet;
	}

	public static JButton getBtnDepoDuzenle() {
		return btnDepoDuzenle;
	}

	public static void setBtnDepoDuzenle(JButton btnDepoDuzenle) {
		DepoKartFrame.btnDepoDuzenle = btnDepoDuzenle;
	}

	public static JButton getBtnDepoKopyala() {
		return btnDepoKopyala;
	}

	public static void setBtnDepoKopyala(JButton btnDepoKopyala) {
		DepoKartFrame.btnDepoKopyala = btnDepoKopyala;
	}

	public static JButton getBtnDepoSil() {
		return btnDepoSil;
	}

	public static void setBtnDepoSil(JButton btnDepoSil) {
		DepoKartFrame.btnDepoSil = btnDepoSil;
	}

	public static JButton getBtnDepoTemizle() {
		return btnDepoTemizle;
	}

	public static void setBtnDepoTemizle(JButton btnDepoTemizle) {
		DepoKartFrame.btnDepoTemizle = btnDepoTemizle;
	}

	public static JButton getBtnDepoAra() {
		return btnDepoAra;
	}

	public static void setBtnDepoAra(JButton btnDepoAra) {
		DepoKartFrame.btnDepoAra = btnDepoAra;
	}

}

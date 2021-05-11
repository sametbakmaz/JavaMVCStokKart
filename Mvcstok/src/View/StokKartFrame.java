package View;

import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Controller.ClearStokController;

import Controller.CopyStokController;
import Controller.DeleteStokController;
import Controller.EditStokController;
import Controller.SaveStokController;
import Controller.SearchStokController;
import Model.DepoKartModel;
import Model.StokKartModel;

import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Font;

import java.awt.Color;

public class StokKartFrame extends JInternalFrame {

	public static JTextField TxtStokKodu;
	public static JTextField TxtStokAdi;
	public static JTextField TxtStokBarkod;
	public static JTextField TxtAra;
	public static JComboBox cmbStokTipi;
	public static JComboBox cmbStokBirimi;
	public static JComboBox cmbKdvTipi;
	public static JComboBox cmbDepoKodu;
	public static JButton btnSave;
	public static JButton btnDuzenle;
	public static JButton btnSil;
	public static JButton btnKopyala;
	public static JButton btnAra;
	public static JButton btnTemizle;
	public static JTextArea TaAciklama;
	

	/**
	 * Launch the application.
	 * 
	 * 
	 * /** Create the frame.
	 */
	public StokKartFrame() throws ParseException {
		setClosable(true);
		setResizable(true);
		getContentPane().setBackground(SystemColor.info);
		setBackground(SystemColor.activeCaption);
		setTitle("STOK İŞLEMLERİ\r\n");

		setBounds(100, 100, 450, 658);
		getContentPane().setLayout(null);

		JLabel LblStokKodu = new JLabel("Stok Kodu");
		LblStokKodu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LblStokKodu.setBounds(10, 36, 57, 13);
		getContentPane().add(LblStokKodu);

		JLabel LblStokAdi = new JLabel("Stok Adı");
		LblStokAdi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LblStokAdi.setBounds(10, 74, 72, 13);
		getContentPane().add(LblStokAdi);

		JLabel LblStokTipi = new JLabel("Stok Tipi");
		LblStokTipi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LblStokTipi.setBounds(10, 113, 72, 13);
		getContentPane().add(LblStokTipi);

		JLabel LblStokBirimi = new JLabel("Stok Birimi");
		LblStokBirimi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LblStokBirimi.setBounds(10, 152, 72, 13);
		getContentPane().add(LblStokBirimi);

		JLabel LblStokBarkodu = new JLabel("StokBarkodu");
		LblStokBarkodu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LblStokBarkodu.setBounds(10, 197, 72, 13);
		getContentPane().add(LblStokBarkodu);

		JLabel LblStokKdv = new JLabel("Stok Kdv");
		LblStokKdv.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LblStokKdv.setBounds(10, 240, 72, 13);
		getContentPane().add(LblStokKdv);

		JLabel LblAciklama = new JLabel("Açıklama");
		LblAciklama.setFont(new Font("Times New Roman", Font.BOLD, 12));
		LblAciklama.setBounds(10, 332, 72, 13);
		getContentPane().add(LblAciklama);

		TxtStokKodu = new JTextField();
		TxtStokKodu.setBounds(111, 33, 287, 19);
		getContentPane().add(TxtStokKodu);
		TxtStokKodu.setColumns(10);

		TxtStokAdi = new JTextField();
		TxtStokAdi.setBounds(111, 71, 287, 19);
		getContentPane().add(TxtStokAdi);
		TxtStokAdi.setColumns(10);

		TxtStokBarkod = new JTextField();
		TxtStokBarkod.setBounds(111, 194, 287, 19);
		getContentPane().add(TxtStokBarkod);
		TxtStokBarkod.setColumns(10);

		TaAciklama = new JTextArea();
		TaAciklama.setBounds(111, 331, 287, 57);
		getContentPane().add(TaAciklama);

		Integer tip[] = new Integer[2];
		tip[0] = 1;
		tip[1] = 2;
		cmbStokTipi = new JComboBox(tip);
		cmbStokTipi.setBackground(SystemColor.menu);
		cmbStokTipi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cmbStokTipi.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));
		cmbStokTipi.setSelectedIndex(1);
		cmbStokTipi.setBounds(111, 109, 196, 20);
		getContentPane().add(cmbStokTipi);

		String birim[] = { "desi", "kg", "koli" };
		cmbStokBirimi = new JComboBox(birim);
		cmbStokBirimi.setBackground(SystemColor.menu);
		cmbStokBirimi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cmbStokBirimi.setSelectedIndex(2);
		cmbStokBirimi.setBounds(111, 148, 196, 20);
		getContentPane().add(cmbStokBirimi);

		Double kdv[] = new Double[3];
		kdv[0] = 0.1;
		kdv[1] = 0.08;
		kdv[2] = 0.18;
		cmbKdvTipi = new JComboBox(kdv);
		cmbKdvTipi.setBackground(SystemColor.menu);
		cmbKdvTipi.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cmbKdvTipi.setModel(new DefaultComboBoxModel(new String[] { "0.1", "0.8", "0.18" }));
		cmbKdvTipi.setSelectedIndex(2);
		cmbKdvTipi.setBounds(111, 236, 196, 20);
		getContentPane().add(cmbKdvTipi);

		this.btnSave = new JButton("KAYDET");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSave.setBackground(new Color(100, 149, 237));
		btnSave.setBounds(142, 398, 126, 46);
		getContentPane().add(btnSave);

		this.btnDuzenle = new JButton("DÜZENLE\r\n");
		btnDuzenle.setBackground(new Color(127, 255, 0));
		btnDuzenle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDuzenle.setBounds(70, 454, 98, 21);
		getContentPane().add(btnDuzenle);

		this.btnSil = new JButton("SİL");
		btnSil.setBackground(new Color(255, 0, 0));
		btnSil.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSil.setBounds(70, 509, 98, 21);
		getContentPane().add(btnSil);

		this.btnKopyala = new JButton("KOPYALA");
		btnKopyala.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnKopyala.setBackground(new Color(135, 206, 235));
		btnKopyala.setBounds(249, 454, 98, 21);
		getContentPane().add(btnKopyala);

		this.btnAra = new JButton("ARA");
		btnAra.setBackground(new Color(154, 205, 50));
		btnAra.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAra.setBounds(10, 571, 85, 32);
		getContentPane().add(btnAra);

		this.TxtAra = new JTextField();
		TxtAra.setBounds(111, 572, 285, 32);
		getContentPane().add(TxtAra);
		TxtAra.setColumns(10);

		this.btnTemizle = new JButton("TEMİZLE");
		btnTemizle.setBackground(new Color(255, 215, 0));
		btnTemizle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnTemizle.setBounds(249, 509, 98, 21);
		getContentPane().add(btnTemizle);
		
		JLabel lblDepoKodu = new JLabel("Depo Kodu");
		lblDepoKodu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDepoKodu.setBounds(10, 283, 72, 13);
		getContentPane().add(lblDepoKodu);
		
		cmbDepoKodu = new JComboBox();
		cmbDepoKodu.setBounds(111, 279, 196, 32);
		getContentPane().add(cmbDepoKodu);
//		cmbDepoKodu.actionPerformed(e);
		StokKartModel kartModel = new StokKartModel(); // cons

		SaveStokController saveController = new SaveStokController(kartModel, null, this, null);
		DeleteStokController deleteController = new DeleteStokController(kartModel, null, this, null);
		EditStokController editController = new EditStokController(kartModel, null, this, null);
		SearchStokController searchController = new SearchStokController(kartModel, null, this, null);
		CopyStokController copyControlelr = new CopyStokController(kartModel, null, this, null);
		ClearStokController clearController = new ClearStokController(kartModel, null, this, null);
		
		DepoKartModel depoModel = new DepoKartModel();
		
		
		
		
	}

	public JComboBox getCmbDepoKodu() {
		return cmbDepoKodu;
	}

	public void setCmbDepoKodu(JComboBox cmbDepoKodu) {
		this.cmbDepoKodu = cmbDepoKodu;
	}

	public JTextField getTxtStokKodu() {
		return TxtStokKodu;
	}

	public void setTxtStokKodu(JTextField txtStokKodu) {
		TxtStokKodu = txtStokKodu;
	}

	public JTextField getTxtStokAdi() {
		return TxtStokAdi;
	}

	public void setTxtStokAdi(JTextField txtStokAdi) {
		TxtStokAdi = txtStokAdi;
	}

	public JTextField getTxtStokBarkod() {
		return TxtStokBarkod;
	}

	public void setTxtStokBarkod(JTextField txtStokBarkod) {
		TxtStokBarkod = txtStokBarkod;
	}

	public JTextField getTxtAra() {
		return TxtAra;
	}

	public void setTxtAra(JTextField txtAra) {
		TxtAra = txtAra;
	}

	public JComboBox getCmbStokTipi() {
		return cmbStokTipi;
	}

	public void setCmbStokTipi(JComboBox cmbStokTipi) {
		this.cmbStokTipi = cmbStokTipi;
	}

	public JComboBox getCmbStokBirimi() {
		return cmbStokBirimi;
	}

	public void setCmbStokBirimi(JComboBox cmbStokBirimi) {
		this.cmbStokBirimi = cmbStokBirimi;
	}

	public JComboBox getCmbKdvTipi() {
		return cmbKdvTipi;
	}

	public void setCmbKdvTipi(JComboBox cmbKdvTipi) {
		this.cmbKdvTipi = cmbKdvTipi;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnDuzenle() {
		return btnDuzenle;
	}

	public void setBtnDuzenle(JButton btnDuzenle) {
		this.btnDuzenle = btnDuzenle;
	}

	public JButton getBtnSil() {
		return btnSil;
	}

	public void setBtnSil(JButton btnSil) {
		this.btnSil = btnSil;
	}

	public JButton getBtnKopyala() {
		return btnKopyala;
	}

	public void setBtnKopyala(JButton btnKopyala) {
		this.btnKopyala = btnKopyala;
	}

	public JButton getBtnAra() {
		return btnAra;
	}

	public void setBtnAra(JButton btnAra) {
		this.btnAra = btnAra;
	}

	public JButton getBtnTemizle() {
		return btnTemizle;
	}

	public void setBtnTemizle(JButton btnTemizle) {
		this.btnTemizle = btnTemizle;
	}
}

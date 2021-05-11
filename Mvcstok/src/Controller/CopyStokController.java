package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.StokKartModel;

import View.MainFrame;
import View.StokKartFrame;
import View.StokListFrame;
import Controller.CopyStokController;

public class CopyStokController implements ActionListener {
	private StokKartModel mod;

	private MainFrame mainFrame;
	private StokKartFrame stokEkleFrame;
	private StokListFrame stokListeleFrame;
	private CopyStokController copyController;

	public CopyStokController(StokKartModel mod, MainFrame mainFrame, StokKartFrame stokEkleFrame,
			StokListFrame stokListeleFrame) {
		this.mod = mod;
		this.mainFrame = mainFrame;
		this.stokEkleFrame = stokEkleFrame;
		this.stokListeleFrame = stokListeleFrame;
		this.stokEkleFrame.btnKopyala.addActionListener(this);

	}

	public void start() {
		mainFrame.setTitle("STOK KART");
		mainFrame.setLocationRelativeTo(null);
		StokKartFrame.TxtStokKodu.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			buttonClicked(e);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	private void buttonClicked(ActionEvent e) {

		if (e.getSource().equals(StokKartFrame.btnKopyala))// kopyala

		{

			getValues();
			if (mod.kopyala(mod)) {

				JOptionPane.showMessageDialog(null, "Stok Kart Başarıyla Kopyalanmıştır.");

				temizle();
			} else {

				JOptionPane.showMessageDialog(null,
						"Kopyalama Başarısız. Farklı Bir Stok Kodu İle Kaydetmeyi Deneyiniz.");

				temizle();
			}

		}

	}

	private void getValues() {
		String stokKodu = JOptionPane.showInputDialog("Yeni stok kodunu giriniz: ");
		if (stokKodu.equals(null) || stokKodu.equals("")) {

			throw new RuntimeException("Stok kodunu boş bırakmamalısınız.");

		}

		mod.setStokKodu(stokKodu);
		mod.setStokAdi(StokKartFrame.TxtStokAdi.getText());
		mod.setStokBirimi((String) StokKartFrame.cmbStokBirimi.getSelectedItem());
		mod.setStokTipi(Integer.parseInt(StokKartFrame.cmbStokTipi.getSelectedItem().toString()));

		mod.setBarkod(StokKartFrame.TxtStokBarkod.getText());
		mod.setKdvTipi(Double.parseDouble(StokKartFrame.cmbKdvTipi.getSelectedItem().toString()));
		mod.setAciklama(StokKartFrame.TaAciklama.getText());
	}

	public void temizle() {// temizle
		StokKartFrame.TxtStokKodu.setText(null);
		StokKartFrame.TxtStokAdi.setText(null);
		StokKartFrame.cmbStokTipi.setToolTipText(null);
		StokKartFrame.cmbStokBirimi.setToolTipText(null);
		StokKartFrame.TxtStokBarkod.setText(null);
		StokKartFrame.cmbKdvTipi.setToolTipText(null);
		StokKartFrame.TaAciklama.setText(null);
		StokKartFrame.TxtAra.setText(null);

	}

}

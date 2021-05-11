package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepoKartModel;
import View.DepoKartFrame;
import View.MainFrame;
import View.StokKartFrame;

public class CopyDepoController implements ActionListener {
	private DepoKartModel mod;
	private MainFrame mainFrame;
	private DepoKartFrame depoKartFrame;
	private CopyDepoController copyController;

	public CopyDepoController(DepoKartModel mod, MainFrame mainFrame, DepoKartFrame depoKartFrame) {
		this.mod = mod;
		this.mainFrame = mainFrame;
		this.depoKartFrame = depoKartFrame;
		this.depoKartFrame.btnDepoKopyala.addActionListener(this);
	}

	public void start() {

		mainFrame.setLocationRelativeTo(null);
		DepoKartFrame.TxtDepoKodu.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			buttonClicked(e);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

	}

	private void buttonClicked(ActionEvent e) {

		if (e.getSource().equals(DepoKartFrame.btnDepoKopyala))// kopyala

		{

			getValues();
			if (mod.kaydetDepo(mod)) {

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
		String depoKodu = JOptionPane.showInputDialog("Yeni stok kodunu giriniz: ");
		if (depoKodu.equals(null) || depoKodu.equals("")) {

			throw new RuntimeException("Stok kodunu boş bırakmamalısınız.");

		}

		mod.setDepoKodu(depoKodu);
		mod.setDepoAdi(DepoKartFrame.TxtDepoAdi.getText());
		mod.setDepoAciklama(DepoKartFrame.TxtAciklama.getText());
	}

	public void temizle() {
		DepoKartFrame.TxtDepoKodu.setText(null);
		DepoKartFrame.TxtDepoAdi.setText(null);
		DepoKartFrame.TxtAciklama.setText(null);
		DepoKartFrame.TxtDepoAra.setText(null);
	}

}

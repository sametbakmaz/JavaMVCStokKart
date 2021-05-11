package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepoKartModel;
import View.DepoKartFrame;
import View.MainFrame;
import View.StokKartFrame;

public class EditDepoController implements ActionListener {

	private DepoKartModel mod;
	private MainFrame mainFrame;
	private DepoKartFrame depoKartFrame;
	private EditDepoController editController;

	public EditDepoController(DepoKartModel mod, MainFrame mainFrame, DepoKartFrame depoKartFrame) {
		this.mod = mod;
		this.mainFrame = mainFrame;
		this.depoKartFrame = depoKartFrame;
		this.depoKartFrame.btnDepoDuzenle.addActionListener(this);
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
		if (e.getSource().equals(DepoKartFrame.btnDepoDuzenle)) {
			String depoKodu = DepoKartFrame.TxtDepoKodu.getText();
			if (!depoKodu.equals(mod.getDepoKodu())) {
				throw new RuntimeException("Depo Kodu Değiştirilemez");
			}
			getValues();
			if (mod.duzenleDepo(mod)) {
				JOptionPane.showMessageDialog(null, "Depo Kartı Başarıyla Güncellendi");
				temizle();
			} else {
				JOptionPane.showMessageDialog(null, "Depo Kartı Güncellemesi Başarısız");
				temizle();
			}

		}

	}
	private void getValues() {
		String depoKodu = DepoKartFrame.TxtDepoKodu.getText();
		if (depoKodu.equals(null) || depoKodu.equals("")) {
			throw new RuntimeException("Stok Kodu Girmeyi Unuttunuz");
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

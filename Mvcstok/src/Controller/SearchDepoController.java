package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepoKartModel;
import View.DepoKartFrame;
import View.MainFrame;
import Controller.SearchDepoController;

public class SearchDepoController implements ActionListener {
	private DepoKartModel mod;
	private MainFrame mainFrame;
	private DepoKartFrame depoKartFrame;
	private SearchDepoController serachController;

	public SearchDepoController(DepoKartModel mod, MainFrame mainFrame, DepoKartFrame depoKartFrame) {
		this.mod = mod;
		this.mainFrame = mainFrame;
		this.depoKartFrame = depoKartFrame;
		this.depoKartFrame.btnDepoAra.addActionListener(this);
	}

	public void start() {
//		mainFrame.setTitle("STOK KART");
		mainFrame.setLocationRelativeTo(null);
		DepoKartFrame.TxtDepoKodu.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			buttonClicked(e);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			temizle();
		}

	}

	private void buttonClicked(ActionEvent e) {
		if (e.getSource().equals(DepoKartFrame.btnDepoAra)) {
			mod.setDepoKodu(DepoKartFrame.TxtDepoAra.getText());
			if (mod.select(mod)) {
				DepoKartFrame.TxtDepoKodu.setText(String.valueOf(mod.getDepoKodu()));
				DepoKartFrame.TxtDepoAdi.setText(String.valueOf(mod.getDepoAdi()));
				DepoKartFrame.TxtAciklama.setText(String.valueOf(mod.getDepoAciklama()));

			} else {
				JOptionPane.showMessageDialog(null, "Kayıt Bulunamadı");
			}
		}

	}

//	private void getValues() {
//		String depoKodu = DepoKartFrame.TxtDepoKodu.getText();
//		if (depoKodu.equals(null) || depoKodu.equals("")) {
//			throw new RuntimeException("Stok Kodu Girmeyi Unuttunuz");
//		}
//
//		mod.setDepoKodu(depoKodu);
//		mod.setDepoAdi(DepoKartFrame.TxtDepoAdi.getText());
//		mod.setDepoAciklama(DepoKartFrame.TxtAciklama.getText());
//
//	}

	public void temizle() {// temizle
		DepoKartFrame.TxtDepoKodu.setText(null);
		DepoKartFrame.TxtDepoAdi.setText(null);
		DepoKartFrame.TxtAciklama.setText(null);

	}

}
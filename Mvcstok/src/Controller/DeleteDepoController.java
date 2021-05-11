package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepoKartModel;
import View.DepoKartFrame;
import View.MainFrame;
import Controller.DeleteDepoController;

public class DeleteDepoController implements ActionListener {
	private DepoKartModel mod;
	private MainFrame mainFrame;
	private DepoKartFrame depoKartFrame;
	private DeleteDepoController deleteController;
	
	public DeleteDepoController(DepoKartModel mod, MainFrame mainFrame, DepoKartFrame depoKartFrame){
		this.mod=mod;
		this.mainFrame=mainFrame;
		this.depoKartFrame=depoKartFrame;
		this.depoKartFrame.btnDepoSil.addActionListener(this);
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
		}

	}
	private void buttonClicked(ActionEvent e) {
		if (e.getSource().equals(DepoKartFrame.btnDepoSil)) {// sil
			String depoAra = DepoKartFrame.TxtDepoAra.getText();
			mod.setDepoKodu(DepoKartFrame.TxtDepoKodu.getText());

			if (mod.sil(mod) && !depoAra.equals("")) {
				JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Silindi");
				temizle();
			} else {
				JOptionPane.showMessageDialog(null,
						"Kayıt Silinemedi. Silinecek Kaydı Seçtikten Sonra Tekrar Deneyiniz. ");
				temizle();

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

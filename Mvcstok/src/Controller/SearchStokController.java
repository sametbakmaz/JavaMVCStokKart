package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.StokKartModel;
import View.MainFrame;
import View.StokKartFrame;
import View.StokListFrame;
import Controller.SearchStokController;

public class SearchStokController implements ActionListener {
	private StokKartModel mod;
	private MainFrame mainFrame;
	private StokKartFrame stokEkleFrame;
	private StokListFrame stokListeleFrame;
	private SearchStokController searchController;

	public SearchStokController(StokKartModel mod, MainFrame mainFrame, StokKartFrame stokEkleFrame,
			StokListFrame stokListeleFrame) {
		this.mod = mod;
		this.mainFrame = mainFrame;
		this.stokEkleFrame = stokEkleFrame;
		this.stokListeleFrame = stokListeleFrame;
		this.stokEkleFrame.btnAra.addActionListener(this);

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
		if (e.getSource().equals(StokKartFrame.btnAra)) {// ara
			mod.setStokKodu(StokKartFrame.TxtAra.getText());
			if (mod.select(mod)) {
				StokKartFrame.TxtStokKodu.setText(String.valueOf(mod.getStokKodu()));
				StokKartFrame.TxtStokAdi.setText(String.valueOf(mod.getStokAdi()));
				StokKartFrame.cmbStokTipi.setSelectedIndex(mod.getStokTipi() - 1);

				for (int i = 0; i < StokKartFrame.cmbStokBirimi.getItemCount(); i++) {
					if (StokKartFrame.cmbStokBirimi.getItemAt(i).equals(mod.getStokBirimi())) {
						StokKartFrame.cmbStokBirimi.setSelectedIndex(i);
					}
				}
				StokKartFrame.TxtStokBarkod.setText(String.valueOf(mod.getBarkod()));

				for (int i = 0; i < StokKartFrame.cmbKdvTipi.getItemCount(); i++) {
					if (StokKartFrame.cmbKdvTipi.getItemAt(i).equals(mod.getKdvTipi().toString())) {
						StokKartFrame.cmbKdvTipi.setSelectedIndex(i);
					}

				}

				StokKartFrame.TaAciklama.setText(String.valueOf(mod.getAciklama()));

			} else {

				JOptionPane.showMessageDialog(null, "Kayıt Bulunamadı");
				temizle();
			}
		}

	}

//	private void getValues() {
//		String stokKodu = StokKartFrame.TxtStokKodu.getText();
//		if (stokKodu.equals(null) || stokKodu.equals("")) {
//			throw new RuntimeException("Stok Kodu Girmeyi Unuttunuz");
//		}
//
//		mod.setStokKodu(stokKodu);
//		mod.setStokAdi(StokKartFrame.TxtStokAdi.getText());
//		mod.setStokBirimi((String) StokKartFrame.cmbStokBirimi.getSelectedItem());
//		mod.setStokTipi(Integer.parseInt(StokKartFrame.cmbStokTipi.getSelectedItem().toString()));
//
//		mod.setBarkod(StokKartFrame.TxtStokBarkod.getText());
//		mod.setKdvTipi(Double.parseDouble(StokKartFrame.cmbKdvTipi.getSelectedItem().toString()));
//		mod.setAciklama(StokKartFrame.TaAciklama.getText());
//	}

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

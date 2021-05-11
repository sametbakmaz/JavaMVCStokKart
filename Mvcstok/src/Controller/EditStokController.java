package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.StokKartModel;
import View.MainFrame;
import View.StokKartFrame;
import View.StokListFrame;
import Controller.EditStokController;

public class EditStokController implements ActionListener {
	private StokKartModel mod;
	private MainFrame mainFrame;
	private StokKartFrame stokEkleFrame;
	private StokListFrame stokListeleFrame;
	private EditStokController editController;

	public EditStokController(StokKartModel mod, MainFrame mainFrame, StokKartFrame stokEkleFrame,
			StokListFrame stokListeleFrame) {
		this.mod = mod;
		this.mainFrame = mainFrame;
		this.stokEkleFrame = stokEkleFrame;
		this.stokListeleFrame = stokListeleFrame;
		this.stokEkleFrame.btnDuzenle.addActionListener(this);

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
		if (e.getSource().equals(StokKartFrame.btnDuzenle))

		{// duzenle
			String stokKodu = StokKartFrame.TxtStokKodu.getText();
			if (!stokKodu.equals(mod.getStokKodu())) {

				throw new RuntimeException("Stok Kodu Değiştirilemez");

			}
			getValues();

			if (mod.duzenle(mod)) {

				JOptionPane.showMessageDialog(null, "Stok Kartı Başarılı Bir Şekilde Düzenlendi ");
				temizle();
			} else {
				JOptionPane.showMessageDialog(null, "Düzenleme Başarısız");
				temizle();

			}

		}

	}

	private void getValues() {
		String stokKodu = StokKartFrame.TxtStokKodu.getText();
		if (stokKodu.equals(null) || stokKodu.equals("")) {
			throw new RuntimeException("Stok Kodu Girmeyi Unuttunuz");
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

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.DepoKartModel;
import View.DepoKartFrame;
import View.MainFrame;


public class ClearDepoController implements ActionListener {
	
	private DepoKartModel mod;
	private MainFrame mainFrame;
	private DepoKartFrame depoKartFrame;
	private ClearDepoController clearController;
	
	public ClearDepoController(DepoKartModel mod, MainFrame mainFrame, DepoKartFrame depoKartFrame){
		this.mod=mod;
		this.mainFrame=mainFrame;
		this.depoKartFrame=depoKartFrame;
		this.depoKartFrame.btnDepoTemizle.addActionListener(this);
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
		if (e.getSource().equals(DepoKartFrame.btnDepoTemizle)) {
			temizle();

		}

	}
	public void temizle() {// temizle
		DepoKartFrame.TxtDepoKodu.setText(null);
		DepoKartFrame.TxtDepoAdi.setText(null);
		DepoKartFrame.TxtAciklama.setText(null);
		DepoKartFrame.TxtDepoAra.setText(null);


	}
	
	

}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import Model.StokKartModel;
import Model.DepoListModel;
import View.DepoKartFrame;
import View.MainFrame;
import View.StokKartFrame;

public class ComboBoxDepoController implements ActionListener{
	
	private DepoListModel mod;
	private MainFrame mainFrame;
	private StokKartFrame stokKartFrame;
	public ComboBoxDepoController(DepoListModel mod, MainFrame mainFrame, StokKartFrame stokKartFrame){
		this.mod=mod;
		this.mainFrame=mainFrame;
		this.stokKartFrame=stokKartFrame;
		this.stokKartFrame.cmbDepoKodu.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		final JComboBox departmanBox = new JComboBox(cmbDepoKodu.listele()
                .toArray());
		
	}
	
	

}

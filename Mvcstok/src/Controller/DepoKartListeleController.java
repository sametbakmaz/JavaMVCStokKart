package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.DepoListModel;
import Model.StokListModel;
import View.DepoListFrame;

public class DepoKartListeleController implements ActionListener {
	private DepoListFrame view;
	private DepoListModel model;
	public DepoKartListeleController(DepoListFrame _view, DepoListModel _model) {
		this.view=_view;
		this.model=_model;
	}@Override
	public void actionPerformed(ActionEvent e) {

		retreiveData();

	}

	public void retreiveData() {

		ArrayList<DepoListModel> cardList = new ArrayList<DepoListModel>();
		cardList = model.list();
		DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
		model.setNumRows(0);
		try {

			for (int i = 0; i < cardList.size(); i++) {

				Object[] rows = new Object[8];
				rows[0] = (cardList.get(i).getDepoKodu());
				rows[1] = (cardList.get(i).getDepoAdi());
				rows[2] = (cardList.get(i).getDepoAciklama());
				

				model.addRow(rows);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


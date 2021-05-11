package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFileChooser;

import View.DepoKartFrame;
import View.MainFrame;
import View.StokKartFrame;
import View.StokListFrame;

public class StokMenuController {

	private MainFrame view;

	public StokMenuController(MainFrame _view) throws ParseException {

		this.view = _view;
		StokKartFrame stokKarti = new StokKartFrame();
		StokListFrame stokKartiListesi = new StokListFrame();
		

		view.stokKartiClick(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				view.add(stokKarti);
				stokKarti.show();
				stokKarti.setClosable(true);

			}
		});

		view.stokKartiListesiClick(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.add(stokKartiListesi);
				stokKartiListesi.show();
				stokKartiListesi.setClosable(true);

			}
		});
		
		
		

	}

}

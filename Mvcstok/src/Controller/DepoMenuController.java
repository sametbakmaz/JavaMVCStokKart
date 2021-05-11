package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import View.DepoKartFrame;
import View.DepoListFrame;
import View.MainFrame;


public class DepoMenuController {
	
	private MainFrame view;

	public DepoMenuController(MainFrame _view) throws ParseException {

		this.view = _view;
		DepoKartFrame depoKarti = new DepoKartFrame();
		DepoListFrame depoList = new DepoListFrame();
		
		view.depoKartiClick(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				_view.add(depoKarti);
				depoKarti.show();
				depoKarti.setClosable(true);

			}
		});
		view.depoKartiListesiClick(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				_view.add(depoList);
				depoList.show();
                depoList.setClosable(true);

			}
		});
		
		
		
		
		

	}
}

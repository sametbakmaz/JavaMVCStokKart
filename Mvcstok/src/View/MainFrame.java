package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DepoMenuController;
import Controller.StokMenuController;
import Model.StokKartModel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JMenuItem ItemStokKartListesi;
	private JMenuItem ItemStokKart;
	private JMenu mnDepo;
	private JMenuItem ItemDepoKart;
	private JMenuItem ItemDepoKartListesi;
	private JMenu mnStok;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					StokMenuController change = new StokMenuController(frame);
					StokKartModel mod = new StokKartModel();
					DepoMenuController dchange = new DepoMenuController(frame);

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(SystemColor.activeCaption);
		setFont(new Font("Times New Roman", Font.BOLD, 14));
		setTitle("Stok Kart ");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 650);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.info);
		setJMenuBar(menuBar);

		mnStok = new JMenu("Stok");
		mnStok.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.add(mnStok);

		ItemStokKart = new JMenuItem("Stok Kart ");
		mnStok.add(ItemStokKart);

		ItemStokKartListesi = new JMenuItem("Stok Kart Listesi");
		mnStok.add(ItemStokKartListesi);
		
		mnDepo = new JMenu("Depo");
		menuBar.add(mnDepo);
		
		ItemDepoKart = new JMenuItem("Depo Kart");
		mnDepo.add(ItemDepoKart);
		
		ItemDepoKartListesi = new JMenuItem("Depo Kart Listesi");
		mnDepo.add(ItemDepoKartListesi);
		
		

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}
	
	public void depoKartiClick(ActionListener mnuDepoKart) {
		ItemDepoKart.addActionListener(mnuDepoKart);
	}
	public void depoKartiListesiClick(ActionListener mnuDepoKartListesi) {
		ItemDepoKartListesi.addActionListener(mnuDepoKartListesi);
	}

	public void stokKartiClick(ActionListener mnuStokKart) {

		ItemStokKart.addActionListener(mnuStokKart);
	}

	public void stokKartiListesiClick(ActionListener mnuStokKartListesi) {

		ItemStokKartListesi.addActionListener(mnuStokKartListesi);
	}
	
	
}

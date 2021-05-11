package View;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DepoKartListeleController;

import Model.DepoListModel;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Font;

@SuppressWarnings("serial")
public class DepoListFrame extends JInternalFrame {
	private JTable table;
	private JButton btnRefresh;

	
	public DepoListFrame() {
		setClosable(true);
		setTitle("DEPO KARTI LİSTELE\r\n");
		setBackground(SystemColor.info);
		setMaximizable(true);
		setResizable(true);
		setBounds(650, 100, 866, 436);

		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] rows = { "DEPO KODU", "DEPO ADI", "DEPO AÇIKLAMA" };
		model.setColumnIdentifiers(rows);
		table.setModel(model);
		JScrollPane pane = new JScrollPane(table);

		DepoListModel card = new DepoListModel();
		DepoKartListeleController listC = new DepoKartListeleController(this, card);

		this.btnRefresh = new JButton("LİSTELE");
		btnRefresh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRefresh.setBackground(SystemColor.activeCaption);
		btnRefresh.addActionListener(listC);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pane, GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRefresh)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	public JTable getTable() {

		return this.table;
	}
	
}

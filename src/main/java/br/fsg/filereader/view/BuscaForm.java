package br.fsg.filereader.view;

import java.awt.event.MouseEvent;
import java.util.List;

import br.fsg.filereader.controller.BuscaController;
import br.fsg.filereader.tablemodel.GenericTableModel;

/**
 *
 * @author Fernando-Godoy
 */
public class BuscaForm<T> extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	private GenericTableModel<T> tableModel;
	private T selected;

	public BuscaForm(GenericTableModel<T> tableModel) {
		initComponents();
		this.tableModel = tableModel;
		this.tbBusca.setModel(tableModel);
		this.tbBusca.updateUI();
		this.setModal(true);
		this.setTitle("Busca");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		tfNome = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbBusca = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		jLabel1.setText("Nome:");

		tfNome.setColumns(50);

		jButton1.setText("Buscar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jButton1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tbBusca.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { {}, {}, {}, {} }, new String[] {

		}));
		tbBusca.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbBuscaMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbBusca);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		findByName();
	}// GEN-LAST:event_jButton1ActionPerformed

	private void tbBuscaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbBuscaMouseClicked
		selecionaItem(evt);
	}// GEN-LAST:event_tbBuscaMouseClicked

	private void selecionaItem(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			int selectedRow = tbBusca.getSelectedRow();
			this.selected = tableModel.getElements().get(selectedRow);
			this.dispose();
		}
	}

	@SuppressWarnings("unchecked")
	private void findByName() {
		cleanTable();
		String texto = tfNome.getText();
		BuscaController controller = new BuscaController();

		switch (tableModel.getSearchType()) {
		case DIRECTORY:
			this.tableModel.addElements((List<T>) controller.findDirectoryByName(texto));
			break;
		case PRODUCT:
			this.tableModel.addElements((List<T>)controller.findProductByName(texto));
			break;
		default:
			break;
		}
		this.tbBusca.setModel(tableModel);
		this.tbBusca.updateUI();
	}

	private void cleanTable() {
		tableModel.clear();
		tbBusca.setModel(tableModel);
		tbBusca.updateUI();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tbBusca;
	private javax.swing.JTextField tfNome;
	// End of variables declaration//GEN-END:variables

	public T getSelected() {
		return selected;
	}
}

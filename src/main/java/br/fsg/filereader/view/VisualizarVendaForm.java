package br.fsg.filereader.view;

import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.fsg.filereader.controller.ConfigurationController;
import br.fsg.filereader.controller.ProductController;
import br.fsg.filereader.controller.SaleController;
import br.fsg.filereader.exception.FileProductNotFoundException;
import br.fsg.filereader.model.Configuration;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.model.Sale;
import br.fsg.filereader.tablemodel.ProductTableModel;
import br.fsg.filereader.util.DirectoryManager;

/**
 *
 * @author Fernando-Godoy
 */
public class VisualizarVendaForm extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LogManager.getLogger(VisualizarVendaForm.class);
	private ProductTableModel tableModel = new ProductTableModel();
	private SaleController controller = new SaleController();
	private ConfigurationController configControl = new ConfigurationController();
	private Configuration configuration;
	private Sale sale;
	
	public VisualizarVendaForm(Long idVenda) {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Dados da Venda");
        loadData(idVenda);
        this.setVisible(true);
    }
    
	private void loadData(Long idVenda) {
		updateConfig();
		updateView(idVenda);
	}


	private void updateConfig() {
		configuration = configControl.findValue();
	}


	private void updateView(Long idVenda) {
		sale = controller.findById(idVenda);
		lbQuantidade.setText(sale.getQuantity().toString());
		lbValor.setText(sale.getAmount().getFormated());
		lbData.setText(sale.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		lbCliente.setText(sale.getClient());
		lbEndereco.setText(sale.getAddress());
		lbStatus.setText(sale.getStatus().toString());
		tableModel.addElements(sale.getProducts());
		tbProdutos.setModel(tableModel);
		tbProdutos.setEnabled(sale.isReserved());
		tbProdutos.updateUI();
		btConfirma.setEnabled(sale.isReserved());
	}


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbQuantidade = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbValor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbEndereco = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        btConfirma = new javax.swing.JButton();
        btCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Número de Itens:");

        lbQuantidade.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbQuantidade.setText("0");

        jLabel3.setText("Valor Total:");

        lbValor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbValor.setText("R$ 0,00");

        jLabel5.setText("Data:");

        lbData.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbData.setText("00/00/0000");

        jLabel7.setText("Cliente:");

        lbCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbCliente.setText("Cliente");

        jLabel2.setText("Situação:");

        lbStatus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbStatus.setText("Reservada");

        jLabel4.setText("Endereço:");

        lbEndereco.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbEndereco.setText("Av. Brasil, 123");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbQuantidade)
                            .addComponent(lbValor)
                            .addComponent(lbData)
                            .addComponent(lbCliente)
                            .addComponent(lbStatus))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEndereco)
                        .addGap(583, 583, 583))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbStatus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProdutos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/reprovar.png"))); // NOI18N
        btConfirma.setText("Confirmar Entrega");
        btConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmaActionPerformed(evt);
            }
        });

        btCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/reprovar.png"))); // NOI18N
        btCancela.setText("Cancelar Entrega");
        btCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btConfirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancela)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancela, btConfirma});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancela, btConfirma});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelaActionPerformed
        cancelarVenda();
    }//GEN-LAST:event_btCancelaActionPerformed


	private void btConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmaActionPerformed
    	deleteFiles();
    }//GEN-LAST:event_btConfirmaActionPerformed

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        viewProduct(evt);
    }//GEN-LAST:event_tbProdutosMouseClicked


	private void viewProduct(MouseEvent evt) {
		if(evt.getClickCount() == 2) {
			if(sale.isReserved()) {
				Product product = tableModel.getElements().get(this.tbProdutos.getSelectedRow());
				new VisualizarProdutoForm(Paths.get(configuration.getReservedPath()).resolve(product.getFileName()));
			}
		}
	}


	private void deleteFiles() {
    	try {
    		sale.getProducts().forEach(prod -> {
    			DirectoryManager.deleteFile(Paths.get(configuration.getReservedPath()).resolve(prod.getFileName()));
    		});
    		controller.delivered(sale);
    		JOptionPane.showMessageDialog(this, "Entrega confirmada com sucesso!");
    	}catch (Exception e) {
    		LOG.info(e);
    		JOptionPane.showMessageDialog(this, "Erro ao confirmar!");
		}
    	this.dispose();
	} 
    
    private void cancelarVenda() {
    	try {
    	   	sale.getProducts().forEach(prod -> {
    			unreserveImage(prod);
    		});
    	   	controller.delete(sale);
    	   	JOptionPane.showMessageDialog(this, "Entrega cancelada com sucesso!");
    	}catch (FileProductNotFoundException e) {
    		LOG.info(e);
    		JOptionPane.showMessageDialog(this, "Erro ao cancelar, venda com entrega já confirmada!");
		}
    	this.dispose();
	}
    
	private void unreserveImage(Product product) {
		try {
			Path pathImage = Paths.get(configuration.getReservedPath()).resolve(product.getFileName());
			DirectoryManager.moveTo(pathImage, Paths.get(product.getDirectoryDescrition()));
		}catch (Exception e) {
			throw e;
		}
		ProductController productController = new ProductController();
		productController.cancel(product);

	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancela;
    private javax.swing.JButton btConfirma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbValor;
    private javax.swing.JTable tbProdutos;
    // End of variables declaration//GEN-END:variables
}

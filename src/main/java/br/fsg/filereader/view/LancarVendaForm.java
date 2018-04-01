package br.fsg.filereader.view;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.fsg.filereader.controller.ConfigurationController;
import br.fsg.filereader.controller.ProductController;
import br.fsg.filereader.controller.SaleController;
import br.fsg.filereader.model.Configuration;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.model.Sale;
import br.fsg.filereader.model.Sale.Builder;
import br.fsg.filereader.tablemodel.ProductTableModel;
import br.fsg.filereader.type.Money;
import br.fsg.filereader.util.DirectoryManager;

/**
 *
 * @author Fernando-Godoy
 */
public class LancarVendaForm extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(LancarVendaForm.class);
	
	private Product selected;
	private ProductTableModel tableModel = new ProductTableModel();
	private Money amount = new Money(BigDecimal.ZERO);
	private Integer quantity = 0;
	private Configuration configuration;

	public LancarVendaForm() {
        initComponents();
        initView();
        this.setTitle("Lançamento de Venda");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initView() {
        this.tbVenda.setModel(tableModel);
        this.tbVenda.updateUI();
        this.tfProduto.setEditable(false);
        lbAmount.setText(amount.getFormated());
        lbQuantity.setText(quantity.toString());
        ConfigurationController configControl = new ConfigurationController();
        configuration = configControl.findValue();
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfProduto = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenda = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbQuantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbAmount = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Cliente:");

        tfCliente.setColumns(50);

        jLabel2.setText("Cod. Produto:");

        tfProduto.setColumns(34);

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btAdd.setText("+");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btRemove.setText("-");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });

        tbVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVenda);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Quantidade:");

        lbQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQuantity.setText("100");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total:");

        lbAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAmount.setForeground(new java.awt.Color(51, 51, 255));
        lbAmount.setText("10.000,00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAmount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbQuantity, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAmount)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAdd)
                                .addGap(4, 4, 4)
                                .addComponent(btRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAdd, btRemove});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemove)
                    .addComponent(btBuscar)
                    .addComponent(btAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
       findProduct();
    }//GEN-LAST:event_btBuscarActionPerformed

	private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        addItem();
    }//GEN-LAST:event_btAddActionPerformed

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        removeItem();
    }//GEN-LAST:event_btRemoveActionPerformed

    private void tbVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendaMouseClicked
        selectItem();
    }//GEN-LAST:event_tbVendaMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        save();
    }//GEN-LAST:event_btSalvarActionPerformed

    
    private void save() {
		try {
			Sale sale = new Builder()
					.withAmount(lbAmount.getText())
					.withClient(tfCliente.getText())
					.withQuantity(lbQuantity.getText())
					.withProducts(tableModel.getElements())
					.build();
			SaleController controller = new SaleController();
			controller.save(sale);
			deleteFiles(sale.getProducts());
			JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
			this.dispose();
		} catch (Exception e) {
			LOG.info(e);
			JOptionPane.showMessageDialog(this, "Nenhum item selecionado");
		}
	}

	private void deleteFiles(List<Product> products) {
		products.forEach(prod -> {
			DirectoryManager.deleteFile(Paths.get(configuration.getReservedPath()).resolve(prod.getFileName()));
		});
	}

	private void selectItem() {
		 selected = tableModel.getElements().get(tbVenda.getSelectedRow());
	}

	private void findProduct() {
    	BuscaForm<Product> buscaForm = new BuscaForm<>(new ProductTableModel());
    	selected = buscaForm.getSelected();
    	if(selected != null) {
    		tfProduto.setText(selected.getFileName());
    	} else {
    		JOptionPane.showMessageDialog(this, "Nenhum item selecionado");
    	}
	}
    
    private void addItem() {
    	if(selected != null) {
    		reserveImage();
        	tableModel.addElement(selected);
        	this.tbVenda.setModel(tableModel);
        	this.tbVenda.updateUI();
        	this.lbQuantity.setText(++quantity + StringUtils.EMPTY);
        	this.lbAmount.setText(amount.plus(selected.getValue()).getFormated());
        	this.tfProduto.setText(StringUtils.EMPTY);
        	selected = null;
    	}else {
    		JOptionPane.showMessageDialog(this, "Nenhum item selecionado");
    	}
    }

	private void reserveImage() {
		Path pathImage = Paths.get(selected.getDirectoryDescrition()).resolve(selected.getFileName());
		ProductController productController = new ProductController();
		productController.reserve(selected);
    	DirectoryManager.moveTo(pathImage, Paths.get(configuration.getReservedPath()));
	}
	
	private void unreserveImage() {
		Path pathImage = Paths.get(configuration.getReservedPath()).resolve(selected.getFileName());
		ProductController productController = new ProductController();
		productController.provide(selected);
    	DirectoryManager.moveTo(pathImage, Paths.get(selected.getDirectoryDescrition()));
	}
    
    private void removeItem() {
    	if(selected != null) {
    		unreserveImage();
        	tableModel.removeElement(selected);
        	this.tbVenda.setModel(tableModel);
        	this.tbVenda.updateUI();
        	this.lbQuantity.setText(--quantity + StringUtils.EMPTY);
        	this.lbAmount.setText(amount.minus(selected.getValue()).getFormated());
        	this.tfProduto.setText(StringUtils.EMPTY);
        	selected = null;
    	}else {
    		JOptionPane.showMessageDialog(this, "Nenhum item selecionado");
    	}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btRemove;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAmount;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JTable tbVenda;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfProduto;
    // End of variables declaration//GEN-END:variables
	
}

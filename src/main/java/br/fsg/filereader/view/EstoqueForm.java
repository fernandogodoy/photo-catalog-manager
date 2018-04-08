package br.fsg.filereader.view;

import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.fsg.filereader.controller.ProductController;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.tablemodel.ProductTableModel;
import br.fsg.filereader.type.Money;

/**
 *
 * @author Fernando-Godoy
 */
public class EstoqueForm extends javax.swing.JDialog {

   
	private static final long serialVersionUID = 1L;
	ProductTableModel tableModel = new ProductTableModel();

	public EstoqueForm() {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Estoque");
		this.tbProdutosEstoque.setModel(tableModel);
        this.tbProdutosEstoque.updateUI();
        resertFields();
        this.setVisible(true);
    }

   
    private void resertFields() {
    	tableModel.clear();
		this.lbQuantidadeEstoque.setText("0");
		this.lbTotalEstoque.setText(new Money(BigDecimal.ZERO).getFormated());
	}


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbQuantidadeEstoque = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTotalEstoque = new javax.swing.JLabel();
        btCarregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutosEstoque = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Quantidade Produtos:");

        lbQuantidadeEstoque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuantidadeEstoque.setText("000.000");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Valor Total:");

        lbTotalEstoque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTotalEstoque.setText("R$ 1.000.000,00");

        btCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/save.png"))); // NOI18N
        btCarregar.setText("Carregar");
        btCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalEstoque, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbQuantidadeEstoque, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbQuantidadeEstoque))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbTotalEstoque))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbProdutosEstoque.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProdutosEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProdutosEstoque);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregarActionPerformed
       loadProducts();
    }//GEN-LAST:event_btCarregarActionPerformed

    private void tbProdutosEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosEstoqueMouseClicked
       viewImage(evt);
    }//GEN-LAST:event_tbProdutosEstoqueMouseClicked

    
    private void viewImage(MouseEvent evt) {
		if(evt.getClickCount() == 2) {
			Product product = this.tableModel.getElements().get(tbProdutosEstoque.getSelectedRow());
			new VisualizarProdutoForm(Paths.get(product.getDirectoryDescrition()).resolve(product.getFileName()));
		}
	}


	private void loadProducts() {
    	resertFields();
		ProductController controller = new ProductController();
		List<Product> all = controller.findAll();
		tableModel.addElements(all);
		tbProdutosEstoque.setModel(tableModel);
		tbProdutosEstoque.updateUI();
		lbQuantidadeEstoque.setText(all.size() + StringUtils.EMPTY);
		lbTotalEstoque.setText(sum(all).getFormated());
	}
    
	private Money sum(List<Product> prods) {
    	Money total = new Money();
    	prods.stream().map(Product::getValue).forEach(total::plus);
    	return total;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCarregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbQuantidadeEstoque;
    private javax.swing.JLabel lbTotalEstoque;
    private javax.swing.JTable tbProdutosEstoque;
    // End of variables declaration//GEN-END:variables
}

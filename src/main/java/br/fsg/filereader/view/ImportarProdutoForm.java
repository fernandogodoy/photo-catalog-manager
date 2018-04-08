package br.fsg.filereader.view;

import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.fsg.filereader.controller.ProductController;
import br.fsg.filereader.model.Directory;
import br.fsg.filereader.tablemodel.BuscaDirectoryTableModel;

/**
 *
 * @author Fernando-Godoy
 */
public class ImportarProdutoForm extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private static final String NAME = "Importador de Fotos";

    public ImportarProdutoForm() {
        initComponents();
        this.setModal(true);
        this.setName(NAME);
        this.setLocationRelativeTo(null);
        enableFields();
        this.setVisible(true);
    }

    private void enableFields() {
        tfProduto.setEnabled(false);
        tfNuvem.setEnabled(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfProduto = new javax.swing.JTextField();
        btBuscarLocal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfNuvem = new javax.swing.JTextField();
        btNuvem = new javax.swing.JButton();
        btImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Foto do Produto:");

        tfProduto.setColumns(50);

        btBuscarLocal.setText("Selecione");
        btBuscarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarLocalActionPerformed(evt);
            }
        });

        jLabel2.setText("Diretório Nuvem:");

        tfNuvem.setColumns(50);

        btNuvem.setText("Selecione");
        btNuvem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuvemActionPerformed(evt);
            }
        });

        btImportar.setText("Importar");
        btImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(btBuscarLocal))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfNuvem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btNuvem))))
                    .addComponent(btImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNuvem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNuvem))
                .addGap(45, 45, 45)
                .addComponent(btImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuvemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuvemActionPerformed
        findDirectory();
    }//GEN-LAST:event_btNuvemActionPerformed

    private void btImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportarActionPerformed
        importar();
    }//GEN-LAST:event_btImportarActionPerformed

	private void importar() {
		try {
			ProductController controller = new ProductController();
			controller.save(Paths.get(tfProduto.getText()), Paths.get(tfNuvem.getText()));
			JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
			this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um problema durante carregamento dos arquivos.");
		}
	}

    private void btBuscarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarLocalActionPerformed
        openFindProduct(tfProduto);
    }//GEN-LAST:event_btBuscarLocalActionPerformed

    private void findDirectory() {
    	BuscaForm<Directory> buscaForm = new BuscaForm<>(new BuscaDirectoryTableModel());
    	Directory directory = buscaForm.getSelected();
    	if(directory != null) {
    		tfNuvem.setText(directory.getDescription());
    	}
    }
    
    private void openFindProduct(JTextField textField) {
        SeletorArquivoForm seletor = new SeletorArquivoForm();
        seletor.openSeletor(textField, JFileChooser.FILES_ONLY);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarLocal;
    private javax.swing.JButton btImportar;
    private javax.swing.JButton btNuvem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfNuvem;
    private javax.swing.JTextField tfProduto;
    // End of variables declaration//GEN-END:variables
}

package br.fsg.filereader.tablemodel;

import java.time.format.DateTimeFormatter;

import br.fsg.filereader.enumerator.SearchType;
import br.fsg.filereader.model.Product;

/**
 *
 * @author Fernando-Godoy
 */
public class ProductTableModel extends GenericTableModel<Product> {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = getElements().get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return product.getId();
		case 1:
			return product.getDirectoryDescrition();
		case 2:
			return product.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		case 3:
			return product.getFormatedValue();
		}
		return product;
	}

	@Override
	public SearchType getSearchType() {
		return SearchType.PRODUCT;
	}

	@Override
	String[] getColunms() {
		return new String[] { "Código Produto", "Pasta Armazenamento", "Data de Compra", "Valor" };
	}

}

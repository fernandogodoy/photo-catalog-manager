package br.fsg.filereader.tablemodel;

import java.time.format.DateTimeFormatter;

import br.fsg.filereader.enumerator.SearchType;
import br.fsg.filereader.model.Sale;

public class SaleTableModel extends GenericTableModel<Sale> {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sale sale = getElements().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return sale.getClient();
		case 1:
			return sale.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		case 2:
			return sale.getQuantity();
		case 3:
			return sale.getAmount().getFormated();
		case 4:
			return sale.getStatus().toString();
		}
		return sale;
	}

	@Override
	public SearchType getSearchType() {
		return SearchType.SALE;
	}

	@Override
	String[] getColunms() {
		return new String[] { "Cliente", "Data", "Número Itens", "Valor", "Situaçao" };
	}

}

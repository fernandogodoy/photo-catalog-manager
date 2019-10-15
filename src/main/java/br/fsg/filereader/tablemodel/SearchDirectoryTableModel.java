package br.fsg.filereader.tablemodel;

import br.fsg.filereader.enumerator.SearchType;
import br.fsg.filereader.model.Directory;

/**
 *
 * @author Fernando-Godoy
 */
public class SearchDirectoryTableModel extends GenericTableModel<Directory> {

	private static final long serialVersionUID = 1L;

	@Override
	String[] getColunms() {
		return new String[] { "Código Identificação", "Nome diretório", "Valor" };
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Directory directory = getElements().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return directory.getId();
		case 1:
			return directory.getPath().getFileName();
		case 2:
			return directory.getValue().getFormated();
		}

		return directory;
	}

	@Override
	public SearchType getSearchType() {
		return SearchType.DIRECTORY;
	}

}

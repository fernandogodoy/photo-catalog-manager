package br.fsg.filereader.tablemodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.fsg.filereader.enumerator.SearchType;

public abstract class GenericTableModel<T> extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<T> elements = new ArrayList<>();

	public abstract SearchType getSearchType();
	abstract String[] getColunms();

	public void addElements(List<T> elements) {
		this.elements.addAll(elements);
	}

	public void addElement(T element) {
		this.elements.add(element);
	}
	
	public void removeElement(T element) {
		this.elements.remove(element);
	}
	
	public void clear() {
		this.elements.clear();
	}

	@Override
	public int getColumnCount() {
		return getColunms().length;
	}
	
	@Override
	public String getColumnName(int column) {
		return getColunms()[column];
	}

	public List<T> getElements() {
		return Collections.unmodifiableList(elements);
	}

	@Override
	public int getRowCount() {
		return elements == null ? 0 : elements.size();
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

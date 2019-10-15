package br.fsg.filereader.enumerator;

import br.fsg.filereader.model.Directory;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.model.Sale;
import br.fsg.filereader.repository.DirectoryRepositoryImpl;
import br.fsg.filereader.repository.ProductRepositoryImpl;
import br.fsg.filereader.repository.Repository;
import br.fsg.filereader.repository.SaleRepositoryImpl;
import br.fsg.filereader.tablemodel.SearchDirectoryTableModel;
import br.fsg.filereader.tablemodel.GenericTableModel;
import br.fsg.filereader.tablemodel.ProductTableModel;
import br.fsg.filereader.tablemodel.SaleTableModel;

public enum SearchType {

	DIRECTORY {
		@Override
		public GenericTableModel<Directory> getTableModel() {
			return new SearchDirectoryTableModel();
		}

		@Override
		public Repository<Directory> getRepository() {
			return new DirectoryRepositoryImpl();
		}
	},
	PRODUCT {
		@Override
		public GenericTableModel<Product> getTableModel() {
			return new ProductTableModel();
		}

		@Override
		public Repository<?> getRepository() {
			return new ProductRepositoryImpl();
		}
	},
	SALE {
		@Override
		public GenericTableModel<Sale> getTableModel() {
			return new SaleTableModel();
		}

		@Override
		public Repository<Sale> getRepository() {
			return new SaleRepositoryImpl();
		}
	};

	public abstract GenericTableModel<?> getTableModel();

	public abstract Repository<?> getRepository();

}

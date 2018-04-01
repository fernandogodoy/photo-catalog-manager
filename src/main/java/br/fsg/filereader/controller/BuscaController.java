package br.fsg.filereader.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.fsg.filereader.model.Directory;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.repository.DirectoryRepository;
import br.fsg.filereader.repository.DirectoryRepositoryImpl;
import br.fsg.filereader.repository.ProductRepository;
import br.fsg.filereader.repository.ProductRepositoryImpl;
import br.fsg.filereader.repository.Repository;

public class BuscaController {
	
	private DirectoryRepository directoryRepository = new DirectoryRepositoryImpl();
	private ProductRepository productRepository = new ProductRepositoryImpl();
	
	public List<Directory> findDirectoryByName(String texto) {
		return executeSearch(texto, directoryRepository);
	}

	public List<Product> findProductByName(String texto) {
		return executeSearch(texto, productRepository);
	}
	
	private <T> List<T> executeSearch(String texto, Repository<T> repository) {
		if(StringUtils.isBlank(texto)) {
			return repository.findAll();
		}
		return repository.findByName(texto);
	}
	
}

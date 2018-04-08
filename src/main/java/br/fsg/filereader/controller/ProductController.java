package br.fsg.filereader.controller;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import br.fsg.filereader.model.Directory;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.repository.DirectoryRepository;
import br.fsg.filereader.repository.DirectoryRepositoryImpl;
import br.fsg.filereader.repository.ProductRepository;
import br.fsg.filereader.repository.ProductRepositoryImpl;

public class ProductController {

	private ProductRepository repository = new ProductRepositoryImpl();
	private DirectoryRepository directoryRepository = new DirectoryRepositoryImpl();

	public void saveAll(Path source, Path target) {
		Directory directory = directoryRepository.findByPath(target);
		List<File> allFiles = Arrays.asList(source.toFile().listFiles());

		for (File file : allFiles) {
			UUID uuid = UUID.randomUUID();
			Product product = new Product(uuid.toString(), directory.getValue(), directory);
			repository.save(product, file);
		}
	}
        
        public void save(Path image, Path target){
            Directory directory = directoryRepository.findByPath(target);
            UUID uuid = UUID.randomUUID();
            Product product = new Product(uuid.toString(), directory.getValue(), directory);
            repository.save(product, image.toFile());
        }

	public void deleteAll() {
		repository.deleteAll();
		
	}
	
	public void delete(Product product) {
		repository.delete(product);
	}

	public void reserve(Product product) {
		product.reserve();
		repository.update(product);
	}
	
	public void provide(Product product) {
		product.provide();
		repository.update(product);
	}

	public List<Product> findAll() {
		return repository.findAll();
		
	}

	public void cancel(Product product) {
		product.cancel();
		repository.update(product);
	}

}

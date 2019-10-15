package br.fsg.filereader.repository;

import java.io.File;

import br.fsg.filereader.model.Product;

public interface ProductRepository extends Repository<Product> {

	Product findByUUID(String uuid);

	void deleteAll();

	void delete(Product product);

	void save(Product product, File file);

}

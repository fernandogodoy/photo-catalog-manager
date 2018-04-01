package br.fsg.filereader.repository;

import java.io.File;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.fsg.filereader.enumerator.Status;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.util.DirectoryManager;

public class ProductRepositoryImpl extends GenericRepository<Product> implements ProductRepository {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(ProductRepositoryImpl.class);

	@Override
	public Product findByUUID(String uuid) {
		Product product = null;

		try {
			product = getEntityManager().createQuery("FROM Product o WHERE o.uuid = :uuid", Product.class)
					.setParameter("uuid", uuid)
					.getSingleResult();
		} catch (NoResultException e) {
			LOG.info("Nenhum registro encontrado para o uuid: " + uuid, e);
		}

		return product;
	}

	@Override
	public void deleteAll() {
		List<Product> all = super.findAll();
		all.forEach(prod ->{
			super.delete(prod);
			DirectoryManager.deleteFile(prod.getDirectory().getPath().resolve(prod.getFileName()).toString());
		});

	}
	
	@Override
	public void delete(Product product) {
		LOG.info("Deleting product" + product);
		super.delete(product);
		String fileName = product.getDirectory().getPath().resolve(product.getFileName()).toString();
		DirectoryManager.deleteFile(fileName);
	}

	@Override
	public void save(Product product, File file) {
		LOG.info("Creating new product" + product);
		super.save(product);
		product = this.findByUUID(product.getUuid());
		DirectoryManager.createAndMove(file, product.getDirectory().getPath(), product.getId());
	}

	@Override
	public List<Product> findByName(String fileName) {
		return getEntityManager().createQuery("FROM Product o WHERE o.id = :fileName AND o.status = :status", Product.class)
				.setParameter("fileName", Long.valueOf(fileName))
				.setParameter("status", Status.DISPONIVEL)
				.getResultList();
	}
	
	@Override
	public List<Product> findAll() {
		return getEntityManager().createQuery("FROM Product o WHERE o.status = :status", Product.class)
				.setParameter("status", Status.DISPONIVEL)
				.getResultList();
	}

}

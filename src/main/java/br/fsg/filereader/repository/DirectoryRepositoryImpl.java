package br.fsg.filereader.repository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.fsg.filereader.exception.DirectoryExistingException;
import br.fsg.filereader.model.Directory;
import br.fsg.filereader.util.DirectoryManager;

public class DirectoryRepositoryImpl extends GenericRepository<Directory> implements DirectoryRepository {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(DirectoryRepositoryImpl.class);

	@Override
	public Directory findByPath(Path target) {
		String path = target.toString();
		Directory directory = null;

		try {
			directory = getEntityManager()
					.createQuery("FROM Directory o WHERE o.description = :description ORDER BY o.id", Directory.class)
					.setParameter("description", path)
					.getSingleResult();

		} catch (NoResultException e) {
			LOG.info("Nenhum Registro encontrado", e);
		}
		return directory;
	}

	@Override
	public void save(Directory directory) {
		Directory directoryFinded = findByPath(Paths.get(directory.getDescription()));
		if (directoryFinded != null) {
			throw new DirectoryExistingException();
		}
		super.save(directory);
		DirectoryManager.createFolder(Paths.get(directory.getDescription()));
		LOG.info("New directory has created: " + directory.getDescription());
	}

	@Override
	public void deleteAll() {
		this.findAll().forEach(dir ->{
			super.delete(dir);
			DirectoryManager.deleteFile(dir.getDescription());
		});
	}

	@Override
	public void delete(Path path) {
		Directory directory = findByPath(path);
		super.delete(directory);
		DirectoryManager.deleteFile(directory.getDescription());
	}

	@Override
	public List<Directory> findByName(String description) {
		return getEntityManager().createQuery("FROM Directory o WHERE o.description = :description", Directory.class)
				.setParameter("description", description)
				.getResultList();
	}
}

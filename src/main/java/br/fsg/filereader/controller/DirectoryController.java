package br.fsg.filereader.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import br.fsg.filereader.model.Directory;
import br.fsg.filereader.repository.DirectoryRepository;
import br.fsg.filereader.repository.DirectoryRepositoryImpl;
import br.fsg.filereader.type.Money;

/**
 *
 * @author Fernando-Godoy
 */
public class DirectoryController {

    private final DirectoryRepository repository = new DirectoryRepositoryImpl();

    public void salvar(Path path, String fileName, String valor) {
        Directory directory = new Directory();
        directory.withDescrition(path, fileName).withValue(new Money(valor));
        repository.save(directory);
    }

	public void deleteAll() {
		repository.deleteAll();
	}
	
	public void delete(String path) {
		repository.delete(Paths.get(path));
	}

}

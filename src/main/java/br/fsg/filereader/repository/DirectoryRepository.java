package br.fsg.filereader.repository;

import java.nio.file.Path;

import br.fsg.filereader.model.Directory;

public interface DirectoryRepository extends Repository<Directory> {

	Directory findByPath(Path target);

	void deleteAll();
	
	void delete(Path path);
	
}

package br.fsg.filereader.repository;

import java.util.List;

import br.fsg.filereader.model.Configuration;

public class ConfigurationRepositoryImpl extends GenericRepository<Configuration> implements ConfigurationRepository {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Configuration> findByName(String texto) {
		throw new UnsupportedOperationException();
	}

}

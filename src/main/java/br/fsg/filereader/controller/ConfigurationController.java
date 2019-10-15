package br.fsg.filereader.controller;

import java.util.List;

import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import br.fsg.filereader.model.Configuration;
import br.fsg.filereader.repository.ConfigurationRepository;
import br.fsg.filereader.repository.ConfigurationRepositoryImpl;
import br.fsg.filereader.util.DirectoryManager;

public class ConfigurationController {

	private final ConfigurationRepository repository = new ConfigurationRepositoryImpl();

	public void save(String path) {
		Configuration configuration = new Configuration(path);
		repository.save(configuration);
		if (StringUtils.isNotBlank(configuration.getReservedPath())) {
			DirectoryManager.createFolder(configuration.getReservedPath());
		}
	}

	public Configuration findValue() {
		List<Configuration> all = repository.findAll();
		if (!all.isEmpty()) {
			return all.get(0);
		}
		return new Configuration(StringUtils.EMPTY);
	}

	public void updateDriveField(JTextField tfDrive) {
		String drivePath = StringUtils.EMPTY;
		Configuration configuration = findValue();
		if (configuration != null) {
			drivePath = configuration.getDrivePath();
		}
		tfDrive.setText(drivePath);
	}

}

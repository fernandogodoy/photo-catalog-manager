package br.fsg.filereader.model;

import java.io.Serializable;
import java.nio.file.Paths;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.StringUtils;

@Entity
@SequenceGenerator(name = "config_generator", sequenceName = "config_seq", initialValue = 1, allocationSize = 1)
public class Configuration implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "config_generator")
	private Long id;

	private String drivePath;

	public Configuration() {
	}

	public Configuration(String drivePath) {
		this.drivePath = drivePath;
	}

	public Long getId() {
		return id;
	}

	public String getDrivePath() {
		return drivePath;
	}

	public String getReservedPath() {
		return StringUtils.isNotBlank(drivePath) ? Paths.get(drivePath).resolve("reservado").toString()
				: StringUtils.EMPTY;
	}
}

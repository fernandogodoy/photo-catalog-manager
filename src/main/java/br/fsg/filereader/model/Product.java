package br.fsg.filereader.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.StringUtils;

import br.fsg.filereader.enumerator.Status;
import br.fsg.filereader.type.Money;

@Entity
@SequenceGenerator(name = "prod_generator", sequenceName = "prod_seq", initialValue = 1, allocationSize = 1)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_generator")
	private Long id;

	private String uuid;

	private Money value;

	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	private Directory directory;

	@ManyToOne
	private Sale sale;

	private LocalDate dataCompra;

	public Product() {
	}

	public Product(String uuid, Money value, Directory directory) {
		this.uuid = uuid;
		this.value = value;
		this.directory = directory;
		this.status = Status.DISPONIVEL;
		this.dataCompra = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public String getFileName() {
		return id != null ? id + ".jpg" : StringUtils.EMPTY;
	}

	public Money getValue() {
		return value;
	}

	public String getFormatedValue() {
		return value.getFormated();
	}

	public String getUuid() {
		return uuid;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isReservado() {
		return this.status == Status.RESERVADO;
	}

	public Directory getDirectory() {
		return directory;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public String getDirectoryDescrition() {
		return directory != null ? directory.getDescription() : StringUtils.EMPTY;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Override
	public String toString() {
		return "UUID: " + uuid + ", file name: " + directory.getPath().resolve(getFileName());
	}

	public void reserve() {
		this.status = Status.RESERVADO;
	}

	public void provide() {
		this.status = Status.DISPONIVEL;
	}

	public void saled() {
		this.status = Status.VENDIDO;
	}

	public void cancel() {
		this.provide();
		this.setSale(null);
	}

}

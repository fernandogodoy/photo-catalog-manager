package br.fsg.filereader.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.fsg.filereader.enumerator.Status;
import br.fsg.filereader.type.Money;

@Entity
@SequenceGenerator(name = "sale_generator", sequenceName = "sale_seq", initialValue = 1, allocationSize = 1)
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_generator")
	private Long id;

	private LocalDate date;

	private Money amount;

	private Integer quantity;

	private String client;

	private String address;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "sale", targetEntity = Product.class, cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();


	public Sale() {
		this.date = LocalDate.now();
		this.amount = Money.ZERO;
		this.quantity = 0;
		this.status = Status.RESERVADO;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Money getAmount() {
		return amount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getClient() {
		return client;
	}

	public String getAddress() {
		return address;
	}
	
	public Status getStatus() {
		return status == null ? Status.ENTREGUE : status;
	}

	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}

	public void add(Product product) {
		this.products.add(product);
		this.amount.plus(product.getValue());
		this.quantity++;
	}

	public void remove(Product product) {
		this.products.remove(product);
		this.amount.minus(product.getValue());
		this.quantity--;
	}

	public static class Builder {

		private Sale sale;

		public Builder() {
			sale = new Sale();
		}

		public Builder withAmount(String amount) {
			this.sale.amount = new Money(amount);
			return this;
		}

		public Builder withQuantity(String quantity) {
			this.sale.quantity = Integer.valueOf(quantity);
			return this;
		}

		public Builder withProducts(List<Product> products) {
			this.sale.products.addAll(products);
			products.forEach(prod -> {
				prod.setSale(sale);
				prod.saled();
			});
			return this;
		}

		public Builder withClient(String client) {
			this.sale.client = client;
			return this;
		}

		public Builder withEndereco(String endereco) {
			this.sale.address = endereco;
			return this;
		}
		
		public Builder withId(Long id) {
			this.sale.id = id;
			return this;
		}

		public Sale build() {
			return sale;
		}
	
	}

	public void clearList() {
		this.products = null;
	}

	public void delivered() {
		this.status = Status.ENTREGUE;
	}

	public boolean isDelivered() {
		return this.status == Status.ENTREGUE;
	}

	public boolean isReserved() {
		return this.status == Status.RESERVADO;
	}
}

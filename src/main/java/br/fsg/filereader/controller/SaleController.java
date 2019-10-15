package br.fsg.filereader.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.fsg.filereader.model.Sale;
import br.fsg.filereader.repository.SaleRepository;
import br.fsg.filereader.repository.SaleRepositoryImpl;

public class SaleController {

	private SaleRepository repository = new SaleRepositoryImpl();

	public void save(Sale sale) {
		if(sale.getId() != null) {
			repository.update(sale);
		}else {
			repository.save(sale);
		}
	}

	public List<Sale> findByPeriodo(String inicio, String fim) {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return repository.findbyPeriodo(LocalDate.parse(inicio, pattern), LocalDate.parse(fim, pattern));
	}

	public Sale findById(Long idVenda) {
		return repository.find(idVenda);
	}

	public void delete(Sale sale) {
		sale.clearList();
		repository.delete(sale);
	}

	public void delivered(Sale sale) {
		sale.delivered();
		repository.update(sale);
	}

}

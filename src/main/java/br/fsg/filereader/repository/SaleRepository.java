package br.fsg.filereader.repository;

import java.time.LocalDate;
import java.util.List;

import br.fsg.filereader.model.Sale;

public interface SaleRepository extends Repository<Sale> {

	List<Sale> findbyPeriodo(LocalDate parse, LocalDate parse2);

}

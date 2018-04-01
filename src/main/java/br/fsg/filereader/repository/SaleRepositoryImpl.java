package br.fsg.filereader.repository;

import java.time.LocalDate;
import java.util.List;

import br.fsg.filereader.model.Sale;

public class SaleRepositoryImpl extends GenericRepository<Sale> implements SaleRepository {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Sale> findByName(String texto) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Sale> findbyPeriodo(LocalDate init, LocalDate fim) {
		return getEntityManager().createQuery("FROM Sale o WHERE o.date BETWEEN :initialDate AND :finalDate", Sale.class)
				.setParameter("initialDate", init)
				.setParameter("finalDate", fim)
				.getResultList();
	}

}

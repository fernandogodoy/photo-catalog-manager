package br.fsg.filereader.repository.jpa;

import br.fsg.filereader.model.Sale;
import br.fsg.filereader.enumerator.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleJpaRepository extends JpaRepository<Sale, Long> {
    
    List<Sale> findByStatus(Status status);
    
    @Query("SELECT s FROM Sale s WHERE s.date BETWEEN :startDate AND :endDate")
    List<Sale> findByDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    
    List<Sale> findByClientContaining(String client);
    
    @Query("SELECT s FROM Sale s ORDER BY s.date DESC")
    List<Sale> findAllOrderByDateDesc();
}
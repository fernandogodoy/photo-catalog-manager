package br.fsg.filereader.repository.jpa;

import br.fsg.filereader.model.Product;
import br.fsg.filereader.enumerator.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    
    Optional<Product> findByUuid(String uuid);
    
    List<Product> findByStatus(Status status);
    
    @Query("SELECT p FROM Product p WHERE p.directory.id = :directoryId")
    List<Product> findByDirectoryId(@Param("directoryId") Long directoryId);
    
    @Query("SELECT p FROM Product p WHERE p.uuid LIKE %:search% OR p.directory.description LIKE %:search%")
    List<Product> findByUuidContainingOrDirectoryDescriptionContaining(@Param("search") String search);
}
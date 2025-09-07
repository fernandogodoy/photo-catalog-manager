package br.fsg.filereader.repository.jpa;

import br.fsg.filereader.model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectoryJpaRepository extends JpaRepository<Directory, Long> {
    
    @Query("SELECT d FROM Directory d WHERE d.description = :description")
    Optional<Directory> findByDescription(@Param("description") String description);
    
    List<Directory> findByDescriptionContaining(String description);
}
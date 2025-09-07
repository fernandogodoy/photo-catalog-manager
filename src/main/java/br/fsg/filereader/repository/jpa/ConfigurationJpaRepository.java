package br.fsg.filereader.repository.jpa;

import br.fsg.filereader.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationJpaRepository extends JpaRepository<Configuration, Long> {
}
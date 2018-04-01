package br.fsg.filereader.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Fernando-Godoy
 * @param <Entity>
 */
public interface Repository<Entity> extends Serializable {

	void save(Entity entity);

	Entity update(Entity entity);

	Entity find(Long id);

	List<Entity> findAll();

	void delete(Entity entity);

	void delete(Long id);

	List<Entity> findByName(String texto);

}

package br.fsg.filereader.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.fsg.filereader.util.PersistenceManager;

/**
 *
 * @author Fernando-Godoy
 * 
 * @param <Entity>
 */
public abstract class GenericRepository<Entity extends Serializable> implements Repository<Entity> {

	private static final long serialVersionUID = 1L;

	private final EntityManager entityManager = PersistenceManager.getEntityManager();

	@SuppressWarnings("unchecked")
	private final Class<Entity> clazz = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	private EntityTransaction getTransaction() {
		return entityManager.getTransaction();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void save(Entity entity) {
		getTransaction().begin();
		getEntityManager().persist(entity);
		getTransaction().commit();
	}

	@Override
	public Entity update(Entity entity) {
		getTransaction().begin();
		entity = getEntityManager().merge(entity);
		getTransaction().commit();
		return entity;
	}

	@Override
	public Entity find(Long id) {
		return getEntityManager().find(clazz, id);
	}

	@Override
	public List<Entity> findAll() {
		TypedQuery<Entity> q = getEntityManager().createQuery(" FROM " + clazz.getSimpleName(), clazz);
		return q.getResultList();
	}

	@Override
	public void delete(Entity entity) {
		getTransaction().begin();
		getEntityManager().remove(entity);
		getTransaction().commit();
	}

	@Override
	public void delete(Long id) {
		Entity entity = find(id);
		delete(entity);
	}

}

package gui.projetosemestral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDao<T, ID> {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private Class<T> persistedClass;

	public GenericDao(Class<T> persistedClass, String persistenceUnit) {
		this.persistedClass = persistedClass;
		factory = Persistence.createEntityManagerFactory(persistenceUnit);
	}

	public void cadastrar(T t) {
		manager = factory.createEntityManager();

		EntityTransaction trasaction = manager.getTransaction();
		trasaction.begin();
		manager.persist(t);
		manager.flush();
		trasaction.commit();

		manager.close();
	}

	public List<T> procurarTodos() {
		manager = factory.createEntityManager();

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		List<T> resultado = manager.createQuery(query).getResultList();

		manager.close();
		return resultado;
	}
	
	public void deletarPorId(ID id) {
		manager = factory.createEntityManager();
		
		EntityTransaction trasaction = manager.getTransaction();
		trasaction.begin();
		T t = manager.find(persistedClass, id);
		manager.remove(t);
		manager.flush();
		trasaction.commit();
		
		manager.close();
	}
	
	public void atualizar(T t) {
		manager = factory.createEntityManager();
		
		EntityTransaction trasaction = manager.getTransaction();
		trasaction.begin();
		manager.merge(t);
		manager.flush();
		trasaction.commit();
		
		manager.close();
	}
	
	public T findById(ID id) {
		return manager.find(persistedClass, id);
	}

}

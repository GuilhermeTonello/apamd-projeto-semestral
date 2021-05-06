package gui.projetosemestral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDao<T> {

	private EntityManagerFactory factory;
	private EntityManager manager;
	private Class<T> persistedClass;
	private String persistenceUnit;

	public GenericDao(Class<T> persistedClass, String persistenceUnit) {
		this.persistedClass = persistedClass;
		this.persistenceUnit = persistenceUnit;
	}

	public void cadastrar(T t) {
		factory = Persistence.createEntityManagerFactory(persistenceUnit);
		manager = factory.createEntityManager();

		EntityTransaction trasaction = manager.getTransaction();
		trasaction.begin();
		manager.merge(t);
		manager.flush();
		trasaction.commit();

		manager.close();
		factory.close();
	}

	public List<T> procurarTodos() {
		factory = Persistence.createEntityManagerFactory(persistenceUnit);
		manager = factory.createEntityManager();

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		List<T> resultado = manager.createQuery(query).getResultList();

		manager.close();
		factory.close();
		return resultado;
	}

}

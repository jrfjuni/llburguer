package br.com.entelgy.burguer.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author JUNNIOR
 *
 */
@Transactional
public class BaseDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Session getHibernateSession() {
		return (Session) getEntityManager().getDelegate();
	}
	
	public void update(Object entity) {
		getHibernateSession().merge(entity);
	}
	
	public void insert(Object entity) {
		getHibernateSession().save(entity);
	}
	
	public void setParam(Query query, Map<String, Object> param) {
		for (Map.Entry<String, Object> entry : param.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
}
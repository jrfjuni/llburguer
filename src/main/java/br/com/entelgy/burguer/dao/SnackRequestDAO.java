package br.com.entelgy.burguer.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.entelgy.burguer.entity.SnackRequest;
import br.com.entelgy.burguer.entity.vo.SnackRequestVO;

@Repository
public class SnackRequestDAO extends BaseDAO{
	
	public SnackRequestVO findById(Integer id) {
		
		StringBuilder hql = new StringBuilder();
		
		hql.append(" SELECT NEW ")
		   .append(SnackRequestVO.class.getCanonicalName())
		   .append(" (snr) ")
		   .append(" FROM ")
		   .append(SnackRequest.class.getCanonicalName())
		   .append(" snr ")
		   .append(" WHERE snr.id = :id ");
		
		Query query = getHibernateSession().createQuery(hql.toString());
		query.setParameter("id", id);
		
		return (SnackRequestVO) query.uniqueResult();
	}
}
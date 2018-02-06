package br.com.entelgy.burguer.dao;

import org.hibernate.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.entelgy.burguer.entity.UserSystem;
import br.com.entelgy.burguer.entity.vo.UserVO;

@Repository
public class LoginDAO extends BaseDAO{

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		StringBuilder hql = new StringBuilder();
		
	   hql.append(" SELECT NEW ")
		  .append(UserVO.class.getCanonicalName())
		  .append(" (cli) ")
		  .append(" FROM ")
		  .append(UserSystem.class.getCanonicalName())
		  .append(" cli ")
		  .append(" WHERE cli.email = :email ");
		
		Query query = getHibernateSession().createQuery(hql.toString());
		query.setParameter("email", email);
		
		return (UserVO) query.uniqueResult();
	}
}
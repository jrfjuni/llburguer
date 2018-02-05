package br.com.entelgy.burguer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.entelgy.burguer.entity.CustomField;
import br.com.entelgy.burguer.entity.vo.CustomFieldVO;
import br.com.entelgy.burguer.search.SearchCustomField;

@Repository
public class CustomFieldDAO extends BaseDAO{
	
	public CustomFieldVO findById(Integer id) {
		StringBuilder hql = new StringBuilder();
		
		hql.append(" SELECT NEW ")
		   .append(CustomFieldVO.class.getCanonicalName())
		   .append(" (cft) ")
		   .append(" FROM ")
		   .append(CustomField.class.getCanonicalName())
		   .append(" cft ")
		   .append(" JOIN cft.language lng ")
		   .append(" WHERE cft.id = :id ");
		
		Query query = getHibernateSession().createQuery(hql.toString());
		query.setParameter("id", id);
		
		return (CustomFieldVO) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomFieldVO> findCustomField(SearchCustomField search){
		StringBuilder hql = new StringBuilder();
		Map<String, Object> params = new HashMap<String, Object>();
		
		hql.append(" SELECT NEW ")
		   .append(CustomFieldVO.class.getCanonicalName())
		   .append(" (cft.id, cft.customFieldValue, cft.customFieldDecimal) ")
		   .append(" FROM ")
		   .append(CustomField.class.getCanonicalName())
		   .append(" cft ")
		   .append(" JOIN cft.language lng ")
		   .append(" WHERE 1 = 1 ");
		
		if(search.getCustomField() != null) {
			hql.append(" AND cft.customField = :customField ");
			params.put("customField", search.getCustomField().getCustomField());
		}
		
		if(!StringUtils.isEmpty(search.getLang())) {
			hql.append(" AND lng.lang = :lang ");
			params.put("lang", search.getLang());
		}
		
		Query query = getHibernateSession().createQuery(hql.toString());
		setParam(query, params);
		
		return (List<CustomFieldVO>) query.list();
	}
}
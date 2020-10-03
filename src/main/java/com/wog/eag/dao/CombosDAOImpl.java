package com.wog.eag.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wog.eag.model.Combo;


@Repository
@Transactional
public class CombosDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Combo> getRefList ( Long adReferenceId, String language ) {
		
		String sql = "SELECT td0.value AS id, ( COALESCE(td_trl0.name, td0.name)) AS NAME, (CASE WHEN td_trl0.description IS NULL THEN td0.description ELSE td_trl0.description END) AS DESCRIPTION"+ 
			     " FROM ad_ref_list td0 left join ad_ref_list_trl td_trl0 on ( td0.ad_ref_list_id = td_trl0.ad_ref_list_id and td_trl0.AD_LANGUAGE = :language  )"+ 
			     " WHERE td0.ad_reference_id = :id AND (td0.isActive = 'Y') ORDER BY (CASE WHEN td_trl0.name IS NULL THEN td0.name ELSE td_trl0.name END)";

		@SuppressWarnings("unchecked")
		List<Combo> lista = sessionFactory.getCurrentSession().createNativeQuery( sql )
				.addEntity(Combo.class)
				.setParameter("id", adReferenceId)
				.setParameter("language", language)
				.list();
		
		 return lista;
	}
	
}
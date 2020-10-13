package com.wog.eag.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wog.eag.model.Combo;
import com.wog.eag.utils.SpecialSymbolsResolver;


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
	
	 public List<Combo> getAdTableId100277(BigDecimal adClientId, BigDecimal adOrgId, String param1 ){
			try {

				String sql = "SELECT td0.AD_Table_ID AS ID, (COALESCE( (td0.TableName), '' ) [SQL_CS] ' - ' [SQL_CS] COALESCE( (td0.Name), '' )) AS NAME, '' AS DESCRIPTION"+ 
					     " FROM AD_Table td0"+ 
					     " WHERE td0.AD_Client_ID IN ( 0, :adClientId ) AND td0.AD_Org_ID IN ( 0, :adOrgId ) AND td0.AD_MODULE_ID IN ( SELECT AD_MODULE_ID FROM AD_MODULE WHERE AD_APPLICATION_ID IN ( :param1, 0 ) ) AND (td0.isActive = 'Y' ) ORDER BY 2";
				
			    @SuppressWarnings("unchecked")
				List<Combo> lista = sessionFactory.getCurrentSession().createNativeQuery( SpecialSymbolsResolver.resolveStatement(sql) )
						.addEntity(Combo.class)
						.setParameter("adClientId", adClientId)
						.setParameter("adOrgId", adOrgId)
						.setParameter("param1", param1)
						.list();
			    return lista;
			} catch (Exception e) {
			    e.printStackTrace();
			    return new ArrayList<Combo>();
			}
	 }
	 
	 public List<Combo> getAdToolbarbuttonId(BigDecimal adClientId, BigDecimal adOrgId ){
			try {

				String sql = "SELECT td0.AD_Toolbarbutton_ID AS ID, (COALESCE( (td1.Name), '' ) [SQL_CS] ' - ' [SQL_CS] COALESCE( (td0.Name), '' )) AS NAME, '' AS DESCRIPTION"+ 
					     " FROM AD_Toolbarbutton td0 left join ad_application td1 on td0.AD_Application_ID = td1.AD_Application_ID"+ 
					     " AND td1.AD_Client_ID IN ( 0, :adClientId ) AND td1.AD_Org_ID IN (  0, :adOrgId )"+ 
					     " WHERE td0.AD_Client_ID IN ( 0, :adClientId ) AND td0.AD_Org_ID IN ( 0, :adOrgId ) AND (td0.isActive = 'Y' ) ORDER BY 2";
				
			    @SuppressWarnings("unchecked")
				List<Combo> lista = sessionFactory.getCurrentSession().createNativeQuery( SpecialSymbolsResolver.resolveStatement(sql) )
						.addEntity(Combo.class)
						.setParameter("adClientId", adClientId)
						.setParameter("adOrgId", adOrgId)
						.list();
			    return lista;
			} catch (Exception e) {
			    e.printStackTrace();
			    return new ArrayList<Combo>();
			}
	 }
	 
}
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
	
	 public List getAdTableId100277(BigDecimal adClientId, BigDecimal adOrgId, String param1 ){
			String sql = "SELECT td0.AD_Table_ID AS ID, (COALESCE( (td0.TableName), '' ) [SQL_CS] ' - ' [SQL_CS] COALESCE( (td0.Name), '' )) AS NAME, '' AS DESCRIPTION"+ 
				     " FROM AD_Table td0"+ 
				     " WHERE td0.AD_Client_ID IN ( 0, :adClientId ) AND td0.AD_Org_ID IN ( 0, :adOrgId ) AND td0.AD_MODULE_ID IN ( SELECT AD_MODULE_ID FROM AD_MODULE WHERE AD_APPLICATION_ID IN ( :param1, 0 ) ) AND (td0.isActive = 'Y' ) ORDER BY 2";
			
//			String[] clientParams = clientList.split(",");
//			String[] orgParams = orgList.split(",");
//			List paramValues = new ArrayList();
//			String paramsSql = "";
//			for (String client : clientParams) {
//				paramsSql += "?";
//				if (StringUtils.isBlank(paramsSql))  {
//					paramsSql += "?";
//				}else {
//					paramsSql += ",?";
//				}
//				paramValues.add(client);
//			}
//			sql.replace("@AD_CLIENT_IDS@", paramsSql);
//			
//			paramsSql = "";
//			for (String org : orgParams) {
//				paramsSql += "?";
//				if (StringUtils.isBlank(paramsSql))  {
//					paramsSql += "?";
//				}else {
//					paramsSql += ",?";
//				}
//				paramValues.add(org);
//			}
//			sql.replace("@AD_ORG_IDS@", paramsSql);
//			
//			Object[] params = paramValues.toArray();
			
			
//			if( aditionalWhere != null && aditionalWhere.length() > 0 ){
//			    StringBuilder __temp = new StringBuilder( sql.substring( 0 , sql.indexOf( "ORDER BY" ) ) );
//			    __temp.append( " " ).append( aditionalWhere ).append( " " );
//			    __temp.append( sql.substring( sql.indexOf( "ORDER BY" ) ) );
//			    sql = __temp.toString( ); 
//			}
			try {

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
			    return new ArrayList();
			}
	 }
	 
}
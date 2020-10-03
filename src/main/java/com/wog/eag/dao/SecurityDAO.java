package com.wog.eag.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wog.eag.model.UsuarioPrincipal;


@Repository
@Transactional
public class SecurityDAO {

	public static final String DEF_USERS_BY_USERNAME_QUERY = "SELECT u.AD_USER_ID,u.PASSWORD, c.ISO_CODE, u.LASTNAME, u.FIRSTNAME, u.USERNAME, u.NAME, u.LASTLOGIN, u.C_BPARTNER_ID, u.C_BPARTNER_LOCATION_ID, u.BPARTNER_TYPE, u.SUPERVISOR_ID,"
		    + "u.INTERNAL_USER, u.EMAIL, u.AMTAPPROVAL, COALESCE(d.DEFAULT_AD_ROLE_ID, -1) AS DEFAULT_AD_ROLE_ID, COALESCE(d.DEFAULT_AD_ORG_ID, -1) AS DEFAULT_AD_ORG_ID, "
		    + "COALESCE(d.DEFAULT_AD_CLIENT_ID, -1) AS DEFAULT_AD_CLIENT_ID, b.C_BP_GROUP_ID, b.URL, b2.C_CURRENCY_ID, b2.URL as URL_ORG, bl.AD_ORG_LOCATION_ID, bl.C_COUNTRY_ID, "
		    + "bl.C_REGION_ID, bl.C_CITY_ID, bl.AD_LOCATION_TYPE, c.C_CURRENCY_ID AS USUARIOCURRENCY, cbl.NAME AS NOMBRESUCURSAL, APP.AD_APPLICATION_ID, "
		    + "COALESCE(d.DEFAULT_AD_LANGUAGE , COALESCE(u.DEFAULT_AD_LANGUAGE , COALESCE(b.AD_LANGUAGE , COALESCE(cl.AD_LANGUAGE , 'es_CO'  )  )  )  ) AS DEFAULT_AD_LANGUAGE, "
		    + "u.EMAILUSERPW, b2.C_BPARTNER_ID AS SOCIO_DIRECTO, u.CU_CUSTUMERMASTER_ID, u.IDENTIFICATION_TYPE, u.IDENTIFICATION, bl.NAME as NOMBREPTOVENTA "
		    + "FROM AD_USER u "
		    + "INNER JOIN ( SELECT AD_APPLICATION_ID, CODE_APPLICATION FROM AD_APPLICATION ) APP "
		    + "ON (APP.CODE_APPLICATION = :codeApplication ) "
		    + "LEFT  JOIN ( SELECT C_CURRENCY_ID, ISO_CODE FROM C_CURRENCY ) c "
		    + "ON (u.C_CURRENCY_ID=c.C_CURRENCY_ID) "
		    + "LEFT  JOIN ( SELECT AD_USER_ID, AD_APPLICATION_ID, DEFAULT_AD_LANGUAGE, DEFAULT_AD_ROLE_ID, DEFAULT_AD_ORG_ID, DEFAULT_AD_CLIENT_ID  FROM AD_USER_DEFAULT_APP ) d "
		    + "ON (u.AD_USER_ID = d.AD_USER_ID and APP.AD_APPLICATION_ID = d.AD_APPLICATION_ID ) "
		    + "LEFT  JOIN ( SELECT C_BPARTNER_ID, C_BP_GROUP_ID, AD_LANGUAGE, URL FROM C_BPARTNER ) b "
		    + "ON (u.C_BPARTNER_ID = b.C_BPARTNER_ID) "
		    + "LEFT  JOIN ( SELECT C_BPARTNER_ID, BPARTNER_TYPE, AD_ORG_ID, C_CURRENCY_ID, URL FROM C_BPARTNER WHERE BPARTNER_TYPE = '000' ) b2 "
		    + "ON (d.DEFAULT_AD_ORG_ID = b2.AD_ORG_ID ) "
		    + "LEFT  JOIN ( SELECT C_BPARTNER_LOCATION_ID, C_BPARTNER_ID, AD_ORG_LOCATION_ID, C_COUNTRY_ID, C_REGION_ID, C_CITY_ID, AD_LOCATION_TYPE, NAME FROM C_BPARTNER_LOCATION ) bl "
		    + "ON (u.C_BPARTNER_LOCATION_ID = bl.C_BPARTNER_LOCATION_ID) "
		    + "LEFT  JOIN ( SELECT C_BPARTNER_LOCATION_ID, NAME FROM C_BPARTNER_LOCATION ) cbl "
		    + "ON (bl.AD_ORG_LOCATION_ID = cbl.C_BPARTNER_LOCATION_ID) " 
		    + "LEFT  JOIN ( SELECT AD_CLIENT_ID, AD_LANGUAGE  FROM AD_CLIENT ) cl "
		    + "ON (cl.AD_CLIENT_ID = d.DEFAULT_AD_CLIENT_ID) " 
		    + "WHERE USERNAME = :username ";
	        
		public static final String CHECK_STATUS_DEFAULT_USER_CONFIG_QUERY = " SELECT Q2.ISACTIVE AS USER_ACTIVE, Q4.ISACTIVE AS ROLE_ACTIVE, " +
				"Q5.ISACTIVE AS CLIENT_ACTIVE, Q6.ISACTIVE AS ORG_ACTIVE, Q7.ISACTIVE AS BPARTNER_ACTIVE, Q8.ISACTIVE AS BPARTNER_LOC_ACTIVE " +
				"FROM AD_APPLICATION Q1, AD_USER Q2, AD_USER_DEFAULT_APP Q3, AD_ROLE Q4, " +
				"AD_CLIENT Q5, AD_ORG Q6, C_BPARTNER Q7, C_BPARTNER_LOCATION Q8 " +
				"WHERE (Q2.AD_USER_ID = ?) AND (Q1.CODE_APPLICATION = ?) AND (Q3.AD_USER_ID = ?) AND (Q1.AD_APPLICATION_ID = Q3.AD_APPLICATION_ID) AND " +
				"(Q3.DEFAULT_AD_ROLE_ID = Q4.AD_ROLE_ID) AND (Q3.DEFAULT_AD_CLIENT_ID = Q5.AD_CLIENT_ID) AND " +
				"(Q3.DEFAULT_AD_ORG_ID = Q6.AD_ORG_ID) AND (Q2.C_BPARTNER_ID = Q7.C_BPARTNER_ID) AND " +
				"(Q2.C_BPARTNER_LOCATION_ID  = Q8.C_BPARTNER_LOCATION_ID)";    

	    public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = "select AD_USER_ID, 'ROLE_SUPERVISOR' as authority from AD_USER where AD_USER_ID = ?";
	    
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public UsuarioPrincipal getUserInfoByUsernameByCodeApp ( String username, String codeApplication) {
		
		@SuppressWarnings("deprecation")
		UsuarioPrincipal usuarioPrincipal= (UsuarioPrincipal)sessionFactory.getCurrentSession().createNativeQuery( DEF_USERS_BY_USERNAME_QUERY )
				.setParameter("codeApplication", codeApplication)
				.setParameter("username", username)
				.setResultTransformer( 
					new ResultTransformer() {
						@Override
						public Object transformTuple(Object[] tuple, String[] aliases) {
							 Transformers.aliasToBean( UsuarioPrincipal.class );
							UsuarioPrincipal usuario = new UsuarioPrincipal();
							
							usuario.setAdUserId((BigDecimal)tuple[0]);
							usuario.setPassword((String)tuple[1]);
							usuario.setIsoCode((String)tuple[2]);
							usuario.setLastname((String)tuple[3]);
							usuario.setFirstname((String)tuple[4]);
							usuario.setUsername((String)tuple[5]);
							usuario.setName((String)tuple[6]);
							usuario.setLastlogin((Timestamp)tuple[7]);
							usuario.setcBpartnerId((BigDecimal)tuple[8]);
							usuario.setcBpartnerLocationId((BigDecimal)tuple[9]);
							usuario.setBpartnerType((String)tuple[10]);
							usuario.setSupervisorId((BigDecimal)tuple[11]);
							usuario.setInternalUser(((Character)tuple[12]).toString());
							usuario.setEmail((String)tuple[13]);
							usuario.setAmtapproval((String)tuple[14]);
							usuario.setDefaultAdRoleId((BigDecimal)tuple[15]);
							usuario.setDefaultAdOrgId((BigDecimal)tuple[16]); 
							usuario.setDefaultAdClientId((BigDecimal)tuple[17]);
							usuario.setcBpGroupId((BigDecimal)tuple[18]);
							usuario.setUrl((String)tuple[19]);
							usuario.setcCurrencyId((BigDecimal)tuple[20]);
							usuario.setUrlOrg((String)tuple[21]);
							usuario.setAdOrgLocationId((BigDecimal)tuple[22]);
							usuario.setcCountryId((BigDecimal)tuple[23]);
							usuario.setcRegionId((BigDecimal)tuple[24]);
							usuario.setcCityId((BigDecimal)tuple[25]);
							usuario.setAdLocationType(((Character)tuple[26]).toString());
							usuario.setUsuariocurrency((String)tuple[27]);
							usuario.setNombresucursal((String)tuple[28]);
							usuario.setAdApplicationId((BigDecimal)tuple[29]);
							usuario.setDefaultAdLanguage((String)tuple[30]); 
							usuario.setEmailuserpw((String)tuple[31]);
							usuario.setSocioDirecto((BigDecimal)tuple[32]);
							usuario.setCuCustumermasterId((BigDecimal)tuple[33]);
							usuario.setIdentificationType((String)tuple[34]);
							usuario.setIdentification((String)tuple[35]);
							usuario.setNombreptoventa((String)tuple[35]); 
							return usuario;
						}
						
						@Override
						public List transformList(List collection) {
							return collection;
						}
					}
				)
				.getSingleResult() ;
		
		 return usuarioPrincipal;
	}
	
	

	
}

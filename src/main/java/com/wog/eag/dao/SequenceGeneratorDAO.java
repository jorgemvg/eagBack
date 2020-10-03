package com.wog.eag.dao;

import java.math.BigDecimal;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SequenceGeneratorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public BigDecimal getSequence ( String sequenceName, BigDecimal clientId ) {
		
		StoredProcedureQuery query = sessionFactory.getCurrentSession().createStoredProcedureQuery("AD_SEQUENCE_NEXT2")
			    .registerStoredProcedureParameter( "PV_SEQUENCE_NAME", String.class, ParameterMode.IN)
			    .registerStoredProcedureParameter( "PD_AD_CLIENT_ID", BigDecimal.class, ParameterMode.IN)
			    .registerStoredProcedureParameter( "OV_NEXT_NO", BigDecimal.class, ParameterMode.OUT)
			    .setParameter("PV_SEQUENCE_NAME", sequenceName)
			    .setParameter("PD_AD_CLIENT_ID", clientId);

		query.execute();

		BigDecimal sequence = (BigDecimal) query.getOutputParameterValue("OV_NEXT_NO");
		System.out.println(sequence);
		return sequence;
		
	}
	
}
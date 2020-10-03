package com.wog.eag.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wog.eag.dao.SequenceGeneratorDAO;

@Service
public class SequenceGeneratorService {

	@Autowired
	private SequenceGeneratorDAO sequenceGeneratorDAO;
	
	@Transactional
	public BigDecimal getSequence( String sequenceName, BigDecimal adClientId ) {
		
		return sequenceGeneratorDAO.getSequence( sequenceName, adClientId );
		
	}
}

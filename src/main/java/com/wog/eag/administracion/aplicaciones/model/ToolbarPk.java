package com.wog.eag.administracion.aplicaciones.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Objects;

public class ToolbarPk implements Serializable {

	private BigDecimal adToolbarbuttonId;
	private BigDecimal adTabToolbarId;

	public ToolbarPk() {}

	public ToolbarPk(BigDecimal adToolbarbuttonId,BigDecimal adTabToolbarId	) {
			this.adToolbarbuttonId = adToolbarbuttonId;
			this.adTabToolbarId = adTabToolbarId;
	}

	@Override
    public int hashCode() {
        return Objects.hash(adToolbarbuttonId,adTabToolbarId);
    }
    
	public BigDecimal getAdToolbarbuttonId() {
		return adToolbarbuttonId;
	}

	public void setAdToolbarbuttonId(BigDecimal adToolbarbuttonId) {
		this.adToolbarbuttonId = adToolbarbuttonId;
	}
	public BigDecimal getAdTabToolbarId() {
		return adTabToolbarId;
	}

	public void setAdTabToolbarId(BigDecimal adTabToolbarId) {
		this.adTabToolbarId = adTabToolbarId;
	}
    
}
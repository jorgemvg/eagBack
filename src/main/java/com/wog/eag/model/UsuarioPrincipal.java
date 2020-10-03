package com.wog.eag.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails{

	private static final long serialVersionUID = 1L;

	public UsuarioPrincipal() {
	}
	
	private Usuario user;
	 
    public UsuarioPrincipal(Usuario user) {
        this.user = user;
    }
    
    private String password;
    private String username;
    
    private BigDecimal adUserId;
    private String isoCode;
    private String lastname;
    private String firstname;
    private String name;
    private Timestamp lastlogin;
    private BigDecimal cBpartnerId;
    private BigDecimal cBpartnerLocationId;
    private String bpartnerType;
    private BigDecimal supervisorId;
    private String internalUser;
    private String email;
    private String amtapproval;
    private BigDecimal defaultAdRoleId;
    private BigDecimal defaultAdOrgId;
    private BigDecimal defaultAdClientId;
    private BigDecimal cBpGroupId;
    private String url;
    private BigDecimal cCurrencyId;
    private String urlOrg;
    private BigDecimal adOrgLocationId;
    private BigDecimal cCountryId;
    private BigDecimal cRegionId;
    private BigDecimal cCityId;
    private String adLocationType;
    private String usuariocurrency;
    private String nombresucursal;
    private BigDecimal adApplicationId;
    private String defaultAdLanguage; 
    private String emailuserpw;
    private BigDecimal socioDirecto;
    private BigDecimal cuCustumermasterId;
    private String identificationType;
    private String identification;
    private String nombreptoventa; 
    
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Validar al consultar el usuario si la cuenta no ha expirado. Por ahora mandamos true, para que se pueda loguear
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Validar al consultar el usuario si la cuenta no esta bloqueadad. Por ahora mandamos true, para que se pueda loguear
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Validar al consultar el usuario si el password no ha expirado. Por ahora mandamos true, para que se pueda loguear
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Validar al consultar el usuario esta activo. Por ahora mandamos true, para que se pueda loguear
		return true;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public BigDecimal getAdUserId() {
		return adUserId;
	}

	public void setAdUserId(BigDecimal adUserId) {
		this.adUserId = adUserId;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public BigDecimal getcBpartnerId() {
		return cBpartnerId;
	}

	public void setcBpartnerId(BigDecimal cBpartnerId) {
		this.cBpartnerId = cBpartnerId;
	}

	public BigDecimal getcBpartnerLocationId() {
		return cBpartnerLocationId;
	}

	public void setcBpartnerLocationId(BigDecimal cBpartnerLocationId) {
		this.cBpartnerLocationId = cBpartnerLocationId;
	}

	public String getBpartnerType() {
		return bpartnerType;
	}

	public void setBpartnerType(String bpartnerType) {
		this.bpartnerType = bpartnerType;
	}

	public BigDecimal getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(BigDecimal supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getInternalUser() {
		return internalUser;
	}

	public void setInternalUser(String internalUser) {
		this.internalUser = internalUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAmtapproval() {
		return amtapproval;
	}

	public void setAmtapproval(String amtapproval) {
		this.amtapproval = amtapproval;
	}

	public BigDecimal getDefaultAdRoleId() {
		return defaultAdRoleId;
	}

	public void setDefaultAdRoleId(BigDecimal defaultAdRoleId) {
		this.defaultAdRoleId = defaultAdRoleId;
	}

	public BigDecimal getDefaultAdOrgId() {
		return defaultAdOrgId;
	}

	public void setDefaultAdOrgId(BigDecimal defaultAdOrgId) {
		this.defaultAdOrgId = defaultAdOrgId;
	}

	public BigDecimal getDefaultAdClientId() {
		return defaultAdClientId;
	}

	public void setDefaultAdClientId(BigDecimal defaultAdClientId) {
		this.defaultAdClientId = defaultAdClientId;
	}

	public BigDecimal getcBpGroupId() {
		return cBpGroupId;
	}

	public void setcBpGroupId(BigDecimal cBpGroupId) {
		this.cBpGroupId = cBpGroupId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getcCurrencyId() {
		return cCurrencyId;
	}

	public void setcCurrencyId(BigDecimal cCurrencyId) {
		this.cCurrencyId = cCurrencyId;
	}

	public String getUrlOrg() {
		return urlOrg;
	}

	public void setUrlOrg(String urlOrg) {
		this.urlOrg = urlOrg;
	}

	public BigDecimal getAdOrgLocationId() {
		return adOrgLocationId;
	}

	public void setAdOrgLocationId(BigDecimal adOrgLocationId) {
		this.adOrgLocationId = adOrgLocationId;
	}

	public BigDecimal getcCountryId() {
		return cCountryId;
	}

	public void setcCountryId(BigDecimal cCountryId) {
		this.cCountryId = cCountryId;
	}

	public BigDecimal getcRegionId() {
		return cRegionId;
	}

	public void setcRegionId(BigDecimal cRegionId) {
		this.cRegionId = cRegionId;
	}

	public BigDecimal getcCityId() {
		return cCityId;
	}

	public void setcCityId(BigDecimal cCityId) {
		this.cCityId = cCityId;
	}

	public String getAdLocationType() {
		return adLocationType;
	}

	public void setAdLocationType(String adLocationType) {
		this.adLocationType = adLocationType;
	}

	public String getUsuariocurrency() {
		return usuariocurrency;
	}

	public void setUsuariocurrency(String usuariocurrency) {
		this.usuariocurrency = usuariocurrency;
	}

	public String getNombresucursal() {
		return nombresucursal;
	}

	public void setNombresucursal(String nombresucursal) {
		this.nombresucursal = nombresucursal;
	}

	public BigDecimal getAdApplicationId() {
		return adApplicationId;
	}

	public void setAdApplicationId(BigDecimal adApplicationId) {
		this.adApplicationId = adApplicationId;
	}

	public String getDefaultAdLanguage() {
		return defaultAdLanguage;
	}

	public void setDefaultAdLanguage(String defaultAdLanguage) {
		this.defaultAdLanguage = defaultAdLanguage;
	}

	public String getEmailuserpw() {
		return emailuserpw;
	}

	public void setEmailuserpw(String emailuserpw) {
		this.emailuserpw = emailuserpw;
	}

	public BigDecimal getSocioDirecto() {
		return socioDirecto;
	}

	public void setSocioDirecto(BigDecimal socioDirecto) {
		this.socioDirecto = socioDirecto;
	}

	public BigDecimal getCuCustumermasterId() {
		return cuCustumermasterId;
	}

	public void setCuCustumermasterId(BigDecimal cuCustumermasterId) {
		this.cuCustumermasterId = cuCustumermasterId;
	}

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getNombreptoventa() {
		return nombreptoventa;
	}

	public void setNombreptoventa(String nombreptoventa) {
		this.nombreptoventa = nombreptoventa;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
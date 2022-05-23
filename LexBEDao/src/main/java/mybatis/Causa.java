package mybatis;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "causa")
public class Causa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	@XmlAttribute(name = "id_causa")
    private String id_causa;
	
	@XmlAttribute(name = "numeroFascicolo")
    private String numeroFascicolo;
	
	@XmlAttribute(name = "id_fascicolo")
    private String id_fascicolo;
	
	@XmlAttribute(name = "prog_causa")
    private String prog_causa;
	
	@XmlAttribute(name = "categoria_cause")
    private String categoria_cause;
    
	@XmlAttribute(name = "dettaglio_categoria")
    private String dettaglio_categoria;
    
	@XmlAttribute(name = "progr_ufficio")
    private String progr_ufficio;
    
	@XmlAttribute(name = "data_udienza")
    private String data_udienza;
    
	@XmlAttribute(name = "attore")
    private String attore;
    
	@XmlAttribute(name = "convenuto")
    private String convenuto;
    
	@XmlAttribute(name = "terzo")
    private String terzo;
    
	@XmlAttribute(name = "cf")
    private String cf;
    
	@XmlAttribute(name = "cognome")
    private String cognome;
    
	@XmlAttribute(name = "nome")
    private String nome;
    
	@XmlAttribute(name = "denominazione")
    private String denominazione;
    
	@XmlAttribute(name = "organo_giudicante")
    private String organo_giudicante;
    
	@XmlAttribute(name = "cod_organo_giudicante")
    private String cod_organo_giudicante;
    
	@XmlAttribute(name = "strutturaInterna")
    private String strutturaInterna;
    
	@XmlAttribute(name = "protocollo")
    private String protocollo;
    
	@XmlAttribute(name = "dataProtocollo")
    private String dataProtocollo;
    
	@XmlAttribute(name = "gradoGiudizziario")
    private String gradoGiudizziario;
    
	@XmlAttribute(name = "tipo_atto")
    private String tipo_atto;
    
	@XmlAttribute(name = "atto_intr")
    private String atto_intr;
    
	@XmlAttribute(name = "ev_provv_imp")
    private String ev_provv_imp;
    
	@XmlAttribute(name = "oggDomanda")
    private String oggDomanda;
    
	@XmlAttribute(name = "stato_causa")
    private String stato_causa;
    
	@XmlAttribute(name = "stato_causa_reale")
    private String stato_causa_reale;
    
	@XmlAttribute(name = "ufficio_acquisizione")
    private String ufficio_acquisizione;
    
	@XmlAttribute(name = "utente_acquisizione")
    private String utente_acquisizione;
    
	@XmlAttribute(name = "pe_esito")
    private String pe_esito;
    
	@XmlAttribute(name = "referente_struttura_competente")
    private String referente_struttura_competente;
    
	@XmlAttribute(name = "struttura_competente")
    private String struttura_competente;
    
	@XmlAttribute(name = "ck_visi_struttura_competente")
    private String ck_visi_struttura_competente;
    
	@XmlAttribute(name = "patr_avvocatura")
    private String patr_avvocatura;
    
	@XmlAttribute(name = "descr_categoria_cause")
    private String descr_categoria_cause;
    
	@XmlAttribute(name = "descr_detteglio_categoria")
    private String descr_detteglio_categoria;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_causa() {
		return id_causa;
	}
	public void setId_causa(String id_causa) {
		this.id_causa = id_causa;
	}
	public String getNumeroFascicolo() {
		return numeroFascicolo;
	}
	public void setNumeroFascicolo(String numeroFascicolo) {
		this.numeroFascicolo = numeroFascicolo;
	}
	public String getId_fascicolo() {
		return id_fascicolo;
	}
	public void setId_fascicolo(String id_fascicolo) {
		this.id_fascicolo = id_fascicolo;
	}
	public String getProg_causa() {
		return prog_causa;
	}
	public void setProg_causa(String prog_causa) {
		this.prog_causa = prog_causa;
	}
	public String getCategoria_cause() {
		return categoria_cause;
	}
	public void setCategoria_cause(String categoria_cause) {
		this.categoria_cause = categoria_cause;
	}
	public String getDettaglio_categoria() {
		return dettaglio_categoria;
	}
	public void setDettaglio_categoria(String dettaglio_categoria) {
		this.dettaglio_categoria = dettaglio_categoria;
	}
	public String getProgr_ufficio() {
		return progr_ufficio;
	}
	public void setProgr_ufficio(String progr_ufficio) {
		this.progr_ufficio = progr_ufficio;
	}
	public String getData_udienza() {
		return data_udienza;
	}
	public void setData_udienza(String data_udienza) {
		this.data_udienza = data_udienza;
	}
	public String getAttore() {
		return attore;
	}
	public void setAttore(String attore) {
		this.attore = attore;
	}
	public String getConvenuto() {
		return convenuto;
	}
	public void setConvenuto(String convenuto) {
		this.convenuto = convenuto;
	}
	public String getTerzo() {
		return terzo;
	}
	public void setTerzo(String terzo) {
		this.terzo = terzo;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getOrgano_giudicante() {
		return organo_giudicante;
	}
	public void setOrgano_giudicante(String organo_giudicante) {
		this.organo_giudicante = organo_giudicante;
	}
	public String getCod_organo_giudicante() {
		return cod_organo_giudicante;
	}
	public void setCod_organo_giudicante(String cod_organo_giudicante) {
		this.cod_organo_giudicante = cod_organo_giudicante;
	}
	public String getStrutturaInterna() {
		return strutturaInterna;
	}
	public void setStrutturaInterna(String strutturaInterna) {
		this.strutturaInterna = strutturaInterna;
	}
	public String getProtocollo() {
		return protocollo;
	}
	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}
	public String getDataProtocollo() {
		return dataProtocollo;
	}
	public void setDataProtocollo(String dataProtocollo) {
		this.dataProtocollo = dataProtocollo;
	}
	public String getGradoGiudizziario() {
		return gradoGiudizziario;
	}
	public void setGradoGiudizziario(String gradoGiudizziario) {
		this.gradoGiudizziario = gradoGiudizziario;
	}
	public String getTipo_atto() {
		return tipo_atto;
	}
	public void setTipo_atto(String tipo_atto) {
		this.tipo_atto = tipo_atto;
	}
	public String getAtto_intr() {
		return atto_intr;
	}
	public void setAtto_intr(String atto_intr) {
		this.atto_intr = atto_intr;
	}
	public String getEv_provv_imp() {
		return ev_provv_imp;
	}
	public void setEv_provv_imp(String ev_provv_imp) {
		this.ev_provv_imp = ev_provv_imp;
	}
	public String getOggDomanda() {
		return oggDomanda;
	}
	public void setOggDomanda(String oggDomanda) {
		this.oggDomanda = oggDomanda;
	}
	public String getStato_causa() {
		return stato_causa;
	}
	public void setStato_causa(String stato_causa) {
		this.stato_causa = stato_causa;
	}
	public String getStato_causa_reale() {
		return stato_causa_reale;
	}
	public void setStato_causa_reale(String stato_causa_reale) {
		this.stato_causa_reale = stato_causa_reale;
	}
	public String getUfficio_acquisizione() {
		return ufficio_acquisizione;
	}
	public void setUfficio_acquisizione(String ufficio_acquisizione) {
		this.ufficio_acquisizione = ufficio_acquisizione;
	}
	public String getUtente_acquisizione() {
		return utente_acquisizione;
	}
	public void setUtente_acquisizione(String utente_acquisizione) {
		this.utente_acquisizione = utente_acquisizione;
	}
	public String getPe_esito() {
		return pe_esito;
	}
	public void setPe_esito(String pe_esito) {
		this.pe_esito = pe_esito;
	}
	public String getReferente_struttura_competente() {
		return referente_struttura_competente;
	}
	public void setReferente_struttura_competente(String referente_struttura_competente) {
		this.referente_struttura_competente = referente_struttura_competente;
	}
	public String getStruttura_competente() {
		return struttura_competente;
	}
	public void setStruttura_competente(String struttura_competente) {
		this.struttura_competente = struttura_competente;
	}
	public String getCk_visi_struttura_competente() {
		return ck_visi_struttura_competente;
	}
	public void setCk_visi_struttura_competente(String ck_visi_struttura_competente) {
		this.ck_visi_struttura_competente = ck_visi_struttura_competente;
	}
	public String getPatr_avvocatura() {
		return patr_avvocatura;
	}
	public void setPatr_avvocatura(String patr_avvocatura) {
		this.patr_avvocatura = patr_avvocatura;
	}
	public String getDescr_categoria_cause() {
		return descr_categoria_cause;
	}
	public void setDescr_categoria_cause(String descr_categoria_cause) {
		this.descr_categoria_cause = descr_categoria_cause;
	}
	public String getDescr_detteglio_categoria() {
		return descr_detteglio_categoria;
	}
	public void setDescr_detteglio_categoria(String descr_detteglio_categoria) {
		this.descr_detteglio_categoria = descr_detteglio_categoria;
	}
	
	@Override
	public String toString() {
		return "Causa [id_causa=" + id_causa + ", numeroFascicolo=" + numeroFascicolo + ", id_fascicolo="
				+ id_fascicolo + ", prog_causa=" + prog_causa + ", categoria_cause=" + categoria_cause
				+ ", dettaglio_categoria=" + dettaglio_categoria + ", progr_ufficio=" + progr_ufficio
				+ ", data_udienza=" + data_udienza + ", attore=" + attore + ", convenuto=" + convenuto + ", terzo="
				+ terzo + ", cf=" + cf + ", cognome=" + cognome + ", nome=" + nome + ", denominazione=" + denominazione
				+ ", organo_giudicante=" + organo_giudicante + ", cod_organo_giudicante=" + cod_organo_giudicante
				+ ", strutturaInterna=" + strutturaInterna + ", protocollo=" + protocollo + ", dataProtocollo="
				+ dataProtocollo + ", gradoGiudizziario=" + gradoGiudizziario + ", tipo_atto=" + tipo_atto
				+ ", atto_intr=" + atto_intr + ", ev_provv_imp=" + ev_provv_imp + ", oggDomanda=" + oggDomanda
				+ ", stato_causa=" + stato_causa + ", stato_causa_reale=" + stato_causa_reale
				+ ", ufficio_acquisizione=" + ufficio_acquisizione + ", utente_acquisizione=" + utente_acquisizione
				+ ", pe_esito=" + pe_esito + ", referente_struttura_competente=" + referente_struttura_competente
				+ ", struttura_competente=" + struttura_competente + ", ck_visi_struttura_competente="
				+ ck_visi_struttura_competente + ", patr_avvocatura=" + patr_avvocatura + ", descr_categoria_cause="
				+ descr_categoria_cause + ", descr_detteglio_categoria=" + descr_detteglio_categoria + "]";
	}
}

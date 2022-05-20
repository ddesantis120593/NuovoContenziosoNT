package mybatis;

public class AgsErrore {

	private int id;
    private String fase;
    private String codice;
    private String descrizione;
    private String tipo;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "id = " + id + ", fase = " + fase + ", codice = " + codice + ", descrizione = " + descrizione
				+ ", tipo = " + tipo;
	}
	
	
    
}

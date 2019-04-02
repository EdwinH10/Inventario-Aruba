package Modelo;

public class Elemento {

	private String id;
	private String nombre;
	private String serie;
	private String parte;
	private String estado;
	private String ubicacion;
	
	public Elemento() {

	}
	public Elemento(String id, String nombre, String serie, String parte, String estado, String ubicacion) {
		this.id= id;
		this.nombre= nombre;
		this.serie= serie;
		this.parte= parte;
		this.estado= estado;
		this.ubicacion= ubicacion;
	}
	
	public String getId(){
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getSerie() {
		return serie;
	}
	public String getParte() {
		return parte;
	}
	public String getEstado() {
		return estado;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	
	public void setId(String id) {
		this.id= id;
	}
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	public void setSerie(String serie) {
		this.serie= serie;
	}
	public void setParte(String parte) {
		this.parte= parte;
	}
	public void setEstado(String estado) {
		this.estado= estado;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion= ubicacion;
	}
}

package bts.sio.azurimmo.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "appartement")

public class Appartement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="surface")
	private double surface;
	
	@Column(name="nbPiecesOriginal")
	private int nbPiecesOriginal;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "batiment_id")
	private Batiment batiment;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public int getNbPiecesOriginal() {
		return nbPiecesOriginal;
	}

	public void setNbPiecesOriginal(int nbPiecesOriginal) {
		this.nbPiecesOriginal = nbPiecesOriginal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	
}

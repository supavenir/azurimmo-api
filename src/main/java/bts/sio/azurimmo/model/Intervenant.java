package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="intervenant")

public class Intervenant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nom")
	private String nom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
}

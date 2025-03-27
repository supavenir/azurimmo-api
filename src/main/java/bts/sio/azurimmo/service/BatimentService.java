package bts.sio.azurimmo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bts.sio.azurimmo.dto.BatimentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.Batiment;
import bts.sio.azurimmo.repository.AppartementRepository;
import bts.sio.azurimmo.repository.BatimentRepository;
import lombok.Data;

@Service
public class BatimentService {
	
	@Autowired
	private BatimentRepository batimentRepository;
	
	@Autowired
	private AppartementService appartementService;
	
	public Batiment saveBatiment(BatimentDto batiment) {
		Batiment _batiment;
		if(batiment.getId()==0) {
			_batiment = new Batiment();
		}else{
			_batiment=batimentRepository.findById(batiment.getId()).get();
		}
		batiment.updateTo(_batiment);
		Batiment savedBatiment = batimentRepository.save(_batiment);
		return savedBatiment;
	}

	public boolean deleteBatiment(Long batimentId) {
		Optional<Batiment> optBat=batimentRepository.findById(batimentId);
		if(optBat.isPresent()) {
			Batiment _batiment=optBat.get();
			for(Appartement ap:_batiment.getAppartements()) {
				appartementService.delete(ap);
			}
			batimentRepository.delete(_batiment);
			return true;
		}
		return false;
	}


	//public List<Batiment> findByVille(String ville) {
	//	return appartementRepository.findByBatiment_Ville(ville);
	//}
	
	//public List<Batiment> getAppartementsParBatiment(long id) {
		//:/return appartementRepository.findByBatiment_Id(id);
	//}
	
	//public List<Appartement> getAppartementsParSurfacePlusGrandeQue(float surface) {
		//:///return appartementRepository.findBySurfaceGreaterThan(surface);
	//}
	
	public List<Batiment> getBatiments() {
		return batimentRepository.findAll();
	}
	
	//public List<Batiment> findByVille(long idVille){
		//return batimentRepository.findByVille(idVille);
	//}
	
	
	public double getSurfaceBatiment(long id) {
		List<Appartement> lesAppartements = appartementService.getAppartementsParBatiment(id);
		double surfaceTot = 0;
		for (Appartement appartement : lesAppartements) {
		    surfaceTot += appartement.getSurface();
		}
		return surfaceTot;
	}
	
	
	public Optional<Batiment> getBatimentById(Long id) {
		return batimentRepository.findById(id);
	}
}

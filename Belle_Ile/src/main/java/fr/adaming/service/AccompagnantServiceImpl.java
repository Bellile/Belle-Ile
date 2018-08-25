package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

@Service
@Transactional
public class AccompagnantServiceImpl implements IAccompagnantService {

	@Override
	public List<Accompagnant> searchAllAccomp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accompagnant searchAccompById(Accompagnant accomp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accompagnant searchAccompByIdResa(Reservation resa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accompagnant addAccomp(Accompagnant accomp, Reservation resa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAccomp(Accompagnant accomp, Reservation resa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAccomp(Accompagnant accomp, Reservation resa) {
		// TODO Auto-generated method stub
		return 0;
	}

}

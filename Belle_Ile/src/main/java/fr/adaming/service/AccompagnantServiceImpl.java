package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAccompagnantDao;
import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

@Service
@Transactional
public class AccompagnantServiceImpl implements IAccompagnantService {

	// injection de dépendance
	@Autowired
	private IAccompagnantDao accompDao;

	// setter pour l'injection de dépendance
	public void setAccompDao(IAccompagnantDao accompDao) {
		this.accompDao = accompDao;
	}

	@Override
	public List<Accompagnant> searchAllAccomp() {

		return accompDao.searchAllAccomp();
	}

	@Override
	public Accompagnant searchAccompById(Accompagnant accomp) {
		
		return accompDao.searchAccompById(accomp);
	}

	@Override
	public List<Accompagnant> searchAccompByIdResa(Reservation resa) {

		return accompDao.searchAccompByIdResa(resa);
	}

	@Override
	public Accompagnant addAccomp(Accompagnant accomp, Reservation resa) {
		
		return accompDao.addAccomp(accomp);
	}

	@Override
	public int deleteAccomp(Accompagnant accomp, Reservation resa) {
		
		return accompDao.deleteAccomp(accomp);
	}

	@Override
	public int updateAccomp(Accompagnant accomp, Reservation resa) {
		
		return accompDao.updateAccomp(accomp);
	}

}

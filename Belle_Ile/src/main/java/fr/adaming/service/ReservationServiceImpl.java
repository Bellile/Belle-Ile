package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Accompagnant;
import fr.adaming.model.Client;
import fr.adaming.model.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao resaDao;

	public void setResaDao(IReservationDao resaDao) {
		this.resaDao = resaDao;
	}

	@Autowired
	private IAccompagnantService accompService;

	public void setAccompService(IAccompagnantService accompService) {
		this.accompService = accompService;
	}

	@Override
	public List<Reservation> searchAllResa() {

		return resaDao.searchAllResa();
	}

	@Override
	public Reservation searchResaById(Reservation resa) {

		return resaDao.searchResaById(resa);
	}

	@Override
	public Reservation addResa(Reservation resa, Client cl) {
		resa.setClient(cl);

		return resaDao.addResa(resa);
	}

	@Override
	public int deleteResa(Reservation resa, Client cl) {
		resa.setClient(cl);

		List <Accompagnant> listeAccomp=accompService.searchAccompByIdResa(resa);
		
		for (Accompagnant accomp:listeAccomp) {
			accompService.deleteAccomp(accomp, resa);
		}
		
		return resaDao.deleteResa(resa);
	}

	@Override
	public int updateResa(Reservation resa, Client cl) {
		resa.setClient(cl);

		return resaDao.updateResa(resa);
	}

}

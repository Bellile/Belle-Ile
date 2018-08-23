package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

/**
 * Classe implémentant l'interface ICategorieService
 * @author Thibault
 *
 */
@Service
@Transactional
public class CategorieServiceImpl implements ICategorieService{

	//Transformation de l'association UML en JAVA
	@Autowired
	private ICategorieDao catDao;
	
	//Setter utilisé pour l'injection dépendance	
	public void setCatDao(ICategorieDao catDao) {
		this.catDao = catDao;
	}

	@Override
	public Categorie addCat(Categorie cat) {
		
		return catDao.addCat(cat);
	}

	@Override
	public int deleteCat(Categorie cat) {
		
		return catDao.deleteCat(cat);
	}

	@Override
	public int updateCat(Categorie cat) {
		
		return catDao.updateCat(cat);
	}

	@Override
	public List<Categorie> searchAllCat() {
		
		return catDao.searchAllCat();
	}

	@Override
	public Categorie searchByIdCat(Categorie cat) {
		
		return catDao.searchByIdCat(cat);
	}

}

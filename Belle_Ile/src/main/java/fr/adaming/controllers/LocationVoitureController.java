package fr.adaming.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.LocationVoiture;
import fr.adaming.service.ILocationVoitureService;

@Controller
@RequestMapping("/admin/location")
public class LocationVoitureController {

	/*
	 * attribus
	 */
	
	private FileUpload file;
	
	/*
	 * association uml en java
	 */
	@Autowired
	private ILocationVoitureService lcService;

	/*
	 * setter pour injection dépendance
	 */

	public void setLcService(ILocationVoitureService lcService) {
		this.lcService = lcService;
	}

	/*
	 * Afficher la liste des location de voiture possible
	 */
	@RequestMapping(value = "/listLC", method = RequestMethod.GET)
	public ModelAndView afficheListeLC() {

		List<LocationVoiture> listeLC = lcService.searchAllLC();

		return new ModelAndView("adminListeLC", "listeLC", listeLC);

	}

	/*
	 * Ajouter une location de voiture
	 */

	@RequestMapping(value = "/showAddLC", method = RequestMethod.GET)
	public String afficheAddLC(Model modele) {

		modele.addAttribute("lcAjout", new LocationVoiture());

		return "adminAjoutLC";

	}

	@RequestMapping(value = "/addLC", method = RequestMethod.POST)
	public String ajoutLCForm(@ModelAttribute("lcAjout") LocationVoiture lc, MultipartFile file, RedirectAttributes rda) throws IOException {

		if(file!=null){
			
			lc.setPhoto(file.getBytes());
			
		}
		LocationVoiture lcOut = lcService.add(lc);

		if (lcOut.getId_location() != 0) {

			return "redirect:listLC";
		} else {
			rda.addAttribute("msg", "l'ajout a échoué");
			return "redirect:adminAjoutLC";
		}

	}

	/*
	 * Supprimer une location de voiture
	 */

	@RequestMapping(value = "/supprLCLink/{pId}", method = RequestMethod.GET)
	public String afficheSupprLc(ModelMap modele, @PathVariable("pId") int id) {

		LocationVoiture lc = new LocationVoiture();
		lc.setId_location(id);

		lcService.delete(lc);

		List<LocationVoiture> listLC = lcService.searchAllLC();

		modele.addAttribute("listeLC", listLC);

		return "adminListeLC";
	}

	/*
	 * Modifier une location de voiture
	 */
	@RequestMapping(value = "/showUpdateLC", method = RequestMethod.GET)
	public ModelAndView showModifLC() {

		return new ModelAndView("adminModifCL", "modifLC", new LocationVoiture());
	}

	
	@RequestMapping(value="/updateLC", method=RequestMethod.POST)
	public String modifLC(@ModelAttribute("modifLC") LocationVoiture lc, RedirectAttributes rda, MultipartFile file) throws IOException{
		
		if(file!=null){
			lc.setPhoto(file.getBytes());
		}else{
			lc.setPhoto(lcService.searchById(lc).getPhoto());
		}
		
		int verif = lcService.update(lc);
		
		if(verif!=0){
			
			return "redirect:listLC";			
		}else{
			rda.addAttribute("msg", "La modification n'a pas été effectué");
			return "redirect:showUpdateLC";
		}
		
	}

	/*
	 * Modifier depuis la liste des locations voiture
	 */

	@RequestMapping(value = "/modifLCLink", method = RequestMethod.GET)
	public String afficheModifLC(Model model, @RequestParam("pId") int id) {

		LocationVoiture lcIn = new LocationVoiture();
		lcIn.setId_location(id);

		LocationVoiture lcOut = lcService.searchById(lcIn);

		model.addAttribute("modifLC", lcOut);

		return "adminModifLC";

		
		
		
		
	}

	@RequestMapping(value = "/adminFindLC", method = RequestMethod.GET)
	public ModelAndView SearchLCById() {

		return new ModelAndView("adminFindLC", "lcSearch", new LocationVoiture());

	}

	@RequestMapping(value = "/soumettreSearchLC", method = RequestMethod.POST)
	public String afficheLCForm(ModelMap modele, @ModelAttribute("lcSearch") LocationVoiture lcIn,
			RedirectAttributes rda) {

		LocationVoiture lcOut = lcService.searchById(lcIn);

		if (lcOut != null) {

			modele.addAttribute("lcFind", lcOut);

			return "adminFindLC";
		} else {

			rda.addAttribute("msg", "Il n'y a pas de voiture pour cet id");
			return "redirect:adminFindLC";
		}

	}
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



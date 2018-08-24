package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Offre;
import fr.adaming.service.IOffreService;

@Controller
@RequestMapping(value = "/admin/offre")
public class OffreController {

	//Attributs
	private FileUpload file;
	
	/**
	 * Attribut pour l'injection de dépendance
	 */
	@Autowired
	private IOffreService offreService;

	/**
	 * Setter pour l'injection dépendance
	 * 
	 * @param offreService
	 */
	public void setOffreService(IOffreService offreService) {
		this.offreService = offreService;
	}

	public OffreController() {
		super();
	}

	@RequestMapping(value = "/listeOffre", method = RequestMethod.GET)
	public ModelAndView afficheListeOffre() {
		List<Offre> listeOffre = offreService.searchAllOffre();
		return new ModelAndView("adminOffreListe", "listeOffre", listeOffre);
	}

	// ----Methode pour ajouter une categorie
	@RequestMapping(value = "/showAddOffre", method = RequestMethod.GET)
	public String showAjoutOffre(Model model) {
		// Specification du model
		model.addAttribute("offreAjout", new Offre());

		return "adminOffreAjout";
	}

	@RequestMapping(value = "/addOffre", method = RequestMethod.POST)
	public String ajoutOffre(@ModelAttribute("offreAjout") Offre offre, RedirectAttributes rda, MultipartFile file)
			throws IOException {
		
		if (file != null) {
			// Transforamtion de l'image en tableau de byte
			offre.setPhoto(file.getBytes());
		}
		
		Offre offreOut = offreService.addOffre(offre);

		if (offreOut.getId_offre() != 0) {
			return "redirect:listeOffre";
		} else {
			rda.addAttribute("msg", true);
			return "redirect:showAddOffre";
		}

	}


	// Methode pour recuperer les images de hotel
	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getHotelImage(@RequestParam("pId") int id) throws IOException {
		Offre offreIn = new Offre();
		offreIn.setId_offre(id);
		Offre offreOut = offreService.searchOffreById(offreIn);

		if (offreOut.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(offreOut.getPhoto()));
		}

	}

}

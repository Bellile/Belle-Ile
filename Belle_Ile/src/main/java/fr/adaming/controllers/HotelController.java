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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Categorie;
import fr.adaming.model.Hotel;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IHotelService;

@Controller
@RequestMapping("/admin/hot")
public class HotelController {

	//Attributs
	private FileUpload file;
	
	//Transforamtion de l'association UML en JAVA
	@Autowired
	private IHotelService hService;
	
	@Autowired
	private ICategorieService catService;

	//Les setter de l'injection dépendance
	public void sethService(IHotelService hService) {
		this.hService = hService;
	}
	
	//----Methode afficher liste hotel
	@RequestMapping(value="/listeHotel", method=RequestMethod.GET)
	public ModelAndView affListeHot() {
		//Récupération de la liste des catégories
		List<Hotel> list = hService.searchAllHotel();
		
		return new ModelAndView("adminHotelListe", "listeHotel", list);
	}
	
	//----Methode pour ajouter un hotel
		@RequestMapping(value="/showAddHotel", method=RequestMethod.GET)
		public String showAjoutHotel(Model model) {
			//Specification du model
			model.addAttribute("hotelAjout", new Hotel());
			
			return "adminHotelAjout";
		}
		@RequestMapping(value="/addHotel", method=RequestMethod.POST)
		public String ajoutHotel(@ModelAttribute("hotelAjout")Hotel hotel,RedirectAttributes rda, MultipartFile file) throws IOException {
			if(file!=null) {
				//Transforamtion de l'image en tableau de byte
				hotel.setPhoto(file.getBytes());
			}
			Categorie cat = catService.searchByIdCat(hotel.getCategorie());
			
			Hotel hOut = hService.addHotel(hotel, cat);
			
			if (hOut.getId_hotel()!=0) {
				return "redirect:listeHotel";
			} else {
				rda.addAttribute("msg", "L'ajout de catégorie a échoué.");
				return "redirect:showAddHotel";
			}
			
		}
		
		//----Methode pour modifier une categorie
		@RequestMapping(value="/showUpdHotel", method=RequestMethod.GET)
		public String showModifHotel(Model model) {
			//Specification du model
			model.addAttribute("hotelModif", new Hotel());
			
			return "adminHotelModif";
		}
		
		@RequestMapping(value="/updHotel", method=RequestMethod.POST)
		public String modifHotel(@ModelAttribute("hotelModif")Hotel hotel,RedirectAttributes rda, MultipartFile file) throws IOException {
			if(file!=null) {
				//Transforamtion de l'image en tableau de byte
				hotel.setPhoto(file.getBytes());
			} else {
				hotel.setPhoto(hService.searchByIdHotel(hotel.getId_hotel()).getPhoto());
			}

			int verif = hService.updateHotel(hotel);
			
			if (verif!=0) {
				return "redirect:listeHotel";
			} else {
				rda.addAttribute("msg", "L'ajout de catégorie a échoué.");
				return "redirect:showUpdHotel";
			}
			
		}
		
		//Modifier par lien
		@RequestMapping(value="/updHotelLink")
		public String modifCatLink(Model model, @RequestParam("pId")int id) {			
			Hotel hotUpd = hService.searchByIdHotel(id); 
			
			model.addAttribute("hotelModif", hotUpd);
			
			return "adminHotelModif";
			
		}
		
		//----Methode pour supprimer une categorie
		@RequestMapping(value="/delHotelLink/{pId}")
		public ModelAndView suppCatLien(@PathVariable("pId")int id) {
			//instanciation d'un hotel
			Hotel hotel = new Hotel();
			hotel.setId_hotel(id);
			
			//Appel de la méthode
			hService.deleteHotel(hotel);
			
			//Récupération de la liste des catégories
			List<Hotel> list = hService.searchAllHotel();
			
			return new ModelAndView("adminHotelListe", "listeHotel", list);
		}
}

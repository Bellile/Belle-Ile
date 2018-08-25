package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Role;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	/*
	 * Association uml en java
	 */
	@Autowired
	private IClientService cService;

	/*
	 * Setter
	 */

	public void setcService(IClientService cService) {
		this.cService = cService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

		formatDate.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	/*
	 * Ajouter un client
	 */
	@RequestMapping(value = "/showAddCient", method = RequestMethod.GET)
	public String afficheAddClientForm(Model modele) {

		modele.addAttribute("clAjout", new Client());

		return "clientAjoutClient";

	}

	@RequestMapping(value = "/addCL", method = RequestMethod.POST)
	public String ajoutClientForm(@ModelAttribute("clAjout") Client cl, RedirectAttributes rda) {

		Role role = new Role();
		role.setId_role(1);
		cl.setRole(role);

		Client clOut = cService.addCl(cl);

		// if (clOut.getId() != 0) {
		return "redirect:client/showAddCient";
		//
		// } else {
		// rda.addAttribute("msg", "L'ajout n'a pas été effectué");
		// return "redirect:client/showAddCient";
		// }

	}

	/*
	 * modifier un client
	 */

	@RequestMapping(value = "/showUpdateClient", method = RequestMethod.GET)
	public ModelAndView showModifClient() {

		return new ModelAndView("clientModifClient", "clModif", new Client());

	}

	@RequestMapping(value = "/updateCL", method = RequestMethod.POST)
	public String modifCL(@ModelAttribute("clModif") Client cl, RedirectAttributes rda) {

		int verif = cService.updateCl(cl);

		if (verif != 0) {

			return "redirect:showUpdateClient";

		} else {

			rda.addAttribute("msg", "La modification a échoué");
			return "showUpdateClient";

		}

	}

	/*
	 * Modifier depuis un lien
	 */

	@RequestMapping(value = "/modifCLLink", method = RequestMethod.GET)
	public String afficheModifCL(Model model, @RequestParam("pId") int id) {

		Client clIn = new Client();
		clIn.setId(id);

		Client clOut = cService.searchByIdCl(clIn);

		model.addAttribute("clmodif", clOut);

		return "clientModifClient";

	}

}

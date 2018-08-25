package fr.adaming.controllers;


import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.adaming.model.Hotel;
import fr.adaming.model.LocationVoiture;
import fr.adaming.service.IHotelService;

@Controller
@RequestMapping("/image")
public class ImageController {

	//Transforamtion de l'association UML en JAVA
	@Autowired
	private IHotelService hService;
	
	//Methode pour recuperer les images de hotel
	@RequestMapping(value="/hotel", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getHotelImage(@RequestParam("pId") int id) throws IOException {
		Hotel hOut = hService.searchByIdHotel(id);
		
		if (hOut.getPhoto()==null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(hOut.getPhoto()));
		}
		
	}
	
	@RequestMapping(value="/locationVoiture", method=RequestMethod.GET, produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getLCImage(@RequestParam("pId") int id) throws IOException{
		LocationVoiture lcIn= new LocationVoiture();
		lcIn.setId_location(id);		
		
		LocationVoiture lcOut = lcService.searchById(lcIn);
		
		if(lcOut.getPhoto()==null){
			
			return new byte[0];
		}else{
			
			return IOUtils.toByteArray(new ByteArrayInputStream(lcOut.getPhoto()));
		}
	
	
	
	
	
	
	
}

package com.kumar.nitesh.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kumar.nitesh.model.Hotel;
import com.kumar.nitesh.service.HotelService;

@Controller
@RequestMapping(value = "/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@RequestMapping(value = "hotelinfo/{name}", method = RequestMethod.GET)
	public String getHotelByName(ModelMap modelMap, @PathVariable String name) {
		modelMap.addAttribute("hotel", hotelService.getHotelByName(name));
		return "hotels/hotelInfo";
	}

	@RequestMapping(value = "hotellist", method = RequestMethod.GET)
	public String getHotels(ModelMap modelMap) {
		modelMap.addAttribute("hotellist", hotelService.getAllHotels());
		return "hotels/hotellist";
	}
	
	@RequestMapping(value = "hotellistbycity/{city}", method = RequestMethod.GET)
	public String getHotelsByCity(ModelMap modelMap, @PathVariable String city) {
		modelMap.addAttribute("hotellist", hotelService.getHotelByCity(city));
		return "hotels/hotellist";
	}
	
	@RequestMapping(value = "hotellistbyrating/{rating}", method = RequestMethod.GET)
	public String getHotelsByRating(ModelMap modelMap, @PathVariable String rating) {
		modelMap.addAttribute("hotellist", hotelService.getHotelByRating(rating));
		return "hotels/hotellist";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "hotels/index";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchHotel(Model model, @RequestParam("searchString") String searchString)
	{
		Iterator<Hotel> ithotels = hotelService.getAllHotels().iterator();
    	List<Hotel> hotelsList = new ArrayList<Hotel>();	
    	    	
    	while(ithotels.hasNext())
    	{
    		Hotel h = ithotels.next();
    		if(h.getName().toLowerCase().contains(searchString.toLowerCase()))
    			hotelsList.add(h);
    	}				
    	
    	model.addAttribute("hotels", hotelsList);
    	return "hotels/index";
	}
}

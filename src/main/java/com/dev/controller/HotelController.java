package com.dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.dev.model.Availability;
import com.dev.model.Hotel;
import com.dev.service.AvailService;
import com.dev.service.HotelService;

//import com.dev.service.InitService;

@Controller
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private AvailService availService;
		
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allHotel", hotelService.getHotelHome().left);
		modelAndView.addObject("cityMap", hotelService.getHotelHome().right);
//		modelAndView.addObject("homeForm", new CheckInForm());
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@PostMapping("/check")
	public String check(HttpServletRequest req, RedirectAttributes redir) {
		String id = req.getParameter("name");
		String date = req.getParameter("date");
		List<Availability> li = availService.checkAvail(id+"|"+date);
		if(li.size() != 0) {
			return "redirect:/error";
		} else {
			redir.addFlashAttribute("id", id);
			redir.addFlashAttribute("date", date);
			return "redirect:/confirm";
		}
	}
	
	@GetMapping("/error")
	public ModelAndView err() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("not-available");
		return modelView;
	}
	
	@GetMapping("/confirm")
	public ModelAndView reserve(@ModelAttribute("id") String id, @ModelAttribute("date") String date) {
		ModelAndView modelView = new ModelAndView();
		Hotel hotel = hotelService.getHotel(Long.parseLong(id));
		modelView.addObject("hotel", hotel);
		modelView.addObject("total", hotel.getPrice()+hotel.getGst());
		modelView.addObject("date", date);
		modelView.setViewName("detail-confirm");
		return modelView;
	}
	
	@PostMapping("/reserve")
	public ModelAndView finalForm(
			@ModelAttribute("hotelId") String id, 
			@ModelAttribute("date") String date) {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("id", id);
		modelView.addObject("date", date);
		modelView.setViewName("reservation-form");
		return modelView;
	}
	
	@PostMapping("/final")
	public ModelAndView last(HttpServletRequest req) {
		String id = req.getParameter("id");
		String date = req.getParameter("date");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		Long age = Long.parseLong(req.getParameter("age"));
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobileNo");
		Availability avail = new Availability(id+"|"+date, name, gender, age, email, mobile);
		availService.saveAvail(avail);
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("name", name);
		Hotel hotel = hotelService.getHotel(Long.parseLong(id));
		modelView.addObject("hotelName", hotel.getHotelName());
		modelView.setViewName("confirmed");
		return modelView;
	}
}

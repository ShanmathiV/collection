package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Admin;
import com.example.demo.model.Doctor;
import com.example.demo.serviceImp.DoctorService;
@Controller
public class DoctorController {
	@Autowired
	DoctorService Docser;

	public DoctorController(DoctorService docser) {
		super();
		Docser = docser;
	}
	@GetMapping("/get/doctor")
	public String loginn(Model model)
	{
		Doctor obj3 =new Doctor();
		model.addAttribute("obj5",obj3);
		return "Welcomedocter";
	}	
	@GetMapping("doctersave")
	public String saveUser(@ModelAttribute("obj5") Doctor doctor)
	{
	    System.out.print("hello doctor");
	    Doctor doc=Docser.loginUser(doctor.getName(),doctor.getSpeaclist());
		return "DocList";
     }
	@GetMapping("/getdoc")
	public String listUserss(Model model)
	{
		model.addAttribute("Admin",Docser.getAllUsers());
		return "DocList";
	}
	@PostMapping("/Mydoctor/update/{id}")
	public String updateStudent(@PathVariable long id,@ModelAttribute("admin") Doctor adm, Model model)
	{
		System.out.println("hello");
	    Doctor exist=Docser.getUserId(id);
		exist.setId(id);
		exist.setName(adm.getName());
		exist.setSpeaclist(adm.getSpeaclist());
		return "redirect:/Doc_list";
	}
	@GetMapping("/Mydoctor/delete/{id}")
	public String DeleteStudent(@PathVariable Long id)
	{
     	Docser.deletedocId(id);
		return  "redirect:/Doc_list";
	}
	
	
}



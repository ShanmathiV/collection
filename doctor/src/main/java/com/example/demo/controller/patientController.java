package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Admin;
import com.example.demo.model.Patient;
import com.example.demo.serviceImp.AdminService;
import com.example.demo.serviceImp.PatientService;
public class patientController {
	@Autowired
	private PatientService obj1;

	public patientController(PatientService obj1) {
		super();
		this.obj1 = obj1;
	}
	
	@GetMapping("getP")
	public String listUserss(Model model)
	{
		model.addAttribute("min",obj1.listAll());
		return "adm";
	}
	@GetMapping("/getnewpatient")
	public String listUsers(Model model)
	{
		model.addAttribute("Admin",obj1.listAll());
			return "admin";
	}
	
	@GetMapping("/get/new")
	public String createUser(Model model)
	{
		Admin obj3 =new Admin();
		model.addAttribute("obj3",obj3);
		return "create_user";
	}
	@PostMapping("/getmy")
	public String saveUser(@ModelAttribute("obj3") Patient admin)
	{
		obj1.save(admin);
		return "redirect:/get";
	}
	@GetMapping("get/update/{id}")
	public String editUserForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("admin",obj1.get(id));	
	   return "edit_admin";	
	}
	@PostMapping("/Mypatient/{id}")
	public String updateStudent(@PathVariable long id,@ModelAttribute("admin") Patient adm, Model model)
	{
		System.out.println("hello");
		Patient exist=obj1.save(id);
		exist.setPatientId(id);
		exist.setPatientname(adm.getPatientname());
		exist.setBloodgroup(adm.getBloodgroup());
		return "redirect:/get";
	}
	@GetMapping("/get/delete/{id}")
	public String DeleteStudent(@PathVariable long id)
	{
     	obj1.delete(id);
		return  "redirect:/gett";
	}
}

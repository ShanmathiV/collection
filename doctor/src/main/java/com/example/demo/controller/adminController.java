package com.example.demo.controller;
import java.util.Objects;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.serviceImp.AdminService;
@Controller
public class adminController {
	private AdminService obj1;

	public adminController(AdminService obj1) {
		super();
		this.obj1 = obj1;
	}
	
	@GetMapping("welcome")
	public String welcome()
	{
		return "Welcome";
	}
	@GetMapping("/get")
	public String listUserss(Model model)
	{
		model.addAttribute("Admin",obj1.getAllUsers());
		return "Welcome";
	}
	
	
	@GetMapping("/gett")
	public String login(Model model)
	{
		model.addAttribute("Admin",obj1.getAllUsers());
			return "admin";
	}
	
	
	@GetMapping("/getn")
	public String loginn(Model model)
	{
		Admin obj3 =new Admin();
		model.addAttribute("obj3",obj3);
		return "Welcome";
	}	
	@PostMapping("/getmy")
	public String loginUser(@ModelAttribute("obj3") Admin admin,Model mode) throws NameNotFoundException
	{
			Admin adm=obj1.loginUser(admin.getName(),admin.getEmail());
			 if(adm==null)
			 {
				return "redirect:gett";
			 }
			 else 
			 {
				 mode.addAttribute("obj3",obj1.getAllUsers());
				 return "admin";
			 }
		}
	@GetMapping("c/new")
	public String createUser(Model model)
	{
		Admin obj4 =new Admin();
		model.addAttribute("obj4",obj4);
		return "create_user";
	}
	@PostMapping("Come")
	public String saveUser(@ModelAttribute("obj4") Admin admin)
	{
		obj1.saveuser(admin);
		return "redirect:/getn";
	}
	@GetMapping("get/update/{id}")
	public String editUserForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("admin",obj1.getUserId(id));	
	   return "edit_admin";	
	}
	@PostMapping("/Myadmin/{id}")
	public String updateStudent(@PathVariable long id,@ModelAttribute("admin") Admin adm, Model model)
	{
		System.out.println("hello");
		Admin exist=obj1.getUserId(id);
		exist.setId(id);
		exist.setName(adm.getName());
		exist.setEmail(adm.getEmail());
		return "redirect:/get";
	}
	@GetMapping("/get/delete/{id}")
	public String DeleteStudent(@PathVariable long id)
	{
     	obj1.deleteId(id);
		return  "redirect:/gett";
	}
}


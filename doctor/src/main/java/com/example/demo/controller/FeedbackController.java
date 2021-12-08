package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Admin;
import com.example.demo.model.Feedback;
import com.example.demo.serviceImp.AdminService;
import com.example.demo.serviceImp.FeedbackService;

@Controller
public class FeedbackController {
	@Autowired

	private FeedbackService obj1;

	public FeedbackController(FeedbackService obj1) {
		super();
		this.obj1 = obj1;
	}

	@GetMapping("feedback")
	public String  ListAll(Model model)
	{
	  model.addAttribute("Admin",obj1.listAll());
	  return "Feedback";
	}
	@GetMapping("feedback/new")
	public String createUser(Model model)
	{
		Feedback obj3 =new Feedback();
		model.addAttribute("obj5",obj3);
		return "create_feedback";
	}
	@PostMapping("/getfeedback")
	public String saveUser(@ModelAttribute("obj5") Feedback admin)
	{
		obj1.save(admin);
		return "redirect:feedback";
	}
	@GetMapping("getfeedback/update/{id}")
	public String editUserForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("admin",obj1.get(id));	
	   return "Feedback";	
	}
	@GetMapping("/getfeedback/delete/{id}")
	public String DeleteStudent(@PathVariable long id)
	{
     	obj1.delete(id);
		return  "redirect:/gett";
	}
}

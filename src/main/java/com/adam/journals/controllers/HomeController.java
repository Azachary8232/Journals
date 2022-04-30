package com.adam.journals.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adam.journals.models.Entry;
import com.adam.journals.models.LoginUser;
import com.adam.journals.models.User;
import com.adam.journals.services.EntryService;
import com.adam.journals.services.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private EntryService entryService;
    
//    	User LOGIN Page
	
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
    		BindingResult result, Model model, HttpSession session) {
    	User user = userService.login(newLogin, result);
    	if(result.hasErrors()) {
    		model.addAttribute("newUser", new User());
    		return "login.jsp";
    	}
    	session.setAttribute("user_id", user.getId());
    	return "redirect:/dashboard";
    }
    
//			New User REGISTRATION Page
    
    @GetMapping("/register")
    public String register(@ModelAttribute("newUser") User newUser) {
    	
    	return "register.jsp";
    }
    
    @PostMapping("/register")
    public String newUser(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "register.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    
//    		DASHBOARD
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
    	
    	return "dashboard.jsp";
    }
    
//    		New Journal Entry Page
    
    @GetMapping("/newEntry")
    public String newEntry(@ModelAttribute("newEntry") Entry newEntry, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
    	
    	return "new_entry.jsp";
    }
    
    @PostMapping("/newEntry")
    public String createEntry(@Valid @ModelAttribute("newEntry") Entry newEntry, BindingResult result, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
    	if (result.hasErrors()) {
    		return "new_entry.jsp";
    	}
    	else {
    		entryService.createEntry(newEntry);
    		return "redirect:/dashboard";
    	}
    }
    
//    		Show Entries Page
    
    @GetMapping("/entries")
    public String showEntries(@RequestParam Long year, @RequestParam Long month, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("user_id");
		List<Entry> entries = entryService.getEntriesByMonth(year, month, userId);
		model.addAttribute("entries", entries);
		
    	return "show_entries.jsp";
    }
    
//    		View Entry Page
    
    @GetMapping("/view/{id}")
    public String viewEntry(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
    	Entry entry = entryService.findEntry(id);
    	model.addAttribute("entry", entry);
		
    	return "view_entry.jsp";
    }
    
//    		Edit Journal Page
    
    @GetMapping("/edit/{id}")
    public String editEntry(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
    	Entry entry = entryService.findEntry(id);
    	model.addAttribute("editEntry", entry);
    	
    	return "edit_entry.jsp";
    }
    
    @PutMapping("/edit/{id}")
    public String updateEntry(@Valid @ModelAttribute("editEntry")Entry editEntry, BindingResult result, @PathVariable("id")Long id, HttpSession session ) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "edit_entry.jsp";	
		} 
		else {
			entryService.editEntry(editEntry);
			return "redirect:/dashboard";
		}
    }
    
//    		DELETE Entry
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
    	entryService.destroy(id);
    	
    	return "redirect:/dashboard";
    }
//    		USER LOGOUT
    
	@GetMapping("/logout")
	public String clear(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
   

}

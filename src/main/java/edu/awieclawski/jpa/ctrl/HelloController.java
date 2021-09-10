package edu.awieclawski.jpa.ctrl;

//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.awieclawski.jpa.dctr.I_UOMs;

@Controller
@SessionAttributes({"agemtr","hghtmtr","wghtmtr"}) // UOMs constants
public class HelloController {

//	private final static Logger LOGGER = Logger.getLogger(HelloController.class.getName());

	@GetMapping({ "/hello", "/welcome", "/home", "/" })
	public String hello(HttpSession session, Model model) {

		// resets all session attributes
		session.invalidate();
		
		// init UOMs
        model.addAttribute("agemtr", I_UOMs.MTR_AGE);
        model.addAttribute("hghtmtr", I_UOMs.MTR_HGHT);
        model.addAttribute("wghtmtr", I_UOMs.MTR_WGHT);
		
		return "/welcome";
	}

}

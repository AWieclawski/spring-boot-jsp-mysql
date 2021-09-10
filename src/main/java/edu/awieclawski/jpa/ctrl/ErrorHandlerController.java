package edu.awieclawski.jpa.ctrl;

import org.springframework.boot.web.servlet.error.ErrorController;

//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.awieclawski.jpa.dctr.Comments;

@Controller
public class ErrorHandlerController implements ErrorController {

//	private final static Logger LOGGER = Logger.getLogger(ErrorHandlerController.class.getName());

	@GetMapping({ "/error" })
	public String hello(Model model, @ModelAttribute("errorMessage") String errorMessageReceived,
			@ModelAttribute("errorName") String errorNameReceived) {

//		LOGGER.log(Level.INFO, "errorMessageReceived=" + errorMessageReceived);

		if (errorMessageReceived != null)
			model.addAttribute("errorMessageToDisplay", errorMessageReceived);
		if (errorNameReceived != null)
			model.addAttribute("errorNameToDisplay", errorNameReceived);
		return "/errorview";
	}

	@Override
	@RequestMapping("/errorplain")
	@ResponseBody
	public String getErrorPath() {
		return "<center><h1>Error</h1><h3>" + Comments.ERROR.getDescription() + "</h3></center>";
	}

}

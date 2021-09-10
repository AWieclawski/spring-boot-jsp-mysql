package edu.awieclawski.jpa.ctrl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

//import edu.awieclawski.jpa.base.BaseEntity;
//import edu.awieclawski.jpa.base.BaseEntity;
import edu.awieclawski.jpa.model.Address;
import edu.awieclawski.jpa.utils.EntityUtils;

@Controller // data presentation
public class ConfirmationController {
	private final static Logger LOGGER = Logger.getLogger(ConfirmationController.class.getName());
	private Map<String, Object> valuesMap;
	private Map<String, String> labelsMap;

	@RequestMapping(value = "/displayaddress", method = RequestMethod.GET)
	public String showEntity(Model model, @SessionAttribute("sessionentity") Address addressReceived) {
		if (addressReceived != null) {
			labelsMap = EntityUtils.getMapOfFieldsAndLabelsFromClass(addressReceived);
			valuesMap = EntityUtils.getMapOfFieldsAndValuesFromClass(addressReceived);
			model.addAttribute("head", addressReceived.getEntityHeaderName());
			model.addAttribute("valuesMap", valuesMap);
			model.addAttribute("labelsMap", labelsMap);
		} else {
			LOGGER.log(Level.SEVERE, "Received entity is:" + addressReceived);
			return "redirect:/home";
		}
		return "/confirmview";
	}

	// TODO universalize confirmation controller, result page presentation

}

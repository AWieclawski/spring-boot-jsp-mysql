package edu.awieclawski.jpa.ctrl;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import edu.awieclawski.jpa.base.BaseEntity;
import edu.awieclawski.jpa.utils.EntityUtils;

@Controller // data presentation
public class ConfirmationController {
	private final static Logger LOGGER = Logger.getLogger(ConfirmationController.class.getName());
	private Map<String, Object> valuesMap;
	private Map<String, String> labelsMap;

	@RequestMapping(value = "/displayentity", method = RequestMethod.GET)
	public String showEntity(Model model, @SessionAttribute("sessionentity") BaseEntity entityReceived) {

		if (entityReceived != null) {
			labelsMap = EntityUtils.getMapOfFieldsAndLabelsFromClass(entityReceived);
			valuesMap = EntityUtils.getMapOfFieldsAndValuesFromClass(entityReceived);
			model.addAttribute("head", entityReceived.getEntityHeaderName());
			model.addAttribute("valuesMap", valuesMap);
			model.addAttribute("labelsMap", labelsMap);
		} else {
			LOGGER.log(Level.SEVERE, "NULL ERROR - Received entity= " + entityReceived);
			return "redirect:/home";
		}
		return "/confirmview";
	}

}

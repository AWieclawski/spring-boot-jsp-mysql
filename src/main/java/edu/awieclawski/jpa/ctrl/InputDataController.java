package edu.awieclawski.jpa.ctrl;

import java.math.BigDecimal;
import java.util.Map;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.awieclawski.jpa.adt.AddressRepository;
import edu.awieclawski.jpa.base.BaseEntity;
import edu.awieclawski.jpa.dctr.Comments;
import edu.awieclawski.jpa.model.Address;
import edu.awieclawski.jpa.sppt.BigDecimalEditor;
import edu.awieclawski.jpa.utils.EntityUtils;

@Controller
@SessionAttributes({ "sessionentity" })
public class InputDataController {
	private final static Logger LOGGER = Logger.getLogger(InputDataController.class.getName());
	private Map<String, String> labelsMap;
	private BaseEntity entity = new Address();

	@Autowired
	private AddressRepository addressRepo;

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public ModelAndView showEntity(Model model) {
		labelsMap = EntityUtils.getMapOfFieldsAndLabelsFromClass(entity);
		model.addAttribute("entityMap", labelsMap);
		model.addAttribute("head", entity.getEntityHeaderName());
		model.addAttribute("link", entity.getEntityLink());
		return new ModelAndView("/upform", "entity", new Address());
	}

	@RequestMapping(value = "/upaddress", method = RequestMethod.POST, params = "submit")
	public String submitEntity(@Valid @ModelAttribute("entity") final Address postedEntity, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			LOGGER.log(Level.SEVERE, "Error result " + postedEntity.getEntityHeaderName());
			return "/upform";
		}

		model.addAttribute("sessionentity", postedEntity);
		addressRepo.save(postedEntity);
		return "redirect:/displayentity";
	}

	@RequestMapping(value = "/upaddress", method = RequestMethod.POST, params = "reset")
	public String cancelMan(Model model) {
		model.addAttribute("message", Comments.CANCEL.getDescription());
		// sets all values to default ones
		model.addAttribute("entity", new Address());
		return "/upform";
	}

	/**
	 * Enables dedicated control before data conversion to BigDecimal format
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
	}

	// TODO change variable isperson by entity type unique code, to recognize data
	// type in jsp views

}

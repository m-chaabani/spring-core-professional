package com.mc.gestionformation.view;

import java.util.HashMap;
import java.util.Map;

import com.mc.gestionformation.business.FormateurBusiness;
import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.integration.dao.FormateurDaoInMemory;
import com.mc.gestionformation.integration.dao.FormateurDaoJDBC;
import com.mc.gestionformation.integration.dao.IFormateurDao;
import com.mc.gestionformation.service.FormateurService;
import com.mc.gestionformation.service.IFormateurService;



public class MyFormateurFactory2 implements FormateurFactory {

	Map<String, Object> components = new HashMap();
	
	{
		createFormateurComponent();
	}

	@Override
	public void createFormateurComponent() {

		IFormateurDao formateurDao = new FormateurDaoJDBC();
		IFormateurService formateurBusiness = new FormateurBusiness(formateurDao);
		IFormateurService formateurService = new FormateurService(formateurBusiness);
		FormateurController controller = new FormateurController(formateurService);

		components.put("myformateurDao", formateurDao);
		components.put("myformateurBusiness", formateurBusiness);
		components.put("myformateurService", formateurService);
		components.put("mycontroller", controller);

	}

	@Override
	public Object getFormateurComponent(String name) {
		return components.get(name);
	}

}

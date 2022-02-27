package com.mc.gestionformation.view;

import java.util.HashMap;
import java.util.Map;

import com.mc.gestionformation.business.FormateurBusiness;
import com.mc.gestionformation.controller.FormateurController;
import com.mc.gestionformation.integration.dao.FormateurDaoInMemory;
import com.mc.gestionformation.integration.dao.IFormateurDao;
import com.mc.gestionformation.service.FormateurService;
import com.mc.gestionformation.service.IFormateurService;

interface FormateurFactory {
	void createFormateurComponent();

	Object getFormateurComponent(String name);
}

public class MyFormateurFactory implements FormateurFactory {
	private static MyFormateurFactory INSTANCE;

	Map<String, Object> components = new HashMap();

	public static MyFormateurFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MyFormateurFactory();
		}
		return INSTANCE;
	}

	private MyFormateurFactory() {
		createFormateurComponent();
	}

	@Override
	public void createFormateurComponent() {

		IFormateurDao formateurDao = new FormateurDaoInMemory();
		IFormateurService formateurBusiness = new FormateurBusiness(formateurDao);
		IFormateurService formateurService = new FormateurService(formateurBusiness);
		FormateurController controller = new FormateurController();

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

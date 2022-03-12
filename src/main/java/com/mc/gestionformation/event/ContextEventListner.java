package com.mc.gestionformation.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextEventListner {

	@EventListener(classes = { ContextStoppedEvent.class })
	public void applicationContextListner() {
		System.out.println("Event happened ! ");

	}

}

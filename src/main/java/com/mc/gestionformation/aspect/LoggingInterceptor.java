package com.mc.gestionformation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mc.gestionformation.dto.FormateurDTO;

@Aspect
@Component
public class LoggingInterceptor {

	// private static Logger logger =
	// LoggerFactory.getLogger(LoggingInterceptor.class);

	@Pointcut(value = "execution( * com.mc.gestionformation.business.*.enregistrer(..) )")
	public void businessLayerEnregistrer() {
	}

	@Before(value = "com.mc.gestionformation.aspect.LoggingInterceptor.businessLayerEnregistrer()")
	public void BeforebusinessLayerEnregistrer() {
		System.out.print("J'applique le PointCut businessLayerEnregistrer");
	}

	@Before(value = "com.mc.gestionformation.aspect.AllPointCuts.loggableForType()")
	public void BeforeLoggable(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getClass());
		System.out.print("BeforeLoggable Log is acting on method named : " + joinPoint.getSignature().getName());

	}

	@Before(value = "com.mc.gestionformation.aspect.AllPointCuts.logIformateurService() && args( dto ) ")
	private void BeforeIFormateurService(JoinPoint joinPoint, FormateurDTO dto) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getClass());
		System.out.print("BeforeIFormateurService : Log is acting on method named : "
				+ joinPoint.getSignature().getName() + "with arguments " + dto.getEntity().toString());

	}

}

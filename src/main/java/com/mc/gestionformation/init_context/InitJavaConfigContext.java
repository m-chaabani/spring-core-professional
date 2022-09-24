package com.mc.gestionformation.init_context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mc.gestionformation.business.impl.ParticipantBusinessSpringData;
import com.mc.gestionformation.config.AppConfig;
import com.mc.gestionformation.dto.ParticipantDTO;
import com.mc.gestionformation.model.Participant;

public class InitJavaConfigContext {

	private static final Logger logger = LoggerFactory.getLogger(InitJavaConfigContext.class);

	public static void main(String[] args) {

		logger.info("Running ApplicationContext from {}", InitJavaConfigContext.class.getSimpleName());

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		// Arrays.asList(ctx.getBeanDefinitionNames()).forEach(System.out::println);

//		FormateurController formateurController = ctx.getBean(FormateurController.class);
//		logger.info(ctx.getBean(Formateur.class).toString());
//		formateurController.BoutonEnregister();
//		IDisciplineBusiness disciplineBusiness = ctx.getBean(IDisciplineBusiness.class);
//		DisciplineDTO disciplineDTO = new DisciplineDTO();
//		Discipline Discipline = new Discipline();
//		Discipline.setId(1L);
//		Discipline.setCode("TOTO");
//		disciplineDTO.setEntity(Discipline);
//		disciplineBusiness.create(disciplineDTO);
//		disciplineDTO = disciplineBusiness.findById(disciplineDTO);
//		System.out.println(disciplineDTO.getEntity());
//		disciplineDTO = disciplineBusiness.findAll(new DisciplineDTO());
//		disciplineDTO.getListEntity().forEach(System.out::println);

//		ParticipantDTO participantDTO = new ParticipantDTO();
//		Participant participant = new Participant();
//		participant.setId(1L);
//		participant.setNom("TITI");
//		participant.setMatricule("4444");
//		participantDTO.setEntity(participant);
//		IParticipantBusiness participantBusiness = ctx.getBean(IParticipantBusiness.class);
//		participantBusiness.create(participantDTO);
//		participantBusiness.findById(participantDTO);
//		participantBusiness.findAll(new ParticipantDTO()).getListEntity().forEach(System.out::println);
//		participantBusiness.findMatriculeIn("4444", "5555", "6666").forEach(System.out::println);
		
		
		ParticipantDTO participantDTO = new ParticipantDTO();
		Participant participant = new Participant();
		participant.setId(1L);
		participant.setNom("TITI");
		participant.setMatricule("4444");
		participant.setAdresse("Tunis");
		participantDTO.setEntity(participant);
		ParticipantBusinessSpringData participantBusiness = ctx.getBean(ParticipantBusinessSpringData.class);
		participantBusiness.create(participantDTO);
		participantBusiness.findById(participantDTO);
		participantBusiness.findAll(new ParticipantDTO()).getListEntity().forEach(System.out::println);
		participantBusiness.findByAdresse("Tunis").forEach(System.out::println);
		
		
		

	}

}

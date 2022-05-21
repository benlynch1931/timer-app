package com.ar;

import com.ar.repository.PresetRepo;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Ben Lynch
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ar"})
public class SpringConnectorApplication {

	private PresetRepo pr;

	public SpringConnectorApplication(PresetRepo pr) {
//		this.pr = pr;
//		List<TaskDto> taskList = new ArrayList<>();
//		taskList.add(new TaskDto("Chips", BigInteger.valueOf(60*25)));
//		pr.save(new PresetDto("Preset 1", BigInteger.valueOf(60), taskList));
	}

	public static void main(String[] args) {
//		SpringApplication.run(SpringConnectorApplication.class);
		Application.launch(TimerApplication.class, args);
	}

}

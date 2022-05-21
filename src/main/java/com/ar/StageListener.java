package com.ar;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

/**
 * @author Ben Lynch
 */
@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {

    private final String title;
    private final Resource fxml;
    private final ApplicationContext applicationContext;


    public StageListener(@Value("${timer.application.title}") String title,
                         @Value("classpath:/preset.fxml") Resource resource, ApplicationContext ac) {
        this.title = title;
        this.fxml = resource;
        this.applicationContext = ac;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            Stage stage = event.getStage();
            URL url = this.fxml.getURL();
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root = fxmlLoader.load();
//            Scene scene = new Scene(root,  828, 1792);
            Scene scene = new Scene(root,  414, 896);
            scene.setFill(Color.web("#E3E3E3"));
            scene.getStylesheets().addAll("TableViewStyle");
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

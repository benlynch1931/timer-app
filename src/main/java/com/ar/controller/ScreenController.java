package com.ar.controller;

import com.ar.config.ComponentSize;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class ScreenController {

    private final ApplicationContext applicationContext;



    public void switchToTaskListView(final ActionEvent event) {
        switchScene(event, "/taskList.fxml");
    }

    public void switchToTaskView(final ActionEvent event) {
        switchScene(event, "/task.fxml");
    }

    public void switchToPresetView(final ActionEvent event) {
        switchScene(event, "/preset.fxml");
    }

    public void switchToPresetListView(final ActionEvent event) {
        switchScene(event, "/presetList.fxml");
    }

    private void switchScene(final ActionEvent event, final String fxmlName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, ComponentSize.SCREEN_WIDTH, ComponentSize.SCREEN_HEIGHT);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

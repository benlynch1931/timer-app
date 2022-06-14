package com.bl.service;

import com.bl.config.TextToSpeechEngine;
import com.bl.entity.ActiveTask;
import com.bl.repository.ActiveTaskRepo;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Ben Lynch
 */
@Component
@RequiredArgsConstructor
public class ActiveTaskService {

    private final ActiveTaskRepo activeTaskRepo;

    private final TextToSpeechEngine textToSpeechEngine;


    /**
     * Checks if task alarm should go off
     * @param activePresetId presetId of active tasks to check
     * @return t/f if all tasks are finished
     */
    public boolean checkTaskStatus(final BigInteger activePresetId) {
        List<ActiveTask> presetActiveTasks = activeTaskRepo.getByPresetId(activePresetId);
        if (presetActiveTasks.isEmpty()) {
            return true;
        } else {
            presetActiveTasks.forEach(task -> {
                if (task.getAlarmTime().isBefore(LocalDateTime.now())) {
                    activeTaskRepo.delete(task);
                    activateAlarm(task);
                }
            });
            return false;
        }
    }

    private void activateAlarm(final ActiveTask activeTask) {
        Media sound = new Media(new File("src/main/resources/alarmOneShort.m4a").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        textToSpeechEngine.speak(activeTask.getName());
        mediaPlayer.play();
    }

}

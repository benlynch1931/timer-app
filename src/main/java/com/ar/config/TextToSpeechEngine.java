package com.ar.config;

import org.springframework.stereotype.Component;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;

@Component
public class TextToSpeechEngine {

    private Synthesizer synthesizer;

    public TextToSpeechEngine() {
        try {

            System.setProperty(
                    "freetts.voices",
                    "com.sun.speech.freetts.en.us"
                            + ".cmu_us_kal.KevinVoiceDirectory");

            // Register Engine
            Central.registerEngineCentral(
                    "com.sun.speech.freetts"
                            + ".jsapi.FreeTTSEngineCentral");

            // Create a Synthesizer
            synthesizer
                    = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));

            // Allocate synthesizer
            synthesizer.allocate();

            // Resume Synthesizer
            synthesizer.resume();
        } catch (Exception e) {
            System.out.println("Error with speech");
        }
    }

    public void speak(String strToSpeak) {
        try {
            // Set property as Kevin Dictionary


            // Speaks the given text
            // until the queue is empty.
            synthesizer.speakPlainText(
                    strToSpeak, null);
            synthesizer.waitEngineState(
                    Synthesizer.QUEUE_EMPTY);

            // Deallocate the Synthesizer.
            synthesizer.deallocate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

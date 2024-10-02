package KI35.Kliuchar.lab3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


interface VoiceControllable {
    void executeVoiceCommand(String command);
}
public class TVTuner extends TV implements VoiceControllable{
    private TunerType tunerType;
    private List<Channel> channels;


    public TVTuner() throws IOException {
        super(); // Викликаємо конструктор базового класу
        tunerType = TunerType.DIGITAL; // За замовчуванням цифровий тюнер
        channels = new ArrayList<>();
    }
    public TVTuner(TunerType tunerType, List<Channel> channels) throws IOException {
        super(); // Викликаємо конструктор базового класу
        this.tunerType = tunerType;
        this.channels = channels;
    }
    @Override
    public void executeVoiceCommand(String command) {
    	if (command.equals("включити")) {
    	    powerOnOff();
    	} else if (command.equals("виключити")) {
    	    powerOnOff();
    	} else if (command.equals("збільшити гучність")) {
    		increaseVolume(10);
    	} else if (command.equals("зменшити гучність")) {
    		decreaseVolume(10);
    	} else {
    	    System.out.println("Невідома команда");
    	}
    }
    public void searchChannels() {
    }

    public void changeTunerType(TunerType newType) {
        tunerType = newType;
    }
    public static class Channel {
        private int number;
        private String name;
        // Інші властивості каналу
    }
    public enum TunerType {
        ANALOG, DIGITAL, SATELLITE
    }
}
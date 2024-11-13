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
        super();
        setTunerType(TunerType.DIGITAL); 
        setChannels(new ArrayList<>());
    }
    public TVTuner(TunerType tunerType, List<Channel> channels) throws IOException {
        super();
        this.setTunerType(tunerType);
        this.setChannels(channels);
    }
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
        setTunerType(newType);
    }
    public TunerType getTunerType() {
		return tunerType;
	}
	public void setTunerType(TunerType tunerType) {
		this.tunerType = tunerType;
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public static class Channel {
        private int number;
        private String name;
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
    }
    public enum TunerType {
        ANALOG, DIGITAL, SATELLITE
    }
}
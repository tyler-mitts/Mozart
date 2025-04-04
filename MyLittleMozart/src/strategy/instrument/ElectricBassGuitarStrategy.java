package strategy.instrument;

import javax.sound.midi.*;

public class ElectricBassGuitarStrategy implements InstrumentStrategy{
	
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage programChange = new ShortMessage();
			programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
			MidiEvent event = new MidiEvent(programChange, 0);
			track.add(event);
		}catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}

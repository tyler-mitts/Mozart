package strategy.instrument;

import javax.sound.midi.*;

/**
 * Strategy implementation for the Electric Bass Guitar instrument.
 * Applies MIDI program number 33 (Electric Bass Guitar) to the specified track and channel.
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy {
	
	/**
	 * Applies the Electric Bass Guitar instrument (program 33) to the specified track and channel.
	 * Adds a PROGRAM_CHANGE message to the track at tick 0.
	 * 
	 * @param track   The MIDI track to apply the instrument to
	 * @param channel The MIDI channel (0-15) to apply the instrument to
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage programChange = new ShortMessage();
			programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
			MidiEvent event = new MidiEvent(programChange, 0);
			track.add(event);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}

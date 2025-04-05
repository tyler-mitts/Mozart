package strategy.instrument;

import javax.sound.midi.*;

/**
 * Strategy implementation for the Trumpet instrument.
 * Applies MIDI program number 56 (Trumpet) to the specified track and channel.
 */
public class TrumpetStrategy implements InstrumentStrategy {
	
	/**
	 * Applies the Trumpet instrument (program 56) to the specified track and channel.
	 * Adds a PROGRAM_CHANGE message to the track at tick 0.
	 * 
	 * @param track   The MIDI track to apply the instrument to
	 * @param channel The MIDI channel (0-15) to apply the instrument to
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage programChange = new ShortMessage();
			programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
			MidiEvent event = new MidiEvent(programChange, 0);
			track.add(event);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}

package strategy.instrument;

import javax.sound.midi.*;

/**
 * Strategy implementation for the Acoustic Grand Piano instrument.
 * Applies MIDI program number 0 (Acoustic Grand Piano) to the specified track and channel.
 */
public class AcousticGrandPianoStrategy implements InstrumentStrategy {
	
	/**
	 * Applies the Acoustic Grand Piano instrument (program 0) to the specified track and channel.
	 * Adds a PROGRAM_CHANGE message to the track at tick 0.
	 * 
	 * @param track   The MIDI track to apply the instrument to
	 * @param channel The MIDI channel (0-15) to apply the instrument to
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage programChange = new ShortMessage();
			programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
			MidiEvent event = new MidiEvent(programChange, 0);
			track.add(event);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}

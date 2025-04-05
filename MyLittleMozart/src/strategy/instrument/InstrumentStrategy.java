package strategy.instrument;

import javax.sound.midi.Track;

/**
 * Strategy interface for applying different instruments to a MIDI track.
 * Part of the Strategy design pattern implementation for instrument selection.
 * Concrete implementations define specific instruments by setting appropriate 
 * MIDI program change events.
 */
public interface InstrumentStrategy {
	/**
	 * Applies a specific instrument to the given MIDI track on the specified channel.
	 * Implementation adds a PROGRAM_CHANGE message to the track at tick 0.
	 * 
	 * @param track   The MIDI track to apply the instrument to
	 * @param channel The MIDI channel (0-15) to apply the instrument to
	 */
	void applyInstrument(Track track, int channel);
}

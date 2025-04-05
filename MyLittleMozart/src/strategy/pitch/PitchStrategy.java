package strategy.pitch;

/**
 * Strategy interface for modifying the pitch of MIDI notes.
 * Part of the Strategy design pattern implementation for pitch modification.
 * Concrete implementations define specific ways to transform MIDI note numbers.
 */
public interface PitchStrategy {
	/**
	 * Modifies the pitch of a MIDI note according to the strategy.
	 * 
	 * @param note The original MIDI note number (0-127)
	 * @return The modified MIDI note number (0-127)
	 */
	int modifyPitch(int note);
}

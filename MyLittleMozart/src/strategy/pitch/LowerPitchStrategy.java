package strategy.pitch;

/**
 * Strategy implementation that lowers the pitch of notes.
 * Decreases each note by 2 semitones (whole step) to create a lower sound.
 */
public class LowerPitchStrategy implements PitchStrategy {

	/**
	 * Decreases the MIDI note number by 2 semitones (a whole step).
	 * 
	 * @param note The original MIDI note number (0-127)
	 * @return The modified MIDI note number, lowered by 2 semitones
	 */
	@Override
	public int modifyPitch(int note) {
		int adjustedNote = note - 2;
		return adjustedNote;
	}
}

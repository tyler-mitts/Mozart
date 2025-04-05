package strategy.pitch;

/**
 * Strategy implementation that raises the pitch of notes.
 * Increases each note by 2 semitones (whole step) to create a higher sound.
 */
public class HigherPitchStrategy implements PitchStrategy {

	/**
	 * Increases the MIDI note number by 2 semitones (a whole step).
	 * 
	 * @param note The original MIDI note number (0-127)
	 * @return The modified MIDI note number, raised by 2 semitones
	 */
	@Override
	public int modifyPitch(int note) {
		int adjustedNote = note + 2;
		return adjustedNote;
	}
}

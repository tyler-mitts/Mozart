package strategy.pitch;

public class HigherPitchStrategy implements PitchStrategy {

	@Override
	public int modifyPitch(int note) {
		int adjustedNote = note + 2;
		return adjustedNote;
	}

}

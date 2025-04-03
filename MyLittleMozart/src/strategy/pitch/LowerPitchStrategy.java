package strategy.pitch;

public class LowerPitchStrategy implements PitchStrategy {

	@Override
	public int modifyPitch(int note) {
		int adjustedNote = note - 2;
		return adjustedNote;
	}

}

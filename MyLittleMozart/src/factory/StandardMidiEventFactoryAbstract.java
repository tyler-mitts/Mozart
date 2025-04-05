package factory;

/**
 * Abstract factory implementation that creates StandardMidiEventFactory instances.
 * Part of the Abstract Factory design pattern implementation.
 */
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Creates and returns a new StandardMidiEventFactory instance.
	 * 
	 * @return A new StandardMidiEventFactory that creates MIDI events with standard timing
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}
}

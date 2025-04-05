package factory;

/**
 * Abstract factory implementation that creates LegatoMidiEventFactory instances.
 * Part of the Abstract Factory design pattern implementation.
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Creates and returns a new LegatoMidiEventFactory instance.
	 * 
	 * @return A new LegatoMidiEventFactory that creates MIDI events with extended note duration
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}
}

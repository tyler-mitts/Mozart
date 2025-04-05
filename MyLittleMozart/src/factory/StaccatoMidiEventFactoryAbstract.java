package factory;

/**
 * Abstract factory implementation that creates StaccatoMidiEventFactory instances.
 * Part of the Abstract Factory design pattern implementation.
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * Creates and returns a new StaccatoMidiEventFactory instance.
	 * 
	 * @return A new StaccatoMidiEventFactory that creates MIDI events with shortened note duration
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}
}

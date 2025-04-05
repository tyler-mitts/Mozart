package factory;

/**
 * Abstract Factory interface for creating different types of MidiEventFactory instances.
 * Implements the Abstract Factory design pattern to provide a way to create families
 * of related objects (factories for different MIDI event styles).
 */
public interface MidiEventFactoryAbstract {
	/**
	 * Creates and returns a concrete MidiEventFactory implementation.
	 * 
	 * @return A concrete implementation of MidiEventFactory (Standard, Legato, or Staccato)
	 */
	MidiEventFactory createFactory();
}

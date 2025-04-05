package factory;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.InvalidMidiDataException;

/**
 * Interface for creating MIDI events using the Factory pattern.
 * Provides methods to create Note On and Note Off MIDI events with specific parameters.
 */
public interface MidiEventFactory {
	/**
	 * Creates a Note On MIDI event.
	 * 
	 * @param tick     The time in ticks when the note starts
	 * @param note     The MIDI note number (0-127)
	 * @param velocity The velocity (volume) of the note (0-127)
	 * @param channel  The MIDI channel (0-15)
	 * @return A MIDI event for the Note On message
	 * @throws InvalidMidiDataException If any parameter is invalid for MIDI specification
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	
	/**
	 * Creates a Note Off MIDI event.
	 * 
	 * @param tick    The time in ticks when the note ends
	 * @param note    The MIDI note number (0-127) to turn off
	 * @param channel The MIDI channel (0-15)
	 * @return A MIDI event for the Note Off message
	 * @throws InvalidMidiDataException If any parameter is invalid for MIDI specification
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}

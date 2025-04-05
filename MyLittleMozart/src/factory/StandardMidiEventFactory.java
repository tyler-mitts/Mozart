package factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Standard implementation of the MidiEventFactory interface.
 * Creates MIDI events with standard timing (no adjustments to note duration).
 */
public class StandardMidiEventFactory implements MidiEventFactory {

	/**
	 * Creates a standard Note On MIDI event at the specified tick.
	 * 
	 * @param tick     The time in ticks when the note starts
	 * @param note     The MIDI note number (0-127)
	 * @param velocity The velocity (volume) of the note (0-127)
	 * @param channel  The MIDI channel (0-15)
	 * @return A MIDI event for the Note On message
	 * @throws InvalidMidiDataException If any parameter is invalid for MIDI specification
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick);
	}

	/**
	 * Creates a standard Note Off MIDI event at the specified tick.
	 * 
	 * @param tick    The time in ticks when the note ends
	 * @param note    The MIDI note number (0-127) to turn off
	 * @param channel The MIDI channel (0-15)
	 * @return A MIDI event for the Note Off message
	 * @throws InvalidMidiDataException If any parameter is invalid for MIDI specification
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(message, tick);
	}
}

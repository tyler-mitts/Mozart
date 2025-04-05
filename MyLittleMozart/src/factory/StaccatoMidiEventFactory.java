package factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Staccato implementation of the MidiEventFactory interface.
 * Creates MIDI events with shortened note duration for a sharp, detached sound.
 * Implements the staccato playing style by moving Note Off events earlier.
 */
public class StaccatoMidiEventFactory implements MidiEventFactory {

	/**
	 * Creates a standard Note On MIDI event at the specified tick.
	 * The staccato style is achieved by shortening the note duration in the Note Off event.
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
	 * Creates an earlier Note Off MIDI event to achieve staccato (short, detached) effect.
	 * Shortens the note duration by moving the Note Off event 120 ticks earlier, but not before 0.
	 * 
	 * @param tick    The time in ticks when the note would normally end
	 * @param note    The MIDI note number (0-127) to turn off
	 * @param channel The MIDI channel (0-15)
	 * @return A MIDI event for the earlier Note Off message
	 * @throws InvalidMidiDataException If any parameter is invalid for MIDI specification
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		int adjustedTick = Math.max(tick - 120, 0);
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(message, adjustedTick);
	}
}

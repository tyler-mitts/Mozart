package factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Legato implementation of the MidiEventFactory interface.
 * Creates MIDI events with extended note duration for a smooth, connected sound.
 * Implements the legato playing style by delaying Note Off events.
 */
public class LegatoMidiEventFactory implements MidiEventFactory {

	/**
	 * Creates a standard Note On MIDI event at the specified tick.
	 * The legato style is achieved by extending the note duration in the Note Off event.
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
	 * Creates a delayed Note Off MIDI event to achieve legato (smooth, connected) effect.
	 * Extends the note duration by delaying the Note Off event by 80 ticks.
	 * 
	 * @param tick    The time in ticks when the note would normally end
	 * @param note    The MIDI note number (0-127) to turn off
	 * @param channel The MIDI channel (0-15)
	 * @return A MIDI event for the delayed Note Off message
	 * @throws InvalidMidiDataException If any parameter is invalid for MIDI specification
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		int adjustedTick = tick + 80;
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(message, adjustedTick);
	}
}

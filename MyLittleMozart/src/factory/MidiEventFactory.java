package factory;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.InvalidMidiDataException;

public interface MidiEventFactory {
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}

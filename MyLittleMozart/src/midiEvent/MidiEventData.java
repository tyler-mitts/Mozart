package midiEvent;

/**
 * Data class that stores MIDI event information parsed from CSV files.
 * Contains all necessary information to create MIDI events for playback,
 * including timing, pitch, velocity, and instrument details.
 */
public class MidiEventData {
	/** The tick (time position) when the note starts or ends */
	private int startEndTick;
	
	/** The velocity (volume) of the note (0-127) */
	private int velocity;
	
	/** The MIDI note number (0-127) */
	private int note;
	
	/** The MIDI channel (0-15) */
	private int channel;
	
	/** The type of event: ShortMessage.NOTE_ON or ShortMessage.NOTE_OFF */
	private int noteOnOff;
	
	/** The MIDI program number representing the instrument (0-127) */
	private int instrument;
	
	/**
	 * Constructs a new MidiEventData object with specified parameters.
	 * 
	 * @param startEndTick The tick (time position) for the event
	 * @param velocity     The velocity (volume) of the note (0-127)
	 * @param note         The MIDI note number (0-127)
	 * @param channel      The MIDI channel (0-15)
	 * @param noteOnOff    The type of event (NOTE_ON or NOTE_OFF)
	 * @param instrument   The MIDI program number for the instrument
	 */
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int noteOnOff, int instrument) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.noteOnOff = noteOnOff;
		this.instrument = instrument;
	}

	/**
	 * Returns a string representation of the MidiEventData object.
	 * 
	 * @return A string containing all the object's field values
	 */
	@Override
	public String toString() {
		return "MidiEventData [startEndTick=" + startEndTick + ", velocity=" + velocity + ", note=" + note
				+ ", channel=" + channel + ", noteOnOff=" + noteOnOff + ", instrument=" + instrument + "]";
	}
	
	/**
	 * Gets the start/end tick value.
	 * 
	 * @return The tick (time position) when the note starts or ends
	 */
	public int getStartEndTick() {
		return startEndTick;
	}

	/**
	 * Sets the start/end tick value.
	 * 
	 * @param startEndTick The tick (time position) to set
	 */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	/**
	 * Gets the velocity value.
	 * 
	 * @return The velocity (volume) of the note (0-127)
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * Sets the velocity value.
	 * 
	 * @param velocity The velocity (volume) to set (0-127)
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * Gets the note value.
	 * 
	 * @return The MIDI note number (0-127)
	 */
	public int getNote() {
		return note;
	}

	/**
	 * Sets the note value.
	 * 
	 * @param note The MIDI note number to set (0-127)
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * Gets the channel value.
	 * 
	 * @return The MIDI channel (0-15)
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * Sets the channel value.
	 * 
	 * @param channel The MIDI channel to set (0-15)
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * Gets the noteOnOff value.
	 * 
	 * @return The type of event (NOTE_ON or NOTE_OFF)
	 */
	public int getNoteOnOff() {
		return noteOnOff;
	}

	/**
	 * Sets the noteOnOff value.
	 * 
	 * @param noteOnOff The type of event to set (NOTE_ON or NOTE_OFF)
	 */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	/**
	 * Gets the instrument value.
	 * 
	 * @return The MIDI program number for the instrument (0-127)
	 */
	public int getInstrument() {
		return instrument;
	}

	/**
	 * Sets the instrument value.
	 * 
	 * @param instrument The MIDI program number to set (0-127)
	 */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
}

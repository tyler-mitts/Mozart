package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.midi.ShortMessage;

import midiEvent.MidiEventData;

/**
 * Utility class for parsing MIDI data from CSV files.
 * Extracts MIDI event information and converts it into MidiEventData objects.
 */
public class MidiCsvParser {
	
	/**
	 * Parses a CSV file containing MIDI event data.
	 * 
	 * <p>The CSV file should have at least 6 columns in the following order:
	 * <ol>
	 *   <li>Tick (time position)</li>
	 *   <li>Note event type ("Note_on_c" or other for Note Off)</li>
	 *   <li>Channel (0-15)</li>
	 *   <li>Note number (0-127)</li>
	 *   <li>Velocity (0-127)</li>
	 *   <li>Instrument number (0-127)</li>
	 * </ol>
	 * 
	 * @param filePath The path to the CSV file to parse
	 * @return A List of MidiEventData objects containing the parsed data, or null if the file is not found
	 */
	public static List<MidiEventData> parseCsv(String filePath) {
		try {
			File f = new File(filePath); // Creates file object using filePath
			int numOfLines = 0;
			Scanner scanner = new Scanner(f); // Creates scanner for parsing file
			while(scanner.hasNextLine() != false) { // Tests how many lines are in the file
				numOfLines++;
				scanner.nextLine();
			}
			scanner.close(); // Resets scanner position
			scanner = new Scanner(f);
			List<MidiEventData> midiObjects = new ArrayList<MidiEventData>(numOfLines); // Create array of MidiEventData objects with the size the number of entries in file
			for(int i = 0; i<numOfLines; i++) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				
				if(parts.length >= 6) {
					int startEndTick = Integer.parseInt(parts[0].trim());
					int noteOnOff = parts[1].trim().equals("Note_on_c") ? ShortMessage.NOTE_ON : ShortMessage.NOTE_OFF;
					int channel = Integer.parseInt(parts[2].trim());
					int note = Integer.parseInt(parts[3].trim());
					int velocity = Integer.parseInt(parts[4].trim());
					int instrument = Integer.parseInt(parts[5].trim());
					
					midiObjects.add(i, new MidiEventData(startEndTick, velocity, note, channel, noteOnOff, instrument));
				}
			}
			scanner.close();
			return midiObjects;
		} catch(FileNotFoundException e) {
			System.err.println("The file could not be found."); // Returns error if file is invalid
			return null;
		}
	}
}

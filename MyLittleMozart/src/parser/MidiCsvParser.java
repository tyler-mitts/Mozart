package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.midi.ShortMessage;
import java.util.regex.Pattern;

import midiEvent.MidiEventData;

public class MidiCsvParser {
	
	public static List<MidiEventData> parseCsv(String filePath) {
		try {
			File f = new File(filePath); //Creates file object using filePath
			int numOfLines = 0;
			Scanner scanner = new Scanner(f); //Creates scanner for parsing file
			while(scanner.hasNextLine() != false) { //Tests how many lines are in the file
				numOfLines++;
				scanner.nextLine();
			}
			scanner.close(); //Resets scanner position
			scanner = new Scanner(f);
			List<MidiEventData> midiObjects = new ArrayList<MidiEventData>(numOfLines); //Create array of MidiEventData objects with the size the number of entries in file
			Pattern pattern = Pattern.compile("[A-Za-z_]*(?=,)");
			for(int i = 0; i<numOfLines; i++) {
				int startEndTick = scanner.nextInt();
				scanner.skip(",");
				int noteOnOff = scanner.next(pattern).equals("Note_on_c") ? ShortMessage.NOTE_ON : ShortMessage.NOTE_OFF;
				scanner.skip(",");
				int channel = scanner.nextInt();
				scanner.skip(",");
				int note = scanner.nextInt();
				scanner.skip(",");
				int velocity = scanner.nextInt();
				scanner.skip(",");
				int instrument = scanner.nextInt();
				midiObjects.add(i, new MidiEventData(startEndTick,velocity,note,channel,noteOnOff,instrument));

			}
			scanner.close();
			return midiObjects;
		} catch(FileNotFoundException e) {
			System.err.println("The file could not be found."); //Returns error if file is invalid
			return null;
		}
	}
}

package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import midiEvent.MidiEventData;

public class MidiCsvParser {
	
	public static MidiEventData[] parseFile(String filePath) {
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
			MidiEventData[] midiObjects = new MidiEventData[numOfLines]; //Create array of MidiEventData objects with the size the number of entries in file
			for(int i = 0; i<numOfLines; i++) {
				int startEndTick = scanner.nextInt();
				int velocity = scanner.nextInt();
				int note = scanner.nextInt();
				int channel = scanner.nextInt();
				int noteOnOff = scanner.nextInt();
				int instrument = scanner.nextInt();
				midiObjects[i] = new MidiEventData(startEndTick,velocity,note,channel,noteOnOff,instrument);

			}
			scanner.close();
			return midiObjects;
		} catch(FileNotFoundException e) {
			System.err.println("The file could not be found."); //Returns error if file is invalid
			return null;
		}
	}
}

package main;

import midiEvent.MidiEventData;
import parser.MidiCsvParser;

public class Main {

	public static void main(String[] args) {
		
		
		//Testing file to see if parsing works
		MidiEventData[] data = MidiCsvParser.parseFile("\\Users\\TylerM\\git\\Mozart\\MyLittleMozart\\src\\main\\testfile.csv");
		
		for(int i = 0;i<2;i++) {
			System.out.println(data[i].toString());
		}
		
		
		
		

	}

}

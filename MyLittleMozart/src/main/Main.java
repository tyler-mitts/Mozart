package main;

import javax.sound.midi.*;
import java.util.List;
import parser.MidiCsvParser;
import factory.*;
//import factory.LegatoMidiEventFactoryAbstract;
//import factory.StaccatoMidiEventFactoryAbstract;
import strategy.instrument.*;
import strategy.pitch.*;
import midiEvent.MidiEventData;

/**
 * Main application class for MyLittleMozart.
 * Demonstrates the use of design patterns (Factory and Strategy) to create and manipulate MIDI sequences.
 */
public class Main {
    /**
     * Entry point for the application.
     * Parses MIDI data from a CSV file, applies instruments and pitch modifications,
     * and plays the resulting sequence.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Parse MIDI data from CSV file
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("resources/mystery_song.csv");
            // Create a new MIDI sequence with resolution of 384 pulses per quarter note
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();
            
            // Use Abstract Factory pattern to create a MIDI event factory
//            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
             MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
//             MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();
            
            // Apply instrument strategies to channels
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);
            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);
            
            // Apply pitch strategy to modify notes
            PitchStrategy pitchStrategy = new HigherPitchStrategy();
//            PitchStrategy pitchStrategy = new LowerPitchStrategy();
            
            // Process each MIDI event
            for (MidiEventData event : midiEvents) {
                // Apply pitch strategy twice to raise by 4 semitones total
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
                
                // Create and add appropriate MIDI events to the track
                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(
                        event.getStartEndTick(),
                        modifiedNote,
                        event.getVelocity(),
                        event.getChannel()
                    ));
                } else {
                    track.add(factory.createNoteOff(
                        event.getStartEndTick(),
                        modifiedNote,
                        event.getChannel()
                    ));
                }
            }
            
            // Set up and start the MIDI sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();
            
            // Keep the program running until playback completes
            while (sequencer.isRunning() || sequencer.isOpen()) {
                Thread.sleep(100);
            }
            
            // Clean up
            Thread.sleep(500);
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

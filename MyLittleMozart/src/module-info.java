/**
 * Module definition for MyLittleMozart application.
 * 
 * <p>This module provides functionality for parsing, modifying, and playing MIDI files.
 * It uses design patterns such as Factory and Strategy to create flexible MIDI processing.</p>
 * 
 * <p>The application reads MIDI data from CSV files, applies various transformations
 * (instrument selection, playing style, pitch adjustments), and plays the resulting music.</p>
 */
module MyLittleMozart {
	/**
	 * Requires java.desktop module for MIDI functionality (javax.sound.midi)
	 */
	requires java.desktop;
}
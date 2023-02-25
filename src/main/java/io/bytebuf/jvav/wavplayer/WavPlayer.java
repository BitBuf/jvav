/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * See the LICENSE file at the root of this repository.
 */

package io.bytebuf.jvav.wavplayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Plays a .wav file all the way through using JavaFX's sound API.
 *
 * @author ByteBuf
 */
public class WavPlayer {
    private static final int BUFFER_SIZE = 4096;

    private File audioFile;

    public WavPlayer(String path) {
        try {
            String mediaType = Files.probeContentType(Paths.get(path));

            if (mediaType.equals("audio/wav")) {
                audioFile = new File(path);
            } else {
                System.err.println("The file (" + path + ") is not a .wav file. Its media type is " + mediaType);
                System.exit(-1);
            }
        } catch (IOException e) {
            System.err.println("An IO exception occurred trying to access " + path);
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Plays the .wav file that was just validated.
     */
    private void play() {
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);

            audioLine.open(format);
            audioLine.start();

            System.out.println("Playing: " + audioFile.getName());

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = audioStream.read(buffer)) != -1) {
                audioLine.write(buffer, 0, bytesRead);
            }

            audioLine.drain();
            audioLine.close();

            System.out.println("Finished playback.");
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.err.println("Could not play audio file: " + audioFile.getName());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WavPlayer(args.length > 0 ? args[0] : "src/main/resources/xp.wav").play();
    }
}

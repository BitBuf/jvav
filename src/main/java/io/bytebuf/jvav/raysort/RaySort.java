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

package io.bytebuf.jvav.raysort;

import java.util.Arrays;
import java.util.Random;

/**
 * Revolutionary sorting algorithm dependent upon the innate bit flipping abilities of cosmic rays.
 *
 * @author ByteBuf
 */
public final class RaySort {
    /**
     * An array of 8-bit bytes, encoded in binary format within the JVM Hotspot Engine.
     */
    private final byte[] startingArray = new byte[50];

    /**
     * RaySort's ideal reference implementation.
     */
    private void run() {
        // Generate random bytes to fill startingArray with, for demonstration purposes.
        new Random().nextBytes(startingArray);

        // Initialize the "goal" array; a new concept unique to RaySort.
        byte[] goalArray = startingArray.clone();
        Arrays.sort(goalArray);

        // Ray-based bit flip handler implementation.
        while (goalArray != startingArray) {
            System.err.println("Ray-based bit flipping on startingArray incomplete. Recalculating...");
        }

        System.out.println("Finished ray-based sorting!");
        System.out.println("Sorted array: " + Arrays.toString(goalArray));
    }

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new RaySort().run();
    }
}

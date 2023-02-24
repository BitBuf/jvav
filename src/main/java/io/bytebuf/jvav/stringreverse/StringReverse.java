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

package io.bytebuf.jvav.stringreverse;

import static io.bytebuf.jvav.utils.JvavUtils.CONSOLE_SCANNER;

/**
 * Takes in an input string and reverses it.
 *
 * @author ByteBuf
 */
public final class StringReverse {
    public static void main(String[] args) {
        System.out.println("Enter string to reverse:");
        char[] str = CONSOLE_SCANNER.nextLine().toCharArray();

        char[] reversed = new char[str.length];

        int highestIndex = str.length - 1;
        for (int i = highestIndex; i >= 0; i--) {
            reversed[highestIndex - i] = str[i];
        }

        System.out.println(String.valueOf(reversed));
    }
}

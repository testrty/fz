package com.util;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class cc {

    public static void main(String[] args) throws Exception {

        final int BUFFER_SIZE = 0x300000;

        String directory = "rmek";
        String fileName = "myFile.txt";
        File f = new File(directory,fileName);

        MappedByteBuffer inputBuffer = new RandomAccessFile(f, "r").getChannel().map(FileChannel.MapMode.READ_ONLY,
                f.length() / 2, f.length() / 2);

        byte[] dst = new byte[BUFFER_SIZE];

        long start = System.currentTimeMillis();

        for (int offset = 0; offset < inputBuffer.capacity(); offset += BUFFER_SIZE) {

            if (inputBuffer.capacity() - offset >= BUFFER_SIZE) {

                for (int i = 0; i < BUFFER_SIZE; i++)

                    dst[i] = inputBuffer.get(offset + i);

            } else {

                for (int i = 0; i < inputBuffer.capacity() - offset; i++)

                    dst[i] = inputBuffer.get(offset + i);

            }

            int length = (inputBuffer.capacity() % BUFFER_SIZE == 0) ? BUFFER_SIZE
                    : inputBuffer.capacity() % BUFFER_SIZE;

            System.out.println(new String(dst, 0, length));// new
            // String(dst,0,length)

        }

        long end = System.currentTimeMillis();

        System.out.println("timeover:" + (end - start) + "hm");

    }
}
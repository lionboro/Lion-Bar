package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	private InputStream In;

	public MyDecompressorInputStream(FileInputStream In) {
		this.In = In;
	}

	// read from file
	public int read() throws IOException {
		return In.read();
	}

	@Override
	public int read(byte[] Bytes) throws IOException {
		byte last;
		byte counter;
		int inSize = In.available();
		int k = 0; // the number of current used bytes

		for (int i = 0; i < inSize; i += 2) {
			if (Bytes.length <= k)
				break;

			last = (byte) In.read();
			counter = (byte) In.read();

			for (int j = 0; j < counter; j++) {
				if (Bytes.length <= k)
					break;
				Bytes[k++] = last;
			}
		}

		return -1;

	}
}
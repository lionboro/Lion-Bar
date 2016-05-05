package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	OutputStream Out;

	public MyCompressorOutputStream(OutputStream Out) {
		this.Out = Out;

	}

	@Override
	public void write(int b) throws IOException {
		Out.write(b);

	}

	public void write(byte[] b) throws IOException {
		byte lastByte = b[0];
		int count = 1;
		for (int i = 1; i < b.length; i++) {
			if (b[i] == lastByte)
				count++;
			else {
				while (count > 255) {
					Out.write(lastByte);
					Out.write(255);
					count -= 255;
				}
				Out.write(lastByte); 
				Out.write(count);
				lastByte = b[i];
				count = 1;
			}

		}
	}
}
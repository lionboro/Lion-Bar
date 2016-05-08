package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream{

	InputStream In;
	
	public MyDecompressorInputStream(InputStream In) {
		this.In=In;
	}
	public int read() throws IOException
	{
		return In.read();
	}
	
	@Override
	public int read(byte[] Bytes) throws IOException {
		int size=In.available();
		System.out.println(size);
		return size;
	}

}

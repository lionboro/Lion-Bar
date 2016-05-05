package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream{

	InputStream In;
	
	public MyDecompressorInputStream(InputStream In) {
		this.In=In;
	}
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}

package algorithms.io;

import java.io.DataInputStream;
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
	public int read(byte[] arr) throws IOException {
    DataInputStream data = new DataInputStream(In);
		
		byte num;
		int i = 0;
		int index;
		
		while (data.available() >= 5 && i < arr.length){
			num = data.readByte();
			index = data.readInt();
			index += i;
			
		for (;i < index; i++) {
			arr[i] = num ;
			
		}
		
		}

		
		return arr.length;
	}
}
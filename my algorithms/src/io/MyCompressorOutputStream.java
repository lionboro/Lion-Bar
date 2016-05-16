package io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {


	private OutputStream Out;

	public MyCompressorOutputStream(OutputStream Out) {
		this.Out = Out;

	}

	@Override
	public void write(int b) throws IOException {
		Out.write(b);

	}

	//write to file
	public void write(byte[] arr) throws IOException {
		DataOutputStream data = new DataOutputStream(Out);
		int counter = 0;
		byte num = arr[0];
	
	    for (byte b : arr) {
		if(b == num){
		   counter++;	
		}
		else{	
		data.writeByte(num);
		data.writeInt(counter);
		num = b;
		counter = 1;	
		}
		
	}
	
	data.writeByte(num);
	data.writeInt(counter);
	}
}
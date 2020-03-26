package multithreaded.chapter03.pipeReaderWriter.src.extthread;

import java.io.PipedReader;

import multithreaded.chapter03.pipeInputOutput.src.service.ReadData;

public class ThreadRead extends Thread {

	private ReadData read;
	private PipedReader input;

	public ThreadRead(ReadData read, PipedReader input) {
		super();
		this.read = read;
		this.input = input;
	}

	@Override
	public void run() {
		read.readMethod(input);
	}
}

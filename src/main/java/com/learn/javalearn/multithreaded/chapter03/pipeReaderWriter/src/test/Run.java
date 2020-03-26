package multithreaded.chapter03.pipeReaderWriter.src.test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

import multithreaded.chapter03.pipeInputOutput.src.service.ReadData;
import multithreaded.chapter03.pipeInputOutput.src.service.WriteData;
import multithreaded.chapter03.pipeInputOutput.src.extthread.ThreadRead;
import multithreaded.chapter03.pipeInputOutput.src.extthread.ThreadWrite;

public class Run {

	public static void main(String[] args) {

		try {
			WriteData writeData = new WriteData();
			ReadData readData = new ReadData();

			PipedReader inputStream = new PipedReader();
			PipedWriter outputStream = new PipedWriter();

			// inputStream.connect(outputStream);
			outputStream.connect(inputStream);

			ThreadRead threadRead = new ThreadRead(readData, inputStream);
			threadRead.start();

			Thread.sleep(2000);

			ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
			threadWrite.start();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
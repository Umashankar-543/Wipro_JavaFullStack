package Day_25;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOExample {

	public static void main(String[] args) {
		Path sourcePath = Paths.get("source.txt");
		Path destinationPath = Paths.get("destination.txt");
		try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
				FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE,
						StandardOpenOption.WRITE)) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while (sourceChannel.read(buffer) > 0) {
				buffer.flip();
				destinationChannel.write(buffer);
				buffer.clear();
			}
			System.out.println("File copied successfully using NIO.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
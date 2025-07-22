package NetworkProgramming.NI0;

import java.nio.ByteBuffer;

public class BufferPractice {
    public static void main(String[] args) {
        //Creating a buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocateDirect(1024);
        //wraping data
        byte[] data = "Hello World".getBytes();
        ByteBuffer buffer3 = ByteBuffer.wrap(data);


    }
}

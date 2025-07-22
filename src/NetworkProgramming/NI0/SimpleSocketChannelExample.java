package NetworkProgramming.NI0;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SimpleSocketChannelExample {
    public static void main(String[] args) throws Exception {
        // 1. Open socket channel
        SocketChannel socketChannel = SocketChannel.open();

        // 2. Connect to server
        socketChannel.connect(new InetSocketAddress("localhost", 5000));

        // 3. Write data to server
        ByteBuffer writeBuffer = ByteBuffer.wrap("Hello Server!".getBytes());
        socketChannel.write(writeBuffer);

        // 4. Read response from server
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(readBuffer);
        readBuffer.flip();
        byte[] data = new byte[bytesRead];
        readBuffer.get(data);
        System.out.println("Received: " + new String(data));

        // 5. Close channel
        socketChannel.close();
    }
}


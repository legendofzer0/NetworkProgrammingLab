package NetworkProgramming.NI0;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SimpleNioServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(5000));
        System.out.println("Server listening on port 5000...");

        SocketChannel client = serverChannel.accept();  // Waits for client connection
        System.out.println("Client connected!");

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = client.read(buffer);
        buffer.flip();

        byte[] data = new byte[bytesRead];
        buffer.get(data);
        System.out.println("Received from client: " + new String(data));

        // Echo back to client
        buffer.rewind();
        client.write(buffer);

        client.close();
        serverChannel.close();
    }
}


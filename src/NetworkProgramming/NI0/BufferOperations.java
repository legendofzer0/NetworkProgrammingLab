package NetworkProgramming.NI0;

import java.nio.ByteBuffer;

public class BufferOperations {
    public static void main(String[] args) {
        // 1. Filling the buffer (put)
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (byte i = 1; i <= 5; i++) {
            buffer.put(i);
        }
        System.out.println("Filled Buffer: " + buffer);

        // 2. Draining (reading) the buffer
        buffer.flip(); // switch to read mode
        System.out.print("Drained Data: ");
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
        System.out.println("\nAfter Draining: " + buffer);

        // 3. Refill buffer with new data
        buffer.clear();
        for (byte i = 10; i < 15; i++) {
            buffer.put(i);
        }

        // 4. Duplicate buffer
        ByteBuffer duplicate = buffer.duplicate();
        System.out.println("Duplicate Buffer: " + duplicate);

        // 5. Slice buffer (slice from index 2 to limit)
        buffer.position(2);
        ByteBuffer slice = buffer.slice(); // creates a new buffer starting at position 2
        System.out.println("Slice Buffer : " + slice);

        // Read slice contents
        System.out.print("Slice Data: ");
        while (slice.hasRemaining()) {
            System.out.print(slice.get() + " ");
        }
        System.out.println();

        // 6. Compact buffer
        buffer.clear(); // Put some new data
        buffer.put((byte) 99);
        buffer.put((byte) 100);
        buffer.flip();
        buffer.get(); // read one item
        buffer.compact(); // keeps unread data and makes space for more
        System.out.println("After Compact: " + buffer);
    }
}

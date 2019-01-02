package com;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.Charset;

class SenderThread implements Runnable {
    private Pipe pipe;
    public SenderThread (Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void run(){
        try {
            Pipe.SinkChannel sink = pipe.sink();
            String writeData = "threadA";
            System.out.println("线程A输入数据：" + writeData);
            ByteBuffer byteBuffer =ByteBuffer.allocate(64);
            byteBuffer.put(writeData.getBytes("UTF-8"));
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                sink.write(byteBuffer);
            }
            byteBuffer.clear();
            sink.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

class ReaderThread implements Runnable {
    private Pipe pipe;
    public ReaderThread (Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void run(){
        try {
            Pipe.SourceChannel source = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int readSize = source.read(byteBuffer);
            byteBuffer.flip();
            while (readSize != -1) {
                System.out.println(Charset.forName("UTF-8").decode(byteBuffer));
                byteBuffer.clear();
                readSize = source.read(byteBuffer);
            }
            source.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
public class PipeTest {
    public static void main(String[] args) throws Exception{
        Pipe pipe = Pipe.open();
        Thread sender = new Thread(new SenderThread(pipe), "senderThread");
        Thread reader = new Thread(new ReaderThread(pipe), "readerThread");
        sender.start();
        reader.start();
    }
}

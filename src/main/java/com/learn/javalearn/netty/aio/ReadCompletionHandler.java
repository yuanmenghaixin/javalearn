package netty.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Administrator on 2017/3/17.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel asynchronousSocketChannel;
//我们将AsynchronousSocketChannel通过参数传递到ReadCompletionHandler中，当作成员变量来使用 ，主要用于读取半包消息和发送应答。
    public ReadCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel) {
        if (this.asynchronousSocketChannel == null) {
            this.asynchronousSocketChannel = asynchronousSocketChannel;
        }
    }

    /**
     * Invoked when an operation has completed.
     *读取到消息后的处理
     * @param result     The result of the I/O operation.
     * @param attachment
     */
    public void completed(Integer result, ByteBuffer attachment) {
        //首先对attachment进行flip操作，为后续从缓存区读取数据做准备。根据缓冲区的可读字节数创建byte数组，然后通过new String
        //方法创建请求消息，对请求消息进行判断，如果是“QUERY TIME ORDER”则获取当前系统服务器的时间，调用doWrite方法发送给客户端。
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, "UTF-8");
            System.out.println("The time server receive order:" + req);
            String currenTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";
            doWrite(currenTime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String currenTime) {
        //首先对当前时间进行合法性的验证，如果合法，调用字符串的解码方法将应答消息编码成字节数组，然后将它复制到发送缓存区writeBuffer中
        //最后调用AsynchronousSocketChannel的异步write方法。正如前面介绍的异步热read方法一样，它也有三个与read方法相同的参数，
        if (currenTime != null && currenTime.trim().length() > 0) {
            byte[] bytes = (currenTime).getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            asynchronousSocketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                /**
                 * Invoked when an operation has completed.
                 *
                 * @param result     The result of the I/O operation.
                 * @param buffer
                 */
                public void completed(Integer result, ByteBuffer buffer) {
                    //如果没有发送完成，继续发送
                    if (buffer.hasRemaining()) {
                        asynchronousSocketChannel.write(buffer, buffer, this);
                    }
                }

                /**
                 * Invoked when an operation fails.
                 *
                 * @param exc        The exception to indicate why the I/O operation failed
                 * @param attachment
                 */
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        asynchronousSocketChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * Invoked when an operation fails.
     *
     * @param exc        The exception to indicate why the I/O operation failed
     * @param attachment
     */
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.asynchronousSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

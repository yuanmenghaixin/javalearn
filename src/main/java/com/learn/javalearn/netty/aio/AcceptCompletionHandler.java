package netty.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by Administrator on 2017/3/17.
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {
    /**
     * Invoked when an operation has completed.
     *
     * @param result     The result of the I/O operation.
     * @param attachment
     */
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        //我们从attachment获取成员变量asynchronousServerSocketChannel，然后继续调用它的accept方法。有的读者可能心存疑惑：
        //既然已经接收客户端成功了，为什么还要再次调用accept方法？原因是这样的：调用asynchronousServerSocketChannel的accept方法后，
        //如果有新的客户端连接接入，系统将回调我们传入的CompletionHandler实例的completed方法，表示新的客户端连接接入，
        // 因为一个asynchronousServerSocketChannel可以接收成千上万个客户端，所以需要继续调用它的accept方法，接收其他的客户端连接，
        //最终形成一个循环。每当接受一个客户读连接成功之后，再异步接收新的客户端连接。
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        //链路建立成功之后，服务端需要接受客户端的请求消息，创建ByteBuffer,预分配1MB的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //调用AsynchronousSocketChannel的read方法，进行异步读操作。
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    /**
     * Invoked when an operation fails.
     *
     * @param exc        The exception to indicate why the I/O operation failed
     * @param attachment
     */
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}

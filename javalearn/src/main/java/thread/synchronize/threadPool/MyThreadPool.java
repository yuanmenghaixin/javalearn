package thread.synchronize.threadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 最后，是我们的服务器端，它不断接受客户端的请求，每收到一个连接请求，服务器端会新开一个线程，来处理后续客户端发来的各种操作指令。
 */
public class MyThreadPool {
    public static void main(String[] args) throws IOException {
        MyThreadPool pool = new MyThreadPool(5);
    }

    private int threadCount;
    private MyThread[] threads = null;


    public MyThreadPool(int count) throws IOException {
        this.threadCount = count;
        threads = new MyThread[count];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
        Init();
    }

    private void Init() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5678);
        while (true) {
            final Socket socket = serverSocket.accept();
            Thread thread = new Thread() {
                public void run() {
                    try {
                        System.out.println("检测到一个新的Socket连接。");
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                            if (line.equals("Count")) {
                                System.out.println("线程池中有5个线程");
                            } else if (line.equals("Status")) {
                                String status = MyThreadManager.getThreadStatus(threads);
                                System.out.println(status);
                            } else if (line.equals("StartAll")) {
                                MyThreadManager.manageThread(threads, ThreadTask.Start);
                            } else if (line.equals("StopAll")) {
                                MyThreadManager.manageThread(threads, ThreadTask.Stop);
                            } else if (line.equals("SleepAll")) {
                                MyThreadManager.manageThread(threads, ThreadTask.Sleep);
                            } else if (line.equals("WakeupAll")) {
                                MyThreadManager.manageThread(threads, ThreadTask.Wakeup);
                            } else if (line.equals("End")) {
                                break;
                            } else {
                                System.out.println("Command:" + line);
                            }
                            ps.println("OK");
                            ps.flush();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }
}
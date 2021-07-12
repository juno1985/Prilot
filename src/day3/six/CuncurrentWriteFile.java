package day3.six;

import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CuncurrentWriteFile {

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "//" + "out.txt";

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            es.submit(()->{
               File file = new File(filePath);
                FileLock lock = null;
                RandomAccessFile raf = null;
                FileChannel channel = null;
                try {
                    raf = new RandomAccessFile(file, "rw");
                    channel = raf.getChannel();

                  while(true){
                      try {
                          lock = channel.tryLock();
                          if(lock.isValid()){
                              raf.seek(raf.length());
                              raf.write(Thread.currentThread().getName().getBytes());
                              raf.write("\r\n".getBytes());
                              Thread.sleep(500);
                              break;
                          }
                      } catch (Exception e) {
                          System.out.println(Thread.currentThread().getName() + " failed getting FILE LOCK and will retry");
                          Thread.yield();
                      }
                  }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        lock.release();
                        channel.close();
                        raf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        es.shutdown();
    }
}

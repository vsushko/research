package threads;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = newThread(r);
        t.setDaemon(true);
        return t;
    }
}

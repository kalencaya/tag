package cn.sliew.tag.lifecycle;

import cn.sliew.tag.release.Closeable;

public interface Lifecycle extends Closeable {

    void addLifecycleListener(LifecycleListener listener);

    void removeLifecycleListener(LifecycleListener listener);

    void start();

    void stop();
}

package cn.sliew.tag.lifecycle;

public interface LifecycleListener {

    default void beforeStart() {}

    default void afterStart() {}

    default void beforeStop() {}

    default void afterStop() {}

    default void beforeClose() {}

    default void afterClose() {}
}
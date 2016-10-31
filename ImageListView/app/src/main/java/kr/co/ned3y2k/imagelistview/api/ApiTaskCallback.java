package kr.co.ned3y2k.imagelistview.api;

/**
 * Created by User on 2016-10-21.
 */

public interface ApiTaskCallback<T> {
    void run(T result);
}

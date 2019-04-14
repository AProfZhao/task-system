package com.talenco.tasksystem.entity;

import java.util.Objects;

/**
 * 用于做值传递的 key-value 对象
 *
 * 在 Kv 集合中，K 应保持唯一，并且在一般情况下，各对象 K, V应分别保持一致
 * 只有 K 的部分参与 equals 与 hashcode
 *
 * @param <K> key 类型
 * @param <V> value 类型
 */
public class Kv<K, V> {
    K k;
    V v;

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Kv<?, ?> kv = (Kv<?, ?>) o;
        return k.equals(kv.k);
    }

    @Override
    public int hashCode() {
        return Objects.hash(k);
    }
}

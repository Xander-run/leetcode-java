package org.example.sort;

public interface Sorter {
    public <T extends Comparable<T>> T[] sort(T[] input);
}

package com.asciugano.engine.memory;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryMapper<T> {

  private final Map<T, MemorySlot> map = new HashMap<>();

  // TODO: implementare la lista degli elementi liberati
  private final List<Integer> freed = new ArrayList<>(0);
  private int currenByteSize = 0;

  public MemorySlot store(T key, byte[] data) {
    int size = data.length;

    MemorySlot slot = new MemorySlot(currenByteSize, size);
    map.put(key, slot);

    currenByteSize += size;
    return slot;
  }

  public MemorySlot remove(T key) {
    return map.remove(key);
  }

  public int getCurrentByteSize() {
    return currenByteSize;
  }
}

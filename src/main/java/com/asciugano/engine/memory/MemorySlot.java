package com.asciugano.engine.memory;

public class MemorySlot {

  private final int startIndex;
  private final int lenght;

  public MemorySlot(int startIndex, int lenght) {
    this.startIndex = startIndex;
    this.lenght = lenght;
  }

  public int getStartIndex() {
    return startIndex;
  }

  public int getLenght() {
    return lenght;
  }
}

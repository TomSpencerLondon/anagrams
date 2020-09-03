package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Word {
  private final String input;

  public Word(String input) {
    this.input = input;
  }

  public List<Word> getAnagrams() {
    return List.of(this);
  }

  @Override
  public String toString() {
    return input;
  }
}

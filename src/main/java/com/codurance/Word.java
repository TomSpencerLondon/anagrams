package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Word {
  private final String input;

  public Word(String input) {
    this.input = input;
  }

  public List<Word> getAnagrams() {
    if (input.length() <= 1) {
      return List.of(this);
    } else {
      Word reverseWord = new Word(new StringBuffer(input).reverse().toString());
      return List.of(this, reverseWord);
    }
  }

  @Override
  public String toString() {
    return input;
  }
}

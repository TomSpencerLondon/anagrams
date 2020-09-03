package com.codurance;

import java.util.List;
import java.util.Set;

public class Word {
  private final String input;

  public Word(String input) {
    this.input = input;
  }

  public Set<Word> getAnagrams() {
    Word reverseWord = new Word(new StringBuffer(input).reverse().toString());
    return Set.of(this, reverseWord);
  }

  @Override
  public String toString() {
    return input;
  }
}

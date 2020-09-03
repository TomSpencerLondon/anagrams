package com.codurance;

import java.util.HashSet;
import java.util.Set;

public class Word {

  public static void main(String[] args) {
    new Word("abc").getAnagrams();
  }

  private final String input;

  public Word(String input) {
    this.input = input;
  }

  public Set<Word> getAnagrams() {
    Set<Word> result = new HashSet<>();
    if(input.length() <= 1) {
      return Set.of(this);
    }
    for (int i = 0; i < input.length(); i++){
      char c = input.charAt(i);
      StringBuilder stringBuilder = new StringBuilder(input);
      String restOfCharacters = stringBuilder.deleteCharAt(i).toString();

      Set<Word> anagramsOfRestOfCharacters = new Word(restOfCharacters).getAnagrams();
      anagramsOfRestOfCharacters.stream()
          .map(w -> w.prepend(c))
          .forEach(result::add);
    }
    return result;
  }

  private Word prepend(char c){
    return new Word(c + input);
  }

  private String reverse() {
    return new StringBuffer(this.input).reverse().toString();
  }

  @Override
  public String toString() {
    return input;
  }
}

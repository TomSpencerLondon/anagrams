package com.codurance;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WordShould {

  @Test
  void be_its_own_anagram_if_empty() {
    Word word = new Word("");
    List<Word> anagrams = word.getAnagrams();
    then(anagrams).extracting(Word::toString).containsOnly("");
  }
}

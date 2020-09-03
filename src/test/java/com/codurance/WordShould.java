package com.codurance;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WordShould {

  @Test
  void be_its_own_anagram_if_empty() {
    List<Word> anagrams = getAnagrams("");
    then(anagrams).extracting(Word::toString).containsOnly("");
  }

  @Test
  void be_its_own_anagram_if_one_letter_long() {
    List<Word> anagrams = getAnagrams("a");
    then(anagrams).extracting(Word::toString).containsOnly("a");
  }

  @Test
  void have_itself_and_its_reverse_as_its_only_anagram() {
    List<Word> anagrams = getAnagrams("ab");
    then(anagrams).extracting(Word::toString).containsOnly("ab", "ba");
  }

  private List<Word> getAnagrams(String input) {
    return new Word(input).getAnagrams();
  }
}

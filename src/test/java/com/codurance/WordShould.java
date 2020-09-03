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

  @Test
  void be_its_own_anagram_if_one_letter_long() {
    Word word = new Word("a");
    List<Word> anagrams = word.getAnagrams();
    then(anagrams).extracting(Word::toString).containsOnly("a");
  }

  @Test
  void have_itself_and_its_reverse_as_its_only_anagram() {
    Word word = new Word("ab");
    List<Word> anagrams = word.getAnagrams();
    then(anagrams).extracting(Word::toString).contains("ab", "ba");
  }
}

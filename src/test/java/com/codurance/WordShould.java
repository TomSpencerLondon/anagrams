package com.codurance;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class WordShould {

  @Test
  void be_its_own_anagram_if_empty() {
    Set<Word> anagrams = getAnagrams("");
    then(anagrams).extracting(Word::toString).containsOnly("");
  }

  @Test
  void be_its_own_anagram_if_one_letter_long() {
    Set<Word> anagrams = getAnagrams("a");
    then(anagrams).extracting(Word::toString).containsOnly("a");
  }

  @Test
  void have_itself_and_its_reverse_as_its_only_anagram() {
    Set<Word> anagrams = getAnagrams("ab");
    then(anagrams).extracting(Word::toString).containsOnly("ab", "ba");
  }

  @Disabled
  @Test
  void have_six_anagrams_for_three_unique_letters() {
    Set<Word> anagrams = getAnagrams("abc");
    then(anagrams).extracting(Word::toString)
        .containsOnly(
            "abc", "acb",
            "bac", "bca",
            "cab", "cba"
        );

  }

  private Set<Word> getAnagrams(String input) {
    return new Word(input).getAnagrams();
  }
}

/**
 * The {@code Word} class represents a word as an array of {@link Letter} objects.
 * <p>
 * It extends {@link SentencePart} and implements {@link Comparable}&lt;Word&gt;,
 * allowing words to be compared based on the occurrence count of a specific letter.</p>
 *
 * <p>Each {@code Word} object stores its characters as an array of {@code Letter} objects,
 * provides a string representation, and can count occurrences of a given letter.</p>
 *
 * @author OleksandrTuziuk
 * @version 1.0
 */
public class Word implements SentencePart, Comparable<Word> {
    /**
     * Array of {@link Letter} objects representing the characters of this word.
     */
    Letter[] content;
    /**
     * The number of occurrences of a specific letter in this word.
     * This field is set by {@link #setNumberOfLetter(char)}.
     */
    int numberOfLetter;

    /**
     * Constructs a new {@code Word} object from a {@code String}.
     * Each character in the string is converted to a {@link Letter} object.
     *
     * @param w the string representing the word
     */
    public Word(String w) {
        char[] letters = w.toCharArray();
        Letter[] word = new Letter[w.length()];
        for (int i = 0; i < w.length(); i++) {
            word[i] = new Letter(letters[i]);
        }
        this.content = word;
    }

    /**
     * Returns a string representation of this word.
     * <p>
     * Concatenates the string representation of each {@link Letter} in the {@link #content} array.
     * </p>
     *
     * @return a {@code String} representing this word
     */
    @Override
    public String toString() {
        String[] text = new String[content.length];

        for (int i = 0; i < content.length; i++) {
            text[i] = content[i].toString();
        }

        return String.join("", text);
    }

    /**
     * Counts the occurrences of the specified letter in this word.
     * <p>
     * The comparison is case-insensitive: both uppercase and lowercase
     * letters are treated as equal.
     * </p>
     *
     * @param l the character to count in the word
     */
    public void setNumberOfLetter(char l) {
        for (Letter letter : content) {
            if (Character.toLowerCase(letter.content) == Character.toLowerCase(l)) {
                this.numberOfLetter++;
            }
        }
    }

    /**
     * Compares this word with another word based on {@link #numberOfLetter}.
     * <p>
     * Used for sorting words by the occurrence count of a specific letter.
     * </p>
     *
     * @param w the word to compare with
     * @return a negative integer, zero, or a positive integer as this word
     *         has fewer, equal, or more occurrences of the letter than the specified word
     */
    @Override
    public int compareTo(Word w) {
        return this.numberOfLetter - w.numberOfLetter;
    }
}

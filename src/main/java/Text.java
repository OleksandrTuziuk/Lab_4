import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The {@code Text} class represents a text consisting of multiple
 * {@link Sentence} objects.
 *
 * <p>The class parses a string into sentences using the period ('.')
 * as a separator. Each sentence is then stored as a {@link Sentence}
 * object in the {@link #content} array.</p>
 *
 * <p>The class also provides functionality to extract all words from the text
 * and sort them based on the number of occurrences of a specified letter.</p>
 *
 * @author OleksandrTuziuk
 * @version 1.0
 */
public class Text {
    /**
     * Array containing the sentences that form this text.
     */
    Sentence[] content;

    /**
     * Constructs a {@code Text} object from a string.
     * <p>
     * The input string is split into sentences using the '.' character.
     * Each resulting substring is converted into a {@link Sentence} object.
     * </p>
     *
     * @param t the string representing the text
     */
    public Text(String t) {
        final String[] text = t.split("\\.");
        this.content = new Sentence[text.length];
        for (int i = 0; i < text.length; i++) {
            this.content[i] = new Sentence(text[i]);
        }
    }

    /**
     * Returns a string representation of the entire text.
     * <p>
     * Each {@link Sentence} is converted to a string and concatenated
     * using ". " as a separator. A period is appended to the end of the text.
     * </p>
     *
     * @return the reconstructed text as a {@code String}
     */
    @Override
    public String toString() {
        final String[] text = new String[content.length];

        for (int i = 0; i < content.length; i++) {
            text[i] = content[i].toString();
        }

        return String.join(". ", text) + ".";
    }

    /**
     * Extracts all {@link Word} objects from the text, counts the occurrences
     * of a specified letter in each word, and returns a new {@code Text}
     * object where the words are sorted in ascending order of that count.
     *
     * <p>The comparison is case-insensitive because the counting is performed
     * using {@link Word#setNumberOfLetter(char)}.</p>
     *
     * <p>All punctuation marks are removed in the resulting text and only
     * the sorted words remain, separated by spaces.</p>
     *
     * @param l the letter used to count occurrences in each word
     * @return a new {@code Text} object containing the sorted words
     */
    public Text sort(char l) {
        final List<Word> cont = new ArrayList<>();
        for (Sentence s : content) {
            for (SentencePart w : s.content) {
                if (w instanceof Word) {
                    ((Word) w).setNumberOfLetter(l);
                    cont.add((Word) w);
                }
            }
        }
        Collections.sort(cont);

        final String[] words = new String[cont.size()];

        for (int i = 0; i < cont.size(); i++) {
            words[i] = cont.get(i).toString();
        }

        final String text = String.join(" ", words);

        return new Text(text);
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Sentence} class represents a sentence composed of multiple
 * {@link SentencePart} objects such as {@link Word} and {@link SpecialSymbol}.
 *
 * <p>The class parses a text string and separates it into logical parts:
 * words and special symbols (for example punctuation marks or spaces).
 * Each part is stored as an element of the {@link #content} array.</p>
 *
 * <p>During construction the sentence string is split into words by spaces.
 * Each word is analyzed:</p>
 * <ul>
 *     <li>If the last character is alphabetic, the entire word is stored as a {@link Word}.</li>
 *     <li>If the last character is not alphabetic (e.g. '.', ',', '!'),
 *     the word and the punctuation mark are stored separately.</li>
 *     <li>Spaces between words are stored as {@link SpecialSymbol} objects.</li>
 * </ul>
 *
 * <p>This design allows processing words and punctuation independently,
 * which can be useful for text analysis or transformation tasks.</p>
 *
 * @author OleksandrTuziuk
 * @version 1.0
 */
public class Sentence {
    /**
     * Array containing the parts of the sentence.
     * Each element is either a {@link Word} or a {@link SpecialSymbol}.
     */
    SentencePart[] content;

    /**
     * Constructs a {@code Sentence} object from a string.
     * The constructor parses the input text and converts it into
     * {@link SentencePart} objects.
     *
     * @param s the string representing the sentence
     */
    public Sentence(String s) {
        final String[] sentence = s.split(" ");
        final List<SentencePart> sentenceParts = new ArrayList<>();
        for (String word : sentence) {
            if (word.length() > 1) {
                final char lastSymbol = word.toCharArray()[word.length() - 1];
                if (Character.isAlphabetic(lastSymbol)) {
                    sentenceParts.add(new Word(word));
                } else {
                    sentenceParts.add(new Word(word.substring(0, word.length() - 1)));
                    sentenceParts.add(new SpecialSymbol(lastSymbol));
                }
                sentenceParts.add(new SpecialSymbol(' '));
            } else if (word.length() == 1) {
                if (Character.isAlphabetic(word.toCharArray()[0])) {
                    sentenceParts.add(new Word(word));
                    sentenceParts.add(new SpecialSymbol(' '));
                } else {
                    sentenceParts.add(new SpecialSymbol(word.toCharArray()[0]));
                    sentenceParts.add(new SpecialSymbol(' '));
                }
            }
        }
        sentenceParts.removeLast();
        this.content = sentenceParts.toArray(new SentencePart[0]);
    }

    /**
     * Returns a string representation of the sentence.
     *
     * <p>The method concatenates the string representations of all
     * {@link SentencePart} elements in the {@link #content} array.</p>
     *
     * @return the reconstructed sentence as a {@code String}
     */
    @Override
    public String toString() {
        final String[] text = new String[content.length];

        for (int i = 0; i < content.length; i++) {
            text[i] = content[i].toString();
        }

        return String.join("", text);
    }
}

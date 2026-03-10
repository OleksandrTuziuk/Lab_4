/**
 * The {@code SpecialSymbol} class represents a single non-letter character,
 * such as punctuation or other special symbols in a sentence.
 * <p>
 * It extends {@link SentencePart}, allowing it to be treated as a part of a sentence
 * along with {@link Word} objects.</p>
 *
 * @author OleksandrTuziuk
 * @version 1.0
 */
public class SpecialSymbol implements SentencePart {
    /**
     * The character representing this special symbol.
     */
    char content;

    /**
     * Constructs a new {@code SpecialSymbol} object with the specified character.
     *
     * @param c the special symbol character
     */
    public SpecialSymbol(char c) {
        this.content = c;
    }

    /**
     * Returns a string representation of this special symbol.
     *
     * @return a {@code String} representing this special symbol
     */
    @Override
    public String toString() {
        return Character.toString(content);
    }
}

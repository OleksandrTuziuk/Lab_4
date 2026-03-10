/**
 * The {@code Letter} class represents a single character as an object.
 * <p>
 * This class encapsulates a {@code char} value and provides a string representation
 * of the character via the {@link #toString()} method.</p>
 *
 * @author OleksandrTuziuk
 * @version 1.0
 */
public class Letter {
    /**
     * The character contained in this {@code Letter} object.
     */
    char content;

    /**
     * Constructs a new {@code Letter} object with the specified character.
     *
     * @param c the character to store in this {@code Letter}
     */
    public Letter(char c) {
        this.content = c;
    }

    /**
     * Returns a string representation of this {@code Letter}.
     * <p>
     * This method converts the character {@link #content} to a {@code String}.
     * </p>
     *
     * @return a {@code String} representing this {@code Letter}
     */
    @Override
    public String toString() {
        return Character.toString(content);
    }
}

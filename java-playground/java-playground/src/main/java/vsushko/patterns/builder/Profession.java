package vsushko.patterns.builder;

/**
 * @author vsushko
 */
public enum Profession {
    WARRIOR,
    THIEF,
    MAGE,
    PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

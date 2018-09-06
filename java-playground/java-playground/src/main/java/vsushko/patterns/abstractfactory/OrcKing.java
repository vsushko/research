package vsushko.patterns.abstractfactory;

/**
 * @author vsushko
 */
public class OrcKing implements King {
    private static final String DESCRIPTION = "This is the Orc king!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}


package vsushko.patterns.abstractfactory;

/**
 * @author vsushko
 */
public interface KingdomFactory {
    Castle createCastle();

    King createKing();

    Army createArmy();
}

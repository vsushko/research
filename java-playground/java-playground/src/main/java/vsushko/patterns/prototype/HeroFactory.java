package vsushko.patterns.prototype;

public interface HeroFactory {
    Mage createMage();
    Warlord createWarlord();
    Beast createBeast();
}

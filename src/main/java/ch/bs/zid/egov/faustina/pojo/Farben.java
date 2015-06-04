package ch.bs.zid.egov.faustina.pojo;

/**
 * ENUM für Farben
 */
public enum Farben
{
    BLAU("blau"),
    ROT("rot"),
    GELB("gelb"),
    GRUEN("gruen"),
    SCHWARZ("schwarz"),
    WEISS("weiss"),
    BEIGE("beige"),
    BRAUN("braun"),
    VIOLET("violet"),
    ROSA("rosa"),
    SENF("senf"),
    FARBIG("farbig");

    private final String label;

    private Farben(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return this.label;
    }
}
package ch.bs.zid.egov.faustina.pojo;

/**
 * ENUM für Farben
   * @author Faustina Bruno
 * @version 1
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

    /**
     * @return String, gibt in Label aus
     */
    public String getLabel()
    {
        return this.label;
    }
}
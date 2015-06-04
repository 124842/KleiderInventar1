package ch.bs.zid.egov.faustina.presentation;


import ch.bs.zid.egov.faustina.application.MarkenService;

import ch.bs.zid.egov.faustina.entities.MarkenEntity;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Marken Bean ist die Verbindung zwischen der View(allen xhtml Dateien ) und dem Rest der Applikation.
 * @author Faustina Bruno
 * @version 1.0
 */
@Named("markenBean")
@SessionScoped
public class MarkenBean implements Serializable
{

    @Inject
    private MarkenService markenService;

    private List<Marke> marken;
    Marke marke = new Marke();

    /**
     *Wird nach dem Built ausgeführt
     */
    @PostConstruct
    public void initBean()
    {
        this.fetchMarken();
    }

    /**
     *
     * @return SelectItem Array mit markenID und Markenbezeichnung
     */
    public SelectItem[] getMarkenValues()
    {
        SelectItem[] markenValues = new SelectItem[this.marken.size()];
        int i = 0;
        for (Marke marke : this.marken)
        {
            markenValues[i++] = new SelectItem(marke.getMarkenId(),marke.getMarkenBezeichnung());

        }
        return markenValues;
    }


    /**
     * Holt alle Marken aus der Datenbank
     */
    public void fetchMarken()
    {
        this.marken = this.markenService.getAllMarken();

    }

    /**
     *
     * @return marke, die momentan gesetzt ist.
     */
    public Marke getMarke() {
        return this.marke;
    }

    /**
     *
     * @param marke, die gesetzt werden muss
     */
    public void setMarke(Marke marke) {
        this.marke = marke;
    }

    /**
     * Speichert die Marke in die Datenbank
     * @return "index.xhtml", gibt die Seite aus, die nach dem Auführen der Mathode angeziegt werden muss
     */
    public String add()
    {

        this.markenService.addMarke(this.marke);
        this.fetchMarken();
        this.marke = new Marke();
        return "index.xhtml";
    }
}

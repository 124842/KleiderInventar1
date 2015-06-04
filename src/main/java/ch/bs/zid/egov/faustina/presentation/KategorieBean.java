package ch.bs.zid.egov.faustina.presentation;

import ch.bs.zid.egov.faustina.application.KategorieService;
import ch.bs.zid.egov.faustina.pojo.Kategorie;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Kategorie Bean ist die Verbindung zwischen der View(allen xhtml Dateien ) und dem Rest der Applikation.
 * @author Faustina Bruno
 * @version 1.0
 */
@Named("kategorieBean")
@SessionScoped
public class KategorieBean implements Serializable
{

    @Inject
    private KategorieService kategorieService;

    private List<Kategorie> kategorien;
    private Kategorie kategorie = new Kategorie();


    /**
     * Nach dem Build wird diese methode ausgeführt,
     * sodass alle Kategorien von Anfang an aus der Datenbank geholt werden können, um sie im DropDown anzuzeigen
     */
    @PostConstruct
    public void initBean(){
        this.fetchKategorien();
    }

    /**
     * holt alle Kategorien aus der Datenbank
     */
    public void fetchKategorien()
    {
        this.kategorien = this.kategorieService.getAllKategorien();

    }

    /**
     *
     * @return ein SelectItem array mit dem jeweiligen kategorieID und kategorieBezeichnung
     */
    public SelectItem[] getKategorienValues()
    {
        SelectItem[] kategorienValues = new SelectItem[this.kategorien.size()];
        int i = 0;
        for (Kategorie kategorie : this.kategorien)
        {
            kategorienValues[i] = new SelectItem(kategorie.getKategorieId(), kategorie.getKategorieBezeichnung());
            i++;
        }
        return kategorienValues;
    }

    /**
     * Speichert eine Kategorie in die Datenbank
     * @return "index.xhtml", gibt die xhtml Seite, die nach dem ausführen der Methode angezeigt werden soll
     */
    public String add()
    {
        this.kategorieService.addKategorie(this.kategorie);
        this.fetchKategorien();
        this.kategorie = new Kategorie();
        return "index.xhtml";
    }

    /**
     * ändert den Mode, und wechselt zur Kategoriepflege
     * @return "kategorie.xhtml", gibt die xhtml Seite, die nach dem ausführen der Methode angezeigt werden soll
     */

public String changeMode(){
    return "kategorien.xhtml";
}

    /**
     *
     * @return momentane Kategorie
     */
    public Kategorie getKategorie() {
        return kategorie;
    }

    /**
     *
     * @param kategorie, die gesetzt werden muss
     */
    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    /**
     *
     * @return momentane KategorieListe
     */
    public List<Kategorie> getKategorien() {
        return kategorien;
    }

    /**
     *
     * @param kategorien Liste die abgefüllt werden muss
     */
    public void setKategorien(List<Kategorie> kategorien) {
        this.kategorien = kategorien;
    }
}

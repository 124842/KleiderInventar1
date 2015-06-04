package ch.bs.zid.egov.faustina.presentation;


import ch.bs.zid.egov.faustina.pojo.Farben;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 * FarbenBean ist die Verbindung zwischen der View(allen xhtml Dateien ) und dem Rest der Applikation.
 * @author Faustina Bruno
 * @version 1.0
 */

@Named("farbenBean")
@ManagedBean
@ApplicationScoped
public class FarbenBean
{
    /**
     *
     * @return ein SelectItem array mit dem jeweiligen FarbenObjekt und dessen Label
     */
    public SelectItem[] getFarben()
    {
        SelectItem[] farben = new SelectItem[Farben.values().length];
        int i = 0;
        for (Farben farbe : Farben.values())
        {
            farben[i++] = new SelectItem(farbe, farbe.getLabel());
        }
        return farben;
    }
}

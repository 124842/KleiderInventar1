package ch.bs.zid.egov.faustina.application;


import ch.bs.zid.egov.faustina.entities.MarkenEntity;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *MarkenServiceist Hier geschieht die ganze Logik zwischen Datenbank und der Rest der Applikation
 * Auch das Maping von den Pojos und Enteties geschieht hier
 * @author Faustina Bruno
 * @version 1.0
 */
@Stateless
public class MarkenService implements Serializable
{
    @PersistenceContext(unitName = "kleider-pu")
    private EntityManager entityManager;

    /**
     *Hier wird eine Marke in die Datenbank geschrieben
     * @param marke, die zuspeichernde Marke
     * @return Marke, die von der Entity zurück konvertiert wurde
     */
    public Marke addMarke(Marke marke)
    {
        MarkenEntity markenEntity = this.convertMarkeToEntity(marke);
        this.entityManager.persist(markenEntity);
        return this.convertEntityToMarke(markenEntity);
    }

    /**
     *
     * @return gibt eine Liste mit allen Marken in der Datenbank wieder
     */
    public List<Marke> getAllMarken()
    {
        CriteriaQuery<MarkenEntity> cq = this.entityManager.getCriteriaBuilder().createQuery(MarkenEntity.class);
        cq.select(cq.from(MarkenEntity.class));
        List<MarkenEntity> markenEntities = this.entityManager.createQuery(cq).getResultList();
        List<Marke> marken = new ArrayList<Marke>();

        if(markenEntities != null && !markenEntities.isEmpty()){
            for(MarkenEntity markenEntity: markenEntities){
                marken.add(this.convertEntityToMarke(markenEntity));
            }
        }
        return marken;
    }

    /**
     * Mapping von Entity zu Marke
     * @param markenEntity die in eine Marke verwandelt werden muss
     * @return die umgewandelte Marke
     */
    public Marke convertEntityToMarke(MarkenEntity markenEntity){
        Marke marke = new Marke();
        marke.setMarkenId(markenEntity.getMarkenId());
        marke.setMarkenBezeichnung(markenEntity.getMarkenBezeichnung());
        return marke;
    }

    /**
     *
     * @param marke
     * @return
     */
    public MarkenEntity convertMarkeToEntity(Marke marke){
        MarkenEntity markenEntity = new MarkenEntity();
        markenEntity.setMarkenId(marke.getMarkenId());
        markenEntity.setMarkenBezeichnung(marke.getMarkenBezeichnung());
        return markenEntity;
    }

    /**
     *
     * @param markenID
     * @return
     */
    public Marke getMarkefromID(int markenID){
        return this.convertEntityToMarke(this.entityManager.find(MarkenEntity.class, markenID));
    }
}

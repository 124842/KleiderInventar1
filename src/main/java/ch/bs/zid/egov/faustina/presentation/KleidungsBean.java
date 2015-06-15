/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package ch.bs.zid.egov.faustina.presentation;

import ch.bs.zid.egov.faustina.application.KleiderService;
import ch.bs.zid.egov.faustina.pojo.Kleid;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
/**
 * KleidungsBean ist die Verbindung zwischen der View(allen xhtml Dateien ) und dem Rest der Applikation.
 * @author Faustina Bruno
 * @version 1.0
 */
@Named("kleidungsBean")
@SessionScoped
public class KleidungsBean implements Serializable
{
    @Inject
    MessagesBean messagesBean;
    @Inject
    private KleiderService kleidService;
    private List<Kleid> kleider;
    private Kleid kleid = new Kleid();
    private boolean bearbeitungsModus=false;

    @PostConstruct
    public void initKleider(){
        this.fetchKleider();
    }

    /**
     * Holt alle Kleider die in der Datenbank gespeichert sind und speichert sie in einer Liste ab
     */
    public void fetchKleider()
    {
        this.kleider = this.kleidService.getAllKleider();
       // return "index.xhtml";
    }

    /**
     * Diese Methode wird abgerufen, wenn man auf Hinzufügen drückt.
     * Es speichert ein Kleid in die Datenbank
     *
     * @return "index.xhtml", gibt die xhtml Seite an, die nach dem ausführen der Methode angezeigt werden soll
     */
    public String add()
    {
        try
        {
            this.kleidService.addKleid(this.kleid);
            this.messagesBean.messageAusgebben("Kleid wurde gespeichert",false);
            this.fetchKleider();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.messagesBean.messageAusgebben("fehler aufgetreten",true);
        }

        this.kleid = new Kleid();
        return "index.xhtml";
    }

    public String updateKleid(){
        try{
            this.kleidService.updateKleid(this.kleid);
            this.changeBearbeitungsModus();
            this.fetchKleider();
            this.kleid=new Kleid();
            this.messagesBean.messageAusgebben("Kleid wurde geändert",false);
            return "index.xhtml";
        }
        catch (Exception e){
            e.printStackTrace();
            this.messagesBean.messageAusgebben("Fehler aufgetreten",true);
            return "index.xhtml";
        }
    }

    /**
     * Methode um ein Kleid zu bearbeiten
     * Es holt das gewünschte Kleid durch die ID von der Datenbank
     *
     * @param kleidID , gibt die ID des Kleides an, welches geändert werden soll
     */
    public void modifyKleid(BigInteger kleidID)
    {
        this.changeBearbeitungsModus();
        this.kleid=this.kleidService.getKleidByID(kleidID);
    }

    public void changeBearbeitungsModus(){
        this.bearbeitungsModus = !this.bearbeitungsModus;
    }

    /**
     * Methode um ein Kleid zu löschen
     * Es holt das gewünschte Kleid durch die ID von der Datenbank
     * @param kleidID, gibt die ID des Kleides an, welches gelöscht werden soll
     */
    public void delete(BigInteger kleidID){
        this.kleidService.deleteKleid(kleidID);
        this.fetchKleider();
    }

    /**
     *
     * @return momentanes Kleid
     */
    public Kleid getKleid()
    {
        return this.kleid;
    }

    /**
     *
     * @param kleid das gesetzt werden soll
     */
    public void setKleid(Kleid kleid)
    {
        this.kleid = kleid;
    }

    /**
     *
     * @return momentane KleiderListe
     */
    public List<Kleid> getKleider()
    {
        return this.kleider;
    }

    /**
     *
     * @param kleider Liste die abgefüllt werden soll
     */
    public void setKleider(List<Kleid> kleider)
    {
        this.kleider = kleider;
    }

    public boolean isBearbeitungsModus() {
        return this.bearbeitungsModus;
    }

    public void setBearbeitungsModus(boolean bearbeitungsModus) {
        this.bearbeitungsModus = bearbeitungsModus;
    }
}

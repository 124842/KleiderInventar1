package ch.bs.zid.egov.faustina.presentation;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Gibt Nachrichten auf der GUI aus
 * @author Faustina Bruno
 * @version 1
 */
@Named("messageBean")
@SessionScoped
public class MessagesBean implements Serializable{
    private boolean errorMessage;

    public void messageAusgebben(String message, boolean messageTypeError){
        this.errorMessage=messageTypeError;
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message,"title")
        );
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("globalMessage");
    }

    public boolean isErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(boolean errorMessage) {
        this.errorMessage = errorMessage;
    }
}

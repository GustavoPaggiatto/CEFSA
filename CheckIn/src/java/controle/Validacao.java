/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Gustavo
 */
@ManagedBean
@RequestScoped
@FacesValidator("checkin.Validator")
public class Validacao implements Validator {

    /**
     * Creates a new instance of Validacao
     */
    public Validacao() {
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        
        String senha = (String) this.senhaInput.getLocalValue();
        
        if (!value.toString().equals(senha)) {
            ((UIInput) component).setValid(false);

            FacesMessage message = new FacesMessage(" Senhas diferentes ");
            context.addMessage(component.getClientId(context), message);
        }
    }

    private UIInput  senhaInput;

    public UIInput getSenhaInput() {
        return senhaInput;
    }

    public void setSenhaInput(UIInput senhaInput) {
        this.senhaInput = senhaInput;
    }

}

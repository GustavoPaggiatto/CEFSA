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
@FacesValidator("checkin.ValidatorStrings")
public class ValidacaoStringIsNullOrEmpty implements Validator {

    /**
     * Creates a new instance of ValidacaoStringIsNullOrEmpty
     */
    public ValidacaoStringIsNullOrEmpty() {
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        if(value.toString().equals(" "))
        {
            ((UIInput) component).setValid(false);

            FacesMessage message = new FacesMessage(" Campo obrigatório ");
            context.addMessage(component.getClientId(context), message);
        }
    }
}

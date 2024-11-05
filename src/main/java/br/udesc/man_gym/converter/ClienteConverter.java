package br.udesc.man_gym.converter;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.udesc.man_gym.model.Cliente;
import br.udesc.man_gym.repository.ClienteRepository;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;

@SuppressWarnings("rawtypes")
@Component
public class ClienteConverter implements Converter {

	@Autowired
	ClienteRepository clienteDao;

	@Override
	@SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
	public Object getAsObject(FacesContext context, UIComponent component, String matricula) {
		if (matricula.isEmpty())
			return null;
		try {
			Optional<Cliente> clienteOpt = clienteDao.findById(Long.valueOf(matricula));
			return clienteOpt.orElse(null);
		} catch (Exception nm) {
			nm.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object cliente) {
	
		if(cliente instanceof Cliente cliente1) {
		return String.valueOf(cliente1.getMatricula());
		
		} else {
		return "Erro na conversão do objeto para string";
		}
	}

}

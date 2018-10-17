package uo.ri.business.impl;

import java.util.List;
import java.util.Map;

import uo.ri.business.ForemanService;
import uo.ri.business.impl.foreman.AddCliente;
import uo.ri.business.impl.foreman.DeleteCliente;
import uo.ri.business.impl.foreman.DetallesCliente;
import uo.ri.business.impl.foreman.FindAllClientes;
import uo.ri.business.impl.foreman.FindRecomendadosCliente;
import uo.ri.business.impl.foreman.UpdateCliente;
import uo.ri.common.BusinessException;

/**
 * Clase con llamadas a todas las clases que controla el Jefe de taller
 * 
 * @author UO250999
 *
 */
public class ForemanServiceImpl implements ForemanService {

	@Override
	public void newCliente(String dni, String nombre, String apellidos, String direccionPostal, int telefono,
			String correo, Long recomendadopor) throws BusinessException {
		AddCliente cliente = new AddCliente(dni, nombre, apellidos, direccionPostal, telefono, correo, recomendadopor);
		cliente.execute();
	}

	@Override
	public void deleteCliente(Long id) throws BusinessException {
		DeleteCliente cliente = new DeleteCliente(id);
		cliente.execute();
	}

	@Override
	public void updateCliente(Long id, String nombre, String apellidos) {
		UpdateCliente cliente = new UpdateCliente(id, nombre, apellidos);
		cliente.execute();
	}

	@Override
	public List<Map<String, Object>> findAllClientes() {
		FindAllClientes clientes = new FindAllClientes();
		return clientes.execute();
	}

	@Override
	public List<Map<String, Object>> findRecomendadosCliente(Long id) {
		FindRecomendadosCliente clientes = new FindRecomendadosCliente(id);
		return clientes.execute();
	}

	@Override
	public Map<String, Object> detallesCliente(Long id) {
		DetallesCliente cliente = new DetallesCliente(id);
		return cliente.execute();
	}
}
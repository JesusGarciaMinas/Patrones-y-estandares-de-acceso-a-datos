package uo.ri.business.impl;

import java.util.List;
import java.util.Map;

import uo.ri.business.AdminService;
import uo.ri.business.impl.admin.AddMechanic;
import uo.ri.business.impl.admin.DeleteMechanic;
import uo.ri.business.impl.admin.FindAllMechanics;
import uo.ri.business.impl.admin.FindByIdMechanic;
import uo.ri.business.impl.admin.GenerarBonos;
import uo.ri.business.impl.admin.UpdateMechanic;

/**
 * Clase con todas las llamadas a aquellas clases que controla el administrador
 * de la base de datos
 * 
 * @author UO250999
 *
 */
public class AdminServiceImpl implements AdminService {

	@Override
	public void newMechanic(String nombre, String apellidos) {
		AddMechanic mechanic = new AddMechanic(nombre, apellidos);
		mechanic.execute();
	}

	@Override
	public void deleteMechanic(Long id) {
		DeleteMechanic eliminarMecanico = new DeleteMechanic(id);
		eliminarMecanico.execute();
	}

	@Override
	public void updateMechanic(Long id, String nombre, String apellidos) {
		UpdateMechanic um = new UpdateMechanic(id, nombre, apellidos);
		um.execute();
	}

	@Override
	public List<Map<String, Object>> findAllMechanics() {
		FindAllMechanics fam = new FindAllMechanics();
		List<Map<String, Object>> lista = fam.execute();
		return lista;
	}

	@Override
	public Map<String, Object> findByIdMechanic(Long id) {
		FindByIdMechanic fbim = new FindByIdMechanic(id);
		Map<String, Object> map = fbim.execute();
		return map;
	}

	@Override
	public void generarBonos() {
		GenerarBonos bonos = new GenerarBonos();
		bonos.execute();
	}
}
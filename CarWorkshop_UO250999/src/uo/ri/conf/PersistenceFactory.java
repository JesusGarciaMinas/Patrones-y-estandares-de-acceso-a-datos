package uo.ri.conf;

import uo.ri.persistence.ClientesGateway;
import uo.ri.persistence.FacturasGateway;
import uo.ri.persistence.MecanicosGateway;
import uo.ri.persistence.MediosPagoGateway;
import uo.ri.persistence.impl.ClientesGatewayImpl;
import uo.ri.persistence.impl.FacturasGatewayImpl;
import uo.ri.persistence.impl.MecanicosGatewayImpl;
import uo.ri.persistence.impl.MediosPagoGatewayImpl;

/**
 * Patrón factoria que permite llegar a todas las clases de tipo Gateway
 * 
 * @author UO250999
 *
 */
public class PersistenceFactory {

	public static MecanicosGateway getMecanicoGateway() {
		return new MecanicosGatewayImpl();
	}

	public static FacturasGateway getFacturasGateway() {
		return new FacturasGatewayImpl();
	}

	public static MediosPagoGateway getMediosPagoGateway() {
		return new MediosPagoGatewayImpl();
	}

	public static ClientesGateway getClienteGateway() {
		return new ClientesGatewayImpl();
	}
}
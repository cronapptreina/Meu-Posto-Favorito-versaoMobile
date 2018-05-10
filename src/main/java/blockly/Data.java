package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Data {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Entidade
	 * @return Var
	 */
	// Data
	public static Var obter_data_atual(Var Entidade) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.valueOf(cronapi.dateTime.Operations.getNow());
			}
		}.call();
	}

}

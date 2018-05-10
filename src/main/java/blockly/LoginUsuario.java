package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class LoginUsuario {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// LoginUsuario
	public static Var obter(Var Dados) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.valueOf(cronapi.util.Operations.getCurrentUserName());
			}
		}.call();
	}

}

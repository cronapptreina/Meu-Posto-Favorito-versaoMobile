package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class FirebaseBack {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param msg_entrada
	 * @return Var
	 */
	// FirebaseBack
	public static Var formatar_mensagem(Var msg_entrada) throws Exception {
		return new Callable<Var>() {

			private Var msg_formatada = Var.VAR_NULL;

			public Var call() throws Exception {
				msg_formatada = cronapi.json.Operations.createObjectJson();
				cronapi.json.Operations.setJsonOrMapField(msg_formatada, Var.valueOf("texto"), msg_entrada);
				cronapi.json.Operations.setJsonOrMapField(msg_formatada, Var.valueOf("data"),
						cronapi.dateTime.Operations.getNowInMilliseconds());
				cronapi.json.Operations.setJsonOrMapField(msg_formatada, Var.valueOf("usuario"),
						cronapi.util.Operations.getCurrentUserName());
				return msg_formatada;
			}
		}.call();
	}

}

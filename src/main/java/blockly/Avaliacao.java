package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Avaliacao {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param nota
	 * @param comentario
	 * @param id_abastecimento
	 * @return Var
	 */
	// Avaliacao
	public static Var insere_avaliacao(Var nota, Var comentario, Var id_abastecimento) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Avaliacao"),
						Var.valueOf("texto", comentario),
						Var.valueOf("abastecimento", cronapi.database.Operations.newEntity(
								Var.valueOf("app.entity.Abastecimento"), Var.valueOf("id", id_abastecimento))),
						Var.valueOf("nota", nota));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Abastecimento"),
						Var.valueOf("update Abastecimento set status = :status where id = :id"),
						Var.valueOf("status", Var.valueOf("true")), Var.valueOf("id", id_abastecimento));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param nota
	 * @param comentario
	 * @param id_abastecimento
	 * @return Var
	 */
	// Avaliacao
	public static Var insere_avaliacaoExerna(Var nota, Var comentario, Var id_abastecimento) throws Exception {
		return new Callable<Var>() {

			private Var campos = Var.VAR_NULL;

			public Var call() throws Exception {
				campos = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"),
						Var.valueOf("application/x-www-form-urlencoded"),
						Var.valueOf("https://8-61-10650.debug.ide.cronapp.io/webapp/#/home/logged/avaliacao"),
						cronapi.map.Operations.createObjectMapWith(Var.valueOf("comentario", comentario),
								Var.valueOf("nota", nota),
								Var.valueOf("id_abastecimento", cronapi.database.Operations.newEntity(
										Var.valueOf("app.entity.Abastecimento"), Var.valueOf("id", id_abastecimento)))),
						Var.VAR_NULL);
				System.out.println(campos.getObjectAsString());
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Abastecimento"),
						Var.valueOf("update Abastecimento set status = :status where id = :id"),
						Var.valueOf("status", Var.valueOf("true")), Var.valueOf("id", id_abastecimento));
				return Var.VAR_NULL;
			}
		}.call();
	}

}

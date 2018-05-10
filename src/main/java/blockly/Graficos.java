package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Graficos {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Graficos
	public static Var carros() throws Exception {
		return new Callable<Var>() {

			private Var listaCarros = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showComponent"),
						Var.valueOf("graph"));
				listaCarros = cronapi.database.Operations.query(Var.valueOf("app.entity.Abastecimento"), Var.valueOf(
						"select a.carro.modelo, SUM(a.valorAbastecimento)/SUM(a.km) from Abastecimento a  group by a.carro.modelo"));
				cronapi.chart.Operations.createChart(Var.valueOf("graph"), Var.valueOf("bar"),
						cronapi.database.Operations.getColumn(listaCarros, Var.valueOf("this[0]")), Var.VAR_NULL,
						cronapi.database.Operations.getColumn(listaCarros, Var.valueOf("this[1]")));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Graficos
	public static Var media_notas() throws Exception {
		return new Callable<Var>() {

			private Var listaMedias = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showComponent"),
						Var.valueOf("graph"));
				listaMedias = cronapi.database.Operations.query(Var.valueOf("app.entity.Avaliacao"), Var.valueOf(
						"select a.abastecimento.posto.nome, AVG(a.nota) from Avaliacao a  group by a.abastecimento.posto.nome"));
				cronapi.chart.Operations.createChart(Var.valueOf("graph"), Var.valueOf("polarArea"),
						cronapi.database.Operations.getColumn(listaMedias, Var.valueOf("this[0]")), Var.VAR_NULL,
						cronapi.database.Operations.getColumn(listaMedias, Var.valueOf("this[1]")));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Graficos
	public static Var postos() throws Exception {
		return new Callable<Var>() {

			private Var listaPostos = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showComponent"),
						Var.valueOf("graph"));
				listaPostos = cronapi.database.Operations.query(Var.valueOf("app.entity.Abastecimento"), Var.valueOf(
						"select a.posto.nome, SUM(a.valorAbastecimento)/SUM(a.km) from Abastecimento a  group by a.posto.nome"));
				cronapi.chart.Operations.createChart(Var.valueOf("graph"), Var.valueOf("doughnut"),
						cronapi.database.Operations.getColumn(listaPostos, Var.valueOf("this[0]")), Var.VAR_NULL,
						cronapi.database.Operations.getColumn(listaPostos, Var.valueOf("this[1]")));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void inicio() throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
						Var.valueOf("graph"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void qtdAbastecimentos() throws Exception {
		new Callable<Var>() {

			private Var listaQuantidades = Var.VAR_NULL;

			public Var call() throws Exception {
				listaQuantidades = cronapi.database.Operations.query(Var.valueOf("app.entity.Abastecimento"),
						Var.valueOf("select a.posto.nome, COUNT(a) from Abastecimento a  group by a.posto.nome"));
				cronapi.chart.Operations.createChart(Var.valueOf("graph2"), Var.valueOf("doughnut"),
						cronapi.database.Operations.getColumn(listaQuantidades, Var.valueOf("this[0]")), Var.VAR_NULL,
						cronapi.database.Operations.getColumn(listaQuantidades, Var.valueOf("this[1]")));
				return Var.VAR_NULL;
			}
		}.call();
	}

}

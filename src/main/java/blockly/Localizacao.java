package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Localizacao {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param coordenadas
	 * @return Var
	 */
	// Localizacao
	public static Var obter_endereco(Var coordenadas) throws Exception {
		return new Callable<Var>() {

			private Var endereco = Var.VAR_NULL;
			private Var url = Var.VAR_NULL;
			private Var consultaEndereco = Var.VAR_NULL;
			private Var Results = Var.VAR_NULL;

			public Var call() throws Exception {
				url = Var.valueOf(Var.valueOf("https://maps.googleapis.com/maps/api/geocode/json?").toString()
						+ coordenadas.toString()
						+ Var.valueOf(
								"&location_type=ROOFTOP&result_type=street_address&key=AIzaSyA5hw_jAdeX9pvtWlXM6wm_hyUaDHD131M")
								.toString());
				consultaEndereco = cronapi.json.Operations.toJson(cronapi.util.Operations.getURLFromOthers(
						Var.valueOf("GET"), Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL));
				Results = cronapi.json.Operations.getJsonOrMapField(consultaEndereco, Var.valueOf("results[0]"));
				endereco = cronapi.json.Operations.getJsonOrMapField(Results, Var.valueOf("formatted_address"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Posto.active.endereco"), endereco);
				setar_endereco(endereco);
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param endereco
	 */
	// Descreva esta função...
	public static void setar_endereco(Var endereco) throws Exception {
		new Callable<Var>() {

			private Var listaEndereco = Var.VAR_NULL;
			private Var logradouro = Var.VAR_NULL;
			private Var bairro = Var.VAR_NULL;
			private Var cidade = Var.VAR_NULL;
			private Var pa_C3_ADs = Var.VAR_NULL;
			private Var link = Var.VAR_NULL;

			public Var call() throws Exception {
				listaEndereco = cronapi.list.Operations.getListFromText(endereco, Var.valueOf(","));
				System.out.println(listaEndereco.getObjectAsString());
				logradouro = cronapi.list.Operations.get(listaEndereco, Var.valueOf(1));
				bairro = cronapi.list.Operations.get(listaEndereco, Var.valueOf(2));
				cidade = cronapi.list.Operations.get(listaEndereco, Var.valueOf(3));
				pa_C3_ADs = cronapi.list.Operations.get(listaEndereco, Var.valueOf(4));
				link = Var.valueOf(Var.valueOf("https://www.google.com/maps/embed/v1/place?key=").toString()
						+ Var.valueOf("AIzaSyA5hw_jAdeX9pvtWlXM6wm_hyUaDHD131M").toString()
						+ Var.valueOf("&q=").toString() + logradouro.toString() + Var.valueOf("+").toString()
						+ bairro.toString() + Var.valueOf("+").toString() + cidade.toString()
						+ Var.valueOf("+").toString() + pa_C3_ADs.toString());
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeAttrValue"),
						Var.valueOf("mapa"), Var.valueOf("src"), link);
				return Var.VAR_NULL;
			}
		}.call();
	}

}

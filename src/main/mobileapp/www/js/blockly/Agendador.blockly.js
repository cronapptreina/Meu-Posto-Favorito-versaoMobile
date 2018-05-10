window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Agendador = window.blockly.js.blockly.Agendador || {};

/**
 * Agendador
 */
window.blockly.js.blockly.Agendador.Executar = function() {
	this.cronapi.util
			.callServerBlocklyNoReturn('blockly.Graficos:qtdAbastecimentos');
	this.cronapi.util
			.scheduleExecution(
					function() {
						this.cronapi.util
								.callServerBlocklyNoReturn('blockly.Graficos:qtdAbastecimentos');
					}.bind(this), 1, 5, 'seconds');
}

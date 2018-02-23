window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Foto = window.blockly.js.blockly.Foto || {};

var item;

/**
 * Foto
 */
window.blockly.js.blockly.Foto.Enviar = function() {
	this.cronapi.cordova.camera
			.getPicture(
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.changeValueOfField("User.active.picture",
										String('data:image/png;base64,')
												+ String(item));
						this.cronapi.screen.showComponent("imagem");
					}.bind(this),
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.notify('error',
										'Ocorreu um erro ao enviar a foto. Por favor, tente novamente!');
					}.bind(this), '0', '0');
}

/**
 * Foto
 */
window.blockly.js.blockly.Foto.Tirar = function() {
	this.cronapi.cordova.camera
			.getPicture(
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.changeValueOfField("User.active.picture",
										String('data:image/png;base64,')
												+ String(item));
						this.cronapi.screen.showComponent("imagem");
					}.bind(this),
					function(sender_item) {
						item = sender_item;
						this.cronapi.screen
								.notify('error',
										'Ocorreu um erro ao enviar a foto. Por favor, tente novamente!');
					}.bind(this), '0', '1');
}

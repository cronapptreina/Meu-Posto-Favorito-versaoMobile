window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Firebase = window.blockly.js.blockly.Firebase || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Firebase.ao_receber_mensagens = function() {

	var item, bd;
	bd = this.cronapi.firebase.getDatabase('');
	this.cronapi.firebase.addOnEvent(bd, '/msg', function(sender_item) {
		item = sender_item;
		this.cronapi.screen.changeValueOfField('messages', item);
	}.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Firebase.enviar_msg = function() {

	var item, bd;
	this.cronapi.firebase.pushData(this.cronapi.firebase.getDatabase(''),
			'/msg', this.cronapi.util.callServerBlockly(
					'blockly.FirebaseBack:formatar_mensagem',
					this.cronapi.screen.getValueOfField("vars.message")));
}

/**
 * Firebase
 */
window.blockly.js.blockly.Firebase.configurar = function() {

	var item, bd;
	this.cronapi.firebase.configFirebase(
			'AIzaSyBlGjxJjUj5RdDajSX91euglnlfEWN8xrM',
			'postofavorito-caac8.firebaseapp.com',
			'https://postofavorito-caac8.firebaseio.com',
			'postofavorito-caac8', 'postofavorito-caac8.appspot.com',
			'235363942691', '', '1:235363942691:android:e5abccfbc945f655');
}

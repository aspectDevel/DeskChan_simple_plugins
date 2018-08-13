/**
 * Плагин для консольного/терминального режима.
 * Добавляет перехват отрисовки технических окон с перенаправлением в сообщение.
 * Например: 
 * 			Когда вы спросите "что умеешь?" - DeskChan пришлет список возможностей в чат, а не в отдельное окно.
 **/

pluginName = "show-technical-to-message"
sendMessage("core:register-alternative", [
	srcTag: "DeskChan:show-technical", 
	dstTag: pluginName, 
	priority: 10000
])

addMessageListener(pluginName, { sender, tag, data ->
	sendMessage("DeskChan:say", data)
})
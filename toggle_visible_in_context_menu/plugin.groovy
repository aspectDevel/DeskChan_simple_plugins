/**
 * Плагин добавляет возможность скрывать/показывать персонажа с помощью контекстного меню
 **/

sendMessage("DeskChan:register-simple-action", [
	name: "Скрыть/показать", 
	msgTag: "TogleCharacterVisible"
])

addMessageListener("TogleCharacterVisible", { sender, tag, data ->
	sendMessage("gui:is-character-visible", null, {asd, visible->
		if(visible){
			sendMessage("gui:hide-character",null)
		}else{
			sendMessage("gui:show-character",null)
		}
	})

})

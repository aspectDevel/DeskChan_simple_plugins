/**
 * Плагин позволяет с помощью контекстного меню выбрать эмоцию асистента. Очень полезно при создании скинов
 **/
def actionsMap = []

[
	Спокойствие: "normal",
	Недоверие: "sceptic",
	Отчаяние: "despair",
	Сумасшествие: "mad",
	Радость: "smile",
	Задумчивость: "thoughtful",
	Азарт: "excitement",
	Смех: "laugh",
	Надежда: "hope",
	Пошлость: "vulgar",
	Смущение: "shy",
	Испуг: "scared",
	Плач: "cry",
	Грусть: "sad",
	Злость: "angry",
	Ярость: "rage",
	Счастье: "happy",
	Отвращение: "disgusted",
	Стыд: "sorry",
	Насмешка: "grin",
	Усталость: "tired",
	Уверенность: "confident",
	Влюблённость: "love",
	Наслаждение: "bounty",
	Замешательство: "confused",
	Шок: "shocked",
	Любопытство: "curious",
	Ожидание: "waiting",
	Ошибка: "error",
	Обида: "offended",
	Удивление: "surprised"
].each {
  actionsMap.add([
    name: it.key + " (" + it.value + ")",
    msgTag: "gui:set-image",
    msgData: it.value
  ])
}

sendMessage("DeskChan:register-simple-actions", [
              name: "Выбор эмоции", 
              actions: actionsMap
])
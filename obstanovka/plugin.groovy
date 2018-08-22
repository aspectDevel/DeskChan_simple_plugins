pluginName = 'obstanovka'

answers = [
	"Сейчас всё спокойно",
	"Всё пиздец! Всё полный пиздец",
	"Ну такое...", "Нормально...",
	"Лучше сядь...",
	"Ой фсё!",
	"Сегодня у тебя будет бурная ночь",
	"Ты не хочешь это знать",
	"Тебе не стоит это знать",
	"Сегодня бери крепкое",
	"Всё тлен",
	"Бывало и лучше",
	"У меня есть две новости. Начну с хорошей. 10% твоих ресурсов еще работают",
	"Давай ты сперва возьмешь успокоительное",
	"Ты не поверишь, но всё прекрасно работает",
	"Всё очень даже не плохо... Но не мешало бы проверить парочку серверов"
]

sendMessage(
	"core:add-command", 
	[
		tag: pluginName+':cmd'
	]
)
Random rand = new Random();

addMessageListener(
	pluginName+':cmd',
	{
		sender, tag, dat ->
			sendMessage("DeskChan:say", answers[Math.abs(rand.nextInt() % answers.size())])
	}
)

sendMessage(
	"core:set-event-link", 
	[
		eventName: 'speech:get',
		commandName: pluginName+':cmd',
		rule: 'обстановка'
	]
)
var config = {};

/**
 * Извлекаем текущие настройки, 
 * выставляем значения по-умолчанию, 
 * вызываем функцию, которая расставит значения по соответствующим инпутам.
 */
chrome.storage.sync.get(["host","port","token"], function(savedData){
	config.host = savedData.host ? savedData.host : "localhost";
	config.port = savedData.port ? savedData.port : "8765";
	config.token = savedData.token ? savedData.token : "db232f05bd7b3e6615b9bfcd38d99624";
	updateInputsValues(config);
});

/**
 * Функция заполняет форму текущими значениями
 */
function updateInputsValues(config){
	$("form").find("input:text").each(function(){
		$(this).val(config[$(this).attr("name")]);
	});
}

/**
 * Функция обновляет значения в хранлище хрома при нажатии кнопки на форме.
 */
$("form").submit(function(){
	$(this).find("input:text").each(function(){
		config[$(this).attr("name")] = $(this).val();
	});
	chrome.storage.sync.set(config);
	$("body").append($("<p/>",{class: "message", text: "Изменения сохранены"}));
	setTimeout(function(){$(".message").hide(1500);}, 3000);
	return false;
});
/**
 * Этот скрипт для каждой страницы свой.
 */
// $("img").attr("src", "https://forum.deskchan.info/assets/uploads/files/1520274092866-4-resized.png");

var json = JSON.stringify({
				"type" : "sendMessage",
				"args" : 
				[
					"DeskChan:Say",
					{
						"text": "Привет из хрома"
					}
				]
			});
chrome.runtime.sendMessage(
	{
		method: "send", 
		params: json
	}
);
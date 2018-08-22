/**
 * Этот скипт является фоновым.
 */
var config = {host: "", port: "", token: ""};
chrome.storage.sync.get(["host","port","token"], function(savedData){
	config.host = savedData.host ? savedData.host : "localhost";
	config.port = savedData.port ? savedData.port : "876522";
	config.token = savedData.token ? savedData.token : "db232f05bd7b3e6615b9bfcd38d99624";
});
setTimeout(function () {
	console.log(config);
}, 1000);

chrome.runtime.onMessage.addListener(
	function (request, sender, sendResponse){
		console.log(request,sender);
		switch(request.method){
			case "send":
				$.post("http://"+config.host+":"+config.port+"/", request.params, function(response){console.log(response)});
			break;
			default:
				console.log(request.method, request.params);
			break;
		}
	}
);
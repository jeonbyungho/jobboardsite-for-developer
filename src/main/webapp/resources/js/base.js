/**
 * @param {HTMLElement} parameterForm
 * @param {String} req_method
 */
async function sendForm(form){
	const formData = new FormData(form);
	const url = form.action;
	const contentType = form.enctype;
	
	let reqInit = {
		method: form.method,
	}
	
	if (contentType != "multipart/form-data"){
		let headers = {
			"Content-Type": contentType,
		};
		reqInit.headers = headers;
		reqInit.body = new URLSearchParams(formData);
	} else {
		reqInit.body = formData;
	}
	
	console.log(reqInit);
	
	try{
		const resp = await fetch(url, reqInit);
		if (!resp.ok){
			throw new Error("서버로부터 정상적인 응답을 받지 못했습니다.");
		}
		return resp.json();
	} catch (error){
		console.error("에러가 발생했습니다.", error);
	}
	return;
}

/**
 * @param {Object} data 
 * @param {String} url 
 * @param {String} req_method 
 * @param {String} contentType 
 */
async function sendData(data, url, reqMethod="GET", contentType="application/x-www-form-urlencoded"){
	try{
		const resp = await fetch(url, {
			method: reqMethod,
			headers: {
				"Content-Type": contentType,
			},
			body: new URLSearchParams(data),
		});
		if (!resp.ok){
			throw new Error("서버로부터 정상적인 응답을 받지 못했습니다.");
		}
		return resp.json();
	} catch (error){
		console.error("에러가 발생했습니다.", error);
	}
	return;
}
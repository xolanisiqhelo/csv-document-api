'use strict';

const studentsBody = document.querySelector('#students > tbody')


function loadStudents() {

	const request = new XMLHttpRequest();
	request.open("GET", "/api/students");

	request.onload = ()=> {

		try {

			const json = JSON.parse(request.responseText);
			console.log("data------>", json);
			populateStudents(json);
		}
		catch (e) {
			console.warn("Could not load students!   :(");
		}
	};

	request.send();



}
function populateStudents(json) {
	//while (rankingBody.firstChild) {
		//rankingBody.removeChild(rankingBody.firstChild);
	//}
	json.forEach((row) => {
		const tr = document.createElement("tr")

		const propertyNames = Object.values(row);
		

		propertyNames.forEach((cell) => {
			
			
			const td = document.createElement("td")

			td.textContent = cell;
			
			tr.appendChild(td);

		});

		studentsBody.appendChild(tr);


	});

}


document.addEventListener("DOMContentLoaded", () => { loadStudents(); });






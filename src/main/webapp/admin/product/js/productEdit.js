const queryString = window.location.search
const urlParams = new URLSearchParams(queryString)
const targetID = urlParams.get('P_ID')
const PRODUCT_URL = "http://localhost:8080/HibernateProject/admin/product/index"
const PRODUCT_TYPE_URL = "http://localhost:8080/HibernateProject/admin/product/type/index"
const typeList = ["MEAT", "VEGE", "BEVE"]
const columnList = ["產品種類", "產品供應商", "產品編號", "產品名稱", "產品存量", "產品買價", "產品售價", "產品圖片"]

let productRawData = []
let productTypeRawData = []
let oldProductName = ""

axios.get(PRODUCT_TYPE_URL)
	.then(response => {
		productTypeRawData = response.data
	})
	.catch(error => { console.log(error) })

axios.get(PRODUCT_URL)
	.then(response => {
		showData(getTargetProduct(response.data))
		addEventListeners(response.data)
	})
	.catch(error => { console.log(error) })

function getTargetProduct(data) {
	return data.find(product => product.P_ID == targetID)
}

function showData(data) {
	let contents = "<tr>"
	contents += "<td width='155px'><input class='產品種類' type='text' name='type' value='" + data.P_Type + "'></td>"
	contents += "<td id='id'><input class='產品編號' id='idValue' disabled type='text' name='id' value='" + data.P_ID + "'></td>"
	contents += "<td id='name'><input class='產品名稱' id='nameValue' type='text' name='name' value='" + data.P_Name + "'></td>"
	contents += "<td><input class='產品存量' type='text' name='stock' value='" + data.P_Stock + "'></td>"
	contents += "<td><input class='產品買價' type='text' name='cost' value='" + data.P_Cost + "'></td>"
	contents += "<td><input class='產品售價' type='text' name='price' value='" + data.P_Price + "'></td>"
	contents += "<td id='imageTD'><input class='產品圖片' type='file' name='image' /></td>"
	contents += "<td><button id='button'>修改</button></td>"
	contents += "<td><button>取消</button></td>"
	resultTable.innerHTML = contents
	oldProductName = data.P_Name
}

function addEventListeners(data) {
	const inputs = document.querySelectorAll("table input")

	document.querySelector("#id").addEventListener("click", () => {
		event.preventDefault()
		alert("產品編號不能更改")
	})

	document.querySelector("#nameValue").addEventListener("change", (event) => {
		for (let i = 0; i < data.length; i++) {
			if (data[i].name.toLowerCase() == event.target.value.trim().toLowerCase()) {
				alert("已有同名稱產品")
				event.target.value = oldProductName
				i = data.length
			}
		}
	})


	inputs[0].addEventListener("mousedown", event => {
		let typeContent = "<select id='type' class='input' name='type'>"
		for (let j = 0; j < productTypeRawData.length; j++) {
			typeContent += "<option value='" + productTypeRawData[j].PT_Name + "'>" + productTypeRawData[j].PT_Name + "</option>"
		}
		typeContent += "</select>"
		event.target.parentElement.innerHTML = typeContent
	})




	document.querySelector("#editForm").addEventListener("submit", (event) => {
		submitResult.innerHTML = ""
		event.preventDefault()
		let switcher = "on"


		for (let i = 0; i < inputs.length; i++) {
			if (inputs[i].value.trim() == "" && i < 6) {
				switcher = "off"
				submitResult.innerHTML += "請輸入" + inputs[i].classList[0] + "<br>"
			}

			if (i === 4) {
				if (inputs[i].value.match(/\./)) {
					switcher = "off"
					submitResult.innerHTML += inputs[i].classList[0] + "只可輸入整數" + "<br>"
				}
			}

			if (i > 4 && i < 6) {
				if (inputs[i].value.match(/[\`\~\!\@\#\$\%\^\&\*\(\)\_\+\-\=\{\}\[\]\;\:\'\"\<\>\?\,\\]/) ||
					inputs[i].value.match(/[\u4E00-\u9FFF]/) ||
					inputs[i].value.match(/[a-zA-Z]/)) {
					switcher = "off"
					submitResult.innerHTML += inputs[i].classList[0] + "只可輸入數字" + "<br>"
				}
				if (inputs[i].value.match("..")) {
					inputs[i].value = inputs[i].value.replace("..", ".")
				}
			}
		}


		if (switcher === "on") {
			document.querySelector("#idValue").disabled = false
			event.currentTarget.submit()
		}

	})
}
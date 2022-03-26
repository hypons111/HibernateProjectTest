const BASE_URL = "http://localhost:8080/HibernateProject/admin/product/index";
const resultTable = document.querySelector("#resultTable")
const id = document.querySelector('#id')
const columnSearchs = document.querySelectorAll('.columnSearch')
const columnSearchInputs = document.querySelectorAll('.columnSearchInput')
const sorts = document.querySelectorAll('#sort')
let currentData = []
let rawData = ""
let sortStates = "ASC"



function ultimateSearch() {
	let tempData = rawData
	const KEY = ["", "P_ID", "", "P_Stock", "P_Cost", "P_Price", ]
	for (let k = 0; k < columnSearchInputs.length; k++) {

		if (columnSearchInputs[k].value !== "") {
			if (k === 0) {
				tempData = tempData.filter(product => product.P_Type.toLowerCase().includes(columnSearchInputs[0].value))
			} else if (k === 2) {
				tempData = tempData.filter(product => product.P_Name.toLowerCase().includes(columnSearchInputs[2].value.toLowerCase()))
			} else {
				if (columnSearchInputs[k].value.includes("<")) {
					tempData = tempData.filter(product => product[KEY[k]] < Number(columnSearchInputs[k].value.slice(1)))
				} else if (columnSearchInputs[k].value.includes(">")) {
					tempData = tempData.filter(product => product[KEY[k]] > Number(columnSearchInputs[k].value.slice(1)))
				} else {
				console.log(tempData.filter(product => product[KEY[k]] == Number(columnSearchInputs[k].value)))
					tempData = tempData.filter(product => product[KEY[k]] == Number(columnSearchInputs[k].value))
				}
			}
		}
	}
	return tempData
}

axios
	.get(BASE_URL)
	.then(response => {
		return new Promise(resolve => {
			resolve(response.data)
			rawData = response.data
		})
	})
	.then(rawData => { showData(rawData) })
	.catch(error => console.log(error));


//show all data button listener
document.querySelector('#showAll').addEventListener('click', () => {
	showData(rawData)
	columnSearchInputs.forEach(columnSearchInput => {
		columnSearchInput.value = ""
	})

})

//sorts listener
sorts.forEach(sort => {

	sort.addEventListener('click', (event) => {
	
		event.preventDefault()
		let attribute = event.target.classList[0]
		if (sortStates === "ASC") {
			currentData.sort((a, b) => {
				if (a[attribute] < b[attribute]) { return -1 }
				if (a[attribute] > b[attribute]) { return 1 }
				return 0
			})
			sortStates = "DESC"
		} else {
			currentData.sort((a, b) => {
				if (a[attribute] < b[attribute]) { return 1 }
				if (a[attribute] > b[attribute]) { return -1 }
				return 0
			})
			sortStates = "ASC"
		}
		showData(currentData)
	})
})

//column searchs listener
for (let i = 0; i < columnSearchs.length; i++) {
	columnSearchs[i].addEventListener('submit', (event) => {
		event.preventDefault()
		showData(ultimateSearch())
	})
}

// show data
function showData(data) {
	currentData = []
	currentData.push(...data)
	document.querySelector("#totalNum").innerText = data.length + "筆"
	contents = ""
	for (let i = 0; i < data.length; i++) {
		contents += "<tr><td>" + (i + 1) + "</td>"
		contents += "<td>" + data[i].P_Type + "</td>"
		contents += "<td>" + data[i].P_ID + "</td>"
		contents += "<td>" + data[i].P_Name + "</td>"
		contents += "<td>" + data[i].P_Stock + "</td>"
		contents += "<td>" + data[i].P_Cost + "</td>"
		contents += "<td>" + data[i].P_Price + "</td>"
		contents += "<td><img src='/images/product/" + data[i].P_Image + "?" + Math.random() + "' width='50px'></td>"
		contents += "<td><a href=updateform.jsp?P_ID=" + data[i].P_ID + "><button>修改</button></a></td>"
		contents += "<td><a href=delete?P_ID=" + data[i].P_ID + "><button>刪除</button></a></td></tr>"
	}
	resultTable.innerHTML = contents
}


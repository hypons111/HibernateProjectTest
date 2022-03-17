
// 預覽圖片，將取得的files一個個取出丟到convertFile()
function previewFiles1(files) {
    if (files && files.length >= 1) {
        $.map(files, file => {
            convertFile(file)
                .then(data => {
                  console.log(data) // 把編碼後的字串輸出到console
                  showPreviewImage1(data, file.name)
                })
                .catch(err => console.log(err))
        })
    }
}

// 預覽圖片，將取得的files一個個取出丟到convertFile()
function previewFiles2(files) {
    if (files && files.length >= 1) {
        $.map(files, file => {
            convertFile(file)
                .then(data => {
                  console.log(data) // 把編碼後的字串輸出到console
                  showPreviewImage2(data, file.name)
                })
                .catch(err => console.log(err))
        })
    }
}

// 使用FileReader讀取檔案，並且回傳Base64編碼後的source
function convertFile(file) {
    return new Promise((resolve,reject)=>{
        // 建立FileReader物件
        let reader = new FileReader()
        // 註冊onload事件，取得result則resolve (會是一個Base64字串)
        reader.onload = () => { resolve(reader.result) }
        // 註冊onerror事件，若發生error則reject
        reader.onerror = () => { reject(reader.error) }
        // 讀取檔案
        reader.readAsDataURL(file)
    })
}

// 在頁面上新增<img>
function showPreviewImage1(src, fileName) {
    let image = new Image(100) // 設定寬100px
    image.name = fileName
    image.src = src // <img>中src屬性除了接url外也可以直接接Base64字串
    $("#addPreviewDiv").append(image) //.append(`<p>File: ${image.name}`)
}

// 在頁面上新增<img>
function showPreviewImage2(src, fileName) {
    let image = new Image(100) // 設定寬100px
    image.name = fileName
    image.src = src // <img>中src屬性除了接url外也可以直接接Base64字串
    $(".updatePreviewDiv").append(image) //.append(`<p>File: ${image.name}`)
}

// 當上傳檔案改變時清除目前預覽圖，並且呼叫previewFiles()
$("#upimgAdd").change(function(){
    $("#addPreviewDiv").empty() // 清空當下預覽
    previewFiles1(this.files) // this即為<input>元素
})

// 當上傳檔案改變時清除目前預覽圖，並且呼叫previewFiles()
$(".upimgUpdate").change(function(){
    $(".updatePreviewDiv").empty() // 清空當下預覽
    previewFiles2(this.files) // this即為<input>元素
})

$("#addClose").click(function(){
	$("#addPreviewDiv").empty() // 清空當下預覽
})

$(".updateClose").click(function(){
	$(".updatePreviewDiv").empty() // 清空當下預覽
})

// dragover事件：拖曳(滑鼠還沒鬆開)至放置區時，就要先防止瀏覽器進行開圖
$("#dragArea").on("dragover", function(e) {
    e.preventDefault()
})

// 當拖曳區發生drop事件時，接受格式為image的資料
$("#dragArea").on("drop", function(e){
    // 防止事件傳遞及預設事件發生
    e.stopPropagation()
    e.preventDefault()
    // 取得data type為image/*的資料
    e.originalEvent.dataTransfer.getData("image/*")
    let files = e.originalEvent.dataTransfer.files
    console.dir(files) // 看看File長什麼樣子
    $("#previewDiv").empty() // 清空當下預覽
    previewFiles(files)
})
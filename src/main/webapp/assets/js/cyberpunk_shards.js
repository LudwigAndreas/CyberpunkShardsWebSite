const textBody = document.getElementById('textBody');

function allChildrenHeight(elm) {
    let children = elm.nextElementSibling.children;
    let childrenSize = elm.nextElementSibling.childElementCount;
    let finalSize = 0;
    for (let i = 0; i < childrenSize; i++) {
        finalSize += children[i].offsetHeight;
        finalSize += parseInt(getComputedStyle(children[i]).marginTop);
    }
    return finalSize;
}

function toggleList(header) {
    if (header.children[1].className == "wrench" && header.children[1].style.rotate == "0deg") {
        header.children[1].style.rotate = "-90deg";
    } else {
        header.children[1].style.rotate = "0deg";
    }
    if (header.nextElementSibling.style.maxHeight === "0px") {
        let fullHeight = allChildrenHeight(header);
        header.nextElementSibling.style.maxHeight = (fullHeight + 1000) + "px";
    } else {
        header.nextElementSibling.style.maxHeight = "0px";
    }
}

function showTextArticles(articleText, selected) {
    const tabList = document.querySelectorAll('.titleBox');
    tabList.forEach(function(tab) {tab.className = "titleBox"});
    selected.className = "selected titleBox";
    textBody.innerHTML = articleText;
    // window.history.replaceState(null, '', "#Articles_"+arrNum);
}

async function getData(url = '') {

    const response = await fetch(url, {
        method: 'GET',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
        }
    });
    return response.json();
}

async function loadDataBase(selected) {
    const tabList = document.querySelectorAll('.titleBox');
    tabList.forEach(function(tab) {tab.className = "titleBox"});
    selected.className = "selected titleBox";
    textBody.innerHTML = '';
    textBody.innerHTML += "<h2 id=\"selectAdd1\" class=\"titleBox\" style=\"align-items: center; margin: 30px auto 30px; height: 50px;\" onclick=\"toggleAddShardModule(this)\">ADD SHARD</h2>";
    textBody.innerHTML += "<h2 id=\"selectAdd2\" class=\"titleBox\" style=\"align-items: center; margin: 30px auto 30px; height: 50px;\" onclick=\"toggleEditShardModule(this)\">EDIT SHARD</h2>";
    // var response = getData('assets/js/cyberpunk_shards.js')
    //     .then((result) => {
    //         console.log(response);
    //     });
}

function toggleEditShardModule(selected) {
    document.getElementById("selectAdd1").className = "titleBox"
    selected.className = "selected titleBox";
    if (document.getElementById("createShardForm") != null)
        document.getElementById("createShardForm").remove();
}

function toggleAddShardModule(selected) {
    document.getElementById("selectAdd2").className = "titleBox"
    selected.className = "selected titleBox";
    let template = document.getElementById('createShardTemplate');
    if (document.getElementById("createShardForm") == null) {
        let addShardField = template.content.cloneNode(true);
        textBody.append(addShardField)
    }

    $("textarea").each(function () {
        this.setAttribute("style", "min-height: 100px; resize: none; margin: 0 auto; height:" + (this.scrollHeight) + "px;overflow-y:hidden;");
    }).on("input", function () {
        this.style.height = 0;
        this.style.height = (this.scrollHeight) + "px";
    });
}

async function loadUserList(selected) {
    const tabList = document.querySelectorAll('.titleBox');
    tabList.forEach(function(tab) {tab.className = "titleBox"});
    selected.className = "selected titleBox";
    textBody.innerHTML = '';
}

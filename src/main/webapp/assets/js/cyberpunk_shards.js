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

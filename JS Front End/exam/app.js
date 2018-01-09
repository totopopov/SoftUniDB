//name of the image of water beast renamed, in firebase image name is "ocean-b east.jpg"
//added some maps to prevent messing around as some info is gotton from the html ids and class.


//==========================================================from second problem

const main = $('#elementsContainer');
const divInfo = $('#elementInfo');
const mapElements = {};
let currentElement = "";

function clearInfo() {
    $('.center-after-click').empty();
    $('#right-after-click').empty();
}

function hideMain() {
    main.addClass('no-display');
}

function showMain() {
    main.removeClass('no-display');
}

function showDivInfo() {
    divInfo.removeClass('no-display');
}

function hideDivInfo() {
    divInfo.addClass('no-display');
}

function renderName(singleElement) {
    let title = $('#elementInfoTitle');
    title.text(singleElement);
}

function renderBackButton() {

    let btnContainer = $('div .back-button');
    btnContainer.empty();
    let btn = $('<button id="backToElements">Back to Elements</button>').appendTo(btnContainer);

    btn.on('click', function (e) {
        e.preventDefault();

        showMain();
        hideDivInfo();
        clearInfo();
    });

}

function renderRadioButtons(data) {

    let list = $('.creatures');
    let map = {};
    let i = 0;
    list.empty();
    for (let creature of data["creatures"]) {
        item = $('<li>');
        let name = creature["name"];
        map[name] = i++;
        console.log(name);

        let radioBtn = $('<input class="radio-button checked" name="selector" type="radio" value="' + name + '">').appendTo(item);
        $('<label>' + name + '</label>').appendTo(item);
        item.appendTo(list);

        radioBtn.change(function (e) {
            e.preventDefault();


            let index = map[$(this).val()];

            if (index != null) {
                let host = 'https://js-retake.firebaseio.com/elements/' + currentElement + '/creatures/' + index + '.json';


                $.get(host)
                    .then(renderInfo)
                    .catch((err) => console.log(err));
            } else {
                alert("Bad request!");
            }


        });
    }
    $(document).ready(function () {

        list.find("li").first().find("input").change();
        list.find("li").first().find("input").attr("checked", true);

    });


}

function renderImage(image) {
    let divImage = $('.center-after-click');
    divImage.empty();

    $('<img id="creature-image" src="images/' + image["image"] + '" alt="">').appendTo(divImage);
}

function renderStats(data) {


    let divData = $('#right-after-click');
    divData.empty();

    $('<p id="creature-name">' + data["name"] + ' </p>').appendTo(divData);
    $('<p id="creature-power"> ' + data["power"] + '</p>').appendTo(divData);
    $('<p id="creature-ultimate"> ' + data["ultimate"] + '</p>').appendTo(divData);
    $('<p id="creature-region">' + data["region"] + ' </p>').appendTo(divData);
}

function renderInfo(creature) {

    renderImage(creature);
    renderStats(creature);
}


function renderSingleElementInHTML(data) {
    showDivInfo();
    hideMain();
    let singeElementName = data["name"];
    renderName(singeElementName);
    renderBackButton();
    renderRadioButtons(data);

}


//==========================================================from second problem


//==========================================================from first problem
function attachHi(main) {

    $('<h1>Choose Your Destiny</h1>').prependTo(main)
}

function attachContainers(elementsName) {

    //style has only first second third fourth, so making it more dynamically changeable would suggest not giving us those classes,
    // you can dynamically change the name of the elements

    let container = $('div.container');

    let mainDivFirst = $('<div class="containers">');
    let mainDivSecond = $('<div class="containers">');
    console.log(elementsName);

    $('<div id="' + elementsName[0] + '" class="first clickable"></div>').appendTo(mainDivFirst);
    $('<div id="' + elementsName[2] + '" class="second clickable"></div>').appendTo(mainDivFirst);

    mainDivFirst.appendTo(container);

    $('<div id="' + elementsName[3] + '" class="third clickable"></div>').appendTo(mainDivSecond);
    $('<div id="' + elementsName[1] + '" class="fourth clickable"></div>').appendTo(mainDivSecond);

    mainDivSecond.appendTo(container);

}

function attachEventElement() {

    $('div.clickable').on('click', function (e) {
        e.preventDefault();


        let element = $(this).attr('id');

        let provenElement = mapElements[element];
        console.log(provenElement);
        if (provenElement == null) {
            alert("Bad Request !")
        } else {
            let host = 'https://js-retake.firebaseio.com/elements/' + provenElement + '.json';

            console.log(host);
            currentElement = provenElement;
            $.get(host)
                .then(renderSingleElementInHTML)
                .catch((err) => console.log(err));
        }


    });
}

function renderAllElementsInHTML(elements) {

    hideDivInfo();
    let bigInfoContainer = $('#elementInfo');
    bigInfoContainer.addClass('no-display');

    let elementsName = [];

    for (let key in elements) {
        elementsName.push(elements[key]["name"].toLowerCase());
        mapElements[elements[key]["name"].toLowerCase()] = elements[key]["name"].toLowerCase()
    }


    // attachHi(main);     // the in index apparantly has it.
    attachContainers(elementsName);

    attachEventElement();
}

//==========================================================from first problem

function getAllElements() {

    //why not using https://js-retake.firebaseio.com/.json so we can skip the rafractoring.
    let host = 'https://js-retake.firebaseio.com/elements.json';

    $.get(host)
        .then(renderAllElementsInHTML)
        .catch((err) => console.log(err));


}


getAllElements();







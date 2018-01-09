let elements = {
    "elements": {
        "air": {
            "creatures": [
                {
                    "image": "archangel.jpg",
                    "name": "Archangel",
                    "power": "Power: 2000",
                    "region": "Region: Heaven's Kingdom",
                    "ultimate": "Ultimate: Wind Justice"
                },
                {
                    "image": "air-elemental.png",
                    "name": "Elemental",
                    "power": "Power: 3500",
                    "region": "Region: Tunders",
                    "ultimate": "Ultimate: Tunder Storm"
                },
                {
                    "image": "hippogryph.jpg",
                    "name": "Hippogryph",
                    "power": "Power: 800",
                    "region": "Region: Wind Vail",
                    "ultimate": "Ultimate: Furious Nails"
                }
            ],
            "name": "Air"
        },
        "earth": {
            "creatures": [
                {
                    "image": "forest-god.jpg",
                    "name": "Forest God",
                    "power": "Power: 5000",
                    "region": "Region: Cursed Forest",
                    "ultimate": "Ultimate: Nature's Grasp"
                },
                {
                    "image": "earth-elemental.jpg",
                    "name": "Earth Elemental",
                    "power": "Power: 2000",
                    "region": "Region: Misty Mountains",
                    "ultimate": "Ultimate: Power Ball"
                },
                {
                    "image": "werewolf.jpg",
                    "name": "Werewolf",
                    "power": "Power: 1150",
                    "region": "Region: Cursed Forest",
                    "ultimate": "Ultimate: Bloody Hunt"
                }
            ],
            "name": "Earth"
        },
        "fire": {
            "creatures": [
                {
                    "image": "fire-guardian.jpg",
                    "name": "Fire Guardian",
                    "power": "Power: 1000",
                    "region": "Region: Dark Dungeon",
                    "ultimate": "Ultimate: Fire Ball"
                },
                {
                    "image": "diablo.jpg",
                    "name": "Diablo",
                    "power": "Power: ~",
                    "region": "Region: Molten Core",
                    "ultimate": "Ultimate: Blast Wave"
                },
                {
                    "image": "fire-dragon.jpg",
                    "name": "Fire Dragon",
                    "power": "Power:3850",
                    "region": "Region: Onixya Liar",
                    "ultimate": "Ultimate: Flame Breath"
                }
            ],
            "name": "Fire"
        },
        "water": {
            "creatures": [
                {
                    "image": "mermaid.jpg",
                    "name": "Mermaid",
                    "power": "Power: 675",
                    "region": "Region: Ocean Abbys",
                    "ultimate": "Ultimate: Allure"
                },
                {
                    "image": "leviathan.jpg",
                    "name": "Leviathan",
                    "power": "Power: 3000",
                    "region": "Region: Ocean Dephts",
                    "ultimate": "Ultimate: Devour"
                },
                {
                    "image": "ocean-beast.jpg",
                    "name": "Ocean Beast",
                    "power": "Power: 3500",
                    "region": "Region: ----------",
                    "ultimate": "Ultimate: Furious bite"
                }
            ],
            "name": "Water"
        }
    }
};


//==========================================================second page

let main = $('#elementsContainer');
let divInfo = $('#elementInfo');


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
    list.empty();
    for (let creature of data["creatures"]) {
        item = $('<li>');
        let name = creature["name"];
        console.log(name);
        let radioBtn = $('<input class="radio-button checked" name="selector" type="radio" value="' + name + '">').appendTo(item);
        $('<label>' + name + '</label>').appendTo(item);
        item.appendTo(list);

        radioBtn.change(function (e) {
            e.preventDefault();
            let element = $(this).attr('value');
            renderImage(creature);
            renderInfo(creature);
        });


    }
}

function renderImage(image) {
    let divImage = $('.center-after-click');
    divImage.empty();

    $('<img id="creature-image" src="images/' + image["image"] + '" alt="">').appendTo(divImage);
}

function renderInfo(data) {

    console.log(data);

    let divData = $('#right-after-click');
    divData.empty();

    $('<p id="creature-name">' + data["name"] + ' </p>').appendTo(divData);
    $('<p id="creature-power"> ' + data["power"] + '</p>').appendTo(divData);
    $('<p id="creature-ultimate"> ' + data["ultimate"] + '</p>').appendTo(divData);
    $('<p id="creature-region">' + data["region"] + ' </p>').appendTo(divData);
}

function renderSingleElementInHTML(data) {
    showDivInfo();
    hideMain();
    let singeElementName = data["name"];
    renderName(singeElementName);
    renderBackButton();
    renderRadioButtons(data);

}


//==========================================================second page


//==========================================================first page
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

function attachEventElement(elements) {

    $('div.clickable').on('click', function (e) {
        e.preventDefault();

        let element = $(this).attr('id');
        console.log(element);
        console.log(elements["elements"][element]);


        renderSingleElementInHTML(elements["elements"][element]);

    });
}

function renderAllElementsInHTML(elements) {

    hideDivInfo();
    let bigInfoContainer = $('#elementInfo');
    bigInfoContainer.addClass('no-display');

    let elementsName = [];

    for (let key in elements["elements"]) {
        elementsName.push(elements["elements"][key]["name"].toLowerCase());
    }


    attachHi(main);
    attachContainers( elementsName);

    attachEventElement(elements);
}

//==========================================================first page

renderAllElementsInHTML(elements);


//attachCreatureInfo(elements, creatures);

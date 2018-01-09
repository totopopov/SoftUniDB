//Problem part 2


let elements = {
    "elements": {
        "air": {
            name: "Air",
            creatures: [
                {
                    name: "Archangel",
                    power: "Power: 2000",
                    ultimate: "Ultimate: Wind Justice",
                    region: "Region: Heaven's Kingdom",
                    image: "archangel.jpg"
                },
                {
                    name: "Elemental",
                    power: "Power: 3500",
                    ultimate: "Ultimate: Tunder Storm",
                    region: "Region: Tunders",
                    image: "air-elemental.png"
                }
            ]
        }
    }
};


function hideMain() {
    let main = $('#elementsContainer');
    main.addClass('no-display');
}

function renderName(singleElement) {
    let title = $('#elementInfoTitle');
    title.text(singleElement);
}

function renderBackButton() {
    let btnContainer = $('div .back-button');
    $('<button id="backToElements">Back to Elements</button>').appendTo(btnContainer);
}

function renderRadioButtons(data,singeElementName) {

    let list=$('.creatures');

    for (let creature of data[singeElementName.toLowerCase()]["creatures"]) {

        console.log(data[singeElementName.toLowerCase()]["creatures"]);


        item=$('<li>');
        let name =creature["name"];
        console.log(name);

        $('<input class="radio-button checked" name="selector" type="radio" value="'+name+'">').appendTo(item);
        $('<label>'+name+'</label>').appendTo(item);

        item.appendTo(list);
    }



}

function renderImage(image) {
    let divImage = $('.center-after-click');

    $('<img id="creature-image" src="images/'+image+'" alt="">').appendTo(divImage);
}

function renderInfo(data) {

    console.log(data);

    let divData = $('#right-after-click');

        $('<p id="creature-name">'+ data["name"] +' </p>').appendTo(divData);
        $('<p id="creature-power"> '+ data["power"]+'</p>').appendTo(divData);
        $('<p id="creature-ultimate"> '+ data["ultimate"]+'</p>').appendTo(divData);
        $('<p id="creature-region">'+ data["region"]+' </p>').appendTo(divData);


}

function renderSingleElementInHTML(data) {
    let divInfo = $('#elementInfo');

    hideMain();
    let singeElementName = data["air"]["name"];

    renderName(singeElementName);
    renderBackButton();

    renderRadioButtons(data,singeElementName);


    renderImage(data["air"]["creatures"][0]["image"]);
    renderInfo(data["air"]["creatures"][0]);
}

renderSingleElementInHTML(elements["elements"]);


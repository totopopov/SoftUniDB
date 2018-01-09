//Problem part 1


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
                }
            ]
        },
        "fire": {
            name: "Fire",
            creatures: [
                {
                    name: "Fire Guardian",
                    power: "Power: 1000",
                    ultimate: "Ultimate: Fire Ball",
                    region: "Region: Dark Dungeon",
                    image: "fire-guardian.jpg"
                }
            ]
        },


        "water": {
            name: "Water",
            creatures: [
                {
                    name: "Mermaid",
                    power: "Power: 675",
                    ultimate: "Ultimate: Allure",
                    region: "Region: Ocean Abbys",
                    image: "mermaid.jpg"
                }
            ]
        },
        "earth": {
            name: "Earth",
            creatures: [
                {
                    name: "Forest God",
                    power: "Power: 5000",
                    ultimate: "Ultimate: Nature's Grasp",
                    region: "Region: Cursed Forest",
                    image: "forest-god.jpg"
                }
            ]
        }
    }
};


function attachHi(main) {

    $('<h1>Choose Your Destiny</h1>').prependTo(main)
}

function attachContainers(container, elementsName) {

    //style has only first second third fourth, so making it more dynamically changeable would suggest not giving us those classes,
    // you can dynamically change the name of the elements

    let mainDivFirst = $('<div class="containers">');
    let mainDivSecond = $('<div class="containers">');

    $('<div id="+elementsName[0] + " class="first clickable"></div>').appendTo(mainDivFirst);
    $('<div id="+elementsName[1] + " class="second clickable"></div>').appendTo(mainDivFirst);

    mainDivFirst.appendTo(container);

    $('<div id="+elementsName[2] + " class="third clickable"></div>').appendTo(mainDivSecond);
    $('<div id="+elementsName[3] + " class="fourth clickable"></div>').appendTo(mainDivSecond);

    mainDivSecond.appendTo(container);

}

function renderAllElementsInHTML(elements) {

    let elementsName = [];

    for (let key in elements["elements"]) {
        elementsName.push(elements["elements"][key]["name"].toLowerCase());
    }


    let main = $('#elementsContainer');
    let container = $('div.container');
    attachHi(main);

    attachContainers(container, elementsName)


}


renderAllElementsInHTML(elements);


//Problem part 2
// see jquery-data2
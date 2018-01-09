
//json taken from firebase/elements, ( I know that https://js-retake.firebaseio.com/.json returns in with the ekements inside but,
// needed to add one more string to access it, elements["elements"])

// its an associative array so access via index is kind of not working  elements[0]....


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
                },
                {
                    name: "Diablo",
                    power: "Power: ~",
                    ultimate: "Ultimate: Blast Wave",
                    region: "Region: Molten Core",
                    image: "diablo.jpg"
                }
            ]
        }
    }
};




function renderAllElements(elements) {
    for (let key in elements) {
     let element=elements[key];
        console.log(element["name"].toLowerCase());
    }

}

function renderSingleElement(element) {
    let elementarno=element;
    let elementName=element["name"];
    console.log(elementName.toLowerCase());
    console.log("Creatures:");
    for (let creature of element["creatures"]) {
        console.log(creature["name"]);
    }
}

function renderSingleCreature(creatures, creatureName) {

    for (let creature of creatures) {
        if (creature["name"]===creatureName){
            console.log(creature["name"]);
            console.log(creature["power"]);
            console.log(creature["ultimate"]);
            console.log(creature["region"]);
        }
    }


}






renderAllElements(elements["elements"]);
renderSingleElement(elements["elements"]["air"]);
renderSingleCreature(elements["elements"]["air"]["creatures"], "Archangel");







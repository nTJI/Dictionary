var fields = [];

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    createFieldDeclaration(data);
    updateTargetDiv();
}

function createFieldDeclaration(id) {
    console.log(id);
    // document.getElementById("target").appendChild();
    var div = document.createElement("div");
    div.className = "block";
    fields.push(createObjectForType(id))
    document.getElementById("target").appendChild(div);
}

function createObjectForType(id) {
    var obj = {
        hidden: id,
        id: id + (fields.length + 1),
        name: "name",
        presetValue: "presetValue"
    }
    console.log(id)
    return obj;
}

function updateTargetDiv() {
    var target = document.getElementById("target");
    target.innerHTML = "";
    fields.forEach(e => {
        var div = document.createElement("div");
        div.className = "myDiv"

        // ID
        var input = document.createElement("input");
        input.id = e.id;
        input.className = "id"
        input.value = e.id;

        var label = document.createElement("label");
        label.innerText = "Id"
        div.appendChild(label);
        div.appendChild(input);
        div.appendChild(document.createElement("br"));

        // NAME
        var input = document.createElement("input");
        input.id = e.id + "_name";
        input.className = "name"
        input.value = e.name;

        var label = document.createElement("label");
        label.innerText = "Name"
        div.appendChild(label);
        div.appendChild(input);
        div.appendChild(document.createElement("br"));


        //PresetValue
        var input = document.createElement("input");
        input.id = e.id + "_presetValue";
        input.className = "presetValue"
        input.value = e.presetValue;

        var label = document.createElement("label");
        label.innerText = "Preset value"
        div.appendChild(label);
        div.appendChild(input);
        div.appendChild(document.createElement("br"));


        // HIDDEN
        var hidden = document.createElement("input")
        hidden.type = "hidden";
        hidden.value = e.hidden;
        hidden.className = "hidden";
        div.appendChild(hidden);

        target.appendChild(div);
    })
}

function save() {
    fields = [];
    var target = document.getElementById("target");
    var divs = target.getElementsByClassName("myDiv");
    Array.prototype.forEach.call(divs, function(div) {

        let id = div.getElementsByClassName("id")[0];
        let name = div.getElementsByClassName("name")[0];
        let presetValue = div.getElementsByClassName("presetValue")[0];
        let hidden = div.getElementsByClassName("hidden")[0];
        fields.push({
            id: id.value,
            name: name.value,
            presetValue: presetValue.value,
            hidden: hidden.value
        })
    });

    let name = document.getElementById("dictName").value;
    var request = {
        name: name,
        fieldDefinitions: fields
    }
    post(request);
}

function post(fields) {
    (async () => {
        const rawResponse = await fetch('/post', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(fields)
        });
        const content = await rawResponse.json();

        console.log(content);
    })();
}
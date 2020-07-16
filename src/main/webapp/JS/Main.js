function depositFunction() {

    var container  = 0;

    var listButtonNames = ["deposit","withdraw","transfer","simulator"];
    var listButtonIds = ["ct1","ct2","ct3","ct4"];

    for(i = 0; i < listButtonNames.length; i++) {
        if (i == container) {
            document.getElementById(listButtonNames[i]).style.display = "flex";
            document.getElementById(listButtonIds[i]).style.border = "2px solid #e68a00";
        } else {
            document.getElementById(listButtonNames[i]).style.display = "none";
            document.getElementById(listButtonIds[i]).style.border = "none";
        }
    }
}

function withdrawFunction() {

    var container  = 1;

    var listButtonNames = ["deposit","withdraw","transfer","simulator"];
    var listButtonIds = ["ct1","ct2","ct3","ct4"];

    for(i = 0; i < listButtonNames.length; i++) {
        if (i == container) {
            document.getElementById(listButtonNames[i]).style.display = "flex";
            document.getElementById(listButtonIds[i]).style.border = "2px solid #e68a00";
        } else {
            document.getElementById(listButtonNames[i]).style.display = "none";
            document.getElementById(listButtonIds[i]).style.border = "none";
        }
    }
}

function transferFunction() {

    var container  = 2;

    var listButtonNames = ["deposit","withdraw","transfer","simulator"];
    var listButtonIds = ["ct1","ct2","ct3","ct4"];

    for(i = 0; i < listButtonNames.length; i++) {
        if (i == container) {
            document.getElementById(listButtonNames[i]).style.display = "flex";
            document.getElementById(listButtonIds[i]).style.border = "2px solid #e68a00";
        } else {
            document.getElementById(listButtonNames[i]).style.display = "none";
            document.getElementById(listButtonIds[i]).style.border = "none";
        }
    }
}

function simulatorFunction() {

    var container  = 3;

    var listButtonNames = ["deposit","withdraw","transfer","simulator"];
    var listButtonIds = ["ct1","ct2","ct3","ct4"];

    for(i = 0; i < listButtonNames.length; i++) {
        if (i == container) {
            document.getElementById(listButtonNames[i]).style.display = "flex";
            document.getElementById(listButtonIds[i]).style.border = "2px solid #e68a00";
        } else {
            document.getElementById(listButtonNames[i]).style.display = "none";
            document.getElementById(listButtonIds[i]).style.border = "none";
        }
    }
}

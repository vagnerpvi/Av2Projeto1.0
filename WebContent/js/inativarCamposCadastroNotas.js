function verifica(value) {
    var aps1 = document.getElementById("aps1");
    var av1 = document.getElementById("av1");
    var aps2 = document.getElementById("aps2");
    var av2 = document.getElementById("av2");
    var av3 = document.getElementById("av3");

    if (value == 0) {
        aps2.disabled = true;
        av2.disabled = true;
        av3.disabled = true;
        aps1.disabled = false;
        av1.disabled = false;
    } else if (value == 1) {
        aps1.disabled = true;
        av1.disabled = true;
        av3.disabled = true;
        aps2.disabled = false;
        av2.disabled = false;

    } else if (value == 2) {
        aps1.disabled = true;
        av1.disabled = true;
        av3.disabled = false;
        aps2.disabled = true;
        av2.disabled = true;

    }
};
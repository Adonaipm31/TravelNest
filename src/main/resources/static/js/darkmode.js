document.addEventListener("DOMContentLoaded", function () {
    const toggle = document.getElementById("darkModeToggle");
    const body = document.body;
    const elements = document.querySelectorAll("areaav");

    // Restaurar el estado del modo oscuro
    if (localStorage.getItem("theme") === "dark") {
        body.classList.add("dark-mode");
        toggle.checked = true;
        elements.forEach(el => el.classList.add("dark-mode"));
    }

    toggle.addEventListener("change", function () {
        if (this.checked) {
            body.classList.add("dark-mode");
            elements.forEach(el => el.classList.add("dark-mode"));
            localStorage.setItem("theme", "dark");
        } else {
            body.classList.remove("dark-mode");
            elements.forEach(el => el.classList.remove("dark-mode"));
            localStorage.setItem("theme", "light");
        }
    });
});
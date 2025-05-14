const toggle = document.querySelector(".toggle")
const menuDashboard = document.querySelector(".menu-dashboard")
const iconoMenu = toggle.querySelector("i")
const enlacesMenu = document.querySelectorAll(".enlace")

toggle.addEventListener("click", () => {
    menuDashboard.classList.toggle("open")

    if(iconoMenu.classList.contains("bx-menu")){
        iconoMenu.classList.replace("bx-menu", "bx-x")
    }else {
        iconoMenu.classList.replace("bx-x", "bx-menu")
    }
})

enlacesMenu.forEach(enlace => {
    enlace.addEventListener("click", () => {
        menuDashboard.classList.add("open")
        iconoMenu.classList.replace("bx-menu", "bx-x")
    })
})

const tipoSelect = document.getElementById("tipoSelect");
const cocinaContainer = document.getElementById("tipoCocinaContainer");

tipoSelect.addEventListener("change", function() {
	cocinaContainer.style.display = this.value === "RESTAURANTE" ? "block" : "none";
});

let horarioIndex = 1;
function agregarHorario() {
	const container = document.getElementById("horariosContainer");
	const div = document.createElement("div");
	div.className = "row mb-2 horario-item";
	div.innerHTML = `
            <div class="col-md-4">
                <input type="text" name="horarioAtencion[${horarioIndex}].dia" class="form-control" placeholder="Día">
            </div>
            <div class="col-md-4">
                <input type="text" name="horarioAtencion[${horarioIndex}].horaApertura" class="form-control" placeholder="Hora apertura">
            </div>
            <div class="col-md-4">
                <input type="text" name="horarioAtencion[${horarioIndex}].horaCierre" class="form-control" placeholder="Hora cierre">
            </div>`;
	container.appendChild(div);
	horarioIndex++;
}

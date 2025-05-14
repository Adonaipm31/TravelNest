let carrito = [];
let total = 0;

document.addEventListener('DOMContentLoaded', () => {
  const verCarrito = document.getElementById('verCarrito');
  const carritoModal = document.getElementById('carritoModal');
  const cerrarCarrito = document.querySelector('.cerrar-carrito');
  const listaCarrito = document.getElementById('listaCarrito');
  const totalCarrito = document.getElementById('totalCarrito');
  const contadorCarrito = document.getElementById('contadorCarrito');

  verCarrito.addEventListener('click', (e) => {
    e.preventDefault();
    renderizarCarrito();
    carritoModal.style.display = 'block';
  });

  cerrarCarrito.addEventListener('click', () => {
    carritoModal.style.display = 'none';
  });

  window.addEventListener('click', (e) => {
    if (e.target === carritoModal) {
      carritoModal.style.display = 'none';
    }
  });

  // Simular añadir producto (esto normalmente lo harías con un botón "Agregar")
  // Puedes eliminar este bloque en producción
  setTimeout(() => {
    agregarProducto({ nombre: 'Hotel Boutique', precio: 120 });
    agregarProducto({ nombre: 'Cena Romántica', precio: 60 });
  }, 1000);

  function agregarProducto(producto) {
    carrito.push(producto);
    total += producto.precio;
    contadorCarrito.textContent = carrito.length;
  }

  function renderizarCarrito() {
    listaCarrito.innerHTML = '';
    carrito.forEach((item, index) => {
      const li = document.createElement('li');
      li.textContent = `${item.nombre} - $${item.precio}`;
      listaCarrito.appendChild(li);
    });
    totalCarrito.textContent = total;
  }
});
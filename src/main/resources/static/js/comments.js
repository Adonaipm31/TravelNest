// Array para guardar los comentarios temporalmente
const comments = []

// Esperar que el DOM esté listo
document.addEventListener('DOMContentLoaded', function () {
  const form = document.getElementById('commentForm')

  form.addEventListener('submit', function (e) {
    e.preventDefault()

    const name = document.getElementById('name').value.trim()
    const rooftop = document.getElementById('rooftop').value.trim()
    const comment = document.getElementById('comment').value.trim()

    if (name && rooftop && comment) {
      comments.push({ name: name, rooftop: rooftop, comment: comment })
      form.reset()
      alert('Comment posted!')
    } else {
      alert('Please fill out all fields')
    }
  })
})

// Función para mostrar u ocultar los comentarios
function toggleComments () {
  const listContainer = document.getElementById('commentList')
  const commentsContainer = document.getElementById('commentsContainer')

  commentsContainer.innerHTML = '' // Limpiar los comentarios anteriores

  if (comments.length === 0) {
    commentsContainer.innerHTML = '<li class="list-group-item">No comments yet.</li>'
  } else {
    comments.forEach(function (c) {
      const li = document.createElement('li')
      li.className = 'list-group-item'
      li.innerHTML = `<strong>${c.rooftop}</strong> - <em>${c.name}</em>: ${c.comment}`
      commentsContainer.appendChild(li)
    })
  }

  // Mostrar u ocultar
  if (listContainer.style.display === 'none' || listContainer.style.display === '') {
    listContainer.style.display = 'block'
  } else {
    listContainer.style.display = 'none'
  }
}
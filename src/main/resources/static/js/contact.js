//Envio Formulario Contacto
  emailjs.init('M2Rhl0hf6HH_PHpmZ');

  const form = document.getElementById('contact-form');
  const btn = document.getElementById('form-submit');

  form.addEventListener('submit', function(event) {
    event.preventDefault();

    const serviceID = 'default_service';
    const templateID = 'template_cj0ftzi';

    emailjs.sendForm(serviceID, templateID, this)
      .then(() => {
        Swal.fire({
          icon: 'success',
          title: 'Message was sent successfully',
          text: 'We will contact you as soon as possible.',
          timer: 2500,
          showConfirmButton: false
        }).then(() => {
          window.location.href = "contact";
        });

      }, (err) => {
        alert("Error al enviar el mensaje: " + JSON.stringify(err));
      });
  });
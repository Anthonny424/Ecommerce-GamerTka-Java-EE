const container = document.getElementById("container");
const registerBtn = document.getElementById("register");
const loginBtn = document.getElementById("login");

document
  .getElementById("iniciarSesionBtn")
  .addEventListener("click", function () {
    var modal = document.getElementById("modalInicioSesion");
    modal.style.display = "block";
  });

document.getElementById("cerrarModal").addEventListener("click", function () {
  var modal = document.getElementById("modalInicioSesion");
  modal.style.display = "none";
});

// // Aquí debes agregar la lógica de inicio de sesión, verificar las credenciales, etc.
// document
//   .getElementById("formularioInicioSesion")
//   .addEventListener("submit", function (e) {
//     e.preventDefault();
//     // Agrega aquí la lógica de validación y autenticación
//     // Si las credenciales son válidas, puedes redirigir al usuario a la página de compras
//     // De lo contrario, muestra un mensaje de error
//   });

registerBtn.addEventListener("click", () => {
  container.classList.add("active");
  container.querySelector(".toggle-left").style.backgroundImage =
    "url(https://images.alphacoders.com/519/519792.jpg)";
  container.querySelector(".toggle-right").style.backgroundImage = "none";
});

loginBtn.addEventListener("click", () => {
  container.classList.remove("active");
  container.querySelector(".toggle-left").style.backgroundImage = "none";
  container.querySelector(".toggle-right").style.backgroundImage =
    "url(https://i.blogs.es/08d770/por-que-kratos-es-inmortal/1366_2000.png)";
});
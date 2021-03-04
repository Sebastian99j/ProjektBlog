// <script>
//     function removeFieldError(field) {
//     const errorText = field.nextElementSibling;
//     if (errorText !== null) {
//     if (errorText.classList.contains("form-error-text")) {
//     errorText.remove();
// }
// }
// };
//
//     function createFieldError(field, text) {
//     removeFieldError(field); //przed stworzeniem usuwam by zawsze był najnowszy komunikat
//
//     const div = document.createElement("div");
//     div.classList.add("form-error-text");
//     div.innerText = text;
//     if (field.nextElementSibling === null) {
//     field.parentElement.appendChild(div);
// } else {
//     if (!field.nextElementSibling.classList.contains("form-error-text")) {
//     field.parentElement.insertBefore(div, field.nextElementSibling);
// }
// }
// };
//
//     function toggleErrorField(field, show) {
//     const errorText = field.nextElementSibling;
//     if (errorText !== null) {
//     if (errorText.classList.contains("form-error-text")) {
//     errorText.style.display = show ? "block" : "none";
//     errorText.setAttribute('aria-hidden', show);
// }
// }
// };
//
//     function markFieldAsError(field, show) {
//     if (show) {
//     field.classList.add("field-error");
// } else {
//     field.classList.remove("field-error");
//     toggleErrorField(field, false);
// }
// };
//
//     //pobieram elementy
//     const form = document.querySelector("#contactForm");
//     const inputs = form.querySelectorAll("[required]");
//
//     form.setAttribute("novalidate", true);
//
//     //etap 1 : podpinam eventy
//     for (const el of inputs) {
//     el.addEventListener("input", e => markFieldAsError(e.target, !e.target.checkValidity()));
// }
//
//     form.addEventListener("submit", e => {
//     e.preventDefault();
//
//     let formErrors = false;
//
//     for (const el of inputs) {
//     removeFieldError(el);
//     el.classList.remove("field-error");
//
//     if (!el.checkValidity()) {
//     createFieldError(el, el.dataset.errorText);
//     el.classList.add("field-error");
//     formHasErrors = true;
// }
// }
//
//     if (!formErrors) {
//     //form.submit();
//     //dane będziemy wysyłać dynamicznie!
// }
// });
// </script>
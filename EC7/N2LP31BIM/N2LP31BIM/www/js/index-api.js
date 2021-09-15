$(document).ready(function () {
  fetch("https://www.abibliadigital.com.br/api/verses/nvi/random", {
    method: "GET",
    mode: "cors"
  })
    .then((data) => {
      return data.json();
    })
    .then((verse) => {
      $("#p-bible")[0].innerHTML =
        "<strong>" +
        verse.text +
        "</strong>" +
        " <small>(" +
        verse.book.abbrev.pt +
        " - " +
        verse.chapter +
        ", " +
        verse.number +
      ")</small>";

      $(".loading").removeClass("show");
    });
});
window.onload = function () {
  $(".loading").addClass("show");

  fetch("https://www.abibliadigital.com.br/api/verses/nvi/sl/23", {
    method: "GET",
    mode: "cors",
  })
    .then((data) => {
      return data.json();
    })
    .then((verses) => {
      $("#p-bible")[0].innerHTML =
        "<strong>" +
        verses.verses[0].text +
        "</strong>" +
        " <small>(" +
        verses.book.name +
        "/" +
        verses.book.version +
        ")</small>";

        $(".loading").removeClass("show");
    });
};

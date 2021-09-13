window.onload = function () {
  $(".loading").addClass("show");
  $("#sel-breeds").on("change", getImagem);

  fetch("https://dog.ceo/api/breeds/list/all", {
    method: "GET",
    mode: "cors",
  })
    .then((data) => {
      return data.json();
    })
    .then((breeds) => {
      var i = 0;
      var selBreeds = $("#sel-breeds")[0];

      for (var breed in breeds.message) {
        var option = document.createElement("OPTION");

        option.setAttribute("value", i);
        option.innerHTML = breed;

        selBreeds.appendChild(option);

        i++;
      }

      $(".loading").removeClass("show");
    });
};

function getImagem() {
  var option = $("#sel-breeds option:selected")[0];

  if (option.value === "-1") {
    $("#img-dog")[0].setAttribute("src", "img/empty.jpg");
    return;
  }

  $(".loading").addClass("show");

  fetch("https://dog.ceo/api/breed/" + option.innerHTML + "/images/random", {
    method: "GET",
    mode: "cors",
  })
    .then((data) => {
      return data.json();
    })
    .then((result) => {
      $("#img-dog")[0].setAttribute("src", result.message);
      $(".loading").removeClass("show");
    });
}

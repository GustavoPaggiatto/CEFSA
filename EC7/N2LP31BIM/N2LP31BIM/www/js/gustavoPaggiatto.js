window.onload = function () {
  $(".loading").addClass("show");

  fetch("https://dog.ceo/api/breeds/list/all", {
    method: "GET",
    mode: "cors",
  })
    .then((data) => {
      return data.json();
    })
    .then((breeds) => {
      var i = 1;
      var tBody = $("#tbody-breeds")[0];

      for (var breed in breeds.message) {
        var tr = document.createElement("TR");
        var tdId = document.createElement("TD");
        var tdNome = document.createElement("TD");
        var tdVariacao = document.createElement("TD");

        tdId.innerHTML = i;
        tdNome.innerHTML = breed;

        var variacoes = breeds.message[breed];

        for (var n = 0; n < variacoes.length; n++) {
          var divVariacao = document.createElement("DIV");

          divVariacao.innerHTML = variacoes[n];
          tdVariacao.appendChild(divVariacao);
        }

        tr.appendChild(tdId);
        tr.appendChild(tdNome);
        tr.appendChild(tdVariacao);
        tBody.appendChild(tr);

        i++;
      }

      $("#table-breeds").DataTable({
        paging: true,
        searching: true,
        pageLength: 8,
        oLanguage: {
          sLengthMenu: "",
          sSearch: "",
          sZeroRecords: "Nenhuma informação encontrada",
          sInfo: "",
          sInfoEmpty: "",
          oPaginate: {
            sPrevious: "<",
            sNext: ">"
          }
        }
      });

      $(".loading").removeClass("show");
    });
};

function espandir() {}

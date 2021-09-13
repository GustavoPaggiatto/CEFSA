window.onload = function () {
  $(".loading").addClass("show");
  $("#sel-breeds").on("change", getSubBreeds);

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

function getSubBreeds() {
  var option = $("#sel-breeds option:selected")[0];

  if (option.value === "-1") {
    Swal.fire({
      title: "Atenção!",
      text: "A raça não foi selecionada",
      icon: "warning",
    });

    return;
  }

  $(".loading").addClass("show");

  fetch("https://dog.ceo/api/breed/" + option.innerHTML + "/list", {
    method: "GET",
    mode: "cors",
  })
    .then((data) => {
      return data.json();
    })
    .then((result) => {
      if (window.dtSubsBreeds != null) {
        window.dtSubsBreeds.destroy();
      }

      var tbody = $("#tbody-subs-breeds")[0];

      while (tbody.children.length > 0) tbody.removeChild(tbody.children[0]);

      for (var ix in result.message) {
        var tr = document.createElement("TR");
        var td = document.createElement("TD");

        td.innerHTML = result.message[ix];
        tr.appendChild(td);
        tbody.appendChild(tr);
      }

      window.dtSubsBreeds = $("#tb-subs-breeds").DataTable({
        paging: true,
        searching: false,
        pageLength: 5,
        oLanguage: {
          sLengthMenu: "Exibir _MENU_ registros por página",
          sSearch: "Procurar:",
          sZeroRecords: "Nenhuma informação encontrada",
          sInfo: "Exibindo _START_ a _END_ de _TOTAL_ registros",
          sInfoEmpty: "Exibindo 0 a 0 de 0 registros",
          oPaginate: {
            sPrevious: "Anterior",
            sNext: "Próxima"
          }
        }
      });

      $(".loading").removeClass("show");
    });
}

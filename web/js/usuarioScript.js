// CARRITO PAGAR
$(document).ready(function () {
    $("#carritoPagar_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $("#carritoVaciar_dialog  .modal-body ").html(data)
                $("#carritoPagarBtnClose").removeClass("hide");
                $("#carritoPagarBtnNo").remove();
                $("#submitCarritoPagarForm").remove();
                
                $("#carritoVaciarBtnClose").removeClass("hide");
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitCarritoPagarForm").on('click', 
        function() 
        {
            $("#carritoPagar_form").submit();
        }

    );
});


// CARRITO VACIAR
$(document).ready(function () {
    $("#carritoVaciar_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $("#carritoVaciar_dialog  .modal-body ").html("<h5>Listo, el carrito se ha vaciado.</h5>")
                $("#carritoVaciarBtnNo").remove();
                $("#submitVaciarCarritoForm").remove();
                
                $("#carritoVaciarBtnClose").removeClass("hide");
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitVaciarCarritoForm").on('click', 
        function() 
        {
            $("#carritoVaciar_form").submit();
        }

    );
});


// CARRITO INCREMENTAR ELEMENTO
$(document).ready(function () {
    $("#carritoIncrementar_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                location.reload();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitCarritoIncrementarForm").on('click', 
        function() 
        {
            $("#carritoIncrementar_form").submit();
        }

    );
});

// CARRITO DECREMENTAR ELEMENTO
$(document).ready(function () {
    $("#carritoDecrementar_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                location.reload();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitCarritoDecrementarForm").on('click', 
        function() 
        {
            $("#carritoDecrementar_form").submit();
        }

    );
});

// CARRITO BORRAR ELEMENTO
$(document).ready(function () {
    $("#carritoBorrar_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                location.reload();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitCarritoBorrarForm").on('click', 
        function() 
        {
            $("#carritoBorrar_form").submit();
        }

    );
});

// CARRITO EDITAR ELEMENTO
$(document).ready(function () {
    $("#carritoEditar_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $("#carritoEditar_dialog .modal-header").html("<h3>Exito!</h3>");
                $("#carritoEditar_dialog .modal-body").html(data);
                $("#carritoEditarBtnClose").removeClass("hide");
                $("#carritoEditarBtnNo").remove();
                $("#submitEditarProductoForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitEditarProductoForm").on('click', 
        function() 
        {
            $("#carritoEditar_form").submit();
        }

    );
});

//------------------------------------------------------------------------------

// SCRIPT PARA CAMPOS SOLO NUMERICOS
$(document).ready(function () {
  //called when key is pressed in textbox
  $("#idCantidad").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg1, #errmsg2, #errmsg3, #errmsg4").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
});

//==============================================================================

// MODAL LOGOUT.
$('a.idLogout').on('click', function() {
    var myModal = $('#logout_dialog');

    myModal.modal({ show: true });

    return false;
});

//------------------------------------------------------------------------------

// TABS LINK
$('#myTab a').click(function(e) {
  e.preventDefault();
  $(this).tab('show');
});

// store the currently selected tab in the hash value
$("ul.active-tab > li > a").on("shown.bs.tab", function(e) {
  var id = $(e.target).attr("href").substr(1);
  window.location.hash = id;
});

// on load of the page: switch to the currently selected tab
var hash = window.location.hash;
$('#myTab a[href="' + hash + '"]').tab('show');

//------------------------------------------------------------------------------

// CARRITO INCREMENTAR BUTTON.
$('a.addProd').on('click', function() {
    var myModal = $('#carritoIncrementar_dialog');

    var idCodigo = $(this).closest('tr').find('td.tIdCodigo').html();
    var cantidad = 1;

    $('#idCodigo'   , myModal).val(idCodigo);
    $('#cantidad'   , myModal).val(cantidad);

    $('#submitCarritoIncrementarForm', myModal).click();

    return false;
});


// CARRITO DECREMENTAR BUTTON.
$('a.removeProd').on('click', function() {
    var myModal = $('#carritoDecrementar_dialog');

    var idCodigo = $(this).closest('tr').find('td.tIdCodigo').html();
    var cantidad = 1;

    $('#idCodigo'   , myModal).val(idCodigo);
    $('#cantidad'   , myModal).val(cantidad);

    $('#submitCarritoDecrementarForm', myModal).click();

    return false;
});


// CARRITO BORRAR BUTTON.
$('a.deleteProd').on('click', function() {
    var myModal = $('#carritoBorra_dialog');

    var idCodigo = $(this).closest('tr').find('td.tIdCodigo').html();

    $('#idCodigo'   , myModal).val(idCodigo);

    $('#submitCarritoBorrarForm', myModal).click();

    return false;
});

// CARRITO EDITAR BUTTON.
$('a.editProd').on('click', function() {
    var myModal = $('#carritoEditar_dialog');

    var idCodigo    = $(this).closest('tr').find('td.tIdCodigo').html();
    var remainStock = $(this).closest('tr').find('td.tStock').html();
    var cantActual  = $(this).closest('tr').find('td.tCant').html(); 

    $('#idCodigo'   , myModal).val(idCodigo);
    $('#idCantidad'   , myModal).val(cantActual);
    $('#idRemainStock'   , myModal).text("Puede agregar como maximo: "+remainStock+" elementos.");

     myModal.modal({ show: true });
    //$('#submitCarritoEForm', myModal).click();

    return false;
});
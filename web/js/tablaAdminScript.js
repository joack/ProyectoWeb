/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// MODAL AGREGADO USUARIO
$(document).ready(function () {
    $("#addUser_form").on("submit", function(e) 
    {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#addUser_dialog .modal-header .modal-title').html("Result");
                $('#addUser_dialog .modal-body').html(data);
                $("#submitAddUserForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });
    $("#submitAddUserForm").on('click', 
        function() 
        {
            $("#addUser_form").submit();
        }
    );
});

//==============================================================================

// MODAL PRODUCTO AGREGAR
$(document).ready(function () {
    $("#AgregarProducto_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#AgregaerProducto_dialog .modal-header .modal-title').html("Result");
                $('#AgregaerProducto_dialog .modal-body').html(data);
                $('#agregarProductoCloseBtn').removeClass('hide');
                $('#AgregarProductoCancelBtn').remove();
                $("#submitAgregarProductoForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitAgregarProductoForm").on('click', 
        function() 
        {
            $("#AgregarProducto_form").submit();
        }
    );
});

// MODAL PRODUCTO EDITAR
$(document).ready(function () {
    $("#EditarProducto_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#EditarProducto_dialog .modal-header .modal-title').html("Result");
                $('#EditarProducto_dialog .modal-body').html(data);
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
            $("#EditarProducto_form").submit();
        }
    );
});

// MODAL PRODUCTO BORRAR
$(document).ready(function () {
    $("#BorrarProducto_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#BorrarProducto_dialog .modal-header .modal-title').html("Result");
                $('#BorrarProducto_dialog .modal-body').html(data);
                $("#submitBorrarProductoForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitBorrarProductoForm").on('click', 
        function() 
        {
            $("#BorrarProducto_form").submit();
        }
    );
});

//==============================================================================

// MODAL ARTICULO AGREGAR
$(document).ready(function () {
    $("#AgregarArticulo_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#AgregarArticulo_dialog .modal-header .modal-title').html("Result");
                $('#AgregarArticulo_dialog .modal-body').html(data);
                $('#idArticuloAgregarCloselBtn').removeClass('hide');
                $('#idArticuloAgregarCancelBtn').remove(); 
                $("#submitArgregarArticuloForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitArgregarArticuloForm").on('click', 
        function() 
        {
            $("#AgregarArticulo_form").submit();
        }

    );
});

// MODAL ARTICULO EDITAR
$(document).ready(function () {
    $("#EditarArticulo_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#EditarArticulo_dialog .modal-header .modal-title').html("Result");
                $('#EditarArticulo_dialog .modal-body').html(data);
                $("#EditarArticuloCloseBtn").removeClass('hide')();
                $("#EditarArticuloCancelBtn").remove();
                $("#submitEditarArticuloForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitEditarArticuloForm").on('click', 
        function() 
        {
            $("#EditarArticulo_form").submit();
        }

    );
});

// MODAL ARTICULO BORRAR
$(document).ready(function () {
    $("#BorrarArticulo_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#BorrarArticulo_dialog .modal-header .modal-title').html("Result");
                $('#BorrarArticulo_dialog .modal-body').html(data);
                $('#idArticuloBorrarOkBtn').removeClass('hide');
                $('#idArticuloBorrarNoBtn').remove();
                $("#submitBorrarArticuloForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitBorrarArticuloForm").on('click', 
        function() 
        {
            $("#BorrarArticulo_form").submit();
        }

    );
});

//==============================================================================

// MODAL DESCRIPCION AGREGAR
$(document).ready(function () {
    $("#AgregarDescripcion_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#AgregarDescripcion_dialog .modal-header .modal-title').html("Result");
                $('#AgregarDescripcion_dialog .modal-body').html(data);
                $("#submitArgregarDescripcionForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitArgregarDescripcionForm").on('click', 
        function() 
        {
            $("#AgregarDescripcion_form").submit();
        }
    );
});


// MODAL DESCRIPCION EDITAR
$(document).ready(function () {
    $("#EditarDescripcion_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#EditarDescripcion_dialog .modal-header .modal-title').html("Result");
                $('#EditarDescripcion_dialog .modal-body').html(data);
                $("#submitEditarDescripcionForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitEditarDescripcionForm").on('click', 
        function() 
        {
            $("#EditarDescripcion_form").submit();
        }
    );
});

// MODAL DESCRIPCION BORRAR
$(document).ready(function () {
    $("#BorrarDescripcionArticulo_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#BorrarDescripcionArticulo_dialog .modal-header .modal-title').html("Result");
                $('#BorrarDescripcionArticulo_dialog .modal-body').html(data);
                $("#submitBorrarDescripcionArticuloForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitBorrarDescripcionArticuloForm").on('click', 
        function() 
        {
            $("#BorrarDescripcionArticulo_form").submit();
        }
    );
});



//==============================================================================

// SCRIPT PARA TABLA CON SCROLL VERTICAL
$(document).ready(function() {
    $("#idProductTableShow  , #idUsersTableShow   , " +
      "#productTable        , #usersTable           , " +
      "#idProductEditTableShow, " +
      "#productDescripTable, #idUsersTableShow" ).DataTable( {
        "scrollY":        "250px",
        "scrollCollapse": true,
        "paging":         false
    } );
} );

// SCRIPT PARA CAMPOS SOLO NUMERICOS
$(document).ready(function () {
  //called when key is pressed in textbox
  $("#fld1, #fld2, #fld3, #fld4").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg1, #errmsg2, #errmsg3, #errmsg4").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
});

// MODAL EDITAR USUARIO
$(document).ready(function () {
    $("#editUser_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#editUser_dialog .modal-header .modal-title').html("Result");
                $('#editUser_dialog .modal-body').html(data);
                $("#submitEditUserFormButton").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitEditUserFormButton").on('click', 
        function() 
        {
            $("#editUser_form").submit();
        }

    );
});

// MODAL BORRAR USUARIO
$(document).ready(function () {
    $("#deleteUser_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#deleteUser_dialog .modal-header .modal-title').html("Result");
                $('#deleteUser_dialog .modal-body').html(data);
                $("#submitDeleteUserFormButton").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitDeleteUserFormButton").on('click', 
        function() 
        {
            $("#deleteUser_form").submit();
        }

    );
});



//==============================================================================

$(document).ready(function () {

    $("a[data-toggle=\"tab\"]").on("shown.bs.tab", function (e) {
      console.log( 'show tab' );
        $($.fn.dataTable.tables(true)).DataTable()
          .columns.adjust();
          //.responsive.recalc();
    });

    $("#productTableShow, #usersTableShow").DataTable({
        data: data,
        ordering: false,
        searching: false,
        info: false
    });
});

$('#myTab a').click(function(e) {
  e.preventDefault();
  $(this).tab('show');
});

// store the currently selected tab in the hash value
$("ul.nav-tabs > li > a").on("shown.bs.tab", function(e) {
  var id = $(e.target).attr("href").substr(1);
  window.location.hash = id;
});

// on load of the page: switch to the currently selected tab
var hash = window.location.hash;
$('#myTab a[href="' + hash + '"]').tab('show');

//==============================================================================

// MODAL PRODUCTO BORRAR
$('a.BorrarProducto').on('click', function() {
    var myModal = $('#BorrarProducto_dialog');

    // now get the values from the table
    var idCodigo    = $(this).closest('tr').find('td.idCodigo').html(); 

    // and set them in the modal:
    $('#idCodigo'   , myModal).val(idCodigo);

    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

// MODAL PRODUCTO EDITAR 
$('a.EditarProducto').on('click', function() {
    var myModal = $('#EditarProducto_dialog');

    // now get the values from the table
    var idCodigo    = $(this).closest('tr').find('td.idCodigo').html();    
    var idMarca     = $(this).closest('tr').find('td.idArticulo').html();

       
    // and set them in the modal: 
    $('#idCodigo'   , myModal).val(idCodigo);   
    $('#idMarca'    , myModal).val(idMarca);

    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

//==============================================================================

// MODAL ARTICULO EDITAR.
$('a.EditarArticulo').on('click', function() {
    var myModal = $('#EditarArticulo_dialog');

    // now get the values from the table
    var idCodigo    = $(this).closest('tr').find('td.idCodigo').html();
    
    var idMarca     = $(this).closest('tr').find('td.idMarca').html();
    var idModelo    = $(this).closest('tr').find('td.idModelo').html();
    var idNombre    = $(this).closest('tr').find('td.idNombre').html();
       
    // and set them in the modal: 
    $('#idCodigo'   , myModal).val(idCodigo);   
    $('#idMarca'    , myModal).val(idMarca);
    $('#idModelo'   , myModal).val(idModelo);
    $('#idNombre'   , myModal).val(idNombre);


    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

// MODAL ARTICULO BORRAR 
$('a.BorrarArticulo').on('click', function() {
    var myModal = $('#BorrarArticulo_dialog');

    // now get the values from the table
    var idCodigo  = $(this).closest('tr').find('td.idCodigo').html();
   
    // and set them in the modal:
    $('#idCodigo' , myModal).val(idCodigo);

    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

//============================================================================== 

//  MODAL PARA EDITAR DESCRIPCION DE Articulo
$('a.EditarDescripcion').on('click', function() {
    var myModal = $('#EditarDescripcion_dialog');

    // now get the values from the table
    var idArticulo  = $(this).closest('tr').find('td.idArticulo').html();
    var idDescrip   = $(this).closest('tr').find('td.idDescrip').html();
    var idPrecio    = $(this).closest('tr').find('td.idPrecio').html();
    var idStock     = $(this).closest('tr').find('td.idStock').html();
    var idImagen    = $(this).closest('tr').find('td.idImagen').html();
    
    // and set them in the modal:
 
    $('#idArticulo' , myModal).val(idArticulo);
    $('#idDescrip'  , myModal).val(idDescrip);
    $('#idPrecio'   , myModal).val(idPrecio);
    $('#idStock'    , myModal).val(idStock);
    $('#idImagen'   , myModal).val(idImagen);


    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

// Boton para borrar descripcion 
$('a.EditarDescipcionArticulo').on('click', function() {
    var myModal = $('#BorrarDescripcionArticulo_dialog');

    // now get the values from the table
    var idArticulo  = $(this).closest('tr').find('td.idArticulo').html();
 
    
    // and set them in the modal:
    $('#idArticulo' , myModal).val(idArticulo);


    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});




//------------------------------------------------------------------------------

//MODAL EDITAR DATOS USUARIO.
$('a.editUserButton').on('click', function() {
    var myModal = $('#editUser_dialog');

    // now get the values from the table
    var email       = $(this).closest('tr').find('td.tEmail').html();
    var nickName    = $(this).closest('tr').find('td.tNick' ).html();
    var password    = $(this).closest('tr').find('td.tPass' ).html();
    var isAdmin     = $(this).closest('tr').find('td.tRol'  ).html();
    
    // and set them in the modal:
    $("#idEmail"    , myModal).val(email);
    $("#idUserName" , myModal).val(nickName);
    $("#idUserPass" , myModal).val(password);
    if (isAdmin === "admin") 
    {
        $('#idIsAdmin'  , myModal).prop( "checked", true );
    }else{
        $('#idIsAdmin'  , myModal).prop( "checked", false );
    }
    


    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

// MODAL BORRAR USUARIO.
$('a.removeUserButton').on('click', function() {
    var myModal = $('#deleteUser_dialog');

    // now get the values from the table
    var email    = $(this).closest('tr').find('td.tEmail').html();
    
    // and set them in the modal:
     $('#idEmail'   , myModal).val(email);

    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

//------------------------------------------------------------------------------

// MODAL LOGOUT.
$('a.idLogout').on('click', function() {
    var myModal = $('#logout_dialog');

    myModal.modal({ show: true });

    return false;
});



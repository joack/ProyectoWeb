/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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


$(document).ready(function () {
    $("#productAdd_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#productAdd_dialog .modal-header .modal-title').html("Result");
                $('#productAdd_dialog .modal-body').html(data);
                $("#submitProductForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitProductForm").on('click', 
        function() 
        {
            $("#productAdd_form").submit();
        }

    );
});

$(document).ready(function() {
    $("#productTable, #usersTable").DataTable( {
        "scrollY":        "200px",
        "scrollCollapse": true,
        "paging":         false
    } );
} );

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

//MODAL EDITAR PRODUCTO.
$('a.editProduct').on('click', function() {
    var myModal = $('#edit-modal');

    // now get the values from the table
    var idCodigo    = $(this).closest('tr').find('td.idCodigo').html();
    var idArticulo  = $(this).closest('tr').find('td.idArticulo').html();
    var idMarca     = $(this).closest('tr').find('td.idMarca').html();
    var idModelo    = $(this).closest('tr').find('td.idModelo').html();
    var idNombre    = $(this).closest('tr').find('td.idNombre').html();
    var idDescrip   = $(this).closest('tr').find('td.idDescrip').html();
    var idPrecio    = $(this).closest('tr').find('td.idPrecio').html();
    var idStock     = $(this).closest('tr').find('td.idStock').html();
    var idImagen    = $(this).closest('tr').find('td.idImagen').html();
    
    // and set them in the modal:
 
    $('#idCodigo'   , myModal).val(idCodigo);
    $('#idArticulo' , myModal).val(idArticulo);
    $('#idMarca'    , myModal).val(idMarca);
    $('#idModelo'   , myModal).val(idModelo);
    $('#idNombre'   , myModal).val(idNombre);
    $('#idDescrip'  , myModal).val(idDescrip);
    $('#idPrecio'    , myModal).val(idPrecio);
    $('#idStock'    , myModal).val(idStock);
    $('#idImagen'   , myModal).val(idImagen);


    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});
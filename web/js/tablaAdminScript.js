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

// MODAL AGREGADO PRODUCTO
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

// MODAL EDITAR DESCRIPCION PODUCTO
$(document).ready(function () {
    $("#productEditDescrip_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#productEditDescrip_dialog .modal-header .modal-title').html("Result");
                $('#productEditDescrip_dialog .modal-body').html(data);
                $("#submitProductEditDescripForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitProductEditDescripForm").on('click', 
        function() 
        {
            $("#productEditDescrip_form").submit();
        }

    );
});

// MODAL BORRAR DESCRIPCION PODUCTO
$(document).ready(function () {
    $("#delProductEditDescrip_form").on("submit", function(e) {
        var postData = $(this).serializeArray();
        var formURL = $(this).attr("action");
        $.ajax({
            url: formURL,
            type: "POST",
            data: postData,
            success: function(data, textStatus, jqXHR) {
                $('#delProductEditDescrip_dialog .modal-header .modal-title').html("Result");
                $('#delProductEditDescrip_dialog .modal-body').html(data);
                $("#submitDelProductEditDescripForm").remove();
            },
            error: function(jqXHR, status, error) {
                console.log(status + ": " + error);
            }
        });
        e.preventDefault();
    });

    $("#submitDelProductEditDescripForm").on('click', 
        function() 
        {
            $("#delProductEditDescrip_form").submit();
        }

    );
});

// SCRIPT PARA TABLA CON SCROLL VERTICAL
$(document).ready(function() {
    $("#productTable, #usersTable").DataTable( {
        "scrollY":        "200px",
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

//MODAL EDITAR PRODUCTO LLENADO DE CAMPOS.
$('a.editProduct').on('click', function() {
    var myModal = $('#productEdit_dialog');

    // now get the values from the table
    var idCodigo    = $(this).closest('tr').find('td.idCodigo').html();
    //var idArticulo  = $(this).closest('tr').find('td.idArticulo').html();
    var idMarca     = $(this).closest('tr').find('td.idMarca').html();
    var idModelo    = $(this).closest('tr').find('td.idModelo').html();
    var idNombre    = $(this).closest('tr').find('td.idNombre').html();
    /*var idDescrip   = $(this).closest('tr').find('td.idDescrip').html();
    var idPrecio    = $(this).closest('tr').find('td.idPrecio').html();
    var idStock     = $(this).closest('tr').find('td.idStock').html();
    var idImagen    = $(this).closest('tr').find('td.idImagen').html();*/
    
    // and set them in the modal:
 
    $('#idCodigo'   , myModal).val(idCodigo);
    //$('#idArticulo' , myModal).val(idArticulo);
    $('#idMarca'    , myModal).val(idMarca);
    $('#idModelo'   , myModal).val(idModelo);
    $('#idNombre'   , myModal).val(idNombre);
    /*$('#idDescrip'  , myModal).val(idDescrip);
    $('#idPrecio'    , myModal).val(idPrecio);
    $('#idStock'    , myModal).val(idStock);
    $('#idImagen'   , myModal).val(idImagen);*/


    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

//  MODAL PARA EDITAR DESCRIPCION DE PRODUCTO
$('a.editProductDesc').on('click', function() {
    var myModal = $('#productEditDescrip_dialog');

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
$('a.delEditProductDesc').on('click', function() {
    var myModal = $('#delProductEditDescrip_dialog');

    // now get the values from the table
    var idArticulo  = $(this).closest('tr').find('td.idArticulo').html();
    var idDescrip   = $(this).closest('tr').find('td.idDescrip' ).html();
    var idPrecio    = $(this).closest('tr').find('td.idPrecio'  ).html();
    var idStock     = $(this).closest('tr').find('td.idStock'   ).html();
    var idImagen    = $(this).closest('tr').find('td.idImagen'  ).html();
    
    // and set them in the modal:
    $('#idArticulo' , myModal).val(idArticulo);
    $('#idDescrip'  , myModal).val(idDescrip );
    $('#idPrecio'   , myModal).val(idPrecio  );
    $('#idStock'    , myModal).val(idStock   );
    $('#idImagen'   , myModal).val(idImagen  );


    // and finally show the modal
    myModal.modal({ show: true });

    return false;
});

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
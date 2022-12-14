
$(function () {
  $("#v_subnavbar").load("v_subnavbar.jsp");
});

$(function () {
  $("#navbarPage").load("v_navbar.jsp");
});

$(function () {
  $("#footerPage").load("v_footer.jsp");
});

$(function () {
  $("#basicNavbarPage").load("v_basicNavbar.jsp");
});

$(function () {
  $("#basicFooterPage").load("v_basicFooter.jsp");
});


$(function () {
  $("#cardProduct1").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct2").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct3").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct4").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct5").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct6").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct7").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct8").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct9").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct10").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct11").load("v_cardProduct.jsp");
});
$(function () {
  $("#cardProduct12").load("v_cardProduct.jsp");
});






$(function () {
  $("#carouselProductos").load("v_carouselProductos.jsp");
});

$(function () {
  $("#carouselProductos2").load("v_carouselProductos.jsp");
});

$(function () {
  $("#carouselProductos3").load("v_carouselProductos.jsp");
});


$(function () {
  $("#cartProduct1").load("v_cartProduct.jsp");
});

$(function () {
  $("#cartProduct2").load("v_cartProduct.jsp");
});
$(function () {
  $("#cartProduct3").load("v_cartProduct.jsp");
});
$(function () {
  $("#cartProduct4").load("v_cartProduct.jsp");
});
$(function () {
  $("#cartProduct5").load("v_cartProduct.jsp");
});




$(function () {
  $("#cardPedido1").load("v_cardPedido.jsp");
});

$(function () {
  $("#cardPedido2").load("v_cardPedido.jsp");
});
$(function () {
  $("#cardPedido3").load("v_cardPedido.jsp");
});
$(function () {
  $("#cardPedido4").load("v_cardPedido.jsp");
});
$(function () {
  $("#cardPedido5").load("v_cardPedido.html");
});
































jQuery.validator.addMethod("lettersonly", function(value, element) {
  return this.optional(element) || /^[ñÑa-zA-ZÀ-ÿ\s]+$/i.test(value);
}, "Letters only please");

jQuery.validator.addMethod("complexpassword", function(value, element) {
  return this.optional(element) || /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(value);
}, "Bad password format");

jQuery.validator.addMethod("numbersonly", function(value, element) {
  return this.optional(element) || /^[0-9]{1,20}$/i.test(value);
}, "Numbers only please");


jQuery.validator.addMethod("phoneFormat", function(value, element) {
 return this.optional(element) || /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/i.test(value);
}, "Bad phone format");




jQuery.validator.addMethod("lessThan", function(value, element) {
 let currentTime = new Date(); 
 let valueDate = new Date(value + " 00:00:00");
//  let valueDay = valueDate.getUTCDate();
//  let valueMonth = valueDate.getUTCMonth();
//  let valueYear = valueDate.getUTCFullYear();
//  let valueDateUTC = new Date(valueYear, valueMonth, valueDay);
//  console.log(currentTime);
//  console.log(value);
//  console.log(valueDate);
//  console.log(valueDate.getTime());
//  console.log(currentTime.getTime());
//  console.log(valueDateUTC);
 return this.optional(element) || valueDate.getTime() < currentTime.getTime();
}, "Date is greater than today");


jQuery.validator.methods.email = function( value, element ) {
  return this.optional(element) || /^([a-zA-Z0-9_]+(?:[.-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:[.-]?[a-zA-Z0-9]+)*\.[a-zA-Z]{2,7})$/.test(value);
}

 /* Validations */

 $(document).ready(function(){
      let usuarioIncorrecto = $("#usuarioIncorrecto").val();
      if(usuarioIncorrecto == "true"){
        $("#pass_form").after("<label class='login-error'> *Su usuario y/o contraseña son incorrectos.</label>");
      }

      let emailEncontrado = $("#emailEncontrado").val();
      if(emailEncontrado == "true"){
        $("#email").after("<label class='signup-error'>*El nombre de usuario ingresado ya esta en uso</label>");
      }

    /* ------------------- Login ------------------ 
    Este se puede encapsular en una funcion, checar */
    $("#button_main-container").click(function() {
        $("#form_main-container").validate({
          errorClass: "login-error",
          rules: {
            email: {
              required: true,
              email: true
            },
            password:{
              required: true,
            }

          },
          messages: {
            email:{
              required: "*Ingrese un correo",
              email: "*Ingrese un formato correcto"
            },
            password:{
              required: "*Ingrese su contrasena"
            }
          }
        });
    });

     /* ------------- Sign up ---------------------- 
    Este se puede encapsular en una funcion, checar */
    $("#button-signup_main-container").click(function(){
      $("#form_main-container").validate({ 
        ignore: ".ignore",
        errorClass: "signup-error",
        rules: {
          nombre: {
            required: true,
            lettersonly: true
          },
          apellidoP: {
            required: true,
            lettersonly: true
          },
          apellidoM: {
          required: false,
            lettersonly: true
          },
          email: {
            required: true,
            email: true
          },
          password: {
            required:  true,
            complexpassword: false
          },
          passconfirm: {
            required:  true,
            equalTo: "#password"
          }
        },
        messages: {
          nombre: {
            required: "*Ingrese sus nombre(s).",
            lettersonly: "Solo se permiten usar caracteres."
          },
          apellidoP: {
            required: "*Ingrese su apellido Paterno.",
            lettersonly: "Solo se permiten usar caracteres."
          },
          apellidoM: {
            lettersonly: "Solo se permiten usar caracteres."
          },
          email: {
            required: "*Ingrese un correo electronico",
            email: "*Ingrese un formato correcto"
          },
          password: {
            required: "*Ingrese una contraseña",
            complexpassword: "La contraseña debe llevar por lo menos 8 caracteres, una letra mayúscula, una minúscula, un número y un signo de puntuacion."
          },
          passconfirm: {
            required: "*Confirme su contraseña",
            equalTo: "Su contraseña debe coincidir"
          }
        },

        errorPlacement:  function(error, element) {
          error.insertAfter(element);
        }

       });
    });

    /* ----------------- Edit ------------------------ 
    Este se puede encapsular en una funcion, checar */
    $("#button-edit_main-container").click(function(){
      $("#form_main-container").validate({ 
        ignore: ".ignore",
        errorClass: "edit-error",
        rules: {
          nombre: {
            required: true,
            lettersonly: true
          },
          apellidoP: {
            required: true,
            lettersonly: true
          },
          apellidoM: {
          required: false,
            lettersonly: true
          },
          password: {
            required:  true,
            complexpassword: false
          },
          passconfirm: {
            required:  true,
            equalTo: "#password"
          }
        },
        messages: {
          nombre: {
            required: "*Ingrese sus nombre(s).",
            lettersonly: "Solo se permiten usar caracteres."
          },
          apellidoP: {
            required: "*Ingrese su apellido Paterno.",
            lettersonly: "Solo se permiten usar caracteres."
          },
          apellidoM: {
            lettersonly: "Solo se permiten usar caracteres."
          },
          password: {
            required: "*Ingrese una contraseña",
            complexpassword: "La contraseña debe llevar por lo menos 8 caracteres, una letra mayúscula, una minúscula, un número y un signo de puntuacion."
          },
          passconfirm: {
            required: "*Confirme su contraseña",
            equalTo: "Su contraseña debe coincidir"
          }

        }

       });
    });
    



	/* ----------------- Pedido ------------------------ 
    Este se puede encapsular en una funcion, checar */
    $("#button-pedido_main-container").click(function(){
      $("#form_main-container").validate({ 
        ignore: ".ignore",
        errorClass: "edit-error",
        rules: {
          Calle: {
            required: true
          },
          N_Int: {
            required: true,
            numbersonly: true
          },
          N_Ext: {
          required: false,
          numbersonly: true
          },
          Colonia: {
            required: true
          },
          Estado: {
            required:  true
          },
          Municipio: {
            required:  true
          },
          Telefono: {
            required:  true,
            phoneFormat: true
          },
          CP: {
            required:  true,
            numbersonly: true            
          },
          Banco: {
            required:  true          
          },
          NumCuenta: {
            required:  true,
            numbersonly: true            
          }
        },
        messages: {
          Calle: {
            required: "*Ingrese su calle."
          },
          N_Int: {
          	required: "*Ingrese su numero interior.",
            numbersonly: "*Ingrese solamente numeros, max 15 digitos"
          },
          N_Ext: {
            numbersonly: "*Ingrese solamente numeros, max 15 digitos"
          },
          Colonia: {
            required: "*Ingrese una colonia"
          },
          Estado: {
            required: "*Ingrese un estado"
          },
          Municipio: {
             required: "*Ingrese un municipio"
          },
          Telefono: {
            required:  "*Ingrese su numero de teléfono.",
            phoneFormat: "*Ingrese correctamente el formato del telefono."
          },
          CP: {
            required:  "*Ingrese su código postal.",
            numbersonly: "*Ingrese solamente numeros, max 15 digitos"
          },
          Banco: {
            required: "*Ingrese un banco"
          },
          NumCuenta: {
	          required:  "*Ingrese un numero de cuenta",
            numbersonly: "*Ingrese solamente numeros, max 15 digitos"   
          }          

        }

       });
    });



	

  


 });





















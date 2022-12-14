/**
 * 
 */


$(function() {

	$('.cart-producto-eliminar-boton').click(function(e) {
		e.preventDefault();
		var elemento = $(this);
		var IdProducto = elemento.parent().find("#IdProducto").val();



		$.ajax({
			url: 'CarritoProductos',
			type: 'post',
			data: {
				opcion: 'eliminarProductoCarrito',
				IdProducto: IdProducto
			},
			success: function(r) {

				elemento.parent().parent().parent().parent().toggle( "blind" , "fast", function() {
					$(this).remove();
				});
				
//				elemento.parent().parent().parent().parent().fadeOut(400, function() {
//					$(this).remove();
//				});
				
				
				
				elemento.off('click');
				elemento.attr("disabled","disabled");
				//alert(r);

				var result = r.split(',');
				var totalPedido = result[0];
				var cantidadPiezasTotales = result[1];

				$('#totalPedidoPhone').text('$' + totalPedido);
				$('#totalPedidoPC').text('$' + totalPedido);
				$('#cantidadPiezasTotalesPhone').text('(' + cantidadPiezasTotales + ' artículos)');
				$('#cantidadPiezasTotalesPC').text('(' + cantidadPiezasTotales + ' artículos)');

				var carritoProductosSpan = $('#navbar-carrito-cantidad-productos');
				var carritoCantidadProductos = +carritoProductosSpan.text() - 1;
				
				carritoProductosSpan.text(carritoCantidadProductos);
				
				if (carritoCantidadProductos == 0){
					var carritoVacioContenedor = $('#carritoVacioContenedor');
					var carritoProductosContenedor = $('#carritoProductosContenedor');
										
					carritoVacioContenedor.fadeIn(300);
					carritoProductosContenedor.fadeOut(300);
					
					carritoVacioContenedor.removeClass("d-none");
					carritoProductosContenedor.addClass("d-none")
					
					var barraTituloPedido = $("#cart-barra-titulo-pedido");
					barraTituloPedido.removeAttr("href");
					barraTituloPedido.removeAttr("href");
					
				}

			}
		});



	});

	


	$('.cart-producto-cantidad-input-botones').click(function(e) {
		e.preventDefault();
		var elemento = $(this);
		var input = elemento.parent().find("#CantidadPiezas");
		var IdProducto = elemento.parent().find("#IdProducto").val();
		//var boton = elemento.text();

		$.ajax({
			url: 'CarritoProductos',
			type: 'post',
			data: {
				opcion: 'conseguirCantidadStock',
				IdProducto: IdProducto
			},
			success: function(r) {

				var cantidadPiezasStock = r;
				var CantidadPiezas = input.val();

				var tipo = elemento.attr("tipo");


				//				

				if (tipo == "sumar" && +input.val() < +cantidadPiezasStock)
					CantidadPiezas = +input.val() + 1;

				// 			
				else if (tipo == "restar" && +input.val() > +1)
					CantidadPiezas = +input.val() - 1;

				elemento.parent().find("#CantidadPiezas").val(CantidadPiezas);

				$('.cart-producto-cantidad-input').trigger('change');
			}
		});
	});



	$('.cart-producto-cantidad-input').change(function(e) {
		e.preventDefault();


		var elemento = $(this);
		var IdProducto = elemento.parent().find("#IdProducto").val();
		var CantidadPiezas = elemento.val();


		$.ajax({
			url: 'CarritoProductos',
			type: 'post',
			data: {
				opcion: 'cambiarCantidadProductos',
				IdProducto: IdProducto,
				CantidadPiezas: CantidadPiezas
			},
			success: function(r) {


				var result = r.split(',');
				var CantidadPiezasFinal = result[0];
				var precioFinalPorPiezas = result[1];
				var totalPedido = result[2];
				var cantidadPiezasTotales = result[3];

				elemento.val(CantidadPiezasFinal);

				$('#totalPorPiezasProducto' + IdProducto).text('$' + precioFinalPorPiezas);
				$('#totalPedidoPhone').text('$' + totalPedido);
				$('#totalPedidoPC').text('$' + totalPedido);
				$('#cantidadPiezasTotalesPhone').text('(' + cantidadPiezasTotales + ' artículos)');
				$('#cantidadPiezasTotalesPC').text('(' + cantidadPiezasTotales + ' artículos)');

			}
		});

	});











	$('#producto-boton-agregar-carrito').click(function(e) {
		e.preventDefault();
		var elemento = $(this);
		var IdProducto = elemento.parent().find("#IdProducto").val();
		var cantidadPiezas = elemento.parent().find("#CantidadPiezasProducto").val();


		$.ajax({
			url: 'DetallesProducto',
			type: 'post',
			data: {
				opcion: "ingresarProducto",
				IdProducto: IdProducto,
				cantidadPiezas: cantidadPiezas
			},
			success: function(r) {
				
				var productoAgregado = $("#producto-agregado");
				
				productoAgregado.fadeOut(300, function() {
					$(this).remove();
				});
			
				//Mostrar pantalla modal de "fue agregado correctamente"
				//Sumar al contador del carrito de compras

				var productoRepetido = r;


				if (productoRepetido == 'false') {
					var carritoProductosSpan = $('#navbar-carrito-cantidad-productos');
					var carritoCantidadProductos = +carritoProductosSpan.text() + 1;

					carritoProductosSpan.text(carritoCantidadProductos);
				}


				var nombreProducto = $("#producto-titulo-id").text();
				var precioProducto = $("#producto-precio-final").attr("value");
				var totalPorPiezas = (+cantidadPiezas * precioProducto).toFixed(2);

				var htmlProducto = 
				'<div id="producto-agregado" class="row gx-0">'+
'                <div class="col-12 col-sm-6 col-md-5 col-lg-4 col-xl-3 producto-agregado-contenedor"  style="z-index: 10000005">'+
''+
''+
'                    <a href="CarritoProductos">'+
'                    	<div class="row gx-0 producto-agregado-header py-2 px-2">'+
'                       	 <div class="col-11">'+
'                                <h2 class="producto-agregado-header-titulo">Producto agregado <i'+
'                                        class="fas fa-shopping-cart my-auto"></i></h2>'+
'	                        </div>'+
'   	                 </div>'+
'                    </a>'+
''+
''+
'                    <a href="CarritoProductos">'+
''+
'                        <div class="d-none d-md-inline">'+
'                            <div class="row gx-0 py-2">'+
'                                <div class="col-3 px-1 d-none d-md-inline col-xxl-2" align="center">'+
'                            		<img src="GeneralServlet?Imagen=Producto&Id=' + IdProducto + ' " style="width: 70px" alt="...">' +
'                                </div>'+
'                                <div class="col-10 col-md-6 ps-2 ps-md-0 ps-xxl-2 col-xxl-7">'+
'  			                          	<h1 class="producto-agregado-titulo" >' +
								nombreProducto +
'                            			</h1>   ' +
'                                </div>'+
'                                <div class="col-2 col-md-3 pe-2 pt-2 pt-md-4" align="end">'+
'                           		 <h5 class="producto-agregado-precio">$' + precioProducto + '</h5>' +
'                                </div>'+
''+
'                            </div>'+
''+
'                        </div>'+
''+
'                        <div class="d-inline d-md-none">'+
'                            <div class="row gx-0 py-2">'+
''+
'                                <div class="col-10 col-md-6 ps-2">'+
'                                    <h1 class="producto-agregado-titulo">'+
'                                        Haz click para ir al carrito'+
'                                    </h1>'+
'                                </div>'+
''+
'                            </div>'+
'                        </div>'+
''+
'                        <div class="row gx-0 justify-content-around pb-3 d-none d-md-flex">'+
'                            <div class="col-3 ps-2  " align="begin">'+
'                                <h5 class="producto-agregado-cantidad-texto  d-inline">Cant:</h5>'+
'                           	 <h5 class="producto-agregado-cantidad-numero d-inline">' + cantidadPiezas + '</h5>' +
'                            </div>'+
'                            <div class="col-8 pe-2" align="end">'+
'                                <p class="producto-agregado-precio-articulos-texto   d-inline">Total p/piezas:</p>'+
'                            	 <p class="producto-agregado-precio-articulos-cantidad  d-inline">' + totalPorPiezas + '</p>' +
'                            </div>'+
'                        </div>'+
'                    </a>'+
'                </div>'+
'            </div>';
	

				var productoAgregadoContenedor = $("#producto-agregado-view");


//				productoAgregadoContenedor.append(html);
				//$(htmlProducto).hide().appendTo("#producto-agregado-view").fadeIn(200);
				
				//	$("#producto-agregado-view").css('position', 'relative'); 
				
				$(htmlProducto).hide().appendTo("#producto-agregado-view").fadeIn(200).delay(5000).fadeOut(300);
				
				// var html =
				// 	'            <div id = "contenedor-oscuro" class = "contenedor-oscuro">' +
				// 	'            </div>';
					
				// $(html).hide().appendTo("#producto-agregado-view").fadeIn(600);
				
				setTimeout(function(){
  					$('#producto-agregado').remove();
				}, 7000);
			}
		})



	});


	$('.producto-cantidad-input-botones').click(function(e) {
		e.preventDefault();

		var elemento = $(this);
		var input = elemento.parent().find("#CantidadPiezasProducto");
		var IdProducto = elemento.parent().find("#IdProducto").val();
		//var boton = elemento.text();

		$.ajax({
			url: 'CarritoProductos',
			type: 'post',
			data: {
				opcion: 'conseguirCantidadStock',
				IdProducto: IdProducto
			},
			success: function(r) {

				var cantidadPiezasStock = r;
				var CantidadPiezas = input.val();

				var tipo = elemento.attr("tipo");


				if (tipo == "sumar" && +input.val() < +cantidadPiezasStock)
					CantidadPiezas = +input.val() + 1;

				// 			
				else if (tipo == "restar" && +input.val() > +1)
					CantidadPiezas = +input.val() - 1;

				elemento.parent().find("#CantidadPiezasProducto").val(CantidadPiezas);

				$('#CantidadPiezasProducto').trigger('change');
			}
		});
	});


	$('#CantidadPiezasProducto').change(function(e) {
		e.preventDefault();


		var elemento = $(this);
		var IdProducto = elemento.parent().find("#IdProducto").val();
		var CantidadPiezas = elemento.val();


		$.ajax({
			url: 'DetallesProducto',
			type: 'post',
			data: {
				opcion: 'cambiarCantidadProductos',
				IdProducto: IdProducto,
				CantidadPiezas: CantidadPiezas
			},
			success: function(r) {

				var CantidadPiezasFinal = r;

				elemento.val(CantidadPiezasFinal);
			}
		});

	});


	$('#producto-agregado-view').on('click', '#producto-agregado-boton-cerrar', function() {
		var productoAgregado = $("#producto-agregado");

		productoAgregado.fadeOut(300, function() {
			$(this).remove();
		});
		
		$('#navbar-carrito-icono').animate({color: '#0fe79f'}, 'normal');
		$('#navbar-carrito-icono').animate({color: '#f5f5f5'}, 'fast');

	});



});
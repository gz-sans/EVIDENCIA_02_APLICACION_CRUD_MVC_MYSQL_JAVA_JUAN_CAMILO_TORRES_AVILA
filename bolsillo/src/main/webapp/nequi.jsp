<!DOCTYPE html>
<html>
<head>
	<title>Nequi - Bolsillo Digital</title>
	<link rel="stylesheet" href="css/style.css">
	<style>
		/* Animación para la barra lateral */
		@keyframes slideIn {
			from {
				transform: translateX(-100%);
			}
			to {
				transform: translateX(0);
			}
		}
		@keyframes slideOut {
			from {
				transform: translateX(0);
			}
			to {
				transform: translateX(-100%);
			}
		}
		.sidebar {
			animation: slideIn 0.5s ease-in-out forwards;
		}
		.sidebar.hide {
			animation: slideOut 0.5s ease-in-out forwards;
		}
	</style>
</head>
<body>
	<style>
		body {
			background-image: url('img/fondo17.jpg');
		}
	</style>
	
	<div class="container">
		<!-- Barra lateral -->
		<div class="sidebar">
			<h1 style="color: #FFF;">Nequi</h1>
			<ul>
				<li><a href="redireccion?boton=nequi" style="color: #FFF;">Inicio</a></li>
				<li><a href="consultar?accion=consultart" style="color: #FFF;">Consultar Saldo</a></li>
				<li><a href="index.jsp" style="color: #FFF;">Salir</a></li>
			</ul>			
		</div>
		<!-- Contenido principal -->
		<div class="main-content" style="background-color: transparent; color: #FFF;">
			<h2>Como funciona Nequi?</h2>
			<p>Nequi es tu bolsillo digital donde puedes guardar, enviar y recibir dinero desde tu celular. Es facil, seguro y sin costo.</p>
			<p>Para empezar, descarga la aplicacion Nequi en tu celular y crea una cuenta. Luego, puedes empezar a cargar dinero en tu cuenta Nequi desde tu cuenta bancaria o con efectivo en tiendas autorizadas. Una vez tengas dinero en tu cuenta Nequi, puedes usarlo para hacer pagos, enviar dinero a otras personas o sacar efectivo en cajeros automaticos.</p>
			<h2>Como sacar dinero?</h2>
			<p>Para sacar dinero de tu cuenta Nequi, sigue estos pasos:</p>
			<ol>
				<li>Abre la aplicacion Nequi en tu celular y selecciona la opcion "Sacar dinero".</li>
				<li>Ingresa el monto que deseas sacar y elige el cajero automatico mas cercano.</li>
				<li>Confirma la transaccion y espera a recibir un codigo de retiro en tu celular.</li>
				<li>Ve al cajero automatico elegido y sigue las instrucciones en la pantalla para retirar el dinero con tu codigo de retiro.</li>
			</ol>
		</div>
	</div>
	<!-- Script para mostrar/ocultar la barra lateral -->
	<script>
		const sidebar = document.querySelector('.sidebar');
		const menuBtn = document.querySelector('#menu-btn');

		menuBtn.addEventListener('click', () => {
			sidebar.classList.toggle('hide');
		});
	</script>
</body>
</html>

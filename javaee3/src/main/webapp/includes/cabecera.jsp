 <base href="${pageContext.request.contextPath}/" target="_blank">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="#">Videos</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Inicio
						<span class="sr-only">(current)</span>
				</a></li>
				<!-- <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li> -->
			</ul>
			<form class="form-inline mt-2 mt-md-0" action="logout" method="POST">
				<!-- <input class="form-control mr-sm-2" type="text" placeholder="Buscar"
					aria-label="Buscar"> -->
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerrar Sesi�n</button>
			</form>
		</div>
	</nav>
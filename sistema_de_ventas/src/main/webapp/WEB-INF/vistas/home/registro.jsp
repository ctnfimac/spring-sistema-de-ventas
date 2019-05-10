<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content pb-3">
      <div class="modal-header">
        <h5 class="modal-title pl-4 text-primary" id="exampleModalLabel">Registro de Usuario</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body pb-3">
        <form action="registrar-usuario" class="text-center px-5" method="POST" modelAttribute="">
			<input path="email" class="form-control mb-4" id="email" type="email" placeholder="E-mail"/>
			<input path="nombre" class="form-control mb-4" id="nombre" type="text" placeholder="nombre"/>
			<div class="row">
			    <div class="col">
					<input path="direccionCalle"  class="form-control mb-4" type="text" id="direccionCalle" placeholder="Calle"/>
			    </div>
			    <div class="col">
					<input path="direccionAltura"  class="form-control mb-4" type="text" id="direccionAltura" placeholder="Altura"/>     		      		  
			    </div>
			 </div>
			  <select path="localidad" id="localidad" class="browser-default custom-select mb-4">
            	<form:option value="0">Elija Localidad</form:option>
            		<option value="1">liniers</option>
            		<option value="2">San justo</option>
			  </select>
			<div class="row">
			    <div class="col">
					<input path="password"  class="form-control mb-4" type="password" id="password" placeholder="Contraseña"/>
			    </div>
			    <div class="col">
					<input path="password2"  class="form-control mb-4" type="password" id="password2" placeholder="Repetir Contraseña"/>     		      		  
			    </div>
			 </div>
			<button class="btn btn-lg btn-success btn-block" Type="Submit"/>Registrar</button>
		</form>
      </div>
    </div>
  </div>
</div>
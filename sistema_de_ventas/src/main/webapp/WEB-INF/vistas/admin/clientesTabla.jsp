 <h2 class="text-center mt-5 mb-3">Tabla de Clientes Registrados</h2>
  	<div class="col-md-12 mb-4">
       <div class="card">
         <div class="card-body">
         <div class="table-responsive">
           <table class="table table-hover "  width="100%">
             <thead class="blue lighten-4">
               <tr>
                 <th>Id</th>
                 <th>Nombre</th>
                 <th>Email</th>
                 <th>Password</th>               
                 <th>Dirección</th>
                 <th>Localidad</th>
                 <th>Estado</th>
               </tr>
             </thead>
             <tbody>
             	<c:forEach var="cliente" items="${clientes}">
            		  <tr>
	                 <th scope="row">${cliente.getId()}</th>
	                 <td>${cliente.getNombre()}</td>
	                 <td>${cliente.getEmail()}</td>
	                 <td>${cliente.getPassword()}</td>
	                  <td>${cliente.getDireccionCalle()}, ${cliente.getDireccionAltura()}</td>
	                 <td>${cliente.getLocalidad().getNombre()}</td>
	                 <td>${cliente.getEstado()}</td>
	               </tr>
             	</c:forEach>
             </tbody>
           </table>
          </div>
        </div>
      </div>
    </div>
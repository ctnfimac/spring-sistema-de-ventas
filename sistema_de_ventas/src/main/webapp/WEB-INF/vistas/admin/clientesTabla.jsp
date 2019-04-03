 <h2 class="text-center mt-5 mb-3">Tabla de Clientes Registrados</h2>
  	<div class="col-md-12 mb-4">
       <div class="card">
         <div class="card-body">
         <div class="table-responsive">
           <table class="table text-center w-100">
             <thead class="blue lighten-4">
               <tr>
                 <th>Id</th>
                 <th>Nombre</th>
                 <th>Email</th>
                 <th>Password</th>               
                 <th>Dirección</th>
                 <th>Localidad</th>
                 <th>Estado</th>
                 <th>Operacion<th>
               </tr>
             </thead>
             <tbody>
             	<c:forEach var="cliente" items="${clientes}">
            		 <tr>
		                 <th scope="row class="align-middle"">${cliente.getId()}</th>
		                 <td class="align-middle">${cliente.getNombre()}</td>
		                 <td class="align-middle">${cliente.getEmail()}</td>
		                 <td class="align-middle">${cliente.getPassword()}</td>
		                 <td class="align-middle">${cliente.getDireccionCalle()}, ${cliente.getDireccionAltura()}</td>
		                 <td class="align-middle">${cliente.getLocalidad().getNombre()}</td>
		                 <td class="align-middle" id="clienteEstado${cliente.getId()}">${cliente.getEstado()}</td>
		                 <td class="align-middle m-0">
		                 	<div class="btn-group" role="group">
      							<button type="button" value="${cliente.getId()}" class="btn btn-success btn-sm eventEstado">Cambiar Estado</button>	                 		
		                 	</div>
		                 </td>
	               </tr>
             	</c:forEach>
             </tbody>
           </table>
          </div>
        </div>
      </div>
    </div>
    

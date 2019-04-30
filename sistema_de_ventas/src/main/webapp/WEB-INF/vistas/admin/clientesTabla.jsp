 <h2 class="text-center mt-5 mb-3">Clientes Registrados</h2>
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
            		 <tr id="cliente${cliente.getId()}">
		                 <th scope="row" class="align-middle">${cliente.getId()}</th>
		                 <td class="align-middle">${cliente.getNombre()}</td>
		                 <td class="align-middle">${cliente.getEmail()}</td>
		                 <td class="align-middle">${cliente.getPassword()}</td>
		                 <td class="align-middle">${cliente.getDireccionCalle()}, ${cliente.getDireccionAltura()}</td>
		                 <td class="align-middle">${cliente.getLocalidad().getNombre()}</td>
		                 <td class="align-middle" id="clienteEstado${cliente.getId()}">${cliente.getEstado()}</td>
		                 <td class="align-middle m-0">
		                 	<div class="btn-group" role="group">
		                 	<c:if test= "${ cliente.getEstado() == 'disabled'}">
                 	      			<button type="button" value="${cliente.getId()}" class="btn-habilitacion btn btn-success btn-sm eventEstado">Enable</button>
		                 	</c:if>
		                 	<c:if test= "${ cliente.getEstado() == 'enabled'}">
                 	      			<button type="button" value="${cliente.getId()}" class="btn-habilitacion btn btn-warning btn-sm eventEstado">Disable</button>
		                 	</c:if>
      							<button type="button" value="${cliente.getId()}" class="btn btn-danger rounded px-3 mb-0 btn-sm eventStateDelete btn-el fas fa-trash-alt ml-1">	                 		
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
    

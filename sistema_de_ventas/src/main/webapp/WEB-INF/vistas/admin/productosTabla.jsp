
<h2 class="text-center mt-5 mb-3">Tabla de Productos</h2> 
  	<div class="col-md-12 mb-4 mt-4">
       <div class="card">
       <div class="card-header align-middle h-25">
		<button class="btn btn-success float-right" data-toggle="modal" data-target="#modalAgregar">agregar nuevo</button>
		</div>
         <div class="card-body">
         <div class="table-responsive">
           <table class="table text-center w-100">
             <thead class="blue lighten-4">
               <tr>
               	 <th>imágen</th> 
                 <th>Id</th>
                 <th>Code</th>
                 <th>Nombre</th>
                 <th>Descripción</th>           
                 <th>Cantidad</th>
                 <th>Precio</th>
                 <th>Categoria</th>
                 <th>Operacion<th>
               </tr>
             </thead>
             <tbody id="resultadoDeMostrarProductos">
             </tbody>
           </table>
          </div>
        </div>
      </div>
    </div>
   
   
   <nav aria-label='Page navigation example'>
	  <ul class='pagination pagination-circle pg-blue justify-content-center'>
		<li class='page-item disabled' id="previous-item"><a class='page-link' tabindex='-1' id="previous">Previous</a></li>
   			<div class="pagination" id="paginacionProductos"></div>
   		<li class='page-item' id="next-item"> <a class='page-link' id="next">Next</a></li>
	  </ul>
   </nav>
   


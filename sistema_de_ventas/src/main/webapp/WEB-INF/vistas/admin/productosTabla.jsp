
<h2 class="text-center mt-5 mb-3">Tabla de Productos</h2> 
  	<div class="col-md-12 mb-4 mt-4">
       <div class="card">
       <div class="card-header align-middle h-25">
		<button class="btn btn-success float-right">agregar nuevo</button>
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
             <tbody>
				<c:forEach var="producto" items="${productos}">
				 <td class="align-middle justify-content-center"><img src="${producto.getUrlimg()}" width=125></td>
            	 <td class="align-middle">${producto.getId()}</td>
                 <th scope="row" class="align-middle">${producto.getCode()}</th>
                 <td class="align-middle">${producto.getNombre()}</td>
                 <td class="align-middle">${producto.getDescripcion()}</td>
                 <td class="align-middle">${producto.getCantidad()}</td>
                 <td class="align-middle">$${producto.getPrecio()}</td>
                 <td class="align-middle">${producto.getCategoria().getNombre()}</td>
                 <td class="align-middle m-0">
                 	<div class="btn-group" role="group">
                 		<button type="button" value="${producto.getId()}" class="btn btn-danger btn-sm eventStateDelete"><i class="fas fa-trash-alt"></i></button>		                 		
						<button type="button" value="${producto.getId()}" class="btn btn-warning btn-sm eventEstado"><i class="fas fa-pencil-alt"></i></button>
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
    
<!--     private Long id; -->
	
<!-- 	@Column(unique=true) -->
<!-- 	private String code; -->
	
<!-- 	private String nombre; -->
<!-- 	private String descripcion; -->
<!-- 	private String urlimg; -->
<!-- 	private Integer cantidad; -->
<!-- 	private Double precio; -->
	
<!-- 	@ManyToOne (cascade = { CascadeType.ALL }) -->
<!-- 	private Categoria categoria; -->
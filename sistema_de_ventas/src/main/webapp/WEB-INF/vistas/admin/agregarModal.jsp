<div class="modal fade" id="modalAgregar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header text-center">
	        <h4 class="modal-title w-100 font-weight-bold">Agregar nuevo Producto</h4>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form method="POST" id="formAdd" enctype="multipart/form-data">
		      <div class="modal-body mx-3">
		     	 <div class="input-group">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
				  </div>
				  <div class="custom-file">
				    <input type="file" class="custom-file-input" name="imagen" id="imagen">
				    <label class="custom-file-label" for="imagen">Choose file</label>
				  </div>
				</div>
		        <div class="md-form mb-5">
		          <input type="text" id="nombre" name="nombre" class="form-control validate">
		          <label for="nombre">Nombre</label>
		        </div>
				 <div class="row">
				    <div class="col">
				      <div class="md-form mt-0">
				        <input type="text" name="code" id="code" class="form-control" placeholder="Code">
				      </div>
				    </div>
				    <div class="col">
				      <div class="md-form mt-0">
				        <input type="number" name="cantidad" id="cantidad" class="form-control" placeholder="Cantidad">
				      </div>
				    </div>
				    <div class="col">
				      <div class="md-form mt-0">
				        <input type="number" name="precio" id="precio" class="form-control" placeholder="Precio">
				      </div>
				    </div>
			    </div>
			    <select name="categoria" id="categoria" class="browser-default custom-select mb-4">
            		<option value="0">Categoria</option>
	            	<c:forEach items="${categorias}" var="categoria">
	            		<option value="${categoria.id}">${categoria.nombre} </option>
	           		</c:forEach>
				</select>
		       <div class="md-form">
				  <textarea id="descripcion" name="descripcion" class="md-textarea form-control" rows="3"></textarea>
				  <label for="descripcion">Descripción</label>
			   </div> 

		      </div>
		      <div class="modal-footer d-flex justify-content-center">
		      	<button class="btn btn-default" class="close" data-dismiss="modal">Cancelar</button>
		        <button type="button" class="btn btn-default" id="btnAddProducto">Agregar</button>
		      </div>
	      </form>
	    </div>
	  </div>
	</div>

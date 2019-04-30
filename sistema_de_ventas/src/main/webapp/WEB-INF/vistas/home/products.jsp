<section class="productos my-5">
	<h2 class="text-center mb-3">Products</h2>
	<div class="container">
		<div class="row d-flex justify-content-center">
			<!-- Grid column -->
			<c:forEach var = "producto" items="${productos}">
			    <div class="col-lg-3 col-md-6 mb-md-4 mb-4"">
			      <div class="card card-cascade narrower card-ecommerce">
			        <div class="view view-cascade overlay">
			          <img src="${producto.urlimg}" class="card-img-top"
			            alt="sample photo" height="150">
			          <a>
			            <div class="mask rgba-white-slight"></div>
			          </a>
			        </div>
			        <div class="card-body card-body-cascade text-center">
<!-- 			          <a href="" class="grey-text"> -->
<%-- 			            <h6>${producto.code }</h6> --%>
<!-- 			          </a> -->
			          <h6 class="card-title">    
			              <a class="text-default">${producto.nombre}</a>			
			          </h6>
<!-- 			          <div class="d-flex justify-content-center"> -->
<!-- 			              <i class="fas fa-star yellow-text"></i> -->
<!-- 			              <i class="fas fa-star yellow-text"></i> -->
<!-- 			              <i class="fas fa-star yellow-text"></i> -->
<!-- 			              <i class="fas fa-star yellow-text"></i> -->
<!-- 			              <i class="fas fa-star-half-alt yellow-text"></i> -->
<!-- 			          </div> -->
<!-- 			          <p class="card-text"> -->
<%-- 			          	${producto.descripcion} --%>
<!-- 			          </p> -->
			          <div class=" px-1">
			            <span class="float-left">
			              <strong>$${producto.precio}</strong>
			            </span>
<!-- 			            <span class="float-right"> -->
<!-- 			              <a data-toggle="tooltip" data-placement="top" title="Add to Cart"> -->
<!-- 			                <i class="fas fa-shopping-cart grey-text ml-3"></i> -->
<!-- 			              </a> -->
<!-- 			              <a data-toggle="tooltip" data-placement="top" title="Share"> -->
<!-- 			                <i class="fas fa-share-alt grey-text ml-3"></i> -->
<!-- 			              </a> -->
<!-- 			              <a class="" data-toggle="tooltip" data-placement="top" title="Add to Wishlist"> -->
<!-- 			                <i class="fas fa-heart grey-text ml-3"></i> -->
<!-- 			              </a> -->
<!-- 			            </span> -->
			          </div>
			        </div>
			      </div>
			    </div>
		    </c:forEach>
		</div>
	</div>
</section>
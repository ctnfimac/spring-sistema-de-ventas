  <header>
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark teal darken-3 text-white scrolling-navbar">
      <div class="container-fluid">
        <button class="navbar-toggler float-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link waves-effect" href="admin">Clientes
                <span class="sr-only">(current)</span>
              </a>
            </li>
             <li class="nav-item active">
              <a class="nav-link waves-effect" href="productos">Productos
                <span class="sr-only">(current)</span>
              </a>
            </li>
          </ul>
<!--           <ul class="navbar-nav nav-flex-icons"> -->
<!--             <li class="nav-item"> -->
<!--               <a href="https://www.facebook.com/mdbootstrap" class="nav-link waves-effect" target="_blank"> -->
<!--                 <i class="fab fa-facebook-f"></i> -->
<!--               </a> -->
<!--             </li> -->
<!--           </ul> -->
		<ul class="navbar-nav mr-aut">
			<li class="nav-item dropdown text-white">
		        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
		          aria-haspopup="true" aria-expanded="false">
		          <i class="fas fa-user"></i> Profile </a>
		        <div class="dropdown-menu dropdown-menu-right navbar-dark teal darken-3 dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
<!-- 		          <a class="dropdown-item" href="#">My account</a> -->
		          <a class="dropdown-item text-white navbar-dark teal darken-3" href="adminSalir">Log out</a>
		        </div>
     		</li>
     		</ul>
        </div>
      </div>
    </nav>
    <div class="sidebar-fixed position-fixed teal darken-3">
      <a class="logo-wrapper waves-effect">
        <img src="https://content.arduino.cc/brand/arduino-white.svg" class="img-fluid" alt="">
      </a>
      <div class="list-group list-group-flush ">
<!--         <a href="admin" class="list-group-item waves-effect active"> -->
<!--           <i class="fas fa-chart-pie mr-3"></i>Administración -->
<!--         </a> -->
        <a href="admin" class="list-group-item list-group-item-action waves-effect teal darken-3 text-white">
          <i class="fas fa-table mr-3"></i>Clientes
         </a>
         <a href="productos" class="list-group-item list-group-item-action waves-effect teal darken-3 text-white">
          <i class="fas fa-table mr-3"></i>Productos
         </a>
      </div>
    </div>
  </header>
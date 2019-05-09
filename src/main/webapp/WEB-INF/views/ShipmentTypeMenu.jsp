<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />


<!-- code starts from here -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">
  WAREHOUSE
  	<img  src="../resources/images/logo.png" width="50" height="50">
  </a>

  <!-- Links -->
  <ul class="navbar-nav">
   
   
    <li class="nav-item">
      <a class="nav-link" href="#">Home</a>
    </li>
    
		
	<!-- Copy below code for another menu option -->
		
	  <!-- Uom Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>UOM</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/uom/register">Register</a>
        <a class="dropdown-item" href="${url}/uom/all">View All</a>
      </div>
    </li>
    <!-- Uom Type end -->
    
      <!-- Shipment Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>ORDER-METHOD</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/ordermethod/show">Register</a>
        <a class="dropdown-item" href="${url}/ordermethod/all">View All</a>
      </div>
    </li>	
		
    <!-- Shipment Type start -->
    <li class="nav-item dropdown dropdown-toggle">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>SHIPMENT-TYPE</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/shipment/register">Register</a>
        <a class="dropdown-item" href="${url}/shipment/all">View All</a>
        <a class="dropdown-item" href="${url}/shipment/charts">Reports</a>
       </div>
    </li>
    <!-- Shipment Type end -->
    
    <!-- copy upto this -->
    
     <!-- Shipment Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>WHUSER-TYPE</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/whUser/register">Register</a>
        <a class="dropdown-item" href="${url}/whUser/all">View All</a>
      </div>
    </li>
    
     <!-- Item Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>ITEM</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/itemspage/show">Show</a>
        <a class="dropdown-item" href="${url}/itemspage/all">View All</a>
      </div>
    </li>
    <!-- Item Type end -->
    
     <!-- Item Type start -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
        <b>PURCHASE ORDER</b>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${url}/purchase/show">Show</a>
        <a class="dropdown-item" href="${url}/purchase/all">View All</a>
        <a class="dropdown-item" href="${url}/purchase/charts">Reports</a>
       </div>
    </li>
    <!-- Item Type end -->
    
    <!-- User -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">User</a>
			<div class="dropdown-menu">
				<%-- <a class="dropdown-item" href="${url}/user/register">Register </a> --%>
				 <a class="dropdown-item" href="${url}/user/view">View All</a>
			</div></li>
    
     <li class="nav-item">
     <a class="nav-link" href="${url}/logout">LOGOUT</a></li>
  </ul>
</nav>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head> 
	<spring:url value="/resources/dist/css/bootstrap.css" var="crunchifyCSS" />
	<spring:url value="/resources/dist/js/jquery-1.9.1.min.js" var="crunchifyJS" />	
	<link href="${crunchifyCSS}" rel="stylesheet" type = "text/css" />
	<script src="${crunchifyJS}" type="text/javascript"></script>

	
			<script src="http://code.highcharts.com/highcharts.js"></script>
        <script src="http://code.highcharts.com/modules/exporting.js"></script>	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Pie Chart</title>
		<script type="text/javascript"> 
  
		$(function () { 
				    $('#container').highcharts({
				        chart: {
				            type: 'column'
				        },
				        title: {
				            text: 'Product Statistics - Current Status'
				        },
				        xAxis: {
				            categories: ['Barclaycard - Arrival', 'Barclaycard - Rewards','Barclaycard - Cashforward']
				        },
				        yAxis: {
				        	title: {
				        				text: 'Social Traffic'
				        	}
				        },
				        credits: {
				            enabled: false
				        },
				        series: [{
				            name: 'Barclaycard Series',
				            data: [2, 1 , 1]
				        }]
				    }); 
		});				  
		</script>
</head>

<body>

<div class="container">
    
<ul class="nav nav-pills pull-right">
  <li role="presentation" class="active"><a href="#">Home</a></li>
  <li role="presentation"><a href="#">Profile</a></li>
  <li role="presentation"><a href="#">Messages</a></li>
</ul>

<div class="row">
  <div class="col-md-10 col-md-push-2">
  	<h4>Twitter Analytics / Column Chart</p> 
	</h4>
	<div id="showStatistics"></div>
	<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
	</div>
  <div class="col-md-2 col-md-pull-10">
	  <ul class="nav nav-pills nav-stacked">
		  <li role="presentation" class="active"><a href="#">Product Catalogue</a></li>
		  <li role="presentation" class="pull-right"><a href="create_product.php">Create a Product</a></li>
		  <li role="presentation" class="pull-right"><a href="all_products.php">All Products</a></li>
	  </ul>
  </div>
    <div class="col-md-2 col-md-pull-10">
	  <ul class="nav nav-pills nav-stacked">
		  <li role="presentation" class="active"><a href="#">Twitter Analytics</a></li>
		  <li role="presentation" class="pull-right"><a href="http://localhost:8080/lma/showpiechart">Pie Chart</a></li>
		  <li role="presentation" class="pull-right"><a href="http://localhost:8080/lma/showcolumnchart">Bar Chart</a></li>				  
	  </ul>
  </div>
</div>
</div>
<div id="show_user_sec" class="user_section">

</div>
<div id="update_user_sec" class="user_section">

</div> 	
	<spring:url value="/resources/dist/js/bootstrap.js" var="bootstrapJS" />	
	<script src="${bootstrapJS}" type="text/javascript"></script>  
</body>
</html>
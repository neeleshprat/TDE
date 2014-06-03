<!DOCTYPE html>
<html>
<head>

<title>Table Data Extraction</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

<!-- Style -->

<link rel="stylesheet" type="text/css"
	href="/tableDataExtraction/css/style.css">

</head>
<body>

	<div id="frame"></div>

	<!-- Handlebars templates -->

	<script id="frameTemplate" type="text/x-handlebars-template">	
		<%@include file="template/frame.jsp" %>
	</script>
	<script id="loadTemplate" type="text/x-handlebars-template">	
		<%@include file="template/load.jsp" %>
	</script>
	<script id="loadResultTemplate" type="text/x-handlebars-template">	
		<%@include file="template/loadResult.jsp" %>
	</script>
	<script id="messageTemplate" type="text/x-handlebars-template">	
		<%@include file="template/message.jsp" %>
	</script>
	<script id="navigationTemplate" type="text/x-handlebars-template">	
		<%@include file="template/navigation.jsp" %>
	</script>
	<script id="overviewTemplate" type="text/x-handlebars-template">	
		<%@include file="template/overview.jsp" %>
	</script>
	<script id="runTemplate" type="text/x-handlebars-template">	
		<%@include file="template/run.jsp" %>
	</script>
	<script id="runResultTemplate" type="text/x-handlebars-template">	
		<%@include file="template/runResult.jsp" %>
	</script>
	<script id="saveTemplate" type="text/x-handlebars-template">	
		<%@include file="template/save.jsp" %>
	</script>
	<script id="statisticsTemplate" type="text/x-handlebars-template">	
		<%@include file="template/statistics.jsp" %>
	</script>
	<script id="tableTemplate" type="text/x-handlebars-template">	
		<%@include file="template/table.jsp" %>
	</script>
	<script id="trainTemplate" type="text/x-handlebars-template">	
		<%@include file="template/train.jsp" %>
	</script>
	<script id="waitTemplate" type="text/x-handlebars-template">	
		<%@include file="template/wait.jsp" %>
	</script>


	<!-- Libraries -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min.js"></script>
	<script type="text/javascript"
		src="http://cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/1.3.0/handlebars.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


	<!-- JavaScript -->

	<script type="text/javascript" src="/tableDataExtraction/js/app/app.js"></script>

	<script type="text/javascript"
		src="/tableDataExtraction/js/model/message.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/model/navigation.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/model/statistics.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/model/table.js"></script>

	<script type="text/javascript"
		src="/tableDataExtraction/js/view/frame.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/load.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/message.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/navigation.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/overview.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/run.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/save.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/statistics.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/table.js"></script>
	<script type="text/javascript"
		src="/tableDataExtraction/js/view/train.js"></script>

	<script type="text/javascript" src="/tableDataExtraction/js/index.js"></script>

</body>
</html>

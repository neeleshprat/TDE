
<div class="navbar-header">

	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target="#bs-example-navbar-collapse-1">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	
	<a class="navbar-brand" href="#overview">tableDataExtraction</a>

</div>
<div class="collapse navbar-collapse">

	<ul class="nav navbar-nav">
	
		{{#each navigation}}
			{{#if current}}
				<li class="active">
			{{else}}
				<li>
			{{/if}}
					<a href="{{url}}">{{title}}</a>
				</li>
		{{/each}}
	</ul>

</div>
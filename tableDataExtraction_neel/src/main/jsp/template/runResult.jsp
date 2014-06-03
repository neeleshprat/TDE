
<div class="well">

	<h1>{{message.title}}</h1>
	
	<p>{{message.text}}</p>
	 
	<h2>Results</h2>
	 
	{{#each message.results}}
	
	{{name}}
	
	<div class="progress">
	  <div class="progress-bar progress-bar-success" style="width: {{correctTablesPercent}}%">
	    {{correctTables}} tables / {{correctTablesPercent}}%
	  </div>
	  <div class="progress-bar progress-bar-danger" style="width: {{wrongTablesPercent}}%">
	    {{wrongTables}} tables / {{wrongTablesPercent}}%
	  </div>
	</div>
	
	{{/each}}
	
	<h2>Maximum gains from perfect combinations</h2>
	 
	{{#each message.combinations}}
	
	{{name}}
	
	<div class="progress">
	  <div class="progress-bar progress-bar-success" style="width: {{correctTablesPercent}}%">
	    {{correctTables}} tables / {{correctTablesPercent}}%
	  </div>
	  <div class="progress-bar progress-bar-danger" style="width: {{wrongTablesPercent}}%">
	    {{wrongTables}} tables / {{wrongTablesPercent}}%
	  </div>
	</div>
	
	{{/each}}
	
	<h2>Runtime</h2>
	
	{{#each message.timers}}
	
	{{@key}}
	 
	<div class="progress">
	  <div class="progress-bar progress-bar" style="width: {{usedTimePercent}}%">
	    {{usedTime}} ms
	  </div>
	</div>
	
	{{/each}}
	
	<h2>Detailed evaluation</h2>
	
	<div class="row">

		<div class="col-md-4">
		
			<div class="wrapRotate">
				<div class="rotate">{{@key}}</div>
			</div>
		
			{{#each message.results.[TENGLI].perTableEvaluation}}
			
			<div class="progress">
				<div class="progress-bar" role="progressbar" style="width: 100%">
					{{name}}
				</div>
			</div>
			
			{{/each}}
		
		</div>
	
		{{#each message.results}}
	
		<div class="col-md-1">
		
			<div class="wrapRotate">
				<div class="rotate">{{@key}}</div>
			</div>
		
			{{#each perTableEvaluation}}
			
			{{#if result}}
			
				<div class="progress">
				  <div class="progress-bar progress-bar-success" role="progressbar" style="width: 100%">
				  	
				  </div>
				</div>
			
			{{else}}
			
				<div class="progress">
				  <div class="progress-bar progress-bar-danger" role="progressbar" style="width: 100%">
				  	
				  </div>
				</div>
			
			{{/if}}
			
			{{/each}}	
			
		</div>
	
		{{/each}}
		
	</div>
	
</div>
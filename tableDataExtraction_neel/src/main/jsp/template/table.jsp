
	<p>{{table.tableId}}</p>

	<p>
		<button type="submit" class="btn btn-success btn-lg" id="buttonSave">Save</button>
	</p>

	<table class="table">
		
		<tr>
		
			<td></td>
		
			{{#each table.data.rows.[0].cells}}
			
				<td class="column-{{@index}}" data-columnnumber="{{@index}}" data-classname="column-{{@index}}" id="demo-{{@index}}">
					<button type="button" class="btn btn-default selectColumn">
						<span class="glyphicon glyphicon-chevron-down"></span>
					</button>
				</td>
			
			{{/each}}
		
		</tr>
		
		{{#each table.data.rows}}
			<tr data-rowNumber="{{@index}}">
			
				<td>
					<button type="button" class="btn btn-default selectRow">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</button>
				</td>
			
				{{#each cells}}
				
					<td class="column-{{@index}}">
					
						{{content}}
					
					</td>
				
				{{/each}}
				
			</tr>
			
		{{/each}}
		
	</table>

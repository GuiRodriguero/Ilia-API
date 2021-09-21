		    (document).ready(function(){
		        var date_input=$('input[name="date"]');
		        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		        date_input.datepicker({
		            format: 'dd/mm/yyyy',
		            container: container,
		            todayHighlight: true,
		            autoclose: true,
		        })
		    })
		    
		    var slider = document.getElementById("startHour");
			var output = document.getElementById("startHourLabel");
			output.innerHTML = slider.value; // Display the default slider value
			
			// Update the current slider value (each time you drag the slider handle)
			slider.oninput = function() {
			  output.innerHTML = this.value;
			}
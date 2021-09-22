$(document).ready(function(){
		        var date_input=$('input[name="dateRegister"]');
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
			output.innerHTML = slider.value;
			
			slider.oninput = function() {
			  output.innerHTML = this.value;
			}

		    var slider2 = document.getElementById("startMinute");
			var output2 = document.getElementById("startMinuteLabel");
			output2.innerHTML = slider.value;
			
			slider2.oninput = function() {
			  output2.innerHTML = this.value;
			}

		    var slider3 = document.getElementById("endHour");
			var output3 = document.getElementById("endHourLabel");
			output3.innerHTML = slider.value;
			
			slider3.oninput = function() {
			  output3.innerHTML = this.value;
			}

		    var slider4 = document.getElementById("endMinute");
			var output4 = document.getElementById("endMinuteLabel");
			output4.innerHTML = slider.value;
			
			slider4.oninput = function() {
			  output4.innerHTML = this.value;
			}
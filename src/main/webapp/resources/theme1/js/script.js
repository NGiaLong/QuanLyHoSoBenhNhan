$(document).ready(
		function() {
			$('#example').DataTable();
			$('#tableChiKhac').DataTable();
			$('#table2').DataTable();
			$('#table3').DataTable();

			$('.date-picker').datepicker({
				changeMonth : true,
				changeYear : true,
				dateFormat : 'dd/mm/yy',
			}).click(function() {
				$('.ui-datepicker-calendar').show();
			});
			
			$(".resetField").click(function() {
				$(".searchField").val("");
			});
			$("#date-option").change(function() {
				var selected = this.value;
				if (selected == 0) {	
					$('.date-picker').removeClass('hasDatepicker');
					$('.date-picker').datepicker({
						changeMonth : true,
						changeYear : true,
						dateFormat : 'dd/mm/yy',						
					}).click(function() {
						$('.ui-datepicker-calendar').show();
					});
				}
				if (selected == 1) {					
					$('.date-picker').removeClass('hasDatepicker');
					$('.date-picker').datepicker({
						changeMonth : true,
						changeYear : true,
						showButtonPanel : true,
						dateFormat : 'mm/yy',
						onChangeMonthYear : function(year, month, widget) {
							setTimeout(function() {
								$('.ui-datepicker-calendar').hide();
							});
						},
						onClose : function(dateText, inst) {
							$(this).datepicker(
									'setDate',
									new Date(inst.selectedYear,
											inst.selectedMonth, 1));
						}
					}).click(function() {
						$('.ui-datepicker-calendar').hide();
					});
				}
				if (selected == 2) {
					$('.date-picker').removeClass('hasDatepicker');
					$('.date-picker').datepicker(
						{
							changeMonth : false,
							changeYear : true,
							showButtonPanel : true,
							dateFormat : 'yy',
							onChangeMonthYear : function(year, month, widget) {
								setTimeout(function() {
									$('.ui-datepicker-calendar').hide();
								});
							},
							onClose : function(dateText, inst) {
								$(this).datepicker(
										'setDate',
										new Date(inst.selectedYear,
												inst.selectedMonth, 1));
							}
						}).click(function() {
						$('.ui-datepicker-calendar').hide();
					});
				}
			});
		});
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
			$('.date-picker-month').datepicker(
					{
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
			$('.date-picker-year').datepicker(
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
			$(".resetField").click(function() {
				$(".searchField").val("");
			});
			$("#date-option").change(function() {
				var selected = this.value;
				if (selected == 0) {
					console.log(selected);
					$('.date-picker').show();
					$('.date-picker-year').hide();
					$('.date-picker-month').hide();
				}
				if (selected == 1) {
					console.log(selected);
					$('.date-picker-month').show();
					$('.date-picker-year').hide();
					$('.date-picker').hide();
				}
				if (selected == 2) {
					console.log(selected);
					$('.date-picker-year').show();
					$('.date-picker').hide();
					$('.date-picker-month').hide();
				}
			});
		});
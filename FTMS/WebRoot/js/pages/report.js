$(document).ready(
		function() {
			var userlevel = $('#userlevel').text();
			var username = $('#username').text();
			$.post("jgcxload_one.action", {
				"level" : userlevel,
				"username" : username
			}, function(data) {
				if (data[0].picpath == "sss") {
					$('#jgimg').attr("src",
							"../images/ManagementSystem/nopic.png")
				} else {
					$('#jgimg').attr("src", data[0].picpath)
				}
				$('#jgname').text(data[0].name), $('#jggender').text(
						data[0].gender),

				$('#jgyear').text(data[0].birthday.year + 1900 + "-"), $(
						'#jgmonth').text(data[0].birthday.month + 1), $(
						'#jgphone').text(data[0].phone), $('#jgidnumber').text(
						data[0].idnumber),

				$('#jgeducation').text(data[0].education), $('#jgprof').text(
						data[0].prof1name + "-" + data[0].prof2name), $(
						'#jgprof2').text(
						data[0].prof1name + "-" + data[0].prof2name),

				$('#jgachievement').text(data[0].achievement), $(
						'#jgwritescore').text(data[0].canjia), $(
						'#jginterviewscore').text(data[0].interviewscore), $(
						'#jgtotal').text(data[0].total), $('#jgcanjia').text(
						data[0].canjia), $('#jgapproval')
						.text(data[0].approval), $('#jgopposition').text(
						data[0].opposition), $('#jgnumber')
						.text(data[0].number),

				$.post("jgAddress.action", {
					username : username
				}, function(kk) {
					$('#jglocal').text(
							data[0].proviceName + data[0].cityName
									+ data[0].countyName + data[0].townName
									+ kk[0])

				});
				$.post("jgcxload_two.action", {
					"level" : userlevel,
					"name" : data[0].name
				}, function(data) {
					$('#jglevel').text(data[0].level), $('#jgtime').text(
							data[0].time), $('#jgaddress')
							.text(data[0].address), $('#jglevel2').text(
							data[0].level)
				}, "json");
				$.post("jgcx_sy.action", {
					"level" : "农技员",
					"name" : data[0].name
				}, function(dd) {
					var i = 0;
					var k = 0;

					while (dd[i] != null) {
						if (dd[i].status == "是") {
							if (k < dd[i].year) {
								k = dd[i].year;
							}
						}
						i++;
					}
					$('#imageyear').text(k);
					$('#imagemonth').text("1");
				}, "json");
			}, "json");
			$('#yj_dg').datagrid({
				url : "achievement.action?username=" + username
			});
			$('#zs_dg').datagrid({
				url : "certificate.action?username=" + username
			});

		});// JavaScript Document

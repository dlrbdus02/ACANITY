<%@ page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	JSONObject json = (JSONObject)request.getAttribute("json");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.0/Chart.bundle.js"></script>
<script src="/acanity/js/admin/utils.js"></script>
<style type="text/css">
	canvas{
	    -moz-user-select: none;
	    -webkit-user-select: none;
	    -ms-user-select: none;
	}
</style>
</head>
<body>
    <div style="width:100%;">
        <canvas id="canvas"></canvas>
    </div>
    <script>
        var config = {
            type: 'line',
            data: {
                labels: <%= json.get("date") %>,
                datasets: [{
                    label: "Visitor Count",
                    backgroundColor: window.chartColors.red,    
                    borderColor: window.chartColors.red,
                    data: <%= json.get("value") %>,
                    fill: false,
                }, 
                ]
            },
            options: {
                responsive: true,
                title:{
                    display:false,
                    text:'Chart.js Line Chart'
                },
                tooltips: {
                    mode: 'index',
                    intersect: false,
                },
                hover: {
                    mode: 'nearest',
                    intersect: true
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Date'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Visitor'
                        }
                    }]
                }
            }
        };

        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myLine = new Chart(ctx, config);
        };

        var colorNames = Object.keys(window.chartColors);
    </script>
</body>

</html>

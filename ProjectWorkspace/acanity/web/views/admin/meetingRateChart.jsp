<%@ page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	JSONObject json = (JSONObject)request.getAttribute("json");
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.0/Chart.bundle.js"></script>
<script src="/acanity/js/admin/utils.js"></script>
</head>
<body>
    <div id="canvas-holder" style="width:100%">
        <canvas id="chart-area" />
    </div>
    <script>
    var randomScalingFactor = function() {
        return Math.round(Math.random() * 100);
    };

    var config = {
        type: 'pie',
        data: {
            datasets: [{
                data: <%= json.get("value") %>,
                backgroundColor: [
                    window.chartColors.red,
                    window.chartColors.orange,
                    window.chartColors.yellow,
                    window.chartColors.green,
                    window.chartColors.blue,
                ],
                label: 'Dataset 1'
            }],
            labels: <%= json.get("names") %>
        },
        options: {
            responsive: true
        }
    };

    window.onload = function() {
        var ctx = document.getElementById("chart-area").getContext("2d");
        window.myPie = new Chart(ctx, config);
    };

    var colorNames = Object.keys(window.chartColors);
    </script>
</body>

</html>

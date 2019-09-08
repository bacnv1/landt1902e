<?php
	include 'connection.php';
	$user_name =  $_POST['user_name'];
	$password = $_POST['password'];

	$sql = "SELECT * FROM user WHERE user_name = '$user_name' and password = '$password'";
	$result = $conn -> query($sql);
	$row = $result -> fetch_array();
	if ($row) {
		$user = array(
			"userName" => $row['user_name'],
			"password" => $row['password'],
			"name" => $row['name']
		);
		echo json_encode($user);
	} else {
		header('HTTP/1.1 401 login fail');
	}
?>
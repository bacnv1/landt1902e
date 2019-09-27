<?php
	include 'connection.php';
	$user_name = $_POST['user_name'];
	$password = $_POST['password'];
	$name = $_POST['name'];
	if ($user_name == '' || $password == '' || $name == '') {
		header('HTTP/1.1 401 register fail');
		return;
	}
	$sql = "INSERT INTO `user`(`user_name`, `password`, `name`) VALUES ('$user_name','$password','$name')";
	$result = $conn -> query($sql);

	if ($result) {
		header('HTTP/1.1 200 register success');
	}else {
		header('HTTP/1.1 401 register fail');
	}
?>
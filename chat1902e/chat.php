<?php
	include 'connection.php';
	$user_name = $_POST['user_name'];
	$message = $_POST['message'];
	$pub_date = date("Y/m/d H:i:s");
	
	if ($user_name == '' || $message == '') {
		header('HTTP/1.1 401 chat fail');
		return;
	}

	$sql = "INSERT INTO `chat`(`user_name`, `message`, `pub_date`) VALUES ('$user_name', '$message', '$pub_date')";
	$result = $conn -> query($sql);

	if ($result) {
		header('HTTP/1.1 200 chat success');
	}else {
		header('HTTP/1.1 401 chat fail');
	}
?>
<?php
	include 'connection.php';
	$sql = "SELECT a.*, b.name FROM chat a inner join user b on a.user_name = b.user_name";
	$result = $conn -> query($sql);

	$arr = array();

	while ($row = $result -> fetch_array()) {
		$chat = array(
			'id' => $row['id'],
			'message' => $row['message'],
			'pubDate' => $row['pub_date'],
			'name' => $row['name'],
			'userName' => $row['user_name']
		);
		$arr[] = $chat;
	}

	echo json_encode($arr);
?>
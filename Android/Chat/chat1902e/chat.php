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
		$sql = "SELECT token FROM user WHERE token != '' and user_name != '$user_name'";
		$query = $conn -> query($sql);
		$arr = array();
		while ($row =  $query -> fetch_array()) {
			$arr[] = $row['token'];
		}
		$notification = array('title' =>"Message from $user_name" , 'body' => $message);

		$data = array("registration_ids" => $arr, "notification" => $notification);
		//FCM API end-point
		$url = 'https://fcm.googleapis.com/fcm/send';
		//api_key in Firebase Console -> Project Settings -> CLOUD MESSAGING -> Server key
		$server_key = 'AIzaSyBy5VJCvrDnDzCIN0CTvTLDANG4solF2Lg';
		//header with content_type api key
		$headers = array(
		    'Content-Type:application/json',
		    'Authorization:key='.$server_key
		);
		//CURL request to route notification to FCM connection server (provided by Google)
		$ch = curl_init();
		curl_setopt($ch, CURLOPT_URL, $url);
		curl_setopt($ch, CURLOPT_POST, true);
		curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
		curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
		$result = curl_exec($ch);
		if ($result === FALSE) {
		    die('Oops! FCM Send Error: ' . curl_error($ch));
		}
		curl_close($ch);


		header('HTTP/1.1 200 chat success');
	}else {
		header('HTTP/1.1 401 chat fail');
	}
?>
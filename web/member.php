<?php
$link =mysqli_connect("localhost","root","...123jeph") or die("failed to connect to server!");
mysqli_select_db($link,"terasite");
if(isset($_REQUEST['submit']))
{
	$errorMessage="";
	$firstname=$_POST['firstname'];
	$lastname=$_POST['lastname'];
	$gender=$_POST['gender'];
	$dob=$_POST['dob'];
	$address=$_POST['address'];
	$city=$_POST['city'];
	$phone=$_POST['phone'];
	$email=$_POST['email'];

	//validation to be added here

	if($errorMessage!=""){
		echo "<p class='message'>".$errorMessage."</p>";
	}

	else{
		//inserting record in table using INSERT query

		$insqDbtb="INSERT INTO 'terasite'.'members'
		('firstname','lastname','gender','dob','address','city','phone','email')VALUES('$firstname','$lastname','$gender',
		'$dob','$address','$city','$phone','$email')";
		mysqli_query($link,$insqDbtb) or die(mysqli_error($link));
	}
}
?>
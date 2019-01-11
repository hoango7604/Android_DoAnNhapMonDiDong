<?php
	include "connect.php";
		$query = "SELECT * FROM loaiquatang";
		$data = mysqli_query($conn, $query);
		$mangloaiqt = array();
		while($row = mysqli_fetch_assoc($data))
		{
			array_push($mangloaiqt, new Loaiqt(
				$row['id'],
				$row['tenloaiqt'],
				$row['hinhanhloaiqt']));
		}
		echo json_encode($mangloaiqt);
	class Loaiqt
	{
		function Loaiqt($id, $tenloaiqt, $hinhanhloaiqt)
		{
			$this->id = $id;
			$this->tenloaiqt = $tenloaiqt;
			$this->hinhanhloaiqt = $hinhanhloaiqt;
		}
	}
?>
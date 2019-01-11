<?php
	include "connect.php";
	$page = $_GET['page'];
	$idsp = $_GET['idsp'];
	$space = 6;
	$limit = ($page - 1) * $space;

	$mangsp = array();
	$query = "SELECT * FROM quatang WHERE idqt = $idsp LIMIT $limit, $space";
	$data = mysqli_query($conn, $query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangsp, new Sanpham(
			$row['id'],
			$row['tenqt'],
			$row['giaqt'],
			$row['hinhanhqt'],
			$row['mota'],
			$row['idqt']));
	}
	echo json_encode($mangsp);
	class Sanpham
	{
		
		function Sanpham($id, $tenqt, $giaqt, $hinhanhqt, $mota, $idqt)
		{
			$this->id = $id;
			$this->tenqt = $tenqt;
			$this->giaqt = $giaqt;
			$this->hinhanhqt = $hinhanhqt;
			$this->mota = $mota;
			$this->idqt = $idqt;
		}
	}
?>
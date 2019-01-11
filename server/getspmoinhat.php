<?php
	include "connect.php";
	$mangspmoinhat = array();
	$query = "SELECT * FROM quatang ORDER BY id DESC LIMIT 6";
	$data = mysqli_query($conn, $query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangspmoinhat, new Spmoinhat(
			$row['id'],
			$row['tenqt'],
			$row['giaqt'],
			$row['hinhanhqt'],
			$row['mota'],
			$row['idqt']));
	}
	echo json_encode($mangspmoinhat);

	class Spmoinhat
	{
		
		function Spmoinhat($id, $tenqt, $giaqt, $hinhanhqt, $mota, $idqt)
		{
			$this->id=$id;
			$this->tenqt=$tenqt;
			$this->giaqt=$giaqt;
			$this->hinhanhqt=$hinhanhqt;
			$this->mota=$mota;
			$this->idqt=$idqt;
		}
	}
?>
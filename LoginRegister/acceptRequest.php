<?php

require "DataBase.php";
$db = new DataBase();
if ($db->dbConnect()) {
    if(isset($_POST['nume']) && isset($_POST['prenume']) && isset($_POST['email']) && isset($_POST['batalion']) && isset($_POST['facultate'])&& isset($_POST['type']))
        if($_POST['type'] == "accept")
            echo  ($db->acceptRequest($_POST['nume'],$_POST['prenume'],$_POST['email'],$_POST['batalion'],$_POST['facultate']));
        else
            echo ($db->refuzRequest($_POST['nume'],$_POST['prenume'],$_POST['email'],$_POST['batalion'],$_POST['facultate']));
    }
?>
<?php
require "DataBase.php";
$db = new DataBase();
if ($db->dbConnect()) {
    if(isset($_POST['utilizator']) && isset($_POST['parola']) && isset($_POST['parolaNoua']) && isset($_POST['parolaConfirm']))
    if ($db->dbConnect()) {
        if ($db->resetPassword("users", $_POST['utilizator'], $_POST['parola'], $_POST['parolaNoua'], $_POST['parolaConfirm'])){
            echo "Parola modificata cu succes!";
       }
    } 
} 


?>
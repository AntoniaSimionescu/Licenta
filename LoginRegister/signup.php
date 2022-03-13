<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['nume']) && isset($_POST['prenume']) && isset($_POST['email']) && isset($_POST['utilizator']) && isset($_POST['parola']) && isset($_POST['batalion']) && isset($_POST['facultate'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("users", $_POST['nume'], $_POST['prenume'], $_POST['email'], $_POST['utilizator'], $_POST['parola'], $_POST['batalion'], $_POST['facultate'])){
            echo "Inscriere cu succes!";
       }  
    } else echo "Eroare la conexiunea cu baza de date!";
} else echo "Toate campurile sunt obligatorii!";
?>

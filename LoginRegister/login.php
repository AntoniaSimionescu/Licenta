<?php

require "DataBase.php";
$db = new DataBase();
if (isset($_POST['utilizator']) && isset($_POST['parola'])) {   
    if ($db->dbConnect()) {
        if ($db->logIn("users", $_POST['utilizator'], $_POST['parola'])) {
            echo ($db->logIn("users", $_POST['utilizator'], $_POST['parola']));
            //echo "Inscriere cu succes!";
        } else echo "Cererea nu a fost inca aprobata sau a fost refuzata!";
    } else echo "Eroare la conexiunea cu baza de date!";
} else echo "Toate campurile sunt obligatorii!";
?>

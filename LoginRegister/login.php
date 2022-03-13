<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['utilizator']) && isset($_POST['parola'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("users", $_POST['utilizator'], $_POST['parola'])) {
            echo ($db->logIn("users", $_POST['utilizator'], $_POST['parola']));
        } else echo "Utilizator sau parola gresita!";
    } else echo "Eroare la conexiunea cu baza de date!";
} else echo "Toate campurile sunt obligatorii!";
?>

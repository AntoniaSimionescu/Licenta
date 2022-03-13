<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $utilizator;
    protected $parola;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->utilizator = $dbc->utilizator;
        $this->parola = $dbc->parola;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->utilizator, $this->parola, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $utilizator, $parola)
    {
        $utilizator = $this->prepareData($utilizator);
        $parola = $this->prepareData($parola);
        $this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbutilizator = $row['utilizator'];
            $dbparola = $row['parola'];
            if ($dbutilizator == $utilizator && password_verify($parola, $dbparola)) {
                $login = $row['prioritate'];
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUp($table, $nume, $prenume, $email, $utilizator, $parola, $batalion, $facultate)
    {
        $nume = $this->prepareData($nume);
        $prenume = $this->prepareData($prenume);
        $utilizator = $this->prepareData($utilizator);
        $parola = $this->prepareData($parola);
        $email = $this->prepareData($email);
        $parola = password_hash($parola, PASSWORD_DEFAULT);
        $batalion = $this->prepareData($batalion);
        $facultate = $this->prepareData($facultate);
        $this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbutilizator = $row['utilizator'];
            if ($dbutilizator == $utilizator) {
                echo "Utilizator existent!"
                ;
            
            } 
        } 
        $this->sql = "select * from " . $table . " where email = '" . $email . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbemail = $row['email'];
            if ($dbemail == $email) {
                echo "Adresa de email corespunde altui utilizator!";
            } 
        } 
        $this->sql =
            "INSERT INTO " . $table . " (nume, prenume, utilizator, parola, email, batalion, facultate) VALUES ('" . $nume . "','" . $prenume . "','" . $utilizator . "','" . $parola . "','" . $email . "','" . $batalion . "','" . $facultate . "')";
        if(mysqli_query($this->connect, $this->sql)){
            return true;
        } else return false;
    }

}

?>

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
            if ($dbutilizator == $utilizator && !password_verify($parola, $dbparola)) {
                echo "Parola este gresita!";
            } 
        } 
        $this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        $login = array();
        if (mysqli_num_rows($result) != 0) {
            $dbutilizator = $row['utilizator'];
            $dbparola = $row['parola'];
            if ($dbutilizator == $utilizator && password_verify($parola, $dbparola)) {
                    $login[] = $row; 
                    return json_encode($login);
            } else {
                echo "";
                return false;
            }
        } 
        
    }

    function getRequests($table)
    {
    $this->sql = "select nume,prenume,batalion,email,facultate from " . $table ;       
    $result = mysqli_query($this->connect, $this->sql);
    while($row = mysqli_fetch_array($result)) {
        $return_arr[] = array($row);
    }
    return json_encode($return_arr);
    }

    function acceptRequest($nume,$prenume,$email,$batalion,$facultate){
        $this->sql = "INSERT INTO users SELECT * FROM requests WHERE nume ='".$nume."' and prenume ='".$prenume."' and email ='".$email."' and batalion ='".$batalion."' and facultate ='".$facultate."'";
        mysqli_query($this->connect, $this->sql);
        $this->sql = "DELETE FROM requests WHERE  nume ='".$nume."' and prenume ='".$prenume."' and email ='".$email."' and batalion ='".$batalion."' and facultate ='".$facultate."'";
        mysqli_query($this->connect, $this->sql);
        return "Cerere acceptata cu succes!";
    }

    function resetPassword($table, $utilizator, $parola, $parolaNoua, $parolaConfirm){
        $utilizator = $this->prepareData($utilizator);
        $parola = $this->prepareData($parola);
        $parolaNoua = $this->prepareData($parolaNoua);
        $parolaConfirm = $this->prepareData($parolaConfirm);
        $this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbutilizator = $row['utilizator'];
            $dbparola = $row['parola'];
            if ($dbutilizator == $utilizator && password_verify($parola, $dbparola)) {
                if($parolaNoua == $parolaConfirm){
                    if (!preg_match('/^(?=.*\d)(?=.*[A-Za-z])[0-9A-Za-z!@#$%]{8,120}$/', $parolaNoua) && !preg_match('/^(?=.*\d)(?=.*[A-Za-z])[0-9A-Za-z!@#$%]{8,120}$/', $parolaConfirm)) {
                        echo "Parola nu corespunde cerintelor!";
                        return false;
                    } else {
                        $parolaNoua = password_hash($parolaNoua, PASSWORD_DEFAULT);
                        $parolaConfirm = password_hash($parolaConfirm, PASSWORD_DEFAULT);
                    }
                    $this->sql = "UPDATE users SET parola = '".$parolaNoua."' where utilizator = '".$utilizator."'";
                    $res = mysqli_query($this->connect, $this->sql);
                    if($res){
                        return true;
                    }else {
                        echo "Eroare la modificarea parolei!";
                    }
                } else {
                    echo "Parola confirmata nu corespunde cu parola noua!";
                }
            } else {
                echo "Parola veche nu corespunde!";
            }
        }
    }

    function refuzRequest($nume,$prenume,$email,$batalion,$facultate)
    {
        $this->sql = "DELETE FROM requests WHERE  nume ='".$nume."' and prenume ='".$prenume."' and email ='".$email."' and batalion ='".$batalion."' and facultate ='".$facultate."'";
        mysqli_query($this->connect, $this->sql);
        return "Cerere refuzata!";

    }

    function signUp($table, $nume, $prenume, $email, $utilizator, $parola, $batalion, $facultate)
    {
        $nume = $this->prepareData($nume);
        $prenume = $this->prepareData($prenume);
        $utilizator = $this->prepareData($utilizator);
        $parola = $this->prepareData($parola);
        $email = $this->prepareData($email);
        if (!preg_match('/^(?=.*\d)(?=.*[A-Za-z])[0-9A-Za-z!@#$%]{8,120}$/', $parola)) {
            echo "Parola nu corespunde cerintelor!";
            return false;
        } else {
            $parola = password_hash($parola, PASSWORD_DEFAULT);
        }
       // $parola = password_hash($parola, PASSWORD_DEFAULT);
        $batalion = $this->prepareData($batalion);
        $facultate = $this->prepareData($facultate);
        $this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbutilizator = $row['utilizator'];
            if ($dbutilizator == $utilizator) {
                echo "Utilizator existent!";
            } 
        } 
        if (substr($email,-7) != "@mta.ro")
        {
            echo "Adresa de email nu corespunde academiei!";
        } else {
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
            "INSERT INTO $table (nume, prenume, utilizator, parola, email, batalion, facultate) VALUES ('$nume', '$prenume', '$utilizator', '$parola', '$email', '$batalion', '$facultate')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    }

}
?>

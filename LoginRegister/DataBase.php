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
        // $this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        // $result = mysqli_query($this->connect, $this->sql);
        // $row = mysqli_fetch_assoc($result);
        // if (mysqli_num_rows($result) != 0) {
        //     $dbutilizator = $row['utilizator'];
        //     $dbparola = $row['parola'];
        //     if ($dbutilizator != $utilizator && !password_verify($parola, $dbparola)) {
        //         echo "Cererea nu a fost inca aprobata sau a fost refuzata!";
        //     } 
        // } 
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
            // $row = mysqli_fetch_assoc(mysqli_query($this->connect, $this->sql));
            // $dbnume = $row['nume'];
            // $dbprenume = $row['prenume'];
            // $dbemail = $row['email'];
            // $dbutilizator = $row['utilizator'];
            // $dbparola = $row['parola'];
            // $dbbatalion = $row['batalion'];
            // $dbfacultate = $row['facultate'];
            // $arr[] = array('nume' => $dbnume, 'prenume' => $dbprenume, 'utilizator' => $dbutilizator, 'parola' => $dbparola, 'email' => $dbemail, 'batalion' => $dbbatalion, 'parola' => $dbparola);
            // return json_encode($arr);
            return true;
        } else return false;
        //$this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        // $result = mysqli_query($this->connect, $this->sql);
        // $row = mysqli_fetch_assoc($result);
        
        
        // $this->sql = "select * from " . $table . " where utilizator = '" . $utilizator . "'";
        // $result = mysqli_query($this->connect, $this->sql);
        // $row = mysqli_fetch_assoc($result);
        // $signup = array();
        // if (mysqli_num_rows($resultat) != 0){
        //     $dbnume = $row['nume'];
        //     $dbprenume = $row['prenume'];
        //     $dbemail = $row['email'];
        //     $dbutilizator = $row['utilizator'];
        //     $dbparola = $row['parola'];
        //     $dbbatalion = $row['batalion'];
        //     $dbfacultate = $row['facultate'];
        //     if($dbnume == $nume && $dbprenume == $prenume && $dbutilizator == $utilizator && password_verify($parola, $dbparola) && $dbemail == $email && $dbbatalion == $batalion && $dbfacultate == $facultate){
        //         $signup[] = $row; 
        //         return json_encode($signup);
        //     } else {
        //         echo "";
        //         return false;
        //     }
        // }

        // }
        
        
            // if(mysqli_query($this->connect, $this->sql)){
        //     $signup[] = $row; 
        //     return json_encode($signup);
        //     //return true;
        // } else return false;
    }

}
?>

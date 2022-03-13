<?php

class DataBaseConfig
{
    public $servername;
    public $utilizator;
    public $parola;
    public $databasename;

    public function __construct()
    {

        $this->servername = 'localhost';
        $this->utilizator = 'root';
        $this->parola = '';
        $this->databasename = 'loginregister';

    }
}

?>

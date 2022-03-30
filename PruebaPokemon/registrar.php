<?php
require 'BDconect.php';

if(isset($_POST['insertar'])){

try{
    ///////////// Informacion enviada por el formulario /////////////
    $nombre=$_POST['nombre'];
    $email=$_POST['email'];
    $password=$_POST['password'];

    ///////// Fin informacion enviada por el formulario ///


    ////////////// Insertar a la tabla la informacion generada /////////
    $sql="insert into usuario (nombre,email,password) values(:nombre,:email,:password)";

    $sql = $connect->prepare($sql);

    $sql->bindParam(':nombre',$nombre,PDO::PARAM_STR, 25);
    $sql->bindParam(':email',$email,PDO::PARAM_STR, 25);
    $sql->bindParam(':password',$password,PDO::PARAM_STR,25);

    $sql->execute();
    header('location:pokemons.php');    
}catch (Exception $e) {
    echo 'No se pudo registrar';
}


}
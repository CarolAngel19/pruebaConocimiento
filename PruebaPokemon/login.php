<?php
 require 'BDconect.php';

    $email = $_POST ['email'];
    $password = $_POST ['password'];
    $sql = "SELECT count(*) as exist FROM usuario where email = '".$email."' and password = '".$password."'"; 
    $query = $connect -> prepare($sql); 
    $query -> execute(); 
    $results = $query -> fetchAll(PDO::FETCH_OBJ); 
    if($results[0]->exist == 1){
        header('location:pokemons.php');
    }else{
        header('location:login.html');
    }
?>
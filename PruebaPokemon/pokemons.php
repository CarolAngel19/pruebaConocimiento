<?php
$res = file_get_contents("https://pokeapi.co/api/v2/pokemon/");
$arrayData = json_decode($res);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Document</title>
</head>
<body >
    <div class="row" >    
    <?php
        foreach($arrayData->results as $item) {
            echo '
            <div class="mt-4 mb-4 col-md-4 text-center ">
            <h3> <a href="pokemondetail.php?url='.$item->url.'">'.$item->name.'</a></h3>
            </div>
            ';
        }
    ?>    
    </div>    
</body>
</html>
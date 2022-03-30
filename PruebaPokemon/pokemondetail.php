<?php
$urlInfo=$_GET['url'];
$res = file_get_contents($urlInfo);
$arrayData = json_decode($res);
$urlApiImage = $arrayData->forms[0]->url;
$resApiImage = file_get_contents($urlApiImage);
$arrayDataImage = json_decode($res);
$urlImage = $arrayDataImage->sprites->front_default;
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
<body>
    <div class="row mt-4">               
        <div class="row">
            <div class="mb-4col-md-12 text-center">
                <h1><?php echo $arrayData->forms[0]->name;?></h1>
            </div>        
            <div class="row mt-4">
            <?php
                echo '<div class="col-md-6 text-center">';
                echo '<h3> Habilidades</h3>';
                foreach($arrayData->abilities as $item) {
                    echo '<b><h6>*'.$item->ability->name.'</h6></b>';
                }
                echo '</div>';
                echo '<div class="col-md-6 text-center">';
                echo '<h3> Imagen Pokemon</h3>';
                echo '<img src="'.$urlImage.'" style= "width:450px; height:550px;"';
                echo '</div>';
            ?>       
            </div>        
        </div>
        <div class="row text-center">
            <a href="pokemons.php"><button type="button" class="btn btn-primary">Volver</button> </a>
        </div>    
    </div>    
</body>
</html>
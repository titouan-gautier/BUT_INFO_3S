<?php
session_start();
if (!isset($_SESSION["user"]))
    echo "acces refusé";
else {
    $pseudo = $_SESSION['user']['pseudo'];
    $status = $_SESSION['user']['status'];
    echo "Bienvenue $pseudo ";
    echo "vous pouvez : ";
    switch ($status) {
        case "administrator": echo "administrer ";
        case 'customer': echo "acheter ";
        case 'visitor': echo "consulter ";

    }

}

?>
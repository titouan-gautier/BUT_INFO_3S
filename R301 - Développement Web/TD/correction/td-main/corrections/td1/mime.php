<?php
    if (isset($_SERVER["CONTENT_TYPE"])) {
        $contentType = $_SERVER["CONTENT_TYPE"];
        header("Content-Type: $contentType");
        switch ($contentType) {
            case "text/plain":
                echo "pseudonyme: jojo";
                break;
            case "text/html" :
                ?>
                <!doctype html>
                <html lang="fr">
                <head>
                    <meta charset="utf-8">
                    <title>Jojo page</title>
                </head>
                <body>
                <p> pseudonyme: jojo </p>
                </body>
                <?php
                break;
                case "application/json" :
                    echo '{"pseudonyme": "jojo"}';
                    break;
        }
    }
?>

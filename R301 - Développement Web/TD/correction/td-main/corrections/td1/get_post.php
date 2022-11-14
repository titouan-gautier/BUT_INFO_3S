<?php
  if (count($_POST)!=0) 
    $data = $_POST;
  else 
    $data = $_GET ; 
?>
<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Test2</title>
  </head>
<body>
  <?php foreach ($data as $key => $value): ?>
  	<p> <?php echo "$key : $value"; ?></p>
  <?php endforeach; ?>
</body>
</html>
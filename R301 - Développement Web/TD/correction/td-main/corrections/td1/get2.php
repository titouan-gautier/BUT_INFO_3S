<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Test2</title>
  </head>
<body>
<!--	
  <?php foreach ($_GET as $key => $value) {
  	?>
  	<p> <?php echo "$key : $value"; ?></p>
  <?php } ?> -->

  <?php foreach ($_GET as $key => $value): ?>
  	<p> <?php echo "$key : $value"; ?></p>
  <?php endforeach; ?>
</body>
</html>
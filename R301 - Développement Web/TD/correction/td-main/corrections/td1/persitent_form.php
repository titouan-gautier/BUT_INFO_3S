<?php
$pseudo="";
if (isset($_COOKIE['pseudo']))
	$pseudo=$_COOKIE['pseudo'];
?>
<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Form persistant</title>
  </head>
<body>
  <form action="authenticate.php" method="post">
    <p> pseudo :  <input type="text" name="pseudo" value="<?php echo $pseudo ?>"> </p>
    <p> mot de passe :  <input type="text" name="password"> </p>
    <input type="submit">
  </form>
</body>
</html>
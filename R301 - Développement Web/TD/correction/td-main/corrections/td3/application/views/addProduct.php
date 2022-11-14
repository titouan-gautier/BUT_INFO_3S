<!doctype html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Ajout magasin</title>
</head>
<body>
<form action="<?=site_url('product/addProduct')?>" method="post">
	<input type="text" name="id" placeholder="id">
	<input type="text" name="name" placeholder="name">
	<input type="text" name="price" placeholder="price">
	<input type="text" name="quantity" placeholder="quantity">
	<input type="submit">
</form>
</body>
</html>

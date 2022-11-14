<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?><!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Mon magasin</title>
</head>
<body>
	<ul>
		<li> <a href="<?= site_url('user/login')?>"> login </a></li>
		<li> <a href="<?= site_url('user/logout')?>"> logout </a></li>
	</ul>
	<ul>
		<li> <a href="<?= site_url('product/add')?>"> Add product </a> </li>
	</ul>

	<table>
		<tr>
			<th> id </th>
			<th> name </th>
			<th> price </th>
			<th> quantity </th>
			<th> update </th>
			<th> delete </th>
		</tr>
		<?php foreach ($prods as  $prod): ?>
		<tr>
			<td><?= $prod->getId()?></td>
			<td><?= $prod->getName()?></td>
			<td><?= $prod->getPrice()?></td>
			<td><?= $prod->getQuantity()?></td>
			<td><a href="<?= site_url('product/update/'.$prod->getId())?>"> update </a></td>
			<td><a href="<?= site_url('product/delete/'.$prod->getId())?>"> delete </a></td>
		</tr>	
		<?php endforeach;?>
	</table>

</body>
</html>	

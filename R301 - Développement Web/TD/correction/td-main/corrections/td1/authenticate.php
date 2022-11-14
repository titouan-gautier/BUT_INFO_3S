<?php
  if (!isset($_POST["pseudo"])) 
  	header("Location: persitent_form.php");
  else {
  	$pseudo = $_POST['pseudo'];
	setcookie('pseudo', htmlentities($pseudo), time()+3600);
	if (!isset($_POST["password"])) 
		header("Location: persitent_form.php");
	else {
			$password = $_POST["password"];
			$users = array(
  				"jojo" => array("password" => "pass1", "status" => "administrator"),
  				"raoul" => array("password" => "pass2", "status" => "visitor"),
  				"roméo" => array("password" => "pass3", "status" => "customer"));

			if (!isset($users[$pseudo]))
				header("Location: persitent_form.php");
			else
			{

				if ($users[$pseudo]["password"] != $password)
                    header("Location: persitent_form.php");
				else {
                    session_start();

                    $_SESSION["user"] = array(
                        "pseudo" => $pseudo,
                        "status" => $users[$pseudo]["status"]
                    );
                    header("Location: site.php");
                }

			}
		}
	}

?>
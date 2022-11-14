<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH.DIRECTORY_SEPARATOR.'models'.DIRECTORY_SEPARATOR."UserEntity.php";
class User extends CI_Controller
{

	public function __construct()
	{
		parent::__construct();
		$this->load->helper('url');
		$this->load->model('UserModel');
	}

	function login(){
		$this->load->view('login');
	}

	function loginCheck(){
		$pseudo = $this->input->post('pseudo');
		$password = $this->input->post('password');
		$user = $this->UserModel->findByPseudo($pseudo);

		if ($user !=null && $user->isValidPassword($password)) {
			$this->session->set_userdata("user",array("pseudo"=>$user->getPseudo(), "status"=>$user->getStatus()));
			redirect("home");
			die();
		}
		$this->load->view('accessDenied.php');
	}

	function logout(){
		$this->session->unset_userdata("login");
		$this->session->sess_destroy();
		redirect("home");
	}
}
?>

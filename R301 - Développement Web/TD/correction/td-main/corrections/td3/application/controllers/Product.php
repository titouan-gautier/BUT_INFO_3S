<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH.DIRECTORY_SEPARATOR.'models'.DIRECTORY_SEPARATOR."ProductEntity.php";
class Product extends CI_Controller
{

	public function __construct()
	{
		parent::__construct();
		$this->load->helper('url');
		$this->load->model('ProductModel');

		if (!isset($this->session->user)) {
			redirect("deny");
			exit();
		}
		$status = $this->session->user["status"];

		if ($status != 'Administrator') {
			redirect("deny");
			exit();
		}
	}

	public function deny(){
		$this->load->view('accessDenied.php');
	}

	public function display($id)
	{
		$product = $this->ProductModel->findById($id);
		$this->load->view('displayProduct', array('product' => $product));
	}

	public function delete($id)
	{
		$res = $this->ProductModel->delete($id);
		redirect('home');
	}
	public function add(){
		$this->load->view('addProduct');
	}
	public function addProduct(){

		$product = new ProductEntity();
		$product->setId(intval($this->input->post('id')));
		$product->setName($this->input->post('name'));
		$product->setPrice(floatval($this->input->post('price')));
		$product->setQuantity(intval($this->input->post('quantity')));
		$product = $this->ProductModel->add($product);
		$this->load->view("displayProduct",array("product"=>$product));
	}

	public function update($id){
		$product =  $this->ProductModel->findById($id);
		$this->load->view("updateProduct.php", array("product"=>$product));
	}

	function updateProduct(){
		$idS = $this->input->post('idS');
		$product=new ProductEntity();
		$product->setId(intval($this->input->post('id')));
		$product->setName($this->input->post('name'));
		$product->setPrice(floatval($this->input->post('price')));
		$product->setQuantity(intval($this->input->post('quantity')));
		$product=$this->ProductModel->update($idS,$product);
		$this->load->view("displayProduct.php", array("product"=>$product));
	}



}
?>

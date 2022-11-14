<?php
require_once APPPATH.DIRECTORY_SEPARATOR.'models'.DIRECTORY_SEPARATOR."ProductEntity.php";
class ProductModel extends CI_Model {

     function findAll(){
	    $this->db->select('*');
	    $q = $this->db->get('product');
		$response = $q-> custom_result_object("ProductEntity");
	    return $response;
		}

	function findById($id){

	    $this->db->select('*');
	    $q = $this->db->get_where('product',array('id'=>$id));
	    $response = $q->row(0,"ProductEntity");
	    return $response;
		}

	function delete(int $id): bool {
		$this->db->delete('product', array('id' => $id));
		return $this->db->affected_rows()!=0;
	}

	function add(ProductEntity $product):?ProductEntity{
		$id = $product->getId();
		$name = $product->getName();
		$price = $product->getPrice();
		$quantity = $product->getQuantity();
     	$data = array(
			'id' => $id,
			'name' => $name,
			'price' => $price,
			'quantity'=> $quantity
		);
     	try {
			$db_debug = $this->db->db_debug;
			$this->db->db_debug = FALSE;
			$this->db->insert('product', $data);
			$this->db->db_debug = $db_debug;
		} catch (Exception $e) {}
		return $this->findById($id);
	}

	public function update(int $idS, ProductEntity $product): ProductEntity
	{
		$id = $product->getId();
		$name = $product->getName();
		$price = $product->getPrice();
		$quantity = $product->getQuantity();
		$data = array(
			'id' => $id,
			'name' => $name,
			'price' => $price,
			'quantity'=> $quantity
		);
		try {
			$db_debug = $this->db->db_debug;
			$this->db->db_debug = FALSE;
			$this->db->set($data);
			$this->db->where('id',$idS);
			$this->db->update('product');
			$this->db->db_debug = $db_debug;
		} catch (Exception $e) {}
		return $this->findById($id);
	}
 }
 ?>

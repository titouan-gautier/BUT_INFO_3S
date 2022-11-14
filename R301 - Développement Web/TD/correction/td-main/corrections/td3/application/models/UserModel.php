<?php

require_once APPPATH.DIRECTORY_SEPARATOR.'models'.DIRECTORY_SEPARATOR."UserEntity.php";
class UserModel extends CI_Model {

    public function findAll()
    {
		$this->db->select('*');
		$q = $this->db->get('user');
		$response = $q-> custom_result_object("UserEntity");
		return $response;
    }

    public function findByPseudo(string $pseudo)
    {
		$this->db->select('*');
		$q = $this->db->get_where('user',array('pseudo'=>$pseudo));
		$response = $q->row(0,"UserEntity");
		return $response;
    }
}
?>

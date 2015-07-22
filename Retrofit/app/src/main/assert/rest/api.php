<?php
/**
* This class is to demonstrate the Simple Rest Web-service and doing
* HTTP operations like PUT,POST,GET and DELETE.
*
* @author Rajiv Manivannan <rajivroczzz@gmail.com>
*
*/
require_once("Rest.inc.php");

class API extends REST 
{
public $data = "";

public function __construct()
{
parent::__construct();// Init parent constructor
}

//Public method for access api.
//This method dynamically call the method based on the query string
public function processApi()
{
$func = strtolower(trim(str_replace("/","",$_REQUEST['req'])));
if((int)method_exists($this,$func) > 0)
$this->$func();
else
$this->response('',404); 
// If the method not exist with in this class, response would be "Page not found".
}

// ##################################### For POST Method #########################################
private function login()
{
// Cross validation if the request method is POST else it will return "Not Acceptable" status
if($this->get_request_method() != "POST")
{
$this->response('',406);
}
$email = $this->_request['email'];  
$password = $this->_request['password'];
$isPost = True;
// Input validations
if(!empty($email) and !empty($password))
{
if($isPost){
	// copy file content into a string variable
$json_data = file_get_contents('user.json');
// convert the string to a json object
$result = json_decode($json_data,true);
// If success everything is good send header as "OK" and user details
$this->response($this->json($result), 200);
}
$this->response('', 204); // If no records "No Content" status
}
// If invalid inputs "Bad Request" status message and reason
$error = array('status' => "Error", "message" => "Invalid Email address or Password");
$this->response($this->json($error), 400);
	
}

// ##################################### For PUT Method #########################################
private function updateUser()
{

}

// ##################################### For GET Method #########################################
private function getProduct()
{
// Cross validation if the request method is GET else it will return "Not Acceptable" status
if($this->get_request_method() != "GET")
{
$this->response('',406);
}
// copy file content into a string variable
$json_data = file_get_contents('product.json');
// convert the string to a json object
$result = json_decode($json_data,true);

// If success everything is good send header as "OK" and return list of users in JSON format
$this->response($this->json($result), 200);

$this->response('',204); // If no records "No Content" status
}

// ##################################### For DELETE Method #########################################
private function deleteUser()
{
if($this->get_request_method() != "DELETE"){
$this->response('',406);
}
$userId = (int)$this->_request['userId'];
if($userId >0)
{    
$success = array('status' => "Success", "message" => "Successfully one record deleted.");
$this->response($this->json($success),200);
}
else
{
$this->response('',204); // If no records "No Content" status
}
}

//Encode array into JSON
private function json($data)
{
if(is_array($data)){
return json_encode($data);
}
}
}
// instantiated Library
$api = new API;
$api->processApi();
?>
<?php
    class Student{
     
        // database connection and table name
        private $conn;
        private $table_name = "student";
     
        // object properties
        public $id;
        public $name;
        public $age;
     
        // constructor with $db as database connection
        public function __construct($db){
            $this->conn = $db;
        }

        // read students
        function read(){
         
            // select all query
            $query = "SELECT * FROM student";
         
            // prepare query statement
            $stmt = $this->conn->prepare($query);
         
            // execute query
            $stmt->execute();
         
            return $stmt;
        }

        // create student
        function create(){
         
            // query to insert record
            $query = "INSERT INTO
                        " . $this->table_name . "
                    SET
                        name=:name, age=:age";
         
            // prepare query
            $stmt = $this->conn->prepare($query);
         
            // sanitize
            $this->name=htmlspecialchars(strip_tags($this->name));
            $this->age=htmlspecialchars(strip_tags($this->age));

         
            // bind values
            $stmt->bindParam(":name", $this->name);
            $stmt->bindParam(":age", $this->age);
       
         
            // execute query
            if($stmt->execute()){
                return true;
            }else{
                return false;
            }
        }

        // update the student
        function update(){
         
            // update query
           $query = "UPDATE
                        " . $this->table_name . "
                    SET
                        name = " . "'" . $this->name . "'" . ",
                        age = " . "'" . $this->age . "'" . "
                    WHERE
                        id = " . $this->id;
         
            //prepare query statement
            $stmt = $this->conn->prepare($query);
         
            // // sanitize
            // $this->name=htmlspecialchars(strip_tags($this->name));
            // $this->age=htmlspecialchars(strip_tags($this->age));
            // $this->id=htmlspecialchars(strip_tags($this->id));
          
         
            // // bind new values
            // $stmt->bindParam(':id', $this->id);
            // $stmt->bindParam(':name', $this->name);
            // $stmt->bindParam(':age', $this->age);
      
         
            // execute the query
            if($stmt->execute()){
                return true;
            }else{
                return false;
            }
        }

        // delete the product
        function delete(){
         
            // delete query
            $query = "DELETE FROM " . $this->table_name . " WHERE id = ?";
         
            // prepare query
            $stmt = $this->conn->prepare($query);
         
            // sanitize
            $this->id=htmlspecialchars(strip_tags($this->id));
         
            // bind id of record to delete
            $stmt->bindParam(1, $this->id);
         
            // execute query
            if($stmt->execute()){
                return true;
            }
         
            return false;
        }
    }
package main

import (
	"log"
	"net"
	"bufio"
)

func main() {

	conn, err := net.Dial("unix", "test.sock")
	if err != nil {
		log.Println("Dial error:", err)
		return
	}
	defer conn.Close()



	var reader *bufio.Reader
	reader = bufio.NewReader(conn)

	n ,err := reader.ReadString('\n')

	if err != nil {
		log.Print("Read error ", err)
	}

	log.Println(n)

	

}

package main

import (
	"net"
	"log"
	"bufio"
)

func main() {

	conn,err := net.Dial("tcp","localhost:8080")

	if err != nil {
		log.Print(err)
	}

	var reader *bufio.Reader
	reader = bufio.NewReader(conn)

	msg,err := reader.ReadString('\n')

	log.Print(msg)

	


}
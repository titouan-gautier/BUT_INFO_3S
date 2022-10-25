package main

import (
	"log"
	"net"
	"bufio"
)

func main() {

	conn, err := net.Dial("tcp", "192.168.43.56:7878")
	if err != nil {
		log.Println("Dial error:", err)
		return
	}
	defer conn.Close()

	log.Println("Je suis connecté")



	var reader *bufio.Reader
	reader = bufio.NewReader(conn)

	n ,err := reader.ReadString('\n')

	if err != nil {
		log.Print("Read error ", err)
	}

	log.Println(n)

	

}

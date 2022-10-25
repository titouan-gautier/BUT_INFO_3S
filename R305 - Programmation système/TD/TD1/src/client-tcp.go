package main

import (
	"log"
	"net"
)

func main() {

	conn, err := net.Dial("tcp", "192.168.43.56:7878")
	if err != nil {
		log.Println("Dial error:", err)
		return
	}
	defer conn.Close()

	log.Println("Je suis connecté")

}

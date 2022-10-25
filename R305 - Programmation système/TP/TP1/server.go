package main

import (
	"log"
	"net"
)

func Connexion() bool {

	listener, err := net.Listen("tcp", ":8080")
		if err != nil {
			log.Println("listen error:", err)
			return false
		}
		defer listener.Close()

	var conn = make([]net.Conn,2)

	for i := 0; i<2; i++ {
		

		c, err := listener.Accept()
		if err != nil {
			log.Println("accept error:", err)
			return false
		}

		log.Print("GG")

		conn[i] = c

		var msg = []byte("test")
		_, err = conn[i].Write(msg)
		if err != nil {
			log.Println("accept error:", err)
			return false
		}

		defer conn[i].Close()
	}

	return true

}


func main() {

	if (Connexion()) {
		log.Println("Tout les joueur connecte")
	}



}
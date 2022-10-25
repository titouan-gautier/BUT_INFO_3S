package main

import (
	"log"
	"net"
	/* "bufio" */
)

func main() {

	conn, err := net.Dial("tcp", "192.168.43.129:8080")
	if err != nil {
		log.Println("Dial error:", err)
		return
	}
	var msg []byte

	conn.Read(msg)
	log.Println(string(msg))
	defer conn.Close()

	/* var reader *bufio.Reader
	reader = bufio.NewReader(conn)

	n ,err := reader.ReadString('\n')

	if err != nil {
		log.Print("Read error ", err)
	}

	log.Println(n) */

	

}

package main

import (
	"log"
	"net"
	"time"
	"bufio"
)

func main() {
	listener, err := net.Listen("unix", "test.sock")
	if err != nil {
		log.Println("listen error:", err)
		return
	}
	defer listener.Close()

	conn, err := listener.Accept()
	if err != nil {
		log.Println("accept error:", err)
		return
	}
	defer conn.Close()
	log.Println("Le client s'est connecté")

	var message string = "bonjour\n"

	var write *bufio.Writer
	write = bufio.NewWriter(conn)

	_, err = write.WriteString(message)

	write.Flush()

	if err != nil {
		log.Print("Read error ", err)
	}

	time.Sleep(10 * time.Second)

}

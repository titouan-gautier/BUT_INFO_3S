package main

import (
	"net"
	"log"
	"bufio"
)

func main() {
	
	listener,err := net.Listen("tcp",":8080") 

	if err != nil {
		log.Print(err)
	}
	defer listener.Close()

	conn , err := listener.Accept()
	if err != nil {
		log.Print(nil)
	}
	defer conn.Close()

	var writer *bufio.Writer
	writer = bufio.NewWriter(conn)

	_,err = writer.WriteString("Bonjour\n")
	if err != nil {
		log.Print(err)
	}
	writer.Flush()
}
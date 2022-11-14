package main

import "fmt"

var c1 = make(chan bool,1)
var c2 = make(chan bool,1)

func routine1() {
	for {
		<-c1
		fmt.Println("Routine 1")
		c2 <- true
	}
}

func routine2() {	
	for {
		<-c2
		fmt.Println("Routine 2")
		c1 <- true
	}
}

func main() {
	c1 <- false
	go routine1()
	routine2()
}

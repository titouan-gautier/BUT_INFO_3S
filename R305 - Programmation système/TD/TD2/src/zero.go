package main

import (
	"fmt"
	"time"
)

func writer(c chan bool) {
	for {
		time.Sleep(time.Millisecond * 500)
		c <- true
		fmt.Println("Écriture")
	}
}

func reader(c chan bool) {
	for {
		time.Sleep(time.Second)
		<-c
		fmt.Println("Lecture")
	}
}

func main() {
	var c chan bool = make(chan bool,10)
	go writer(c)
	reader(c)
}

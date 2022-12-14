package main

import "fmt"

func ping(ready, next, done chan bool) {
	for i := 0; i < 10; i++ {
		<-ready
		fmt.Println("Ping")
		next <- true
	}
	done <- true
}

func pong(ready, next, done chan bool) {
	for i := 0; i < 10; i++ {
		<-ready
		fmt.Println("Pong")
		next <- true
	}
	done <- true
}

func main() {
	pingchan := make(chan bool, 1)
	pongchan := make(chan bool, 1)
	done := make(chan bool, 2)

	pingchan <- true

	go ping(pingchan, pongchan, done)
	go pong(pongchan, pingchan, done)

	<-done
	<-done
}


func trie(tab []int) {
	for i:=0 ; i<len(tab) ; i++ {
		for y:=0; y< len(tab) -1; y++ {
			if tab[y] < tab[y+1] {
				tab[y],tab[y+1] = tab[y+1],tab[y]
			}
		}
	}
}
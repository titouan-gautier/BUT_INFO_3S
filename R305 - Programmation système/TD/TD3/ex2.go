package main

import (
	"log"
	"sync"
)

var com1, com2 []int
var c1 chan int = make(chan int,1001)
var c2 chan int = make(chan int,1001)

var m1 sync.Mutex
var m2 sync.Mutex

var w sync.WaitGroup

func prod(n int) {
	defer w.Done()
	for i := 1; i <= n; i++ {
		m1.Lock()
		c1 <- i
		m1.Unlock()
	}
}

func trans() {
	defer w.Done()
	for {
		m1.Lock()
		if len(c1) > 0 {
			t := <-c1
			m2.Lock()
			c2 <- t
			m2.Unlock()
		}
		m1.Unlock()
	}
}

func cons() {
	defer w.Done()
	for {
		if len(c2) > 0 {
			m2.Lock()
			t := <- c2
			m2.Unlock()
			log.Print(t)
		}
	}
}

func main() {
	w.Add(3)
	go prod(1000)
	go trans()
	go cons()
	w.Wait()
}

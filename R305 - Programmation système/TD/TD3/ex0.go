package main

import (
	"fmt"
	"sync"
)

var x, y int
var w sync.WaitGroup
var m sync.Mutex

func switchxy() {
	m.Lock()
	for i := 0; i < 1000; i++ {
		x, y = y, x
	}
	m.Unlock()
	w.Done()
}

func main() {
	x = 5
	y = 7
	w.Add(1000)
	for i := 0; i < 1000; i++ {
		go switchxy()
	}
	w.Wait()
	fmt.Println("x vaut", x, "et y vaut", y)
}

/* 
	Il y a 1000 race conditions, elles ont lieu au niveau de la ligne 13 la ou plusieurs go routines accède à x et y en même temps

	


*/

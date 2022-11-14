package main

import (
	"fmt"
	"sync"
)

var res int
var w sync.WaitGroup
var mu sync.Mutex

// calcule n puissance m
func puissance(n, m int) {

	mu.Lock()

	res = 1
	for i := 0; i < m; i++ {
		mu.Lock()
		res *= n
	}
	fmt.Println(n, "puissance", m, "vaut", res)

	mu.Unlock()
	w.Done()
	return
}

func main() {

	for i := 0; i < 10; i++ {
		for j := 0; j < 3; j++ {
			w.Add(1)
			go puissance(i, j)
		}
	}

	w.Wait()
}

/*

	Il y a 30 race conditions car il y a des go routines et elles utilisent une variables res communes

*/

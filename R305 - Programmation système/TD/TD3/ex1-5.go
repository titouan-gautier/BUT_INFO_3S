package main

import (
	"fmt"
	"sync"
)

var w sync.WaitGroup
var mu sync.Mutex

// calcule n puissance m
func puissance(n, m int, res *int) {
	
	mu.Lock()

	*res = 1
	for i := 0; i < m; i++ {
		*res *= n
	}
	fmt.Println(n, "puissance", m, "vaut", *res)

	mu.Unlock()
	w.Done()
	return
}

func main() {

	var res int

	for i := 0; i < 10; i++ {
		for j := 0; j < 3; j++ {
			w.Add(1)
			go puissance(i, j, &res)
		}
	}

	w.Wait()
}


/*

	Il y a des race conctions car les go routines utilisent la variable res du main car on passe dans la fonction puissance l'adresse de res

*/
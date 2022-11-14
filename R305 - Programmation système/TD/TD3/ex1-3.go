package main

import "fmt"

var res int

// calcule n puissance m
func puissance(n, m int) {
	res = 1
	for i := 0; i < m; i++ {
		res *= n
	}
	fmt.Println(n, "puissance", m, "vaut", res)
	return
}

func main() {

	for i := 0; i < 10; i++ {
		for j := 0; j < 3; j++ {
			puissance(i, j)
		}
	}

}


/*

il n'y a pas de race conditions car pas de go routines

*/

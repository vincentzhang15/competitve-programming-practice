package main

import (
	"fmt"
	"strings"
)

func main() {
	var s string
	fmt.Scanf("%s", &s)

	for i:= 97; i<97+6; i++ {
		var c string = string(i)

		if !strings.ContainsAny(s, c) {
			fmt.Printf("%s\n", c)
			break
		}
	}
}
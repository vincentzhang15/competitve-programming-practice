package main

import "fmt"

func main() {
    var n int
    fmt.Scan(&n)

    b := make([]int, n+1)
    for i := 0; i <= n; i++ {
        fmt.Scan(&b[i])
    }

    h := make([]int, n)
    for i := 0; i < n; i++ {
        fmt.Scan(&h[i])
    }

    var ans int = 0
    for i := 0; i < n; i++ {
        ans += (b[i] + b[i+1]) * h[i]
    }

    fmt.Printf("%.1f", float32(ans) / 2.0)
}